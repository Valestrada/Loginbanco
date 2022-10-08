package com.example.loginbanco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Banco : AppCompatActivity() {
    private lateinit var cbVersaldo: CheckBox
    private lateinit var rbIngresar: RadioButton
    private lateinit var rbRetirar: RadioButton
    private lateinit var rbSalir: RadioButton
    private lateinit var tvVersaldo: TextView
    private lateinit var etnIngresar: EditText
    private lateinit var etnRetirar: EditText
    private var saldo = 100.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banco)

        cbVersaldo = findViewById(R.id.cb_versaldo)
        rbIngresar = findViewById(R.id.rb_ingresar)
        rbRetirar = findViewById(R.id.rb_retiro)
        rbSalir = findViewById(R.id.rb_salir)
        tvVersaldo = findViewById(R.id.tv_Versaldo)
        etnIngresar = findViewById(R.id.etn_registrar)
        etnRetirar = findViewById(R.id.etn_retirar)
    }

    fun accion(v: View) {
        tvVersaldo.visibility = View.INVISIBLE
        etnIngresar.visibility = View.INVISIBLE
        etnRetirar.visibility = View.INVISIBLE

        if (cbVersaldo.isChecked() == true) {
            tvVersaldo.visibility = View.VISIBLE
            tvVersaldo.text = "Saldo disponible $${saldo}"
        }
        if (rbIngresar.isChecked() == true) {
            etnIngresar.visibility = View.VISIBLE
        }
        if (rbRetirar.isChecked() == true) {
            etnRetirar.visibility = View.VISIBLE
        }
        if (rbSalir.isChecked() == true) {
            tvVersaldo.visibility = View.VISIBLE
            tvVersaldo.text = "¡Regrese pronto!"
            Toast.makeText(this, "Has decidido salir de la app", Toast.LENGTH_SHORT).show()
        }
    }

    fun procesar(Vista: View) {
        tvVersaldo.visibility = View.INVISIBLE
        etnIngresar.visibility = View.INVISIBLE
        etnRetirar.visibility = View.INVISIBLE
        if (cbVersaldo.isChecked() == true) {
            tvVersaldo.visibility = View.VISIBLE
            tvVersaldo.text = "Saldo disponible $${saldo}"
        }
        if (rbIngresar.isChecked() == true) {
            etnIngresar.visibility = View.VISIBLE
            var ingresar = etnIngresar.text.toString().toDouble()
            saldo = saldo + ingresar
            tvVersaldo.text = "Tu saldo es $$saldo"
            Toast.makeText(this, "Tu operacion se ralizo de forma exitosa", Toast.LENGTH_SHORT).show()
        }
        if (rbRetirar.isChecked() == true) {
            var retirar = etnRetirar.text.toString().toDouble()
            if (saldo - retirar < 0.0)
            {
                tvVersaldo.visibility = View.VISIBLE
                tvVersaldo.text = "Saldo Insuficiente"
            }
            else
            {
                saldo = saldo - retirar
                tvVersaldo.text = "Tu saldo es $$saldo"
                Toast.makeText(this,"Tu operacion se ralizo de forma exitosa", Toast.LENGTH_SHORT).show()
            }

        }
        if (rbSalir.isChecked() == true) {
            tvVersaldo.visibility = View.VISIBLE
            finish()
            System.exit(0)
        }

    }
}