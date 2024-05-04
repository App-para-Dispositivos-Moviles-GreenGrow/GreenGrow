package com.upc.comunity.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.upc.comunity.model.data.Course


@Composable
fun Courses(){
    val courses = listOf(
        Course("Fundamento 1",
            "Fund. de hidroponia",
            "$ 0.00",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Catharanthus_roseus_white_CC-BY-SA.jpg/640px-Catharanthus_roseus_white_CC-BY-SA.jpg"),
        Course("Cultivo Avanza",
            "Cult.Avanza.de Int.",
            "$ 0.00",
            "https://algoritmomag.com/wp-content/uploads/2024/02/hidroponia-casera.jpg"),
        Course("Fundamento 1",
            "Fund. de hidroponia",
            "$ 0.00",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Catharanthus_roseus_white_CC-BY-SA.jpg/640px-Catharanthus_roseus_white_CC-BY-SA.jpg"),
        Course("Cultivo Avanza",
            "Cult.Avanza.de Int.",
            "$ 0.00",
            "https://algoritmomag.com/wp-content/uploads/2024/02/hidroponia-casera.jpg"),
        Course("Fundamento 1",
            "Fund. de hidroponia",
            "$ 0.00",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Catharanthus_roseus_white_CC-BY-SA.jpg/640px-Catharanthus_roseus_white_CC-BY-SA.jpg"),
        Course("Cultivo Avanza",
            "Cult.Avanza.de Int.",
            "$ 0.00",
            "https://algoritmomag.com/wp-content/uploads/2024/02/hidroponia-casera.jpg"),
        Course("Fundamento 1",
            "Fund. de hidroponia",
            "$ 0.00",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Catharanthus_roseus_white_CC-BY-SA.jpg/640px-Catharanthus_roseus_white_CC-BY-SA.jpg"),
        Course("Cultivo Avanza",
            "Cult.Avanza.de Int.",
            "$ 0.00",
            "https://algoritmomag.com/wp-content/uploads/2024/02/hidroponia-casera.jpg")
        )

    Scaffold (
        topBar = { TopBarCourses()}
    ){
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            CoursesGrid(courses)
        }
    }
}

@Composable
fun CoursesGrid(courses: List<Course>){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        columns = GridCells.Fixed(2)
    ) {
        items(courses){course ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CourseItem(course)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun TopBarCourses(){
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
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(70.dp))
            )
        }
        SearchBar()
    }
}
