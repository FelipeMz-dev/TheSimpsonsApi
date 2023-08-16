package com.example.thesimpsonsapi.view

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.animalapi.R
import com.example.thesimpsonsapi.viewmodel.MainViewModel
import com.example.thesimpsonsapi.data.model.Character
import com.example.thesimpsonsapi.ui.theme.AnimalApiTheme

private var listCharacter: List<Character> = listOf(
    Character("personage 1", "cuerpo del elemento animal con solo dos lineas", ""),
    Character(
        "personage 2",
        "cuerpo del elemento animal, aunque este texto tenga mas lineas solo va a mostrar 2 lineas de si mismo",
        ""
    ),
    Character("personage 3", "cuerpo del elemento animal", ""),
    Character("personage 4", "cuerpo del elemento animal", ""),
    Character("personage 5", "cuerpo del elemento animal", ""),
    Character("personage 6", "cuerpo del elemento animal", ""),
    Character("personage 7", "cuerpo del elemento animal", ""),
    Character("personage 8", "cuerpo del elemento animal", ""),
    Character("personage 9", "cuerpo del elemento animal", ""),
    Character("personage 10", "cuerpo del elemento animal", ""),
    Character("personage 11", "cuerpo del elemento animal", "")
)

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list: List<Character> by viewModel.items.collectAsState()
            ElementMaker(list)
        }
        viewModel.fetchCharacters(this)
    }
}

@Composable
fun ElementMaker(Characters: List<Character>) {
    AnimalApiTheme {
        LazyColumn(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(6.dp)
        ) {
            items(Characters) { Character ->
                ElementComponent(Character)
            }
        }
    }
}

@Composable
fun ElementComponent(characterElement: Character) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        ElementImage(characterElement.urlImage)
        Spacer(modifier = Modifier.width(8.dp))
        ElementTexts(characterElement)
    }
}

@Composable
fun ElementTexts(characterElement: Character) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        Text(
            characterElement.name,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            characterElement.history,
            color = MaterialTheme.colorScheme.onPrimary,
            maxLines = if (isExpanded) Int.MAX_VALUE else 2
        )
    }
}

@Composable
fun ElementImage(url: String) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.baseline_visibility_off_24)
        }
    )
    Image(
        painter = painter,
        "image",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary)
            .size(72.dp)
    )
}

@Preview
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    AnimalApiTheme {
        ElementMaker(listCharacter)
    }
}