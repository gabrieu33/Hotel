package com.ifam.hotelll

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

import com.ifam.hotelll.util.Configuracaobd

class CadastrarConta : AppCompatActivity() {

    private lateinit var autenticacao: FirebaseAuth
    private lateinit var campoNome: EditText
    private lateinit var campoEmail: EditText
    private lateinit var campoSenha: EditText
    private lateinit var buttonCadastrar: Button
    private val configuracaoBd = Configuracaobd()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastrarconta)

        inicializar()
    }

    private fun inicializar() {
        campoNome = findViewById(R.id.CadNome)
        campoEmail = findViewById(R.id.CadEmail)
        campoSenha = findViewById(R.id.CadSenha)
        buttonCadastrar = findViewById(R.id.buttonCad)

        buttonCadastrar.setOnClickListener {
            validarCampos(campoNome, campoEmail, campoSenha)
        }
    }

    private fun validarCampos(campoNome: EditText, campoEmail: EditText, campoSenha: EditText) {
        val nome = campoNome.text.toString().trim()
        val email = campoEmail.text.toString().trim()
        val senha = campoSenha.text.toString().trim()

        if (nome.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty()) {
            val usuario = Usuario(nome, email, senha)
            cadastrarUsuario(nome, email, senha)
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cadastrarUsuario(nome: String, email: String, senha: String) {
        autenticacao = configuracaoBd.FirebaseAutenticacao()

        autenticacao.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val usuarioFirebase = task.result?.user
                    Toast.makeText(this@CadastrarConta, "Sucesso ao cadastrar o usuário", Toast.LENGTH_SHORT).show()
                } else {
                    try {
                        throw task.exception!!
                    } catch (e: FirebaseAuthWeakPasswordException) {
                        Toast.makeText(this@CadastrarConta, "Digite uma senha mais forte", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(this@CadastrarConta, "Digite um email válido", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthUserCollisionException) {
                        Toast.makeText(this@CadastrarConta, "Esta conta já existe", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        Toast.makeText(this@CadastrarConta, "Ops, ocorreu um erro: ${e.message}", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                }
            }
    }
}

