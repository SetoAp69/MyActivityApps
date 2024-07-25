package com.excal.myactivityapps

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    var harga:Int=0;
    var jumlah:Int=0;

    private lateinit var input_harga:EditText
    private lateinit var input_jumlah:EditText
    private lateinit var tv_total:TextView
    private lateinit var btn_hitung:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        input_harga=findViewById(R.id.Input_Harga)
        input_jumlah=findViewById(R.id.Input_Jumlah)
        tv_total=findViewById(R.id.Tv_HargaTotal)
        btn_hitung=findViewById(R.id.btn_hitung)
        btn_hitung.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }

    fun calculate():Int{
        return harga*jumlah

    }

    override fun onClick(p0: View?) {

        if(p0?.id==R.id.btn_hitung){
            val inputHarga=if (input_harga.text.toString()!="") input_harga.text.toString().toInt()  else 0
            val inputJumlah=if (input_jumlah.text.toString()!="") input_jumlah.text.toString().toInt()  else 0

            tv_total.text=(inputHarga*inputJumlah).toString()
        }
    }
}