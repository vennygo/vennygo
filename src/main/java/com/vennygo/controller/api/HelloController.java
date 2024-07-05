package com.vennygo.controller.api;

import com.vennygo.dto.HelloRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @Operation(summary = "String")
    @GetMapping("/string")
    public String string(String hello) {
        // http://localhost:8080/api/hello/string?hello=abc
        // abc
        return hello;
    }

    @Operation(summary = "dto")
    @GetMapping("/dto")
    public String dto(HelloRequestDto request) {
        // json
        // http://localhost:8080/api/hello/dto?hello=abc
        // abc
        return request.getHello();
    }

    @Operation(summary = "String, dto")
    @GetMapping("/complex")
    public String complex(String hi, HelloRequestDto request) {
        // json
        // http://localhost:8080/api/hello/complex?hi=hi&hello=abc
        // hiabc
        return hi + request.getHello();
    }

    @Operation(summary = "RequestParam String")
    @GetMapping("/request-param-string")
    public String requestParamString(@RequestParam String hello) {
        // http://localhost:8080/api/hello/request-param-string?hello=abc
        // abc
        return hello;
    }

    @Operation(summary = "RequestParam dto")
    @GetMapping("/request-param-dto")
    public String requestParamDto(@RequestParam HelloRequestDto request) {
        // json
        // http://localhost:8080/api/hello/request-param-dto?hello=abc
        // 400 error
        // @RequestParam는 dto를 받을 수 없음. Map<String, String>은 가능
        return request.getHello();
    }

    @Operation(summary = "RequestParam map")
    @GetMapping("/request-param-map")
    public String requestParamMap(@RequestParam String param1, @RequestParam(required = false, defaultValue = "value2") String param2,
                                  @RequestParam Map<String, String> map) {
        // http://localhost:8080/api/hello/request-param-map?param1=value1&param2=value2&param3=value3
        // value1value2value3
        return param1 + param2 + map.get("param3");
    }

    @Operation(summary = "ModelAttribute String")
    @GetMapping("/model-attribute-string")
    public String modelAttributeString(@ModelAttribute String hello) {
        // http://localhost:8080/api/hello/model-attribute-string?hello=abc
        // X
        return hello;
    }

    @Operation(summary = "ModelAttribute dto")
    @GetMapping("/model-attribute-dto")
    public String modelAttributeDto(@ModelAttribute HelloRequestDto request) {
        // json
        // http://localhost:8080/api/hello/model-attribute-dto?hello=abc
        // abc
        return request.getHello();
    }

    @Operation(summary = "pathVariable String")
    @GetMapping("/{hello}")
    public String pathVariable(@PathVariable String hello) {
        // http://localhost:8080/api/hello/abc
        // abc
        return hello;
    }
}