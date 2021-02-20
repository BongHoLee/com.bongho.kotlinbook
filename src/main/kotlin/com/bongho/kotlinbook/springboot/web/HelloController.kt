package com.bongho.kotlinbook.springboot.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// JSON을 반환하는 컨트롤러
// 일전에 @RequestBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다.
@RestController
class HelloController {

    // HTTP GET method 요청 수신 API
    // 이전에는 @RequestMapping(method = RequestMethod.GET)으로 사용됨
    @GetMapping("/hello")
    fun hello() : String {
        return "hello"
    }
}