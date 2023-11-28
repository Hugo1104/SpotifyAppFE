package com.laioffer.spotify

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.laioffer.spotify.ui.theme.SpotifyTheme

// customized extend AppCompatActivity
class MainActivity : AppCompatActivity() {

    private val TAG = "lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "We are at onCreate()");

        setContent {
            SpotifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    var name by remember { mutableStateOf("") }
//
//                    // name -> state
//                    // onNameChange -> event
//                    HelloContentWithStateless(name) { typingText ->
//                        name = typingText }
                    AlbumCover()
                }
            }
        }
    }
}

@Composable
private fun AlbumCover() {
    Column {
        Box(modifier = Modifier.size(160.dp)) {
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/en/d/d1/Stillfantasy.jpg",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = "Still Fantasy",
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 2.dp)
                    .align(Alignment.BottomStart),
            )
        }

        Text(
            text = "Jay Chou",
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            color = Color.LightGray,
        )
    }
}

@Composable
private fun HelloContentWithState() {
    var name by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        if (name.isNotEmpty()) {
            Text(
                text = "Hello! $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.body2
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
    }
}

@Composable
private fun HelloContentWithStateless(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (name.isNotEmpty()) {
            Text(
                text = "Hello! $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.body2
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}



@Composable
fun ArtistCardBox() {
    Box {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Composable
fun ArtistCardColumn() {
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Composable
fun ArtistCardRow() {
    Row {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Preview
@Composable
fun PreviewArtistCard() {
    SpotifyTheme {
        Surface {
            Column {
                ArtistCardBox()
                ArtistCardColumn()
                ArtistCardRow()
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)
        .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello")
        Text(text = name)
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 732)
@Composable
fun DefaultPreview() {
    SpotifyTheme {
        Surface {
            AlbumCover()
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SpotifyTheme {
//        Surface {
//            Greeting("Android")
//        }
//    }
//}

//@Preview
//@Composable
//fun PreviewHelloContent() {
//    SpotifyTheme {
//        Surface {
//            HelloContent()
//        }
//    }
//}