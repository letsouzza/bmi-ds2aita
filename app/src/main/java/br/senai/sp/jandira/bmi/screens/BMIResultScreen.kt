package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculate
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.numberConvertToLocale
import java.util.Locale

@Composable
fun BMIResultScreen(navegacao: NavHostController?) {

    val context = LocalContext.current
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)
    val userAge = userFile.getInt("user_age", 0)
    val userWeight = userFile.getFloat("user_weight", 0.0f)
    val userHeight = userFile.getFloat("user_height", 0.0f)

    //Obter os dados do IMC do usuário
    val result = bmiCalculate(
        userWeight.toInt(),
        userHeight.toDouble().div(100)
    )

    Box(
        modifier = Modifier
            .fillMaxSize( )
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
                    R.string.your_bmi
                ),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(20.dp)
                    .padding(top = 30.dp)
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
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card(
                        modifier = Modifier
                            .size(150.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 7.dp,
                            color = result.color
                        )
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = numberConvertToLocale(result.bmi.second),
                                fontSize = 50.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }
                    Text(
                        text = result.bmi.first,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(15.dp)
                    )
                    Card(
                        modifier = Modifier
                            .width(370.dp)
                            .height(100.dp),
                        colors = CardDefaults
                            .cardColors(
                                containerColor = Color(0xABAFA8E1)
                            )
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.age
                                    ),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "$userAge",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                            VerticalDivider(
                                modifier = Modifier
                                    .padding(vertical = 10.dp),
                                color = Color.Gray
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.weight
                                    ),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "$userWeight",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                            VerticalDivider(
                                modifier = Modifier
                                    .padding(vertical = 10.dp),
                                color = Color.Gray
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.height
                                    ),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "$userHeight",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                    ){
                        BmiLevel(
                            leftText = stringResource(R.string.under),
                            rightText = "< 18.5",
                            bulletColor = colorResource(R.color.light_blue),
                            background =
                                if(result.status == BmiStatus.UNDER_WEIGHT)
                                    colorResource(R.color.light_blue)
                                else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.normal),
                            rightText = "18.5 - 24.9",
                            bulletColor = colorResource(R.color.light_green),
                            background =
                            if(result.status == BmiStatus.NORMAL)
                                colorResource(R.color.light_green)
                            else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.over),
                            rightText = "25.0 - 29.9",
                            bulletColor = colorResource(R.color.yellow),
                            background =
                            if(result.status == BmiStatus.OVER_WEIGHT)
                                colorResource(R.color.yellow)
                            else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.class1),
                            rightText = "30.0 - 34.9",
                            bulletColor = colorResource(R.color.light_orange),
                            background =
                            if(result.status == BmiStatus.OBESITY_1)
                                colorResource(R.color.light_orange)
                            else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.class2),
                            rightText = "35.0 - 39.9",
                            bulletColor = colorResource(R.color.dark_orange),
                            background =
                            if(result.status == BmiStatus.OBESITY_2)
                                colorResource(R.color.dark_orange)
                            else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.class3),
                            rightText = "> 40.0",
                            bulletColor = colorResource(R.color.light_red),
                            background =
                            if(result.status == BmiStatus.OBESITY_3)
                                colorResource(R.color.light_red)
                            else Color.Transparent
                        )
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 30.dp),
                        color = Color.Gray
                    )
                    Button(
                        onClick = {
                            navegacao?.navigate("home")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF451693))
                    ){
                        Text(
                            text = stringResource(
                                R.string.new_calc
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
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}