package com.moraegames.adminweb.api.web

import com.moraegames.adminweb.api.web.service.WebLoginService
import com.moraegames.adminweb.data.web.webLoginDTO
import com.moraegames.adminweb.data.web.webUserDTO
import com.moraegames.adminweb.util.Constants
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI


@RequestMapping("/api/web")
@RestController
class APIController(@Qualifier("WebLoginService")private val loginService: WebLoginService) {

    @PostMapping("/loginCheck")
    fun loginCheck(@RequestBody  request: webLoginDTO) : ResponseEntity<String>{
        val idCheck = loginService.existCheckFromId(request.id)
        if(!idCheck) return ResponseEntity.badRequest().body("id not exist")

        val passwordCheck = loginService.existCheckFromIdAndPassword(request.id, request.password)
        if(!passwordCheck) return ResponseEntity.badRequest().body("password not match")

        val webUsers = loginService.findUserById(request.id)
        val userData = webUserDTO(webUsers.id, webUsers.password, webUsers.name)
        return ResponseEntity.ok("login success : ${userData.name}")

        // 리다이렉트
//        val headers = HttpHeaders()
//        headers.location = URI(Constants.LoginSuccessPath)
//        return ResponseEntity(headers, HttpStatus.PERMANENT_REDIRECT)
    }
}