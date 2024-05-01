package com.upc.comunity.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class Post(
    val title: String,
    val author: String,
    val views: Int,
    val likes: Int,
    val comments: Int,
    val rating: Float,
    val imageUrl: Any
    ) {

}

@Composable
fun SearchBar() {
    val searchText = remember { mutableStateOf("") }

    TextField(
        value = searchText.value,
        onValueChange = { newText -> searchText.value = newText },
        label = { Text("Buscar") },

        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(16.dp)
            .clip(RoundedCornerShape(20.dp)),
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Icono de búsqueda") },
        singleLine = true,

        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search)
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Community() {
    // Lista de ejemplo, idealmente esto debería ser proporcionado por un modelo de datos o ViewModel
    val posts = listOf(
        Post("Oportunidades de Negocio en Ferias Agrícolas", "Arturo Vidal", 965987, 67987, 74, 4.9f,"https://acortar.link/FmZYIV" ),
        Post("Iniciando en la Hidroponía: Consejos para principiantes", "Paolo Guerrero", 456987, 66342, 22, 4.9f, "https://acortar.link/FmZYIV"),
        Post("Oportunidades de Negocio en Ferias Agrícolas", "Marco Antonio", 67569, 6759, 23, 4.9f, "https://acortar.link/FmZYIV")
    )

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF313131))
            ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = { }, colors = ButtonDefaults.buttonColors(
                            Color.Red)) {
                            Text("Crear Post")
                        }

                        
                    }
                    SearchBar()
                    TopAppBar(title = { Text("Publicaciones Recientes") })
                }

        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(posts) { post ->
                PostItem(post)
            }
        }
    }
}
@Composable
fun PostItem(post: Post) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

    ) {


            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = post.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "Por ${post.author}", fontSize = 14.sp, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Text(text = "${post.views} Visitas", Modifier.weight(1f))
                    Text(text = "${post.likes} Me gusta", Modifier.weight(1f))
                    Text(text = "${post.comments} Comentarios", Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "${post.rating} ★", fontWeight = FontWeight.Bold, fontSize = 14.sp)

                Button(onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF224F34),
                        contentColor = Color.White
                    )) {
                    Text("ver más ")
                }
            }


    }
}