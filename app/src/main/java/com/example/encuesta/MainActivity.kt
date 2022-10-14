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
            var marcas = "Especialidad/es:"
            if (marca1.isChecked()) {
                marcas += " DAM "
            }
            if (marca2.isChecked()) {
                marcas += " ASIR  "
            }
            if (marca3.isChecked()) {
                marcas += " DAW "
            }
            listaEncuestas.add(Encuesta(nombre.text.toString(),msg,marcas,barra.progress))
            //oculto.setText(oculto.text.toString()+nombre.text.toString()+" "+" "+msg+ " "+marcas+" "+"Horas: " +textoBarra.text.toString()+System.getProperty("line.separator"))


            nombre.setText("")
            nombre.isEnabled=true
            anon.isChecked=false
            radio1.isChecked=false
            radio2.isChecked=false
            radio3.isChecked=false
            marca1.isChecked=false
            marca2.isChecked=false
            marca3.isChecked=false
            barra.progress=0
        }

        //este es el codigo de la barra

        barra.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textoBarra.setText(barra.progress.toString())
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        var miBoton2: Button = findViewById(R.id.botonReiniciar)
        miBoton2.setOnClickListener() {
            listaEncuestas.clear()
            nombre.setText("")
            nombre.isEnabled=true
            anon.isChecked=false
            radio1.isChecked=false
            radio2.isChecked=false
            radio3.isChecked=false
            marca1.isChecked=false
            marca2.isChecked=false
            marca3.isChecked=false
            barra.progress=0
            oculto.setText("")
            resumen.setText("")
        }
        var miBoton3: Button = findViewById(R.id.botonContar)
        miBoton3.setOnClickListener() {

            Toast.makeText(this, "Hay "+listaEncuestas.size.toString()+" encuesta/s", Toast.LENGTH_LONG).show()
        }
        var miBoton4: Button = findViewById(R.id.botonResumen)
        miBoton4.setOnClickListener() {

            oculto.text = ""
            for(i in 0..listaEncuestas.size-1){

                oculto.setText(oculto.text.toString()+listaEncuestas[i].Nombre+", "+listaEncuestas[i].sistema+", "+listaEncuestas[i].especialidad+", Horas: "+listaEncuestas[i].horas.toString()+System.getProperty("line.separator"))

            }
            resumen.setText(oculto.text)
        }
    }


}
