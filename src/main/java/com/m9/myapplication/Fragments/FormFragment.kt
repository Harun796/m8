package com.m9.myapplication.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.m9.myapplication.BottomNav
import com.m9.myapplication.DB.SeleccionEspDBHelper
import com.m9.myapplication.Jugador
import com.m9.myapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment(db:SeleccionEspDBHelper) : Fragment() {
    var dbHelper = db;
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

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v:View= inflater.inflate(R.layout.fragment_form, container, false)

        var equipo: EditText = v.findViewById(R.id.TextTeamSeleccion)
        var nombre: EditText = v.findViewById(R.id.TextNameSeleccion)
        var guardar: Button = v.findViewById(R.id.buttonAddPlayer);
        var delete:Button= v.findViewById(R.id.buttonAllPlayers);
        guardar.setOnClickListener {
            var player: Jugador =Jugador(0, equipo.text.toString(),nombre.text.toString())
            dbHelper.insertJugador(player);
        }
        delete.setOnClickListener{
            dbHelper.deleteAllJugadores();
        }
        //Declaras el click del boton de guardar
            //recoger los textos de los inputs --> nombre.text.toString();
            //Creas el objeto Jugador
            // var j:Jugador = Jugador( , )

            //Llamar a la bd para añadir el jugador

        return v;
    }
    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

}