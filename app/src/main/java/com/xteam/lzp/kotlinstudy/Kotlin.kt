package com.xteam.lzp.kotlinstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class Kotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun kotlin2ifelse(){
        var desc = 1;
        desc = if(1 > 2) 2 else 3;
    }

    fun for3var(){
        //从11开始遍历到66  包括11不包括66
        for(i in 11 until 66){ }

        //每次递增4
        for(i in 23..89 step 4){ }

        //递减
        for(i in 50 downTo 7){ }
    }

    fun whileTest(){
        var poem : String = "";
        var i : Int = 0;
        var poemArray : MutableList<String> = mutableListOf("how","do","hyou");

        do{
            if(i%2 == 0){

            }else{

            }
            i++;
        }while(i < poemArray.size)

    }

    fun jumpFor(){
        var poemArray : MutableList<String> = mutableListOf("how","do","hyou");
        var i : Int = 0;
        var is_found = false;
        outside@ while(i < poemArray.size){
            var j = 0;
            var item = poemArray[i];
            while(j < item.length){
                if(item[j] == 'w'){
                    is_found = true;
                    break@outside;
                }
                j++;
            }
            if(is_found)
                break;
            i ++;
        }
    }

}