package com.example.bliotech

import android.annotation.SuppressLint
import android.content.Intent
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bliotech.ui.theme.BliotechTheme
import androidx.compose.ui.text.font.FontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BliotechTheme {
                TelaInicial(onNavigate = { destination: String ->
                    when (destination) {
                        "CadastroLivro" -> startActivity(
                            Intent(this, CadastroLivroActivity::class.java)
                        )
                        "CadastroPessoa" -> startActivity(
                            Intent(this, CadastroPessoaActivity::class.java)
                        )
                        "BuscaLivro" -> startActivity(
                            Intent(this, BuscaLivroActivity::class.java)
                        )
                        "ExibeEmprestimos" -> startActivity(
                            Intent(this, ExibeEmprestimosActivity::class.java)
                        )
                        "NovoEmprestimo" -> startActivity(
                            Intent(this, NovoEmprestimoActivity::class.java)
                        )
                    }
                })
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun TelaInicialPreview() {
    BliotechTheme {
        TelaInicial(onNavigate = {})
    }
}

@Composable
fun BotaoEstilizado(text: String, onClick: () -> Unit){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF8C0009),
            contentColor = Color.White
        ),
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Composable
fun TelaInicial(onNavigate: (String) -> Unit) {
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

            // Texto bem vindo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
                    .padding(vertical = 8.dp, horizontal = 15.dp), // Padding interno
            ) {
                Text(
                    text = "Bem Vindo(a)!",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

        // Botões
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(0.9f)
                .padding(top = 200.dp, bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            BotaoEstilizado(text = "Cadastro de Livro", onClick = { onNavigate("CadastroLivro") })

            Spacer(modifier = Modifier.height(16.dp))

            BotaoEstilizado(text = "Cadastro de Pessoa", onClick = { onNavigate("CadastroPessoa") })

            Spacer(modifier = Modifier.height(16.dp))

            BotaoEstilizado(text = "Buscar Livro", onClick = { onNavigate("BuscaLivro") })

            Spacer(modifier = Modifier.height(16.dp))

            BotaoEstilizado(text = "Exibir Empréstimos", onClick = { onNavigate("ExibeEmprestimos") })

            Spacer(modifier = Modifier.height(16.dp))

            BotaoEstilizado(text = "Novo Empréstimo", onClick = { onNavigate("NovoEmprestimo") })

        }

        // Texto de ajuda
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.08f)
                .align(Alignment.BottomEnd),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
                    .padding(vertical = 8.dp, horizontal = 15.dp), // Padding interno
            ) {
                Text(
                    text = "Ajuda",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }
}


