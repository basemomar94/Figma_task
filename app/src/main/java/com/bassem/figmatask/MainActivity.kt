package com.bassem.figmatask

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.bassem.figmatask.PaintView.Companion.currentBrush
import com.bassem.figmatask.databinding.ActivityMainBinding
import kotlin.io.path.Path

class MainActivity : AppCompatActivity() {
    val name:String=""
    var binding: ActivityMainBinding? = null
    var isPlate=false

    companion object {
        var path = android.graphics.Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding!!.root
        setContentView(view)


        //listeners
        binding?.paletBtu?.setOnClickListener {
            println(isPlate)

            if (!isPlate){
                binding?.colorLinear?.visibility=View.VISIBLE
                isPlate=true
            }
            else {
                binding!!.colorLinear.visibility=View.GONE
                isPlate=false
            }
        }
        binding!!.redBtu.setOnClickListener {
            paintBrush.color= Color.RED
            currentColor(paintBrush.color)

        }
        binding!!.blackBtu.setOnClickListener {
            paintBrush.color=  Color.BLACK
            currentColor(paintBrush.color)


        }
        binding!!.greenBtu.setOnClickListener {
            paintBrush.color= Color.GREEN
            currentColor(paintBrush.color)


        }
        binding!!.blueBtu.setOnClickListener {
            paintBrush.color= Color.BLUE
            currentColor(paintBrush.color)


        }


    }

    fun currentColor(color:Int){
        currentBrush=color
        path=android.graphics.Path()
    }
}