package com.ifam.hotelll

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.ifam.hotelll.util.Configuracaobd

class MainActivity : AppCompatActivity() {

    private lateinit var autenticacao: FirebaseAuth
    private lateinit var campoEmail: EditText
    private lateinit var campoSenha: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializar()
        //Botao Para Entrar e se Increver
        val botaocriar: Button = findViewById(R.id.increver)
        botaocriar.setOnClickListener {
            val intent = Intent(this, CadastrarConta::class.java)
            startActivity(intent)
        }

    }



    private fun inicializar() {
        campoEmail = findViewById(R.id.CampoEmailLogin)
        campoSenha = findViewById(R.id.CampoSenhaLogin)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            validarLogin(campoEmail, campoSenha)
        }
    }

    private fun validarLogin(campoEmail: EditText, campoSenha: EditText) {
        val email = campoEmail.text.toString().trim()
        val senha = campoSenha.text.toString().trim()

        if (email.isNotEmpty() && senha.isNotEmpty()) {
            realizarLogin(email, senha)
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun realizarLogin(email: String, senha: String) {
        autenticacao = FirebaseAuth.getInstance()

        autenticacao.signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, TelaPrincipal::class.java)
                    startActivity(intent)
                    finish() 
                } else {
                    try {
                        throw task.exception!!
                    } catch (e: FirebaseAuthWeakPasswordException) {
                        Toast.makeText(this@MainActivity, "Digite uma senha mais forte", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(this@MainActivity, "Credenciais inválidas, verifique o e-mail e a senha", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthUserCollisionException) {
                        Toast.makeText(this@MainActivity, "Esta conta já existe", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        Toast.makeText(this@MainActivity, "Ops, ocorreu um erro: ${e.message}", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                }
            }
    }


}