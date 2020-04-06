package com.load.more.database.factories

import com.load.more.entities.Image
import com.load.more.entities.Images
import dev.alpas.hashing.Hasher
import dev.alpas.ozone.EntityFactory
import dev.alpas.ozone.faker
import java.time.Instant

// https://alpas.dev/docs/entity-factory
internal class ImageFactory(private val hasher: Hasher) : EntityFactory<Image, Images>() {
    override val table = Images

    override fun entity(): Image {
        return Image {

            name = faker.name().name()
            src = faker.internet().safeEmailAddress()
            updatedAt = Instant.now()
            createdAt = Instant.now()
        }
    }
}


