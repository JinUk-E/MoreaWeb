package com.moraegames.adminweb.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class WebUtils {
    companion object {
        private val mapper: ObjectMapper = jacksonObjectMapper()

        fun CheckToJSONEnabled(value: String): Boolean {
            return value.contains("{") && value.contains("}")
        }

        fun StringToJson(value : String) :  String {
            return mapper.writeValueAsString(value)
        }
    }
}