package com.load.more

import com.load.more.controllers.WelcomeController
import com.load.more.controllers.VueController
import dev.alpas.routing.RouteGroup
import dev.alpas.routing.Router

// https://alpas.dev/docs/routing
fun Router.addRoutes() = apply {
    group {
        webRoutesGroup()
    }.middlewareGroup("web")

    apiRoutes()
}

private fun RouteGroup.webRoutesGroup() {
    get("/", WelcomeController::index).name("welcome")
    post("/showdata", WelcomeController::showmore).name("showmore")
    get("/vue", VueController::vue)
    post("/vue/vue-more", VueController::vuemore)

}

private fun Router.apiRoutes() {
    // register API routes here
}
