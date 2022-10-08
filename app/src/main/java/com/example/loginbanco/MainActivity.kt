package com.example.loginbanco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // o private var etnombre: EditText? = null
    private lateinit var etnombre: EditText
    private lateinit var etcontraseña:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etnombre = findViewById(R.id.et_nombre)
        etnombre = findViewById(R.id.et_cotraseña)
    }

    fun registrar(Viste: View){
        val nombre = etnombre .text.toString()
        val contraseña = etcontraseña.text.toString()

        if(nombre.length == 0)
        {
            Toast.makeText(this, "Ingresar nombre", Toast.LENGTH_LONG).show()
        }
        if(contraseña.length == 0)
        {
            Toast.makeText(this, "Ingresar contraseña", Toast.LENGTH_LONG).show()
        }
        if (nombre.length!= 0 && contraseña.length!= 0)
        {
            Toast.makeText(this,"Registro en proceso...", Toast.LENGTH_LONG).show()

            if(nombre == "Valeria" && contraseña == "1234")
            {
                Toast.makeText(this, "Bienvenido al sistema bancario", Toast.LENGTH_LONG).show()
                val vBanco:Intent = Intent(this, Banco::class.java)
                startActivity(vBanco)
            }
            else
            {
                Toast.makeText(this, "Tu usuario o contraseña son erroneas", Toast.LENGTH_LONG).show()
            }
        }

    }


}