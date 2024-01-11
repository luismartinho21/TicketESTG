package com.example.ticketestg.User

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.ticketestg.R
import androidx.recyclerview.widget.RecyclerView

class UserHistoryAdapter :
    ListAdapter<UserHistoryModel, UserHistoryAdapter.UserHistoryViewHolder>(UserHistoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_history_item, parent, false)
        return UserHistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserHistoryViewHolder, position: Int) {
        val currentTicket = getItem(position)
        holder.bind(currentTicket)
    }

    inner class UserHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ticketIdTextView: TextView = itemView.findViewById(R.id.textViewUserHistoryTicketId)
        private val ticketStatusTextView: TextView = itemView.findViewById(R.id.textViewUserHistoryTicketStatus)

        fun bind(ticket: UserHistoryModel) {
            ticketIdTextView.text = "Ticket ID: ${ticket.ticketId}"
            ticketStatusTextView.text = "Status: ${ticket.ticketStatus}"
        }
    }

    private class UserHistoryDiffCallback : DiffUtil.ItemCallback<UserHistoryModel>() {
        override fun areItemsTheSame(oldItem: UserHistoryModel, newItem: UserHistoryModel): Boolean {
            return oldItem.ticketId == newItem.ticketId
        }

        override fun areContentsTheSame(oldItem: UserHistoryModel, newItem: UserHistoryModel): Boolean {
            return oldItem == newItem
        }
    }
}