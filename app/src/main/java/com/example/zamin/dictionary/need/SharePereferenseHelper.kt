package com.example.zamin.dictionary.need

import android.content.Context
import android.content.SharedPreferences.Editor

class SharePereferenseHelper(val context: Context) {
    private val sharePereferense = context.getSharedPreferences("DB",Context.MODE_PRIVATE)
    private lateinit var editor: Editor
    fun set(s:String){
        editor = sharePereferense.edit()
        editor.putString("mone",s)
        editor.commit()
    }
    fun get() = sharePereferense.getString("mone","true").toString()
}