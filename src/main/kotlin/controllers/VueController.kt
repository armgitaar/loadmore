package com.load.more.controllers

import dev.alpas.http.HttpCall
import dev.alpas.routing.Controller

class ViewController : Controller() {
    fun index(call: HttpCall) {
        call.reply("Hello, ViewController!")
    }
}