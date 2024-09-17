package com.example.bliotech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bliotech.ui.theme.BliotechTheme

class ExibeEmprestimosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BliotechTheme {
                ExibeEmprestimos(
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExibeEmprestimos() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            val image = painterResource(id = R.drawable.logobliotech)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            // Titulo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
                    .padding(vertical = 8.dp, horizontal = 15.dp), // Padding interno
            ) {
                Text(
                    text = "Empréstimos",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .padding(top = 200.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Empréstimos Ativos:",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 15.dp),
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.LightGray)
                    .padding(vertical = 8.dp, horizontal = 15.dp), // Padding interno
            ) {
                Column(
                ) {
                    Text(
                        text = "Livro: Harry Potter\n" +
                                "CPF: 123.456.789-10\n" +
                                "Data Empréstimo: 11/09/24\n" +
                                "Data Devolução: 18/09/24\n",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Monospace
                    )
                    HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.secondary)
                    Text(
                        text = "Livro: Cachorrinho Samba\n" +
                                "CPF: 987.654.321-00\n" +
                                "Data Empréstimo: 12/09/24\n" +
                                "Data Devolução: 19/09/24\n",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Monospace
                    )
                    HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.secondary)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ExibeEmprestimosPreview() {
    BliotechTheme {
        ExibeEmprestimos()
    }
}