fun main(args: Array<String>) {
    fun zad2(List: List<String>): List<Pair<Char, List<String>>> {
        return List
            .sorted()
            .groupingBy { it.first() }
            .fold(listOf<String>()) { acc, e -> if (e.length % 2 == 0) acc.plusElement(e) else acc }
            .toList()
    }
    println(zad2(listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")))

    fun zad1(List: List<Number>): MutableList<Double> {
        val result: MutableList<Double> = mutableListOf()
        for ((index, element) in List.withIndex()) {
            if (index % 2 == 1)
                result.add(element.toDouble() * element.toDouble())
        }
        return result
    }
    println(zad1(listOf(1, 2, 3.5, 5, -6, 1, 1)))

    fun zad3(List: List<Int>): MutableList<List<Int>> {
        val output = mutableListOf<List<Int>>()
        fun swapValues(listToswap: MutableList<Int>, indexA: Int, indexB: Int) {
            val temp = listToswap[indexA]
            listToswap[indexA] = listToswap[indexB]
            listToswap[indexB] = temp
        }

        fun generate(n: Int, heapList: MutableList<Int>) {
            if (n == 1) {
                output.add(heapList.toMutableList())
            } else
                for (i in 0 until n) {
                    generate(n - 1, heapList)
                    if (i % 2 == 0)
                        swapValues(heapList, i, n - 1)
                    else
                        swapValues(heapList, 0, n - 1)
                }
        }
        generate(List.count(), List.toMutableList())
        return output

    }
    println(zad3(listOf(1, 2, 3)))

    fun zad4(N: Int, List: List<Int>): Int? {
        fun SumOfPair(Preamble: List<Int>, sum: Int): Boolean
        {
            Preamble.forEachIndexed{ i, first ->
                Preamble.forEachIndexed{ j, second ->
                    if (i != j && first + second == sum) return true
                }
            }
            return false
        }
        for (index in (N + 1)..List.lastIndex)
        {
            val preamble = List.subList(index - N, index)
            if (! SumOfPair(preamble, List[index]))
                return List[index]
        }
        return null
    }

    println(zad4(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))
}
