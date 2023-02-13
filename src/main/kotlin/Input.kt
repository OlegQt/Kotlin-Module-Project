import java.util.*

class Input {
    private val scanner = Scanner(System.`in`)


    fun navigate(
        menu: () -> Unit,
        choose: (n:Int) -> Unit,
    ) {
        menu.invoke()
        when (val input = this.inputInt()) {
            -112 -> println("Введены буквы") // Введены буквы
            -113 -> println("Ввод пустой строки недопустим") // Введены буквы
            else -> choose.invoke(input)
        }
    }

    fun create(
        article:()->Unit,
        pass:(s:String) -> Unit
    ){
        article()
        pass.invoke(inputStr())
    }


    private fun inputInt(): Int {
        val inputString = scanner.nextLine()
        if(inputString.isEmpty()) return -113
        for (symbol in inputString) {
            if (symbol.isLetter()) return -112
        }
        return inputString.toInt()
    }
    fun inputStr():String{
        return scanner.nextLine()
    }
}
