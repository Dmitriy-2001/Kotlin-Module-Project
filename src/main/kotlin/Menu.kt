import java.util.Scanner

class Menu(
    private val options: List<Pair<String, () -> Unit>>,
    private val backAction: () -> Unit
) {
    private val scanner = Scanner(System.`in`)

    fun show() {
        while (true) {
            println("Меню:")
            options.forEachIndexed { index, (label, _) ->
                println("$index. $label")
            }
            println("b. Назад")

            val input = scanner.nextLine()

            when {
                input == "b" -> {
                    backAction()
                    return
                }
                input.matches("\\d+".toRegex()) -> {
                    val index = input.toInt()
                    if (index in options.indices) {
                        options[index].second.invoke()
                    } else {
                        println("Нет такого пункта меню. Пожалуйста, введите корректный символ.")
                    }
                }
                else -> {
                    println("Пожалуйста, введите цифру или 'b' для назад.")
                }
            }
        }
    }
}
