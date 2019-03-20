package com.xteam.lzp.kotlin2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //test1();
    DateUtil.nowDate;
    }


    val myMutableSet : MutableMap<String,String> = mutableMapOf("mxy" to "gss", Pair("wc","lzp"));
    val myMutableSet2 : MutableList<String> = mutableListOf("mxy" , "gss", "wc","lzp");
    var dataType : Int = 100;

    fun test1(){
        var array :IntArray = intArrayOf(1,2,3,4,5,65,4,654,98,76,543,12,312,654)
        if(3 !in array){

        }
        var desc : String? = null;
        var desc2 : String = "11";

        txt.text = desc!!.length.toString()
    }
    fun for3var(){


    }



}
