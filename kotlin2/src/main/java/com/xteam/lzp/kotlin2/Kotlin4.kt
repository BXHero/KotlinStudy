package com.xteam.lzp.kotlin2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class Kotlin4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin4)
        //1.2.2命名参数
        //getDinnerInput2(1,water="就是水");

        //getDinnerInput3("hiahia1","hiahia2","hiahia3","hiahia4");


        //getDinnerInput4(arrayOf("How","do","you","do"),arrayOf("hiahia1","hiahia2","hiahia3","hiahia4"));
//        appendStringTest();

        longToast("${factorial2(10)}");
    }

    //1.1.2参数格式
    fun getDinnerEmpty(){}

    fun getDinnerInput(egg : Int,leek : Double,water : String? ,shell :Float){}

    //1.1.3输参格式
    fun main() : Int{
        return 0;
    }
    //无返参
    fun main2() : Unit{}

    //1.2.1默认参数
    fun getDinnerInput2(egg : Int=1,leek : Double=2.2,water : String?="搅拌一下" ,shell :Float=0.5f){
        toast("egg:${egg}，leek:${leek}，water:${water}，shell:${shell}，")
    }

    //1.2.3可变参数
    fun getDinnerInput3(vararg otherArray : String?){
        var str = "init";
        if(otherArray.isNotEmpty()){
            for (item in otherArray){
                str = "$str : $item"
            }
        }
        toast("$str")
    }

    fun getDinnerInput4(vararg otherArray : Array<String>) : String{
        var str = "init";
        if(otherArray.isNotEmpty()){
            for (array in otherArray){
                for(item in array){
                    str = ("$str:$item")
                }
            }
        }
        longToast("$str")
        return str;
    }

    //1.3.1泛型函数
    fun <T> appendString(tag : String,vararg otherInfo : T?) : String{
        var str : String = "$tag";
        for(it in otherInfo){
            str = "$str : ${it.toString()}"
        }
        longToast("$str")
        return str;
    }
    var count = 0;
    //1.3.1 Test
    fun appendStringTest(){
        when(count % 3){
            0 -> appendString<String>("One","1","1","1","1");
            1 -> appendString<Int>("Two",2,2,2,2,2);
            else -> appendString<Double>("three",2.1,2.2,2.3,2.4,2.5);
        }
        count ++;
    }

    //该参数很尴尬的,不接受Double 也不接受Int
    fun setArrayNumber(array : Array<Number>){

    }

    //内联函数的操作就是修改这个问题.
    //Int Float Double 都继承自Number类
    //inline 表示是内联函数
    inline fun <reified T : Number> setArrayNumber2(arrya : Array<T>){

    }

    //简化函数-阶乘函数
    fun factorial(n : Int) : Int{
        return if(n <= 1) n else n*factorial(n-1);
    }

    //尾递归函数,指的是函数末尾的返回值重复调用了自身函数.标注是尾递归函数,编译器会进行相应的优化操作
    //调用循环的方式代替地柜,避免栈溢出
    //求余弦不动点函数
    tailrec fun findFixPoint(x : Double = 1.0) : Double = if(x == Math.cos(x)) x else findFixPoint(Math.cos(x));

    //相对应的,上面的函数也可以改造成
    tailrec fun factorial2(n : Int) :Int = if(n <= 1) n else n*factorial2(n-1);


    //区分高阶函数和高阶函数的函数参数(函数变量)-先走个例子.
    //maxCustom为高阶函数 greater为函数变量
    fun <T> maxCustom(array : Array<T>,greater:(T,T) -> Boolean) : T?{
        var max : T? = null;
        for(item in array){
            if(max == null || greater(item,max))
                max = item
        }
        return max;
    }

    //调用的函数
    var string_array : Array<String> = arrayOf("I","am","so","happy");
    fun testMaxCustom(index : Int = 0){
        when(index){
            0 -> "默认最大值${string_array.max()}"
            1 -> "字符串按照长度比较最大值${maxCustom<String>(string_array,{a,b -> a.length > b.length})}"
            2 -> "字符串数组的默认最大值${maxCustom<String>(string_array,{a,b -> a > b})}"
            else -> "去掉空格后比较长度${maxCustom<String>(string_array,{a,b -> a.trim().toString() > b.trim().toString()})}"
        }
    }

    //{a,b -> a > b} 这种写法,是一种缩写.
    fun anonymous(a : String,b : String) : Boolean{
        var result : Boolean = a > b
        return result
    }

    //1.4.1扩展函数
    //扩展Array数组元素交换的方法
    fun <T> Array<T>.swap(pos1 : Int, pos2 : Int){
        val tmp = this[pos1] //this表示数组本身
        this[pos1] = this[pos2]
        this[pos2] = tmp
    }

    fun testSwap(){
        var array : Array<Double> = arrayOf(1.0,2.0,3.0,4.0)
        array.swap(2,3);
    }

    //高阶函数的扩展函数操作
    fun <T> Array<T>.maxCustom2(greater : (T,T) -> Boolean) : T?{
        var max : T? = null;
        for(item in this){
            if(max == null || greater(item,max))
                max = item
        }
        return max;
    }

    fun testSwap2(){
        var array : Array<Double> = arrayOf(1.0,2.0,3.0,4.0)
        array.maxCustom2({a,b -> a > b});
    }

    //利用kotlin实现时间的写法
    fun Date.getNowDateTime() : String{
        val sdf = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
        return sdf.format(this);
    }


}

object DateUtil{
    val nowDateTime : String
            get() {
                val sdf = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
                return sdf.format(this);
            }

    val nowDate : String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            return sdf.format(this);
        }
}