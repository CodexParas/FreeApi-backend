package com.paras.FreeAPIs.DTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestMethodDTO {
    private String method;
    private Object headers;
    private String origin;
    private String url;


    public static RequestMethodDTO from (HttpServletRequest req) {
        return RequestMethodDTO.builder()
                               .method(req.getMethod())
                               .headers(getHeaders(req))
                               .origin(req.getLocalAddr())
                               .url(req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getRequestURI())
                               .build();
    }


    private static HttpHeaders getHeaders (HttpServletRequest req) {
        HttpHeaders headers = new HttpHeaders();
        req.getHeaderNames().asIterator().forEachRemaining(
                headerName -> headers.add(headerName, req.getHeader(headerName))
                                                          );
        return headers;
    }
}
