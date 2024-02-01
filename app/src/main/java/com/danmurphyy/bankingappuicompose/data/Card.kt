package com.danmurphyy.bankingappuicompose.data

import androidx.compose.ui.graphics.Brush

data class Card(
    var cardType: String,
    var cardNumber: String,
    var cardName: String,
    var balance: Double,
    var color: Brush,
)
