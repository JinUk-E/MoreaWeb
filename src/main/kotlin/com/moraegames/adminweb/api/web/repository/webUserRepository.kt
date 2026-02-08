package com.moraegames.adminweb.api.web.repository

import com.moraegames.adminweb.api.web.entity.webUserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface webUserRepository : JpaRepository<webUserEntity, Int> {
    // id로 조회
    fun findById(id: String): webUserEntity
    // id 존재여부 확인
    fun existsById(id: String): Boolean
    // password 확인
    fun existsByIdAndPassword(id: String, password: String): Boolean

}