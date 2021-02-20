package com.bongho.kotlinbook.springboot.web

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


// 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
// 여기서는 SpringRunner라는 스프링 실행자를 사용
// 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 하는 어노테이션임
@RunWith(SpringRunner::class)

// 여러 스프링 테스트 어노테이션 중 Spring MVC에 집중할 수 있는 어노테이션
// @Controller, @ControllerAdvice 등을 사용 가능
// @Service, @Component, @Repository 등은 사용 불가능
// 이번 테스트에서는 컨트롤러만 사용하기 때문에 선언
@WebMvcTest(controllers = [HelloController::class])
class HelloControllerTest {

    @Autowired
    private lateinit var mvc : MockMvc  // 웹 API를 테스트 할 때 사용. Spring MVC 테스트의 시작점. HTTP, GET, POST 등에 대한 API 테스트 가능

    @Test
    fun shouldReturnHello() {
        val hello : String = "hello"

        mvc.perform(get("/hello"))      // MockMvc를 통해 /hello 주소로 HTTP GET 요청
            .andExpect(status().isOk)               // mvc.perform의 결과를 검증, HTTP Header의 status를 검증(200 등 상태코드)
            .andExpect(content().string(hello))     // 응답 본문의 내용을 검증 Controller에서 Hello를 리턴하기 때문에 이 값이 맞는지를 검증한다.

    }

}