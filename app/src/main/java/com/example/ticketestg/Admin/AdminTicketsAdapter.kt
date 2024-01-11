// AdminTicketsAdapter.kt
package com.example.ticketestg.Admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketestg.R

class AdminTicketsAdapter :
    ListAdapter<AdminTicketModel, AdminTicketsAdapter.AdminTicketViewHolder>(AdminTicketDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminTicketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.admin_ticket_item, parent, false)
        return AdminTicketViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdminTicketViewHolder, position: Int) {
        val currentTicket = getItem(position)
        holder.bind(currentTicket)
    }

    inner class AdminTicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ticketIdTextView: TextView = itemView.findViewById(R.id.textViewTicketId)
        private val userNameTextView: TextView = itemView.findViewById(R.id.textViewUserName)
        private val ticketStatusTextView: TextView = itemView.findViewById(R.id.textViewTicketStatus)

        fun bind(ticket: AdminTicketModel) {
            ticketIdTextView.text = "Ticket ID: ${ticket.ticketId}"
            userNameTextView.text = "User: ${ticket.userName}"
            ticketStatusTextView.text = "Status: ${ticket.ticketStatus}"
        }
    }

    private class AdminTicketDiffCallback : DiffUtil.ItemCallback<AdminTicketModel>() {
        override fun areItemsTheSame(oldItem: AdminTicketModel, newItem: AdminTicketModel): Boolean {
            return oldItem.ticketId == newItem.ticketId
        }

        override fun areContentsTheSame(oldItem: AdminTicketModel, newItem: AdminTicketModel): Boolean {
            return oldItem == newItem
        }
    }
}
