package com.example.zamin.dictionary.need

import android.util.Log
import com.google.gson.Gson

fun D(message:String){
    Log.d("sardor","|------------>   $message   <-------------------|")
}

fun listToGson(list: MutableList<String>) = Gson().toJson(list)