package br.senai.sp.jandira.bmi.calcs

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.model.Bmi
import br.senai.sp.jandira.bmi.model.BmiStatus
import kotlin.math.pow

@Composable

fun bmiCalculate(weight: Int, height: Double): Bmi {
//    Formar de calcular o imc
//    var bmi = weight / (height * height)
//    var bmi = weight.div(height.pow(2))

    var bmi = weight / height.pow(2)

//    Outra forma de fazer o IF no Kotlin
    when{
        bmi < 18.5 -> // A setinha significa entaão
            return Bmi(
                color = colorResource(R.color.light_blue),
                status = BmiStatus.UNDER_WEIGHT,
                bmi = Pair(stringResource(R.string.under_weight), bmi)
            )
        bmi >= 18.5 && bmi < 25.0 -> // A setinha significa entaão
            return Bmi(
                color = colorResource(R.color.light_green),
                status = BmiStatus.NORMAL,
                bmi = Pair(stringResource(R.string.normal_weight), bmi)
            )
        bmi >= 25.0 && bmi < 30.0 -> // A setinha significa entaão
            return Bmi(
                color = colorResource(R.color.yellow),
                status = BmiStatus.OVER_WEIGHT,
                bmi = Pair(stringResource(R.string.over_weight), bmi)
            )
        bmi >= 30.0 && bmi < 35.0 -> // A setinha significa entaão
            return Bmi(
                color = colorResource(R.color.light_orange),
                status = BmiStatus.OBESITY_1,
                bmi = Pair(stringResource(R.string.class1_weight), bmi)
            )
        bmi >= 35.0 && bmi < 40.0 -> // A setinha significa entaão
            return Bmi(
                color = colorResource(R.color.dark_orange),
                status = BmiStatus.OBESITY_2,
                bmi = Pair(stringResource(R.string.class2_weight), bmi)
            )
        else ->
            return Bmi(
                color = colorResource(R.color.light_red),
                status = BmiStatus.OBESITY_3,
                bmi = Pair(stringResource(R.string.class3_weight), bmi)
            )
    }
}