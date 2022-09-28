package com.example.zamin.dictionary

import android.content.Intent
import android.content.res.AssetManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.zamin.dictionary.databinding.ActivityMainBinding
import com.example.zamin.dictionary.need.D
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import java.io.InputStream
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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



        fun readExcelFileFromAssets() {
            try {
                val myInput: InputStream
                val assetManager: AssetManager = getAssets()
                myInput = assetManager.open("sardor.xls")
                val myFileSystem = POIFSFileSystem(myInput)
                val myWorkBook = HSSFWorkbook(myFileSystem)
                val mySheet = myWorkBook.getSheetAt(0)
                val rowIter = mySheet.rowIterator()
                var rowno = 0
                while (rowIter.hasNext()) {
                    val myRow = rowIter.next() as HSSFRow
                    if (rowno != 0) {
                        val cellIter = myRow.cellIterator()
                        var colno = 0
                        var ikkinch = ""
                        var uchinch = ""
                        var turtinch = ""
                        var beshinchi = ""
                        while (cellIter.hasNext()) {
                            val myCell = cellIter.next() as HSSFCell
                            D("$myCell")
                            when (colno) {
                                1 ->
                                    ikkinch = myCell.toString()
                                2 ->
                                    uchinch = myCell.toString()
                                3 ->
                                    turtinch = myCell.toString()
                                4 ->
                                    beshinchi = myCell.toString()
                            }

                            colno++
                        }
                    }
                    rowno++
                }
            } catch (e: Exception) {
                D("xatolik  ${e.message}\n$e")
            }

        }
    }
}