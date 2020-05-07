package com.botpy.sourcecodedemo

/**
 * @author liuxuhui
 * @date 2020-03-30
 */
class Student constructor(private var name: String){

    private var sex: String = ""
    private var score: Int = 0

    constructor(name: String, sex: String): this(name = name) {
        this.sex = sex
    }

    constructor(name: String, sex: String, score: Int): this(name = name, sex = sex) {
        this.score = score
    }

    fun show(): Unit {
        println("My name is $name, I am a $sex, my score is $score")
        var list = listOf<Int>(21, 40, 11, 33, 78)
        var newList = list.filter { i -> i % 3 == 0}
        println(list.toString())
        println(newList.toString())
    }
}