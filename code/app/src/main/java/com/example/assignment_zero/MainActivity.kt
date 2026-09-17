package com.example.assignment_zero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.assignment_zero.ui.theme.Assignment_zeroTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //create interface with title "Decide For Me!"
            //three buttons
            //first button: Yay! 80%
            //second button: Maybe. 50%
            //third button: not really... 15%
            //area which displays text saying Go or Don't Go
            //num which keeps track of how many times clicked
            //text at bottom
            Assignment_zeroTheme {
                ButtonScreen()
            }
        }
    }
}

@Composable
fun Greeting(titletext: String, modifier: Modifier = Modifier) {
    Text(
        text = titletext,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment_zeroTheme {
        Greeting("Decide For Me!")
    }
}

// function GiveChanceResult
//takes in a threshhold int of what is needed for a yes, calculates random chance and returns the result as a 0 (yes) or 1 (no)

fun giveChanceResult(chance:Int): String{
    if(chance > Random.nextInt(0, 100)){
        return "Yes"
    }
    return "No"
}
//function buttonscreen
//ui screen, holds buttons
@Composable
fun ButtonScreen(){
    var buttonCounter by remember { mutableIntStateOf(0) } //counter init
    var result by remember{mutableStateOf("Should We Go?")}

    Column ( //column for title, result text and counter
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ){
        Spacer(modifier = Modifier.height(200.dp))
        //title
        Text(text=result, fontSize =  12.em, modifier=Modifier.fillMaxWidth(), textAlign=TextAlign.Center)

        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                space=12.dp,
                alignment = Alignment.CenterHorizontally
            )
        ){
            //button one: yes button (80%)
            Button(
                onClick ={
                    buttonCounter++
                    result = giveChanceResult(80)
                }
            ){
                Text(text="Sure!")
            }
            Spacer(modifier = Modifier.height(16.dp))
            //button two: maybe button (50%)
            Button(
                onClick ={
                    buttonCounter++
                    result = giveChanceResult(50)}
            ){
                Text(text="Maybe...")
            }
            Spacer(modifier = Modifier.height(16.dp))
            //button three: ehh button (15%)
            Button(
                onClick ={buttonCounter++
                    result = giveChanceResult(15)}
            ){
                Text(text="Nah.")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Total Times Clicked: $buttonCounter times.",
            fontSize = 24.sp,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            textAlign=TextAlign.Center
        )
        Text(
            text = "Credit: @ 2026 rusic , 1721833",
            fontSize = 18.sp
        )
    }
    /*
    Spacer(modifier = Modifier.height(16.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ){ //button column
        Row(modifier = Modifier.fillMaxWidth()){
            //button one: yes button (80%)
            Button(
                onClick ={
                    buttonCounter++
                }
            ){
                Text(text="Yes!")
            }
            Spacer(modifier = Modifier.height(16.dp))
            //button two: maybe button (50%)
            Button(
                onClick ={buttonCounter++}
            ){
                Text(text="Maybe...")
            }
            Spacer(modifier = Modifier.height(16.dp))
            //button three: ehh button (15%)
            Button(
                onClick ={buttonCounter++}
            ){
                Text(text="Nah.")
            }
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)
    ){//credit column

    }
     */
}