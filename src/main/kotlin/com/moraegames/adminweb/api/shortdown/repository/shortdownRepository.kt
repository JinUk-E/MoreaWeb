package com.moraegames.adminweb.api.shortdown.repository

import com.moraegames.adminweb.api.shortdown.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String> {}