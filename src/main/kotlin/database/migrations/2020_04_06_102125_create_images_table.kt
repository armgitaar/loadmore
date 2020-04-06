package com.load.more.database.migrations

import com.load.more.entities.Images
import dev.alpas.ozone.migration.Migration

class CreateImagesTable : Migration() {
    override var name = "2020_04_06_102125_create_images_table"
    
    override fun up() {
        createTable(Images)
    }
    
    override fun down() {
        dropTable(Images)
    }
}