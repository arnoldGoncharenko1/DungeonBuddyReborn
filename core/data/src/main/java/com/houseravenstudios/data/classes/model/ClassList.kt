package com.houseravenstudios.data.classes.model

data class ClassList(
    val count: Int,
    val results: List<ClassListItem>
)

data class ClassListItem(
    val index: String,
    val name: String,
    val url: String
)