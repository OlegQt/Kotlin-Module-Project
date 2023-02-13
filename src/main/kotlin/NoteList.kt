class NoteList() {
    val noteList: MutableSet<Note> = mutableSetOf()
    var activeNote: Note = Note("")

    // Функция выбора пункта меню осуществляется только после корректного ввода
    // Проверка корректности ввода в классе Input
    // 0 - создание переходим на экран создания заметки
    // от 1 до размера списка - переходим на экран показа заметки
    // и последний переход на экран назад
    val choose: (n: Int) -> Unit = { n ->
        when (n) {
            0 -> ScreenMode.mode = ScreenMode.NOTE_CREATE
            in 1..noteList.size -> {
                this.activeNote = setActive(n);
                println("Chosen note N$n - ${activeNote.name}")
                ScreenMode.mode = ScreenMode.NOTE_SHOW
            }
            noteList.size + 1 -> ScreenMode.mode = ScreenMode.ARCHIVE_LIST
            else -> println("Заметки с номером $n нет в списке")
        }
    }

    // Lambda для создания новой заметки
    val createSome: (name: String) -> Unit = { name ->
        this.noteList.add(Note(name))
        ScreenMode.mode = ScreenMode.NOTE_LIST
    }

    // Lambda для отображения красивой менюшки и списка заметок на экране списка заметок
    val showMainMenu: () -> Unit = {
        var index = 0;
        println("-------Список ЗАМЕТОК-------")
        var menu = "$index) - Create note\n"
        if (noteList.isEmpty()) menu += "Note list is empty\n"
        //noteList.forEachIndexed { index, s -> menu += "${index + 1}) - $s \n" }
        noteList.forEach { note ->
            index++
            menu += "${index}) - ${note.name} \n"
        }
        menu += "${noteList.size + 1} - Go Back to Archive list"
        println(menu)
    }


    private fun setActive(number: Int): Note {
        var iterator = 0
        for(note in noteList){
            iterator++
            if(iterator==number) return note
        }
        return this.activeNote
    }


    override fun toString(): String {
        var str = ""
        if (noteList.isEmpty()) return "Empty"
        noteList.forEachIndexed { index, s -> str += "$index) ${s.name} \n" }

        return str
        //return map.keys.toString()
    }
}