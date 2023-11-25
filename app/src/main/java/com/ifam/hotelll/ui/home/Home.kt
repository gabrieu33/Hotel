package com.ifam.hotelll.ui.home

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.ifam.hotelll.MainActivity
import com.ifam.hotelll.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // Obter referência para o botão
        val btnLocal = view.findViewById<Button>(R.id.btnlocal)
        val btnData = view.findViewById<Button>(R.id.btnData)
        val btnHospedes = view.findViewById<Button>(R.id.btnHospede)

        // Definir um ouvinte de clique para o botão
        btnLocal.setOnClickListener {
            // Ação a ser executada quando o botão é clicado
            // Neste exemplo, estamos voltando para a MainActivity
            val mainActivityIntent = Intent(activity, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }
        btnData.setOnClickListener {
            // Ação a ser executada quando o botão é clicado
            // Neste exemplo, estamos voltando para a MainActivity
            val mainActivityIntent = Intent(activity, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }
        btnHospedes.setOnClickListener {
            // Ação a ser executada quando o botão é clicado
            // Neste exemplo, estamos voltando para a MainActivity
            val mainActivityIntent = Intent(activity, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}