package com.eduardomaxwell.contactsbootcamp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eduardomaxwell.contactsbootcamp.R
import com.eduardomaxwell.contactsbootcamp.model.Contact

class ContactAdapter(val contacts: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder =
        ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        )

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindView(contacts[position])
    }

    override fun getItemCount(): Int = contacts.size

    //    VIEW HOLDER
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(contact: Contact) {
            val name = itemView.findViewById<TextView>(R.id.nameContact)
            val phoneNumber = itemView.findViewById<TextView>(R.id.numberContact)
            val photo = itemView.findViewById<ImageView>(R.id.photoContact)

            name.text = contact.name
            phoneNumber.text = contact.phoneNumber
            Glide.with(itemView.context)
                .load(contact.picture)
                .circleCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(photo)

        }
    }
}