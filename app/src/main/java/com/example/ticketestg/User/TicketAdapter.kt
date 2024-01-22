// TicketAdapter.kt
package com.example.ticketestg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TicketAdapter: ListAdapter<Ticket, TicketAdapter.TicketViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_senha, parent, false)
        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.item_senhaad, parent, false)
        return TicketViewHolder(view)
        return TicketViewHolder(view1)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = getItem(position)
        holder.bind(ticket)
    }

    class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nomeTextView: TextView = itemView.findViewById(R.id.editnomeuser)
        private val numeroTextView: TextView = itemView.findViewById(R.id.editnumero)
        private val emailTextView: TextView = itemView.findViewById(R.id.txtEmail)
        private val motivoTextView: TextView = itemView.findViewById(R.id.editmotivo)
        private val descricaoTextView: TextView = itemView.findViewById(R.id.editdescricao)

        fun bind(ticket: Ticket) {
            nomeTextView.text = "Nome: ${ticket.nomeUsuario}"
            numeroTextView.text = "Número: ${ticket.numeroContato}"
            emailTextView.text = "E-mail: ${ticket.email}"
            motivoTextView.text = "Motivo: ${ticket.motivo}"
            descricaoTextView.text = "Descrição: ${ticket.descricao}"
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Ticket>() {
        override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
            return oldItem == newItem
        }
    }

}
