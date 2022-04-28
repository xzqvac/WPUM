import kotlin.math.ln

fun main(args: Array<String>) {
    //Zadanie 2
    val f : (String) -> String = {it + "!"}
    //println(f("Żaba"))

    //Zadanie 3
    tailrec fun fib(i: Int, a: Int, b: Int) : Int
    {
        if (i == 0)
            return a
        else if (i == 1)
            return b
        else
            return fib(i - 1, b, a+b)
    }
    //println(fib(5, 0, 1))

    //Zadanie 4
    fun log2(i: Int):Int
    {
        require(i > 0) {"Nie istnieje logarytm z liczbym ujemnej"}
        return (ln(i.toDouble()) / ln(2.0)).toInt()
    }
    //println(log2(8))

    //Zadanie 5
    fun formatResult(name: String, n: Int, f: (Int) -> Int): String
    {
        val res = f(n).toString()
        return "$name($n) = $res"
    }

    println(formatResult("log2", 8 , ::log2))

    //println(formatResult("log2", 3, log2(8)))

    //Zadanie 6
    fun <T> List<T>.tail(): List<T> {
        return subList(1, this.size)
    }
    fun <T> List<T>.head(): T {
        return this[0]
    }
    val listaa = listOf(13,22,53)
    println(listaa.tail())
    println(listaa.head())

    //Zadanie 7

    /*fun <A> isSorted(lista: List<A>, order: (A, A) -> Boolean): List<A> {
        return lista.sortedBy {order(lista.head(), lista.tail().head())}
    }*/

    fun <A> isSorted(aa: List<A>, ordered: (A, A) -> Boolean): Boolean {
        tailrec fun next(x: A, xs: List<A>): Boolean =
            if (xs.isEmpty()) true
            else if (!ordered(x, xs.head())) false
            else next(xs.head(), xs.tail())

        return aa.isEmpty() || next(aa.head(), aa.tail())
    }
    //println(isSorted(listOf(1,2, 3), {i: Int, j: Int -> i < j}))


    //Zadanie 8
    fun suma(a: Array<Int>): Int
    {
        return a.filter { it > 0 }.map{it}.sum()
    }

    //println(suma(arrayOf<Int>(1, -4, 12, 0, -3, 29, -150)))

    //Zadanie 9
    fun countElements(a: ArrayList<ArrayList<Char>>): Map<Char, Int>
    {
        val sings = a.joinToString(separator = "").replace(("[^\\w]").toRegex(), "")
        return sings.groupingBy { it }.eachCount()
    }
    //println(countElements(arrayListOf(arrayListOf('a','b'),arrayListOf('c','d','c','c'))))
}
