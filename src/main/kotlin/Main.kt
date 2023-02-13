fun main() {
    val archiveList = ArchiveList() // Список архивов хранится в этом экземпляре класса
    var running = true // Условие проверки выхода из рпограммы


    while (running) {
        when (ScreenMode.mode) {
            ScreenMode.ARCHIVE_LIST -> {
                Input().navigate(
                    archiveList.showMainMenu,
                    archiveList.choose,
                )
            }
            ScreenMode.NOTE_LIST -> {
                Input().navigate(
                    archiveList.activeNoteList.showMainMenu,
                    archiveList.activeNoteList.choose,
                )
            }
            ScreenMode.ARCHIVE_CREATE -> {
                Input().create({println("Введите название нового архива")},archiveList.createSome)
            }
            ScreenMode.NOTE_CREATE -> {
                Input().create({println("Введите название новой заметки")},archiveList.activeNoteList.createSome)
            }
            ScreenMode.NOTE_SHOW -> {
                Input().navigate(
                    archiveList.activeNoteList.activeNote.showMainMenu,
                    archiveList.activeNoteList.activeNote.choose
                )
            }
            ScreenMode.NOTE_EDIT ->{
                Input().create({println("Дополните заметку")},archiveList.activeNoteList.activeNote.addText)
            }
            else -> running = false
        }

    }
}


