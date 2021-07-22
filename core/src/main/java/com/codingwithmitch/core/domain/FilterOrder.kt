package com.codingwithmitch.core.domain

sealed class SqlFilterOrder(val value: String, val uiValue: String,) {

    object Ascending: SqlFilterOrder("", "Asc")

    object Descending: SqlFilterOrder("-", "Desc")
}
