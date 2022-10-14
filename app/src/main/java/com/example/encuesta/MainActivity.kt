package com.example.encuesta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nombre:TextView=findViewById(R.id.editTextTextPersonName)
        var anon: Switch=findViewById(R.id.switch1)
        var listaEncuestas= ArrayList<Encuesta>()
        anon.setOnClickListener() {
            nombre.isEnabled = !anon.isChecked
        }

        var oculto:TextView=findViewById(R.id.textView5)
        var resumen :TextView = findViewById(R.id.txtResumen)

        var migrupo1: RadioGroup=findViewById(R.id.grupo1)
        var radio1: RadioButton=findViewById(R.id.radioButton)
        var radio2: RadioButton=findViewById(R.id.radioButton2)
        var radio3: RadioButton=findViewById(R.id.radioButton3)
        var marca1:CheckBox=findViewById(R.id.checkBox)
        var marca2:CheckBox=findViewById(R.id.checkBox2)
        var marca3:CheckBox=findViewById(R.id.checkBox3)
        var textoBarra:TextView=findViewById(R.id.txvSlider)
        var barra:SeekBar= findViewById(R.id.seekBar)
        textoBarra.setText("0")



        var miBoton: Button = findViewById(R.id.botonValidar)
        miBoton.setOnClickListener() {
            if (anon.isChecked) {
                nombre.setText("Anónimo")
            }
            var msg = ""

            when {
                radio1.isChecked -> msg = radio1.text.toString()
                radio2.isChecked -> msg = radio2.text.toString()
                radio3.isChecked -> msg = radio3.text.toString()
            }
        }}

}

