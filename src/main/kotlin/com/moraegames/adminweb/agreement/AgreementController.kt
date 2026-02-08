package com.moraegames.adminweb.agreement

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class AgreementController {
    @GetMapping("/terms")
    fun terms(model: Model): String {
        model.addAttribute("name", "Morae")
        model.addAttribute("title", "termsPage")
        return "terms"
    }

    @GetMapping("/personalInfo")
    fun personalInformation(model: Model): String {
        model.addAttribute("name", "Morae")
        model.addAttribute("title", "personalInfo")
        return "personalInfo"
    }
}