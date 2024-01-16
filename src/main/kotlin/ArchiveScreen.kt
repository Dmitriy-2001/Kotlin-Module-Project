class ArchiveScreen {
    private companion object {
        val archives = mutableListOf<String>()
    }

    fun show() {
        val menu = Menu(
            options = listOf(
                "Создать архив" to this::createArchive,
                "Просмотреть архивы" to this::viewArchives
            ),
            backAction = { }
        )
        menu.show()
    }

    private fun createArchive() {
        print("Введите имя архива: ")
        val archiveName = readLine()?.takeIf { it.isNotBlank() }
        if (archiveName != null) {
            archives.add(archiveName)
            println("Архив '$archiveName' создан.")
        } else {
            println("Имя архива не может быть пустым.")
        }
    }

    private fun viewArchives() {
        if (archives.isEmpty()) {
            println("Нет созданных архивов.")
        } else {
            println("Список архивов:")
            archives.forEach { println(it) }
        }
    }
}
