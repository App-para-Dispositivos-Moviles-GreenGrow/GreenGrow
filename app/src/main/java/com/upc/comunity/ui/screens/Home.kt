package com.upc.comunity.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage

import com.upc.comunity.model.data.Course
import com.upc.comunity.model.data.Service

@Composable
fun Home(){
    val courses = listOf(
        Course("Fundamento 1",
            "Fund. de hidroponia",
            "$ 0.00",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Catharanthus_roseus_white_CC-BY-SA.jpg/640px-Catharanthus_roseus_white_CC-BY-SA.jpg"),
        Course("Cultivo Avanza",
            "Cult.Avanza.de Int.",
            "$ 0.00",
"https://algoritmomag.com/wp-content/uploads/2024/02/hidroponia-casera.jpg")    )

    val services = listOf(
        Service("Cursos", "https://www.edx.org/contentful/ii9ehdcj88bc/2depiIx5lt9DcoegVedK0c/0c302992182a12f41bea84160cc96cad/Aprende_agricultura.jpg?w=509&h=339&q=50&fm=webp"),
        Service("Comunidad", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRblql0uxNbA3BFjZ81lawCLfSN6GzLnNK0mX6cCzWmg2Mvrj_7")
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
                        .padding(16.dp, 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Location", color = Color.White)
                        Text(text = "Lima, Peru", color = Color.White)
                    }
                    GlideImage(
                        imageModel = { "https://wac-cdn.atlassian.com/es/dam/jcr:ba03a215-2f45-40f5-8540-b2015223c918/Max-R_Headshot%20(1).jpg?cdnVersion=1587" },
                        modifier = Modifier.size(50.dp).
                        clip(RoundedCornerShape(70.dp))
                    )
                }
                GlideImage(
                    imageModel = { "https://www.lazoht.com/images/servicio_10.jpg" },
                    modifier = Modifier.padding(16.dp, 10.dp).
                    fillMaxWidth().height(100.dp).
                    clip(RoundedCornerShape(20.dp))
                )
            }

        },
    ){
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            HomeContent(courses, services)
        }
    }
}

@Composable
fun HomeContent(courses: List<Course>, services: List<Service>){
    Column {
        Subtitles(title = "Mas destacados")
        CourseList(courses = courses)
        Subtitles(title = "Nuestros servicios")
        ServiceList(services = services)
    }
}

@Composable
fun CourseList(courses: List<Course>){
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(courses) { course ->
            CourseItem(course)
        }
    }
}

@Composable
fun ServiceList(services: List<Service>){
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        items(services) { service ->
            ServiceItem(service)
        }
    }
}

@Composable
fun CourseItem(course: Course){
    Card(
        modifier = Modifier.size(140.dp, 210.dp)
    ){
        Column {
            CourseImage(url = course.photo, size = 140.dp)
            Text(text = course.title, fontWeight = FontWeight.Bold)
            Text(text = course.description, fontSize = 12.sp)
            Row {
                Text(text = course.price, modifier = Modifier.weight(6f))
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.
                    clip(RoundedCornerShape(5.dp)).
                    background(Color(0xFF224F34)).
                    size(25.dp)
                ) {
                    Icon(Icons.Rounded.Add, contentDescription = "Add course to shopp",
                        tint = Color.White)
                }
            }
        }
    }
}

@Composable
fun CourseImage(url: String, size: Dp){
    GlideImage(
        imageModel = { url }, modifier = Modifier.size(size)
    )

}

@Composable
fun Subtitles(title: String){
    Text(text = title,
        Modifier
            .fillMaxWidth()
            .padding(16.dp), textAlign = TextAlign.Center,
        fontSize = 24.sp,
        color = Color(0xFF224F34),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ServiceItem(service: Service) {
    Card(
        modifier = Modifier.size(140.dp, 180.dp)
    ){
        Column {
            CourseImage(url = service.photo, size = 140.dp)
            Text(text = service.title,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
        }
    }
}
