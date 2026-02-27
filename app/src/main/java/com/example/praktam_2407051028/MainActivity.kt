package com.example.praktam_2407051028

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktam_2407051028.ui.theme.PrakTAM_2407051028Theme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.size
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_2407051028Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FashionList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FashionList(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Fashionsource.QisFashion.forEach { fashion ->

            Image(
                painter = painterResource(id = fashion.imageRes),
                contentDescription = fashion.nama,
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = "Nama: ${fashion.nama}")
            Text(text = "Deskripsi: ${fashion.deskripsi}")
            Text(text = "Harga: Rp ${fashion.harga}")

        }
    }
}
data class Fashion(
    val nama: String,
    val deskripsi: String,
    val harga: Int,
    val imageRes: Int
)

object Fashionsource {
    val QisFashion = listOf(
        Fashion("Kerudung", "Viscose", 100000, R.drawable.kerudung),
        Fashion("Rok", "Princess", 150000, R.drawable.rok),
        Fashion("Gamis", "Umbrella", 100000, R.drawable.gamis)
    )
}