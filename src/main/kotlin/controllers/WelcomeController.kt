package com.load.more.controllers

import com.load.more.entities.Images
import dev.alpas.http.HttpCall
import dev.alpas.routing.Controller
import dev.alpas.ozone.latest
import dev.alpas.toJson
import me.liuwj.ktorm.entity.take
import me.liuwj.ktorm.entity.drop
import me.liuwj.ktorm.entity.toList

// https://alpas.dev/docs/controllers
class WelcomeController : Controller() {
    fun index(call: HttpCall) {

        val images = Images
            .latest()
            .take(5)
            .toList()

        call.render("welcome"){"images" to images}
    }

    fun showmore(call: HttpCall){
        if(call.isAjax){
            var num: Int = call.intParam("id") as Int

            val images = Images
                .latest()
                .drop(num)
                .take(5)
                .toList()

            var content = ""
            var last_id = num + 5

            if (num < 15){
                for (image in images){

                    content += """
                        <li class="p-4 bg-white rounded-lg mb-3 flex flex-st">
                            <div class="flex">
                              <div class="self-center">
                                  <a href="${image.src}" target="_blank">
                                    <img class="h-20 w-20 object-cover rounded-lg" src="${image.src}">
                                  </a>
                              </div>
                              <div class="ml-6 pr-4 flex-1">
                                <div class="text-xl font-bold text-gray-900"> ${image.name} </div>
                              </div>
                           </div>
                         </li>
                    """.trimIndent()
                }

                content += """
                    <button type="button" name="show_more_button" class="font-semibold uppercase py-2 px-4 rounded-lg inline-flex" data-id="${last_id}" id="show_more_button">
                      <svg class="fill-current h-4 w-4 mr-2 mt-1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/></svg>
                      <span>Show More</span>
                    </button>
                """.trimIndent()

            }else {
                content = "🏙 That's all! 👋"

            }
            call.reply(content)
        }
    }
}
