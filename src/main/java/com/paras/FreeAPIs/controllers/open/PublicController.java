package com.paras.FreeAPIs.controllers.open;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/public")
@Tag(name = "Public APIs", description = "Public APIs for everyone")
public abstract class PublicController {
}
