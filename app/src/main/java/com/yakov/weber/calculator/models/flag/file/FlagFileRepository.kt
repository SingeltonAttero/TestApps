package com.yakov.weber.calculator.models.flag.file

import android.content.Context
import android.content.res.AssetManager
import com.yakov.weber.calculator.extent.printConstruction
import com.yakov.weber.calculator.models.flag.prefs.Prefs
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

class FlagFileRepository @Inject constructor(
        private val prefs: Prefs,
        private val context: Context,
        private val resourceManager: ResManager) {

    init {
        printConstruction()
    }

    fun nameCounterFlag(): List<String> {
        val list = mutableListOf<String>()

        val regions = prefs.regions

        for(region in regions){
            val assetManager = context.assets.list(region)

            for (path in assetManager){
                list.add(path.replace(".png",""))
            }
        }

        return list.toList()
    }

}