package com.danmurphyy.bankingappuicompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danmurphyy.bankingappuicompose.data.Card
import com.danmurphyy.bankingappuicompose.ui.theme.BlueEnd
import com.danmurphyy.bankingappuicompose.ui.theme.BlueStart
import com.danmurphyy.bankingappuicompose.ui.theme.GreenEnd
import com.danmurphyy.bankingappuicompose.ui.theme.GreenStart
import com.danmurphyy.bankingappuicompose.ui.theme.OrangeEnd
import com.danmurphyy.bankingappuicompose.ui.theme.OrangeStart
import com.danmurphyy.bankingappuicompose.ui.theme.PurpleEnd
import com.danmurphyy.bankingappuicompose.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "0123 4567 8910 1234",
        cardName = "Business",
        balance = 46.77,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "0123 4567 8910 1111",
        cardName = "Savings",
        balance = 56.77,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "0123 4567 8910 2233",
        cardName = "School",
        balance = 6.77,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "0123 4567 8910 4455",
        cardName = "Trips",
        balance = 26.77,
        color = getGradient(GreenStart, GreenEnd)
    ),
)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            startColor, endColor
        )
    )
}

@Preview
@Composable
fun CardsSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int,
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(
        modifier = Modifier.padding(
            start = 16.dp,
            end = lastItemPaddingEnd
        )
    ) {
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .clickable { }
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )


        }
    }

}