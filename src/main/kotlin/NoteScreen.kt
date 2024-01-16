class NoteScreen {
    private companion object {
        val notes = mutableListOf<Note>()
    }

    data class Note(val title: String, val content: String)

    fun show() {
        val menu = Menu(
            options = listOf(
                "Создать заметку" to this::createNote,
                "Просмотреть заметки" to this::viewNotes
            ),
            backAction = { }
        )
        menu.show()
    }

    private fun createNote() {
        print("Введите заголовок заметки: ")
        val title = readLine()?.takeIf { it.isNotBlank() }
        print("Введите содержание заметки: ")
        val content = readLine()?.takeIf { it.isNotBlank() }

        if (title != null && content != null) {
            notes.add(Note(title, content))
            println("Заметка '$title' создана.")
        } else {
            println("Ни заголовок, ни содержание не могут быть пустыми.")
        }
    }

    private fun viewNotes() {
        if (notes.isEmpty()) {
            println("Нет созданных заметок.")
        } else {
            println("Список заметок:")
            notes.forEach { println("${it.title}: ${it.content}") }
        }
    }
}