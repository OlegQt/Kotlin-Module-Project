fun main() {
    val archiveList = ArchiveList()
    var running: Boolean = true

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
            else -> running = false
        }

    }
}


