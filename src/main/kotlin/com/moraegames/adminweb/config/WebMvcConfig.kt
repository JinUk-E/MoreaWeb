package com.moraegames.adminweb.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

// 인증서 발급 시 사용할 경로를 설정하는 클래스
@Configuration
class WebMvcConfig : WebMvcConfigurer {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/.well-known/acme-challenge/**") // --1
            .addResourceLocations("file:///home/ubuntu/https/certbot/") //--2
    }
}