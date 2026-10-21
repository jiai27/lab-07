package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DriversScreen(navController: NavController) {
    
    var racerName by remember{
        mutableStateOf("")
    }

    var racers = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(color = Color.Black, text = "FormulaZero Drivers", fontSize = 28.sp, textAlign = TextAlign.Center)


        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            TextField(
                value = racerName,
                onValueChange = {
                    racerName = it
                },
                label = {
                    Text("Racer Name")
                },
                modifier = Modifier.testTag("nameInput")
            )
            
            Button(
                onClick = {
                    if (racerName.isNotBlank()){
                        racers.add(racerName)
                        racerName = ""
                    }
                    //println(racers)
                },
                modifier = Modifier.testTag("addDriverButton")
            ){
                Text("Add Driver")
            }

            LazyColumn(modifier = Modifier.testTag("racerList")){
                items(racers) { racer ->
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = racer,
                        fontSize = 12.sp
                    )
                }
            }

            Button(
                onClick = {
                    racers.clear()
                    //println(racers)
                },
                modifier = Modifier.testTag("clearButton")
            ){
                Text("Clear Drivers")
            }
        }


        Button(             //Back Button
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton")
        ){
            Text("Back")
        }


    }

}