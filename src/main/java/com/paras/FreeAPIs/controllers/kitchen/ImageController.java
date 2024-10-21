package com.paras.FreeAPIs.controllers.kitchen;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController extends KitchenController {


    @GetMapping("/jpeg")
    @SneakyThrows
    public ResponseEntity<Resource> getJpegImage () {
        ClassPathResource resource = new ClassPathResource("static/images/ken_thompson.jpeg");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @GetMapping("/jpg")
    @SneakyThrows
    public ResponseEntity<Resource> getJpgImage () {
        ClassPathResource resource = new ClassPathResource("static/images/gaearon.jpg");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @GetMapping("/png")
    @SneakyThrows
    public ResponseEntity<Resource> getPngImage () {
        ClassPathResource resource = new ClassPathResource("static/images/rich_harris.png");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @GetMapping("/svg")
    @SneakyThrows
    public ResponseEntity<Resource> getSvgImage () {
        ClassPathResource resource = new ClassPathResource("static/images/javascript.svg");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("image/svg+xml"));
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @GetMapping("/webp")
    @SneakyThrows
    public ResponseEntity<Resource> getWebpImage () {
        ClassPathResource resource = new ClassPathResource("static/images/guido_van_rossum.webp");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("image/webp"));
        return ResponseEntity.ok().headers(headers).body(resource);
    }
}
