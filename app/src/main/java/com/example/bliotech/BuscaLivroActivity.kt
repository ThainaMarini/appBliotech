package com.example.bliotech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults

class BuscaLivroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BliotechTheme {
                BuscaLivro(
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscaLivro() {
    var titulo by remember { mutableStateOf("") }
    var autor by remember { mutableStateOf("") }
    var generoLiv by remember { mutableStateOf("") }
    var msgConfirm by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val generos = listOf("Ficção", "Horror", "Romance", "Fantasia")


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
                    text = "Buscar Livro",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

        // Campos
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .padding(top = 200.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            TextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Autor
            TextField(
                value = autor,
                onValueChange = {},
                label = { Text("Autor") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Genero
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }

            ) {
                TextField(
                    value = generoLiv,
                    onValueChange = { generoLiv = it },
                    label = { Text("Gênero") },
                    readOnly = true, // Impede edição direta
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    generos.forEach { genero ->
                        DropdownMenuItem(
                            text = { Text(genero) },
                            onClick = {
                                generoLiv = genero
                                expanded = false // Fecha o menu ao selecionar
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botão de finalizar
            Button(
                onClick = { msgConfirm = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text(
                    text = "Buscar",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }

            if (msgConfirm){
                AlertDialog(
                    onDismissRequest = { msgConfirm = false },
                    title = { Text(text = "Sucesso")},
                    text = {Text("Livro encontrado!")},
                    confirmButton = {
                        Button(
                            onClick = {msgConfirm = false}
                        ){
                            Text("Ok")
                        }
                    })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BuscaLivroPreview() {
    BliotechTheme {
        BuscaLivro()
    }
}