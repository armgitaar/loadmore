package com.load.more.entities

import dev.alpas.ozone.*
import java.time.Instant

interface Image : OzoneEntity<Image> {
    var id: Long
    var name: String?
    var src: String?
    var createdAt: Instant?
    var updatedAt: Instant?

    companion object : OzoneEntity.Of<Image>()
}

object Images : OzoneTable<Image>("imageses") {
    val id by bigIncrements()
    val name by string("name").size(150).nullable().bindTo { it.name }
    val src by string("src").size(150).nullable().bindTo { it.src }
    val createdAt by createdAt()
    val updatedAt by updatedAt()
}