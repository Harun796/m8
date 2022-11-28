package com.m9.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.m9.myapplication.DB.SeleccionEspDBHelper
import com.m9.myapplication.Jugador
import com.m9.myapplication.R
import com.m9.myapplication.RecyclerAdapter.RecyclerViewAdapter

class ListFragment(dbHelber: SeleccionEspDBHelper) : Fragment() {

    val dbHelper : SeleccionEspDBHelper = dbHelber;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View= inflater.inflate(R.layout.fragment_list, container, false);
        var llistat : ArrayList<Jugador> = dbHelper.getJugadores();
        var recyclerView: RecyclerView = view.findViewById(R.id.recycler);
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter : RecyclerViewAdapter = RecyclerViewAdapter(llistat, context, dbHelper);
        recyclerView.adapter = adapter
        return view;
    }
}