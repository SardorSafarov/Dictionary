package com.example.zamin.dictionary

import android.content.Intent
import android.content.res.AssetManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zamin.dictionary.adapters.AdapterMain
import com.example.zamin.dictionary.databinding.ActivityMainBinding
import com.example.zamin.dictionary.need.D
import com.example.zamin.dictionary.need.listToGson
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import java.io.InputStream
import java.lang.Exception


class MainActivity : AppCompatActivity(), AdapterMain.ItemClick {
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: AdapterMain
    var list: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.txt.setOnClickListener {
                startActivity(Intent(this, Page1Activity::class.java))
            }
        }
        adapter = AdapterMain(this)
        readExel()
    }

    fun readExel() {
        try {
            val myInput: InputStream
            val assetManager: AssetManager = getAssets()
            myInput = assetManager.open("soqqa.xls")
            val myFileSystem = POIFSFileSystem(myInput)
            val myWorkBook = HSSFWorkbook(myFileSystem)
            val mySheet = myWorkBook.getSheetAt(1)
            val rowIter = mySheet.rowIterator()
            while (rowIter.hasNext()) {
                val myRow = rowIter.next() as HSSFRow
                val cellIter = myRow.cellIterator()
                val myCell = cellIter.next() as HSSFCell
                list.add(myCell.toString())
            }
        } catch (e: Exception) {
            D("xatolik  ${e.message}\n$e")
        }

        binding.apply {
            recView.adapter = adapter
            recView.layoutManager = LinearLayoutManager(this@MainActivity)
            list.removeFirst()
            adapter.setList(list)
        }

    }

    override fun clickItem(item: String) {
        val intent = Intent(this, Page1Activity::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }


}