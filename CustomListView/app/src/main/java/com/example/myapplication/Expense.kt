package com.example.myapplication

import kotlinx.android.synthetic.main.list_item.view.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

data class Expense(val item: String, val price: Float) {

    fun getFormattedPrice(): String = formatter.format(price)

    companion object {
        private val formatter: NumberFormat =  NumberFormat.getCurrencyInstance()
        init {
            formatter.currency = Currency.getInstance("INR")
        }

        fun total(expenses : ArrayList<Expense>) : String {
            var total: Float = 0f
            expenses.forEach {
                total += it.price
            }
            return formatter.format(total)
        }
    }
}