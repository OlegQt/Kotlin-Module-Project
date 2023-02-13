class Note(val name: String,private var text:String) {
    constructor(name: String) : this(name,"")

    // Функция отображения земетки и навигационных заголовков (lambda)
    val showMainMenu: () -> Unit = {
        var str = ("-------ЗАМЕТКА $name-------\n")
        str += this.text
        str += "-------------------------------\n"
        str += "0) - Add text to note\n"
        str += "1) - Go Back"
        println(str)
    }

    // Функция навигации по экрану заметки (lambda)
    val choose: (n: Int) -> Unit = { n ->
        when (n) {
            0 -> ScreenMode.mode = ScreenMode.NOTE_EDIT
            1 -> ScreenMode.mode = ScreenMode.NOTE_LIST
            else -> println("Заметки с номером $n нет в списке")
        }
    }

    // Функция редактирования текста заметки (lambda)
    val addText: (text: String) -> Unit = { text ->
        this.text+="$text\n"
        ScreenMode.mode = ScreenMode.NOTE_SHOW
    }
}