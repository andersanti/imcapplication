package com.andersanti.imcapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        Log.w("lifecycle", "CREATED - estou criando a tela")
    }

    private fun setListeners(){
        heigthEDT?.doAfterTextChanged { text ->
          //  Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        weigthEDT?.doOnTextChanged { text, _, _, _ ->
            // tittleTXT?.text = text
        }
        calculationBTN.setOnClickListener{
            calcularIMC(weigthEDT.text.toString(), heigthEDT.text.toString())
        }
        }

    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null){
            val imc = peso / (altura * altura)
            resultIMC.text = "Seu IMC é: %.2f".format(imc)
        }
    }


    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "START - deixei a tela visível para você")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "RESUMO - agora você pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle", "PAUSE - a tela perdeu o foco, você não pode mais interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.w("lifecycle", "STOP - a tela não está mais visível, mas ainda existe")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle", "\nRESTART - a tela está retomando ao foco")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecycle", "\nDESTROY - oh não! A tela foi destruída")
    }

}