package com.hn.sprase.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hn.sprase.R
import com.hn.sprase.domain.model.TimeRange
import com.hn.sprase.presentation.ui.components.RangePill
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun HomeScreen(){
    var name by remember {
        mutableStateOf("Ugo")
    }

    var visibleMoney by remember {
        mutableStateOf(false)
    }

    var range by remember { mutableStateOf(TimeRange.Week) }

    val transactions = remember {
        listOf(
            Tx("Sent to Wilfred Alfred", "06 May 2022", -50.60),
            Tx("Groceries - Walmart",   "05 May 2022", -32.45),
            Tx("Deposit into spare",    "05 May 2022", 150.00),
            Tx("Uber Ride",             "04 May 2022", -7.25),
            Tx("App Store Refund",      "04 May 2022",  3.99),
            Tx("Salary",                "03 May 2022", 2350.00),
            Tx("Coffee Shop",           "03 May 2022", -4.80),
            Tx("Electricity Bill",      "02 May 2022", -45.10),
            Tx("Restaurant - Bento",    "01 May 2022", -12.30),
            Tx("ATM Withdrawal",        "30 Apr 2022", -120.00)
        )
    }

    val chartBars = remember { listOf(36f, 34f, 52f, 63f, 28f, 40f, 22f) }
    val chartLabels = remember { listOf("Apr 30","May 01","May 02","May 03","May 04","May 05","May 06") }

    val balanceGradient = remember {
        Brush.verticalGradient(
            0f to Color.Black.copy(alpha = 0.1f),
            1f to Color.Black.copy(alpha = 0.25f)
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
    ) {
        item(key = "header") {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = "https://cellphones.com.vn/sforum/wp-content/uploads/2024/01/avartar-anime-6.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop, // Cắt ảnh cho vừa khung
                        modifier = Modifier
                            .size(45.dp)                // set kích thước
                            .clip(CircleShape)
                    )
                    Spacer(Modifier.width(10.dp))
                    Column {
                        Text("Good morning,", fontSize = 14.sp, fontWeight = FontWeight.Normal)
                        Text(name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }
                IconButton(onClick = {}, modifier = Modifier.size(60.dp)) {
                    BadgedBox(
                        badge = {
                            Badge {
                                Text("5")
                            }
                        }
                    ) {
                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = null,
                            tint = Color(0xFF407AFF),
                            modifier = Modifier.size(30.dp),
                        )
                    }
                }
            }
        }

        item (key = "money"){
            Spacer(Modifier.height(20.dp))

            Card(
                modifier = Modifier,
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Box(
                    Modifier.fillMaxWidth()
                        .height(130.dp)
                        .clip((RoundedCornerShape(22.dp)))
                ) {
                    Image(
                        painter = painterResource(R.drawable.homebg),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.matchParentSize()
                    )

                    Box(
                        Modifier.matchParentSize()
                            .background(
                               balanceGradient
                            )
                    )

                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(horizontal = 20.dp, vertical = 16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "spare balance",
                            color = Color.White.copy(alpha = 0.9f),
                            style = MaterialTheme.typography.labelLarge
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                if (visibleMoney) "*******" else currency(545258.723),
                                color = Color.White,
                                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
                            )
                            Spacer(Modifier.width(8.dp))
                            IconButton(
                                onClick = { visibleMoney = !visibleMoney },
                                modifier = Modifier.size(30.dp)
                            ) {
                                Icon(
                                    if (visibleMoney) Icons.Outlined.Favorite else Icons.Outlined.Lock,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = Color.White,
                                shadowElevation = 3.dp
                            ) {
                                Row(
                                    Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        Modifier.size(6.dp)
                                            .background(Color(0xFF407AFF), CircleShape)
                                    )
                                    Spacer(Modifier.width(4.dp))
                                    Box(
                                        Modifier.size(6.dp)
                                            .background(Color(0xFF407AFF), CircleShape)
                                    )
                                    Spacer(Modifier.width(8.dp))
                                    Text(
                                        "4552",
                                        color = Color(0xFF407AFF),
                                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        item(key = "list_btn") {

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PillActionButton(text = "Add money", icon = Icons.Outlined.Add, onClick = {})
                PillActionButton(
                    text = "Withdraw",
                    icon = Icons.Outlined.ArrowDropDown,
                    onClick = {})
                PillActionButton(text = "More...", icon = Icons.Outlined.Menu, onClick = {})
            }

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("My Analysis", style = MaterialTheme.typography.headlineSmall, color = Color(0xFF0F172A), fontWeight = FontWeight.Bold)
                RangePill(range = range, onRangeChange = { range = it })
            }
        }

        item(key = "chart") {
            ChartCard(
                bars = chartBars,
                labels = chartLabels,
                highlightIndex = 2,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(220.dp)
            )
        }

        item(key = "title") {
            Spacer(Modifier.height(12.dp))
            Text(
                "May, 2025",
                modifier = Modifier.padding(horizontal = 16.dp, 8.dp),
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                color = Color(0xFF0F172A)
            )
        }

        items(transactions, key = { tx -> "${tx.tile}_${tx.date}" }) { tx ->
            TransactionRow(
                tx = tx,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 6.dp)
                    .fillMaxWidth()
            )
        }


    }
}

private fun currency(value: Double): String {
    val nf = NumberFormat.getCurrencyInstance(Locale.US)
    nf.maximumFractionDigits = 2; nf.minimumFractionDigits = 2
    return nf.format(value)
}

@Composable
fun PillActionButton(
    text : String,
    icon : ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    borderColor: Color = Color(0xFF407AFF),
    textColor: Color = Color(0xFF111827),
    iconTint: Color = Color(0xFF407AFF)
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.5.dp, borderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = textColor
        ),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 5.dp),
        modifier = modifier.height(34.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(18.dp)
        )
        Spacer(Modifier.width(5.dp))
        Text(text, color = textColor, fontWeight = FontWeight.Medium, fontSize = 10.sp)

    }
}

