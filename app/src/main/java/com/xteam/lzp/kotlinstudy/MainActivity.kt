package com.xteam.lzp.kotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun getArrayStringData(){
        var string_array : Array<String> = arrayOf("How","do","you","do");
        var str : String? = "";
        var index : Int = 0;
        while(index < string_array.size){
            str += string_array[index]+"，";
            index ++;
        }
    }

    fun getStringFun(){
        var str : String = "Who am I? You are Kotlin Man."
        //index and substring
        if(str.indexOf("?") > 0){
            str = str.substring(0,str.indexOf("?"))
        }

        //注意，split返回的是List<String>
        var strList : List<String> = str.split("?")
        var strResult : String = "";
        for(item in strList){
            strResult += item +"，"
        }

        //字符串的获取还可以直接通过下标获取
        var strIndex5 : String = str[5].toString();
        var strIndex6 : String = str.get(6).toString();


        text.text = "You can do it!!add...${str}"
    }

    fun getListData(){
        var strList : List<String> = listOf("I","you","she");
    }
    val myMutableSet : MutableSet<String> = mutableSetOf("mxy","gss","wc","lzp");
    val myMutableList : MutableList<String> = mutableListOf("mxy","gss","wc","lzp");
    val myMutableMap : Map<String,String> = mapOf(Pair("1","gss"),"2 " to "gss");
    fun showSet_Forin(){
        var desc = "";
        for(item in myMutableSet){
            desc = "${desc}名称：${item}";
        }
    }

    fun showSet_Iterator(){
        var desc = "";
        var iterator = myMutableSet.iterator();
        while(iterator.hasNext()){
            val item = iterator.next();
            desc = "${desc}名称：${item}";
        }
    }

    fun showSet_ForEach(){
        var desc = "";
        //it 是内部使用的子对象
        myMutableSet.forEach{desc = "${desc}名称：${it}"}
    }

    fun showList_indexFor() : String{
        var desc = "";
        for( i in myMutableList.indices){
            val item = myMutableList[i];
            desc = "${desc}名称：${item}"
        }
        myMutableList.sortBy { it.length }
        myMutableList.sortByDescending { it.length }

        return desc;
    }

    fun showMap_forIn(){
        var desc = "";
        for(item in myMutableMap){
            desc = "${desc}${item.key}的名字是：${item.value}"
        }
    }

    fun showMap_ForEach(){
        var desc = "";
        //foreach 内部使用key 和value
        myMutableMap.forEach{key,value ->
            desc = "${desc}${key}的名字是：${value}"
        }
    }

    fun showMap_iterator(){
        var desc = "";
        var iterator = myMutableMap.iterator();
        while(iterator.hasNext()){
            val item = iterator.next();
            desc = "${desc}${item.key}的名字是：${item.value}"
        }

    }

}
