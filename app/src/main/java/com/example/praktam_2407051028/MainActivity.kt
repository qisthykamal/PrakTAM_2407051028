package com.example.praktam_2407051028

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktam_2407051028.ui.theme.PrakTAM_2407051028Theme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.size
import com.example.praktam_2407051028.model.Fashion
import com.example.praktam_2407051028.model.Fashionsource
import androidx.compose.ui.tooling.preview.Preview

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    )

    {
        Fashionsource.QisFashion.forEach { fashion ->
            DetailFashion(fashion = fashion)
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
            @Composable
            fun DetailFashion(fashion: Fashion) {
                Column(modifier = Modifier.fillMaxWidth()) {

                    Image(
                        painter = painterResource(id = fashion.imageRes),
                        contentDescription = fashion.nama,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )

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
                        text = "Harga: Rp ${fashion.harga}",
                        style = MaterialTheme.typography.bodyLarge
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
