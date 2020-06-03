package com.example.cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOne.setOnClickListener{appendOnExpression("1",true)}
        tvTwo.setOnClickListener{appendOnExpression("2",true)}
        tvThree.setOnClickListener{appendOnExpression("3",true)}
        tvFour.setOnClickListener{appendOnExpression("4",true)}
        tvFive.setOnClickListener{appendOnExpression("5",true)}
        tvSix.setOnClickListener{appendOnExpression("6",true)}
        tvSeven.setOnClickListener{appendOnExpression("7",true)}
        tvEight.setOnClickListener{appendOnExpression("8",true)}
        tvNine.setOnClickListener{appendOnExpression("9",true)}
        tvZero.setOnClickListener{appendOnExpression("0",true)}
        tvDot.setOnClickListener{appendOnExpression(".",true)}

        tvPlus.setOnClickListener{appendOnExpression("+",false)}
        tvMinus.setOnClickListener{appendOnExpression("-",false)}
        tvMultiply.setOnClickListener{appendOnExpression("*",false)}
        tvDivide.setOnClickListener{appendOnExpression("/",false)}
        tvOpen.setOnClickListener{appendOnExpression("{",false)}
        tvClose.setOnClickListener{appendOnExpression("}",false)}

        tvClear.setOnClickListener{
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener{
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener{
            try{
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                var result = expression.evaluate()
                var longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = longResult.toString()
            }catch (e:Exception){
                Log.d("Exception"," message " + e.message)
            }
        }

    }

    fun appendOnExpression(string: String, canClear : Boolean){

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if(canClear){
            tvResult.text=""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

}