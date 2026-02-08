package com.moraegames.adminweb.api.web.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "members")
class webUserEntity() {

    @Id
    var no : Int = 0

    @Column(name = "id")
    var id : String = ""

    @Column(name = "password")
    var password : String = ""

    @Column(name = "name")
    var name : String = ""

}