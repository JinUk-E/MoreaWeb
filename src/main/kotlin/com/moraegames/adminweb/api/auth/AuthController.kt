package com.moraegames.adminweb.api.auth

import com.moraegames.adminweb.util.Constants
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("")
@RestController
class AuthController {

    @GetMapping("/.well-known/assetlinks.json")
    fun assetlinks() = Constants.DeepLinksJson

    @GetMapping("/.well-known/apple-app-site-association")
    fun appleAppSiteAssociation(): String = Constants.AASA

    @GetMapping("/app-ads.txt")
    fun adMobSettings() = Constants.app_ads
}