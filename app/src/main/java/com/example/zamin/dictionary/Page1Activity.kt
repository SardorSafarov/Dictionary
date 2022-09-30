package com.example.zamin.dictionary

import android.content.Intent
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zamin.dictionary.adapters.AdapterPage1
import com.example.zamin.dictionary.databinding.ActivityPage1Binding
import com.example.zamin.dictionary.need.D
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import java.io.InputStream

class Page1Activity : AppCompatActivity(), AdapterPage1.ItemClick {
    private lateinit var binding:ActivityPage1Binding
    var list: MutableList<String> = mutableListOf()
    var list1: MutableList<String> = mutableListOf()
    lateinit var adapter:AdapterPage1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPage1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val item=intent.getStringExtra("item").toString()
        binding.icBack.setOnClickListener {
            finish()
        }
        adapter = AdapterPage1(this)
        try {
            val myInput: InputStream
            val assetManager: AssetManager = getAssets()
            myInput = assetManager.open("soqqa.xls")
            val myFileSystem = POIFSFileSystem(myInput)
            val myWorkBook = HSSFWorkbook(myFileSystem)
            val mySheet = myWorkBook.getSheetAt(0)
            val rowIter = mySheet.rowIterator()
            while (rowIter.hasNext()) {
                val myRow = rowIter.next() as HSSFRow
                val cellIter = myRow.cellIterator()
                val myCell = cellIter.next() as HSSFCell
                if (myCell.toString() == item)
                    while (cellIter.hasNext()) {
                        val myCell = cellIter.next() as HSSFCell
                        list.add(myCell.toString())
                    }
            }
        } catch (e: Exception) {
            D("xatolik  ${e.message}\n$e")
        }
        list.forEach {

            list1.add((it.reversed().substring(it.reversed().indexOf(')')+1,it.reversed().indexOf('('))).reversed())
        }
       binding.apply {
           recView.adapter = adapter
           recView.layoutManager = LinearLayoutManager(this@Page1Activity)
           adapter.setList(list1)
       }
    }

    override fun clickItem(item: String) {
        val intent = Intent(this,Page2Activity::class.java)
        intent.putExtra("item",intent.getStringExtra("item"))
        list.forEach {
            if (it.contains(item)){
                intent.putExtra("body",it)
            }
        }
        startActivity(intent)
    }
}