package com.example.bliotech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import java.text.SimpleDateFormat
import java.util.*

class NovoEmprestimoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BliotechTheme {
                NovoEmprestimo(

                )
            }
        }
    }
}


@Composable
fun NovoEmprestimo() {
    var cpf by remember { mutableStateOf("") }
    var isbn by remember { mutableStateOf("") }
    val dataAtual= SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
    var returnData by remember { mutableStateOf("") }
    var msgConfirm by remember { mutableStateOf(false) }

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
                    text = "Novo Empréstimo",
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
                .fillMaxHeight(0.9f)
                .padding(top = 200.dp, bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // CPF
            TextField(
                value = cpf,
                onValueChange = { cpf = it },
                label = { Text("CPF") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // ISBN
            TextField(
                value = isbn,
                onValueChange = { isbn = it },
                label = { Text("ISBN do Livro") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Data de Empréstimo (data atual do sistema)
            TextField(
                value = dataAtual,
                onValueChange = {},
                enabled = false,
                label = { Text("Data de Empréstimo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Data de Devolução (input do usuário)
            TextField(
                value = returnData,
                onValueChange = { returnData = it },
                label = { Text("Data de Devolução") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Botão de finalizar empréstimo
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
                    text = "Finalizar Empréstimo",
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
fun NovoEmprestimoPreview() {
    BliotechTheme {
        NovoEmprestimo()
    }
}
