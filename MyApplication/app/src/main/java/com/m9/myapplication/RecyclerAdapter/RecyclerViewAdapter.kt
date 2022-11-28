package com.m9.myapplication.RecyclerAdapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.m9.myapplication.DB.SeleccionEspDBHelper
import com.m9.myapplication.Jugador
import com.m9.myapplication.R

class RecyclerViewAdapter(llistat: ArrayList<Jugador>, context: Context?, db: SeleccionEspDBHelper): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var dbHelper = db;
    var llistat: ArrayList<Jugador> = llistat;
    var context: Context? = context;
    override fun getItemCount(): Int {
        return llistat.size;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.txtequipo.setText(llistat.get(position).equipo,);
        holder.txtNom.setText(llistat.get(position).nombre);
        holder.btnDelete.setOnClickListener{
            dbHelper.deleteJugador(llistat.get(holder.adapterPosition).id);
            Toast.makeText(context, "Se ha eliminado correctamente", Toast.LENGTH_LONG).show();
            llistat.removeAt(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,llistat.size);
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNom: TextView = view.findViewById(R.id.txtView);
        val txtequipo: TextView = view.findViewById(R.id.textView2);
        val btnDelete :Button = view.findViewById(R.id.buttonDeleteJuagdor)
    }
}