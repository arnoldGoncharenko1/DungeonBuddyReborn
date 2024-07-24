package com.houseravenstudios.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ClassList(
    val count: Int,
    val results: List<ClassResultsItem>
)

@Serializable
data class ClassResultsItem(
    val index: String,
    val name: String,
    val url: String
)
