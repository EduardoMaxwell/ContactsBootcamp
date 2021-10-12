package com.eduardomaxwell.contactsbootcamp.model

data class Contact(
    val name: String,
    val phoneNumber: String,
    val picture: String? = null
)
