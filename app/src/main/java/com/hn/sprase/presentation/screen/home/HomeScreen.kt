package com.hn.sprase.presentation.screen.home

import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hn.sprase.R
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeScreen(){
    var name by remember {
        mutableStateOf("Ugo")
    }

    var visibleMoney by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .statusBarsPadding()
            .padding(20.dp)
    ) {
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
                    Text("Good morning,", fontSize = 14.sp, fontWeight = FontWeight.Normal )
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
                            Brush.verticalGradient(
                                0f to Color.Black.copy(alpha = 0.1f),
                                1f to Color.Black.copy(alpha = 0.25f)
                            )
                        )
                )

                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("spare balance", color = Color.White.copy(alpha = 0.9f), style = MaterialTheme.typography.labelLarge)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            if(visibleMoney) "*******" else currency(545258.723),
                            color = Color.White,
                            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
                        )
                        Spacer(Modifier.width(8.dp))
                        IconButton(onClick = {visibleMoney = !visibleMoney}, modifier = Modifier.size(30.dp)) {
                            Icon(
                                if(visibleMoney) Icons.Outlined.Favorite else Icons.Outlined.Lock,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Surface(shape = RoundedCornerShape(50), color = Color.White, shadowElevation = 3.dp) {
                            Row(Modifier.padding(horizontal = 12.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                                Box(Modifier.size(6.dp).background(Color(0xFF407AFF) ,CircleShape))
                                Spacer(Modifier.width(4.dp))
                                Box(Modifier.size(6.dp).background(Color(0xFF407AFF), CircleShape))
                                Spacer(Modifier.width(8.dp))
                                Text("4552", color = Color(0xFF407AFF), style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium))
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PillActionButton(text = "Add money", icon = Icons.Outlined.Add, onClick = {})
            PillActionButton(text = "Withdraw",  icon = Icons.Outlined.ArrowDropDown, onClick = {})
            PillActionButton(text = "More...",   icon = Icons.Outlined.Menu, onClick = {})
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