package kg.internlabs.xiomicalculator.model.calculator

import java.util.*

class SimpleCalculator {
    private var result = "0"
    private var st = Stack<Double>()

    fun calculate(rawRPN: String): String {
        var tmp = ""
        val list = mutableListOf<String>()

        rawRPN.forEach {
            if (it != ' ') {
                if (tmp.isNotEmpty()) {
                    tmp += it.toString()
                } else {
                    tmp = it.toString()
                }
            } else {
                list.add(tmp)
                tmp = ""
            }
        }
        if (tmp.isNotEmpty()) {
            list.add(tmp)
            tmp = ""
        }
        result = routineJob(list)
        result = converter(result)
        return result
    }

    private fun converter(result: String): String {
        if (result == "No") return "Нельзья на ноль делит!!!"

        var i = 0
        val indexOfDot = result.indexOf(".")
        val d: Double = result.toDouble()

        try {
            i = (result.removeRange(indexOfDot, result.length)).toInt()
        } catch (e: Exception) {
            println("**********exc*****${e.message}*********")
        }
        val r = d - i
        return if (r != 0.0) {
            result
        } else {
            i.toString()
        }
    }

    private fun routineJob(rawRPN: MutableList<String>): String {
        st = Stack<Double>()

        rawRPN.forEach { c ->
            when (c) {
                "*" -> {
                    var a: Double = st.pop()
                    var b: Double
                    try {
                        b = st.pop()
                    } catch (e: Exception) {
                        b = a
                        a = 1.0
                    }
                    getSolvation('*', a, b)
                }
                "/" -> {
                    var a: Double = st.pop()
                    var b: Double
                    try {
                        b = st.pop()
                    } catch (e: Exception) {
                        b = a
                        a = 1.0
                    }
                    val zero = getSolvation('/', a, b)
                    if (zero.isNotEmpty()) {
                        return zero
                    }
                }
                "+" -> {
                    var a: Double = st.pop()
                    var b: Double
                    try {
                        b = st.pop()
                    } catch (e: Exception) {
                        b = a
                        a = 0.0
                    }
                    getSolvation('+', a, b)
                }
                "-" -> {
                    var a: Double = st.pop()
                    var b: Double
                    try {
                        b = st.pop()
                    } catch (e: Exception) {
                        b = a
                        a = 0.0
                    }
                    getSolvation('-', a, b)
                }
                else -> {
                    try {
                        st.push(c.toDouble())
                    } catch (e: Exception) {
                        try {
                            st.push(c.dropLast(1).toDouble())
                        } catch (e : NumberFormatException){
                            try {
                                st.push(c.dropLast(1).toDouble())
                            } catch (e : NumberFormatException){
                                println("..\"Simple Calc routine job inNumbers\".push error .e.message....${e.message} ... $c")
                            }
                        }
                    }
                }
            }
        }
        return if (st.isNotEmpty()) {
            st.peek().toString()
        } else {
            "0"
        }
    }

    private fun getSolvation(c: Char, a: Double, b: Double): String {
        when (c) {
            '*' -> {
                st.push(a * b)
            }
            '/' -> {
                val ab = b / a
                if (ab.isInfinite()) {
                    return "No"
                }
                st.push(ab)
            }
            '+' -> {
                st.push(a + b)
            }
            '-' -> {
                st.push(b - a)
            }
        }
        return ""
    }
}