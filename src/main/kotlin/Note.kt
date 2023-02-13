class Note(val name: String) {
    val text = ""

    val showMainMenu: () -> Unit = {
        var str = ("-------ЗАМЕТКА $name-------\n")
        str += this.text
        str += "-------------------------------\n"
        str += "0) - Add text to note\n"
        str += "1) - Go Back"
        println(str)
    }

    val choose: (n: Int) -> Unit = { n ->
        when (n) {
            0 -> ScreenMode.mode = ScreenMode.NOTE_CREATE
            1 -> ScreenMode.mode = ScreenMode.NOTE_LIST
            else -> println("Заметки с номером $n нет в списке")
        }
    }
}