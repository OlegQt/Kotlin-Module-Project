import java.util.*

class Input {
    private val scanner = Scanner(System.`in`)
    // В этом классе реализованы функции ввода символов
    // С необходимыми проверками
    // Так же здесь разметил обе навигационные обобщенные функции, так как
    // Они тесно связаны с функциями ввода


    // Навигационный образ для экранов со списками
    fun navigate(
        menu: () -> Unit,
        choose: (n:Int) -> Unit,
    ) {
        menu.invoke()
        when (val input = this.inputInt()) {
            -112 -> println("Ввод букв недопустим") // Введены буквы
            -113 -> println("Ввод пустой строки недопустим") // пустая строка
            -111 -> println("Ввод символов недопустим") // символы
            else -> choose.invoke(input)
        }
    }

    // Шаблон для экранов просмотра либо создания содержимого
    fun create(
        article:()->Unit,
        pass:(s:String) -> Unit
    ){
        article()
        pass.invoke(inputStr())
    }


    // Ввод строки (символы запрещены)
    private fun inputInt(): Int {
        val inputString = scanner.nextLine()
        if(inputString.isEmpty()) return -113
        for (symbol in inputString) {
            if (symbol.isLetter()) return -112
            else if(!symbol.isDigit()) return -111
        }
        return inputString.toInt()
    }

    // Ввод строки (символы разрешены)
    private fun inputStr():String{
        return scanner.nextLine()
    }
}
