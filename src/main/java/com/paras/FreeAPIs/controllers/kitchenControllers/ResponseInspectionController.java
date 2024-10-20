package com.paras.FreeAPIs.controllers.kitchenControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.OutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/response")
public class ResponseInspectionController extends KitchenController {

    @GetMapping("/cache/{timeToLive}/{cacheResponseDirective}")
    public ResponseEntity<ResponseDTO> cacheResponse (
            @PathVariable @NotEmpty(message = "Time to live is missing") @Min(value = 1, message = "Time to live must be a number") Integer timeToLive,
            @PathVariable @NotEmpty(message = "Cache response directive is missing") @Pattern(regexp = "public|private", message = "Invalid cache directive") String cacheResponseDirective,
            HttpServletResponse response
                                                     ) {
        response.setHeader("Cache-Control", cacheResponseDirective + ", max-age=" + timeToLive);
        return ResponseEntity.ok(
                ResponseDTO.success(
                        "Cache directive set to " + cacheResponseDirective + " with max-age " + timeToLive,
                        response.getHeader("Cache-Control")));
    }

    @GetMapping("/headers")
    public ResponseEntity<ResponseDTO> headers (HttpServletResponse response) {
        response.setHeader("Content-Type", "application/json; charset=utf-8");
        response.setHeader("Content-Length", "280");
        response.setHeader("etag", "12345");
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("Content-Length", "280");
        headers.put("etag", "12345");
        return ResponseEntity.ok(ResponseDTO.success("Headers set", headers));
    }

    // todo: Test this
    @GetMapping("/html")
    @SneakyThrows
    public ResponseEntity<String> html () {
        ClassPathResource resource = new ClassPathResource("templates/html_response.html");
        String htmlContent = Files.readString(resource.getFile().toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return ResponseEntity.ok().headers(headers).body(htmlContent);
    }

    @GetMapping("/xml")
    @SneakyThrows
    public ResponseEntity<String> xml () {
        ClassPathResource resource = new ClassPathResource("templates/xml_response.xml");
        String xmlContent = Files.readString(resource.getFile().toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        return ResponseEntity.ok().headers(headers).body(xmlContent);
    }

    // todo: Test this
    @GetMapping("/gzip")
    public void gzip (HttpServletResponse response) throws Exception {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("text/html");
        response.setHeader(HttpHeaders.CONTENT_ENCODING, "gzip");
        String animal = "elephant";
        String content = animal.repeat(1000);
        try (OutputStream outputStream = response.getOutputStream();
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
            gzipOutputStream.write(content.getBytes());
            gzipOutputStream.flush();
        }
    }
}
