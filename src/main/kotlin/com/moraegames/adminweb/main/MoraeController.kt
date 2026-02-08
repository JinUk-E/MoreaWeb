package com.moraegames.adminweb.main

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/moraeAdmin")
class MoraeController {

    /// MoraeAdmin 로그인 페이지 예정
    @GetMapping("")
    fun moraeAdmin(): String = "moraeAdmin.html"

    @GetMapping("/main")
    fun moraeAdminMain(): String = "moraeAdminMain.html"
}