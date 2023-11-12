package com.ifam.hotelll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.internal.NavigationMenu
import com.ifam.hotelll.databinding.ActivityMainBinding
import com.ifam.hotelll.databinding.TelaPrincipalAppBinding
import com.ifam.hotelll.ui.buscar.Buscar
import com.ifam.hotelll.ui.conta.Conta
import com.ifam.hotelll.ui.dashboard.Navegacao
import com.ifam.hotelll.ui.home.Home

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: TelaPrincipalAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaPrincipalAppBinding.inflate(layoutInflater)

        setContentView(binding.root)
        replaceFragment(Home())

        binding.botaoNavegacao.setOnItemSelectedListener { menuItem ->

            when(menuItem.itemId) {

                R.id.navigation_home -> replaceFragment(Home())
                R.id.navigation_navegacao -> replaceFragment(Navegacao())
                R.id.navigation_buscar -> replaceFragment(Buscar())
                R.id.navigation_conta ->  replaceFragment(Conta())
                // Adicione outros casos conforme necessário

                else -> {
                    // Lidar com outras opções do menu aqui, se necessário
                }

            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
