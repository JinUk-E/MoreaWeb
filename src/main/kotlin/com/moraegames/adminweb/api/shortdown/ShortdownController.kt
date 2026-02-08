package com.moraegames.adminweb.api.shortdown

import com.moraegames.adminweb.api.shortdown.entity.User
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/shortdown")
@RestController
class ShortdownController(var userService: UserService) {
    @RequestMapping("/User")
    fun Shortdown(@RequestBody user: User) : String{
        var exist = userService.Check(user);
        if(exist){
            return "Already Exist"
        }
        userService.Create(user);
        return "Success"
    }
}