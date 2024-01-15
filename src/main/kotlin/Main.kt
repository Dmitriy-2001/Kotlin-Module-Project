fun main() {
    val mainMenu = Menu(
        options = listOf(
            "Работа с архивами" to { ArchiveScreen().show() },
            "Работа с заметками" to { NoteScreen().show() }
        ),
        backAction = { println("Программа завершена.")
            System.exit(0)
        }
    )
    mainMenu.show()
}
