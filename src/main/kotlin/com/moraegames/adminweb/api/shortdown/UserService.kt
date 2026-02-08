package com.moraegames.adminweb.api.shortdown

import com.moraegames.adminweb.api.shortdown.entity.User
import com.moraegames.adminweb.api.shortdown.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val ur: UserRepository) {

    fun Create(user : User) : Boolean{
        Check(user);

        ur.save(user)
        return !Check(user);
    }

    fun Check(user : User) : Boolean{
        return ur.existsById(user.Id)
    }

}