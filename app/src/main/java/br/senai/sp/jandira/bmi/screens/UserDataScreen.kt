package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(modifier: Modifier = Modifier) {

    var ageState = remember{
        mutableStateOf("Age")
    }
    var weightState = remember {
        mutableStateOf("Weight")
    }
    var heightState = remember {
        mutableStateOf("Height")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF9B81DC),
                            Color(0xFF6945A8)
                        )
                    )
                )
        ){
            Text(
                text = stringResource(
                    R.string.hi
                ),
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(50.dp)
                    .weight(1f)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f)
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 50.dp
                )
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        Column{
                            Image(
                                painter = painterResource(
                                    R.drawable.perfilhomem
                                ),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(150.dp)
                            )
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .width(140.dp)
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.male
                                    )
                                )
                            }
                        }
                        Column {
                            Image(
                                painter = painterResource(
                                    R.drawable.perfilmulher
                                ),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(150.dp)
                            )
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .width(140.dp)
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.female
                                    )
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = ageState.value,
                        onValueChange = { it ->
                            ageState.value = it
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Cake,
                                contentDescription = "",
                                tint = Color(0xFF9B81DC)
                            )
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp)
                    )

                    OutlinedTextField(
                        value = weightState.value,
                        onValueChange = { it ->
                            weightState.value = it
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Balance,
                                contentDescription = "",
                                tint = Color(0xFF9B81DC)
                            )
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                    )

                    OutlinedTextField(
                        value = heightState.value,
                        onValueChange = { it ->
                            heightState.value = it
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Height,
                                contentDescription = "",
                                tint = Color(0xFF9B81DC)
                            )
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                    )

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF471894))
                    ){
                        Text(
                            text = stringResource(
                                R.string.calculate
                            ),
                            fontSize = 25.sp
                        )
                    }
                }

            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen()
}