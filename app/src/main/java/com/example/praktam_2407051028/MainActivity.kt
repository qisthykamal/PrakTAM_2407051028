package com.example.praktam_2407051028

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import com.example.praktam_2407051028.model.Fashion
import com.example.praktam_2407051028.model.Fashionsource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.praktam_2407051028.ui.theme.PrakTAM_2407051028Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_2407051028Theme {
                    FashionList(
                    )
                }
            }
        }
    }


@Composable
fun FashionList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Text(
                text = "Rekomendasi Populer",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(Fashionsource.QisFashion) { fashion ->
                    FashionRowItem(fashion)
                }
            }

            Spacer(modifier = Modifier.height(45.dp))

            Text(
                text = "Daftar Pilihan Fashion Lengkap",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        items(Fashionsource.QisFashion) { fashion ->
            DetailFashion(fashion)
        }
    }
}
        @Composable
        fun FashionRowItem(fashion: Fashion) {
            Card(
                modifier = Modifier.width(180.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = fashion.imageRes),
                        contentDescription = fashion.nama,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White) // 🔥 INI KUNCI
                            .padding(8.dp)
                    ) {
                        Text(
                            text = fashion.nama,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Text(
                            text = "Rp ${fashion.harga}",
                            color = Color.Black,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }


        @Composable
        fun DetailFashion(fashion: Fashion) {
            var isFavorite by remember { mutableStateOf(false) }
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),

                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {

                Column(modifier = Modifier.fillMaxSize()) {
                    Box {
                        Image(
                            painter = painterResource(id = fashion.imageRes),
                            contentDescription = fashion.nama,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )

                        IconButton(
                            onClick = { isFavorite = !isFavorite },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(8.dp)
                        )
                        {
                            Icon(
                                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Favorite Icon",
                                tint = if (isFavorite) Color.Red else Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = fashion.nama,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = fashion.deskripsi,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Rp ${fashion.harga}",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Text("Pesan Sekarang")
                    }
                }

            }

            @Preview(showBackground = true)
            @Composable
            fun DaftarMakananPreview() {
                PrakTAM_2407051028Theme() {
                    FashionList()
                }
            }
        }
