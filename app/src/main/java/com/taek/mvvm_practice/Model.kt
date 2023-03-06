package com.taek.mvvm_practice

// Model
// 데이터베이스
// 일종의 뷰를 표시해주는데 정보를 관리하는 클래스
class Model {
    var password: MutableList<Int> = mutableListOf()

    fun inputPassword(i: Int) {
        if (password.size < 4) {
            password.add(i)
        }
    }

    fun checkPassword(): Boolean {
        var trueCount = 0
        var savePassword = mutableListOf(1, 2, 3, 4)

        for (i in 0 until savePassword.size) {
            if (savePassword.get(i) == password.get(i)) {
                trueCount++
            }
        }

        return trueCount == 4
    }
}