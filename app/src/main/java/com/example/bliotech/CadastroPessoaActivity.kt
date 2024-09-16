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
import androidx.compose.foundation.clickable
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.TextFieldDefaults
import kotlin.math.exp

class CadastroPessoaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BliotechTheme {
                CadastroPessoa(
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroPessoa() {
    var nome by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var generoFav by remember { mutableStateOf("") }
    var dataNasc by remember { mutableStateOf("") }
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
                    text = "Cadastro de Pessoa",
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
            // Nome
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // CPF
            TextField(
                value = cpf,
                onValueChange = { cpf = it },
                label = { Text("CPF") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Endereço
            TextField(
                value = endereco,
                onValueChange = {},
                label = { Text("Endereço") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Genero Favorito
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }

            ) {
                TextField(
                    value = generoFav,
                    onValueChange = { generoFav = it },
                    label = { Text("Gênero Favorito") },
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
                                generoFav = genero
                                expanded = false // Fecha o menu ao selecionar
                            }
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(20.dp))

            // Data de Nascimento
            TextField(
                value = dataNasc,
                onValueChange = { dataNasc = it },
                label = { Text("Data de Nascimento") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

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
                    text = "Finalizar Cadastro",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }

            if (msgConfirm){
                AlertDialog(
                    onDismissRequest = { msgConfirm = false },
                    title = { Text(text = "Sucesso")},
                    text = {Text("Empréstimo concluido com sucesso!")},
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
fun CadastroPessoaPreview() {
    BliotechTheme {
        CadastroPessoa()
    }
}