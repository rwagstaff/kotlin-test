fun main() {
    val books = listOf(
        WordCount.Novel(
            1,
            "Lord of the Rings",
            listOf("One ring to rule them all"),
            listOf("Chapter 1: A Dwarf lost the ring", "Chapter Two: Found the ring")
        ),
        WordCount.Magazine(2, "Computer Weekly", listOf("Best computers of the decade")),
        WordCount.Comic(3, "The batman", listOf("Batman solves crime")),
    )

    val words = WordCount.getBlock(books)
    WordCount.countWords("the", words)
    WordCount.countWords("Batman", words)
    WordCount.countWords("Ball", words)
    WordCount.countWords("Computer", words)
    print("Done")
}

sealed class WordCount {
    data class Novel(val id: Int, val title: String, val introduction: List<String>, val chapters: List<String>) :
        WordCount()

    data class Magazine(val id: Int, val title: String, val articles: List<String>) : WordCount()
    data class Comic(val id: Int, val title: String, val stories: List<String>) : WordCount()

    companion object {
        fun getBlock(books: List<WordCount>): List<String> {
            return books.flatMap {
                when (it) {
                    is Novel -> it.introduction + it.chapters + listOf(it.title)
                    is Magazine -> it.articles + listOf(it.title)
                    is Comic -> it.stories + listOf(it.title)
                }
            }
        }

        fun countWords(searchWord: String, words: List<String>) {
            val matching: Int = count(words, searchWord)

            println("$searchWord has a count of ${matching}")

        }

        private fun count(
            words: List<String>,
            searchWord: String
        ): Int {
            val matching: List<Int> = words.map {
                val split = it.split(" ")
                val matching = split.filter { word -> word.equals(searchWord, ignoreCase = true) }
                matching.size
            }
            return matching.sum()
        }

        fun findBooks(): MutableList<WordCount> {
            return mutableListOf(
                Novel(
                    1,
                    "Lord of the Rings",
                    listOf("One ring to rule them all"),
                    listOf("Chapter 1: A Dwarf lost the ring", "Chapter Two: Found the ring")
                ),
                Magazine(2, "Computer Weekly", listOf("Best computers of the decade")),
                Comic(3, "The batman", listOf("Batman solves crime")),
            )
        }


    }
}

