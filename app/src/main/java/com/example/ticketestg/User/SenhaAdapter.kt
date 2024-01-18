package com.example.ticketestg.User

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketestg.Historico
import com.example.ticketestg.R

class SenhaAdapter(var listaSenhas: Historico) :
    RecyclerView.Adapter<SenhaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtNome: TextView = itemView.findViewById(R.id.editnomeuser)
        val txtNumero: TextView = itemView.findViewById(R.id.editnumero)
        val txtMail: TextView = itemView.findViewById(R.id.editemail)
        val txtMotivo: TextView = itemView.findViewById(R.id.editmotivo)
        val txtDescricao: TextView = itemView.findViewById(R.id.editdescrição)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_senha, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}