@Composable
private fun ChartCard(
    bars: List<Float>,
    labels: List<String>,
    highlightIndex: Int?,
    modifier: Modifier = Modifier,
    barWidth: Dp = 16.dp
){
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        tonalElevation = 0.dp,
        shadowElevation = 2.dp
    ) {
        Column(Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 12.dp)) {
            Box(Modifier.fillMaxWidth().height(150.dp)){
                BarsChart(
                    values = bars,
                    highlightIndex = highlightIndex,
                    barWidth = barWidth
                )
            }

            Row(
                Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                labels.forEachIndexed { i, lbl ->
                    Text(
                        lbl,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (i == highlightIndex) Color(0xFF63F0CB).copy(alpha = 0.9f) else Color(0xFF64748B)
                    )
                }
            }
        }
    }
}

@Composable
private fun BarsChart(
    values: List<Float>,
    highlightIndex: Int?,
    modifier: Modifier = Modifier,
    barWidth: Dp = 16.dp,
    girdLines: Int = 4
){
    val max = remember(values) { (values.maxOrNull() ?: 0f).coerceAtLeast(1f) }
    val dash = remember { PathEffect.dashPathEffect(floatArrayOf(10f, 14f), 0f) }

    Canvas(modifier = modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val bw = barWidth.toPx()

        // ✅ Chia đều width cho mỗi bar (giống SpaceBetween)
        val sectionWidth = w / values.size

        repeat(girdLines) { i ->
            val y = h * (1f - (i + 1) / (girdLines + 1f))
            drawLine(
                color = Color(0xFFE6EEFF),
                start = androidx.compose.ui.geometry.Offset(0f, y),
                end = androidx.compose.ui.geometry.Offset(w, y),
                strokeWidth = 2f,
                pathEffect = dash
            )
        }

        values.forEachIndexed { index, v ->
            // ✅ Căn giữa bar trong section của nó
            val sectionStart = index * sectionWidth
            val left = sectionStart + (sectionWidth - bw) / 2f

            val barHeight = (v / max) * (h * 0.9f)
            val top = h - barHeight
            val color = if(index == highlightIndex) Color(0xFF63F0CB) else Color(0xFF407AFF)

            drawRoundRect(
                color = color,
                topLeft = androidx.compose.ui.geometry.Offset(left, top),
                size = androidx.compose.ui.geometry.Size(bw, barHeight),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(bw / 2f, bw / 2f)
            )
        }
    }
}
data class Tx(
    val  tile: String,
    val  date: String,
    val amount: Double
)

@Composable
private fun TransactionRow(tx : Tx, modifier: Modifier = Modifier){
    val amountColor = remember(tx.amount) { // ✅ Cache
        if(tx.amount >= 0) Color(0xFF10B981) else Color(0xFFEF4444)
    }
    val dotColor = remember(tx.amount) { // ✅ Cache
        if(tx.amount >= 0) Color(0xFF63F0CB) else Color(0xFF407AFF)
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        tonalElevation = 0.dp,
        shadowElevation = 0.5.dp,
        onClick = {}
    ) {
        Row(
            Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.size(28.dp)
                    .clip(CircleShape)
                    .background(dotColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ){
                Box(Modifier.size(10.dp).clip(CircleShape).background(dotColor))
            }

            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    tx.tile,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                    maxLines = 1, overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF0F172A)
                )
                Text(
                    tx.date,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFF94A3B8)
                )
            }
            Spacer(Modifier.width(12.dp))
            Text(
                text = (if (tx.amount >= 0) "+" else "") + formatMoney(tx.amount),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = amountColor
            )
        }
    }

}

private fun formatMoney(v : Double) : String {
    val sign = if( v < 0) "-" else ""
    val abs = kotlin.math.abs(v)
    val cents = ((abs - abs.toInt()) +100).roundToInt()
    val whole = abs.toInt()
    val withComma = "%,d".format(whole)
    return "$sign$$withComma.${cents.toString().padStart(2, '0')}"
}