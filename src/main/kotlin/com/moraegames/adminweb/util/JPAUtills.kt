package com.moraegames.adminweb.util

object JPAUtills {
    fun multiDBJpaProperties(): Map<String, Any> {
        val jpaProperties = mutableMapOf<String, Any>()
        jpaProperties["hibernate.physical_naming_strategy"] =
            "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl"
        return jpaProperties
    }
}