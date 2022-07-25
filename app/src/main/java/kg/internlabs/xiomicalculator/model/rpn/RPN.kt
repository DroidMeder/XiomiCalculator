package kg.internlabs.xiomicalculator.model.rpn

import kg.internlabs.xiomicalculator.model.calculator.SimpleCalculator
import java.math.MathContext
import java.util.*

class RPN {
    private var postfix = ""
    private var resultOfCalculation = "0"
    private val operationPriority = mapOf('+' to 1, '-' to 1, '/' to 2, '*' to 2)

    private val calculator: SimpleCalculator = SimpleCalculator()

    fun calculate(infix : String) : String {
        if (!infix.contains("[*/+-]".toRegex())) {
            return infix
        }
        postfix = toPostfix(infix)
        resultOfCalculation = calculator.calculate(postfix)
        return resultOfCalculation
    }

    private fun toPostfix(infix: String): String {
        var postfix = ""
        val stack = Stack<Char>()

        infix.forEachIndexed { index, it ->
            if (!operationPriority.containsKey(it)){
                if (postfix.isNotEmpty()){ postfix += it } else {
                    postfix = it.toString()
                }
            }
            else if (operationPriority.containsKey(it) && index != infix.length-1){
                if (postfix.endsWith("E")){
                    postfix += it
                } else {
                    postfix += " "
                    if (stack.isNotEmpty()){
                        if (operationPriority.getValue(stack.peek()) < operationPriority.getValue(it)){
                            stack.push(it)
                        }else {
                            while (stack.isNotEmpty() && operationPriority.getValue(stack.peek())
                                >= operationPriority.getValue(it)){
                                if (postfix.isNotEmpty()){ postfix += "${stack.pop()} "
                                } else {
                                    postfix =  "${stack.pop()}"
                                }
                            }
                            stack.push(it)
                        }
                    }else {
                        stack.push(it)
                    }
                }
            }
        }
        while (stack.isNotEmpty()){
            if (postfix.isNotEmpty()){ postfix += " ${stack.pop()}"
            } else {
                postfix =  "${stack.pop()}"
            }
        }
        return postfix
    }

    fun percentCalculate(totalTemp: String): String {
        var drop = ""
        var outcome = 0.0
        val any = findIndexOfLastOperator(totalTemp)

        val percent = totalTemp.takeLast(totalTemp.length-any-1)
        if (!totalTemp.contains("E-".toRegex()) || !totalTemp.contains("E+".toRegex())) {
            drop = totalTemp.dropLast(totalTemp.length-any-1)
        }
        val tmp = calculate(drop.dropLast(1))

        if (drop.isNotEmpty()) {
            when(drop.last()){
                '+' -> {
                    outcome = tmp.toDouble() * percent.toDouble() / 100
                }
                '-' -> {
                    outcome = tmp.toDouble() * percent.toDouble() / 100
                }
                '*' -> {
                    outcome = percent.toDouble() / 100
                }
                '/' -> {
                    outcome = percent.toDouble() / 100
                }
            }
        } else {
            if (percent.isNotEmpty()){
                val per = percent.toDouble() / 100
                val bigDecimal = per.toBigDecimal(MathContext(4))

                if (bigDecimal.toString().last().code > 8 && bigDecimal.toString().contains("E")){
                    val bigD = bigDecimal.toString().dropLast(1)
                    return "$bigD NaN"
                }
                return bigDecimal.toString()
            }
        }

        val bigDecimal = outcome.toBigDecimal(MathContext(4))

        if (bigDecimal.toString().last().code > 8 && bigDecimal.toString().contains("E")){
            val bigD = bigDecimal.toString().dropLast(1)
            return "$bigD NaN"
        }
        return bigDecimal.toString()
    }

    private fun findIndexOfLastOperator(totalTemp: String): Int {
        var index = 0

        if (totalTemp.contains("E")){
            for (i in totalTemp.length-1..1){
                if (!totalTemp[i].isDigit() || totalTemp[i] != '.' || totalTemp[i] != 'E'){
                    if (totalTemp[i-1] != 'E'){
                        index = i
                    }
                }
            }
        } else {
            index = totalTemp.lastIndexOfAny(listOf("+", "-", "/", "*"))
        }
        return index
    }
}