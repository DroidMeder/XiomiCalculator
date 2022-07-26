package kg.internlabs.xiomicalculator.model

import kg.internlabs.xiomicalculator.model.data.models.History
import kg.internlabs.xiomicalculator.model.rpn.RPN
import kg.internlabs.xiomicalculator.viewer.ui.simpleCalculatorViewer.SimpleCalculatorViewerFragment
import java.text.DecimalFormat

class SimpleOperationsModel(viewer: SimpleCalculatorViewerFragment) {
    private var simpleViewer: SimpleCalculatorViewerFragment
    private var rpn: RPN
    private var historyList: MutableList<History>
    private val operationPriority = mapOf('+' to 1, '-' to 1, '/' to 2, '*' to 2)

    private var totalTemp: String
    private var result: String

    init {
        println("******* Simple Cal Model constructor started")
        simpleViewer = viewer
        println("********* I am Simple Cal Model object")

        totalTemp = ""
        result = "0"
        rpn = RPN()
        historyList = mutableListOf()
        println("********* Simple Cal Model constructor finished")
    }


    fun doYourJob(values: Char) {
        when (values.code) {
            in 48..57 -> { // Digits
                putCorrectDigits(values)
            }
            in 42..43 -> { // +, *
                putOperand(values)
            }
            45 -> { // -
                putOperand(values)
            }
            47 -> { // /
                putOperand(values)
            }
            46 -> { // .
                putDot()
            }
            99 -> { // c or Clear
                totalTemp = ""
                simpleViewer.updateResults(totalTemp, "0")
                return
            }
            100 -> { // d or Delete
                totalTemp = if (totalTemp.isNotEmpty()) {
                    totalTemp.dropLast(1)
                } else {
                    ""
                }
            }
            61 -> {  // =
                if (result != "0." && result != "0") {
                    historyList.add(History(input = totalTemp, result = "=$result"))
                    simpleViewer.thatIsIt(totalTemp, "= " + getFormattedResult(),
                        historyList.toList())
                } else {
                    historyList.add(History(input = totalTemp, result = "0"))
                    simpleViewer.thatIsIt(totalTemp, "0", historyList.toList())
                }
                totalTemp = ""
                result = "0"
                return
            }
            37 -> { // %
                addPercent()
            }
        }
        
        result = if (totalTemp.contains("[*/+-]".toRegex())) {
            rpn.calculate(totalTemp)
        } else {
            totalTemp
        }
        if (result.isNotEmpty()) {
            if (result != "0.") {
                simpleViewer.updateResults(totalTemp, "= " + getFormattedResult())
            } else {
                simpleViewer.updateResults(totalTemp, "0")
            }
        } else {
            simpleViewer.updateResults(totalTemp, "0")
        }
    }

    private fun addPercent() {
        if (totalTemp.isNotEmpty()) {
            if (totalTemp.last().isDigit() && totalTemp != "0") {
                val any = findIndexOfLastOperator()
                val percent = rpn.percentCalculate(totalTemp)
                totalTemp = totalTemp.dropLast(totalTemp.length - any - 1)
                totalTemp += percent
            }

            totalTemp = removeExtraOperators(totalTemp)  //  0-1+2%  выводил результат 0-1+---0.00000002
        }
    }

    private fun removeExtraOperators(totalTemp: String): String {
        var tmp = totalTemp

        if (totalTemp.length > 3) {
            tmp = ""
            for (i in 2 until totalTemp.length) {
                if (!totalTemp[i].isDigit() && totalTemp[i] != '.' && totalTemp[i] != 'E') {
                    println()
                    if (operationPriority.containsKey(totalTemp[i - 2]) &&
                        operationPriority.containsKey(totalTemp[i - 1]) &&
                        !operationPriority.containsKey(totalTemp[i])
                    ) {
                        tmp += totalTemp[i]
                    }
                    if (operationPriority.containsKey(totalTemp[i - 2]) &&
                        !operationPriority.containsKey(totalTemp[i - 1]) &&
                        operationPriority.containsKey(totalTemp[i])
                    ) {
                        tmp += totalTemp[i]
                    }
                    if (!operationPriority.containsKey(totalTemp[i - 2]) &&
                        operationPriority.containsKey(totalTemp[i - 1]) &&
                        operationPriority.containsKey(totalTemp[i])
                    ) {
                        tmp += totalTemp[i]
                    }
                } else {
                    tmp += totalTemp[i]
                }
            }
            tmp = totalTemp[1] + tmp
            tmp = totalTemp[0] + tmp
        }
        return tmp
    }

    private fun getFormattedResult(): String {
        if (result.contains("E") || result == "Нельзья на ноль делит!!!") return result
        return if (DecimalFormat("#.#########").format(result.toDouble()).length > 12) {
            DecimalFormat("#.#######E0").format(result.toDouble())
        } else {
            DecimalFormat("#.##########").format(result.toDouble())
        }
    }

    private fun putDot() {
        var str: String
        
        if (totalTemp.contains("[*/+-]".toRegex())) {
            val any = findIndexOfLastOperator()
            str = totalTemp.removeRange(0, any + 1)
            if (str.isNotEmpty()) {
                if (!str.contains(".")) {
                    str += "."
                }
            } else {
                str = "0."
            }
            totalTemp = totalTemp.replaceRange(any + 1, totalTemp.length, str)
        } else if (totalTemp.isNotEmpty()) {
            if (!totalTemp.contains(".")) {
                totalTemp += "."
            }
        } else {
            totalTemp = "0."
        }
    }

    private fun putOperand(s: Char) {
        
        if (totalTemp.equals("[*/+-]".toRegex())) {
            totalTemp = s.toString()
        } else if (totalTemp == "0" || totalTemp.isEmpty()) {
            totalTemp = "0$s"
        } else if (totalTemp.length > 1 && totalTemp.endsWith("+") || totalTemp.endsWith("-")
            || totalTemp.endsWith("/") || totalTemp.endsWith("*")
        ) {
            totalTemp = totalTemp.dropLast(1)
            totalTemp += s.toString()
        } else {
            totalTemp += s.toString()
        }
    }

    private fun putCorrectDigits(s: Char) {
        var str: String

        if (totalTemp.contains("[*/+-]".toRegex())) {
            val any = findIndexOfLastOperator()
            str = totalTemp.removeRange(0, any)

            if (str.isNotEmpty()) {
                if (str.startsWith("0") && !str.contains(".")) {
                    str = s.toString()
                } else {
                    if (str.length < 15) {
                        str += s.toString()
                    }
                }
            } else {
                str = s.toString()
            }
            totalTemp = totalTemp.replaceRange(any, totalTemp.length, str)
        } else if (totalTemp.isNotEmpty()) {
            if (totalTemp.startsWith("0") && !totalTemp.contains(".")) {
                totalTemp = s.toString()
            } else {
                if (totalTemp.length < 15) {
                    totalTemp += s.toString()
                }
            }
        } else {
            totalTemp = s.toString()
        }
    }

    private fun findIndexOfLastOperator(): Int {
        var index = 0
        
        if (totalTemp.contains("E")){
            for (i in totalTemp.length-1 downTo  1){
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