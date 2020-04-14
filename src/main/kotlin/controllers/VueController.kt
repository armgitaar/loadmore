package com.load.more.controllers

import com.load.more.entities.Images
import dev.alpas.http.HttpCall
import dev.alpas.ozone.latest
import dev.alpas.routing.Controller
import dev.alpas.toJson
import me.liuwj.ktorm.entity.drop
import me.liuwj.ktorm.entity.take
import me.liuwj.ktorm.entity.toList

class VueController : Controller() {
    fun vue(call: HttpCall) {

        val images = Images
            .latest()
            .take(5)
            .toList()

        call.render("vue"){"images" to images}
    }

    fun vuemore(call: HttpCall){

        if(call.isAjax) {
            var last_id = call.jsonBody?.get("id")

            val images = last_id?.let {
                Images
                    .latest()
                    .drop(it as Int)
                    .take(5)
                    .toList()
            }

            if (images != null) {
                call.reply(images.toJson())
            }
        }
    }
}