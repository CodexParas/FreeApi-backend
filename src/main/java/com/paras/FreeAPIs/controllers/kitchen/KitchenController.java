package com.paras.FreeAPIs.controllers.kitchen;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/kitchen-sink")
@Tag(name = "Kitchen Sink", description = "Kitchen Sink APIs for testing")
public abstract class KitchenController {
}
