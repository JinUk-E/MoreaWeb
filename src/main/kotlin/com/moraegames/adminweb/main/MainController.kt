package com.moraegames.adminweb.main

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController() {
    @GetMapping("/")
    fun main(model: Model): String {
        return "index.html"
    }
    
    // Todo : 일반 접속자를 위한 페이지로 개편예정
}