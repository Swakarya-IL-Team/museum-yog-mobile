package com.swakarya.museumyog.data.model

data class DataDropdown(
    val title: String,
    val description: String
)

val dataDropdown = listOf(
    DataDropdown(
        title = "Bagaimana cara memesan tiket museum melalui aplikasi?",
        description = "Berikut cara memesan tiket museum melalui aplikasi: "
    ),
    DataDropdown(
        title = "Bagaimana cara mencari informasi tentang museum tertentu?",
        description = "Berikut cara mencari informasi tentang museum tertentu: "
    ),
    DataDropdown(
        title = "Bagaimana cara mengatur dan mengelola akun saya?",
        description = "Berikut cara mengatur dan mengelola akun saya: "
    ),
    DataDropdown(
        title = "Bagaimana cara melaporkan bug atau masalah lainnya kepada tim pengembangan kami?",
        description = "Berikut cara melaporkan bug atau masalah lainnya kepada tim pengembangan kami: "
    ),
)