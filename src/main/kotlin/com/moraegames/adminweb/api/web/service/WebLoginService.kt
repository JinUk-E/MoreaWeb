package com.moraegames.adminweb.api.web.service

import com.moraegames.adminweb.api.web.repository.webUserRepository
import org.springframework.stereotype.Service

@Service("WebLoginService")
class WebLoginService(private val webUser: webUserRepository) {

    fun existCheckFromId(id: String): Boolean =
        webUser.existsById(id)

    fun existCheckFromIdAndPassword(id: String, password: String): Boolean =
        webUser.existsByIdAndPassword(id, password)

    fun findUserById(id: String) = webUser.findById(id)
}