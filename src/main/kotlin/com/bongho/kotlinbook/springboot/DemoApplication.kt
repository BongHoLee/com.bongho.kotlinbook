package com.bongho.kotlinbook.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// boot 자동 설정, bean 읽기 및 생성이 모두 자동설정된다.
// @SpringBootApplication가 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트 최상단에 위치해야한다.
@SpringBootApplication
class DemoApplication
fun main(args: Array<String>) {
    // SpringApplication.run이 내장 WAS를 실행한다.
    // 별도로 외부에 WAS를 두지 않고 애플리케이션 실행 시 내부에서 WAS를 실행하는 것을 의미함
    // 서버에 Tomcat을 별도로 설치할 필요가 없다.
    // 스프링부트에서는 내장 WAS를 사용하는것을 권장함(언제 어디서나 같은 환경에서 스프링부트 배포가 가능)
    //SpringApplication.run(Application::class.java, *args)
    runApplication<DemoApplication>(*args)
}