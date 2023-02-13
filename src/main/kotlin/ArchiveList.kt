class ArchiveList {
    // map зранит список архивов
    private val map: MutableMap<String, NoteList> = mutableMapOf()
    // В переменной хранится номер активированного архива
    var activeNoteList:NoteList=NoteList()


    val choose: (n: Int) -> Unit = { n ->
        when(n){
            0-> ScreenMode.mode=ScreenMode.ARCHIVE_CREATE
            in 1..map.size -> {
                this.activeNoteList = setActive(n);
                println("Chosen archive N$n - $activeNoteList")
                ScreenMode.mode = ScreenMode.NOTE_LIST
            }
            map.size+1 -> ScreenMode.mode = ScreenMode.EXIT_COM
            else -> println("Архива с номером $n нет в списке")
        }
    }

    val createSome: (name:String) -> Unit = { name ->
        map[name] = NoteList()
        ScreenMode.mode=ScreenMode.ARCHIVE_LIST
    }


    val showMainMenu: () -> Unit = {
        println("-------Список АРХИВОВ-------")
        var menu = "0) - Create archive\n"
        if (map.isEmpty()) menu += "Empty\n"
        map.keys.forEachIndexed { index, s -> menu += "${index + 1}) - $s \n" }
        menu += "${map.size + 1}) - Go Back"
        println(menu)
    }

    private fun setActive(number:Int):NoteList{
        var iterator = 0
        map.forEach { (s, noteList) ->
            iterator++;
            if (iterator==number) {
                return noteList
            }
        }
        return NoteList()
    }

    override fun toString(): String {
        var str = ""
        if (map.isEmpty()) return "Empty"
        map.keys.forEachIndexed { index, s -> str += "$index) $s \n" }

        return str
        //return map.keys.toString()
    }
}