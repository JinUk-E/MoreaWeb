package com.moraegames.adminweb.api.shortdown.entity

import jakarta.persistence.*
import java.math.BigInteger
import java.time.ZonedDateTime

@Entity
@Table(name = "user_data")
class User() {

    @Id
    var Id: String = ""

    @Column(name = "created_at")
    var Created_at: String = ZonedDateTime.now().toString()

    @Column(name = "current_stage")
    var Current_stage: Int = 0

    @Column(name = "diamond")
    var Diamond: Int = 0

    @Column(name = "experience")
    var Experience: Int = 0

    @Column(name = "gold")
    var Gold: BigInteger = BigInteger("0")

    @Column(name = "last_connection_at")
    var Last_connection_at: String = ZonedDateTime.now().toString()

    @Column(name = "last_disconnection_at")
    var Last_disconnection_at: String = ZonedDateTime.now().toString()

    @Column(name = "level")
    var Level: Int = 0

    @Column(name = "play_time")
    var Play_time: Int = 0

    @Column(name="skill_number")
    var Skill_number: Int = 0

    @Column(name="sns_id")
    var Sns_id: String = ""

    @Column(name="star")
    var Star: Int = 0

    @Column(name="username")
    var Username: String = ""

    @Column(name="enemy_id")
    var Enemy_id: String = ""

    @Column(name="game_info_id")
    var Game_info_id: String = ""
}