import kotlin.random.Random

/*2020-11-27 - Basic code for the Pass Generator*/

fun main() {
    //Declare list of characters to create password
    val listAbc = listOf<Char>('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val listNumbers = listOf<Char>('0','1', '2', '3', '4', '5', '6', '7', '8', '9')
    val listSymbols = listOf<Char>('!', '?', '(', ')', '[', ']', '{', '}', '"', '<', '>', '"', ':', ';', '.', ',',
        '-', '_', '|', '^', '~', '@', '&', '$')

    //Declare needed variables and initialize them
    val tempListRandChar = mutableListOf<Char>()
    val tempListPassChar = mutableListOf<Char>()
    //val finalPass: String

    val sizeOfPass: Int = 8

    //Loop that creates random chars list to generate a password.
    var count: Int = 0
    while (count < sizeOfPass ) {
        //First I create a small list with an element from each different list of chars
        val a = listAbc.shuffled()
        val b = listNumbers.shuffled()
        val c = listSymbols.shuffled()
        tempListRandChar.add(a.random())
        tempListRandChar.add(b.random())
        tempListRandChar.add(c.random())
        //Than from that small list I randomized it again an add that element to final char list
        //val randomChar: Int = (0 until tempListRandChar.size).random()
        tempListPassChar.add(tempListRandChar[(0 until tempListRandChar.size).random()])
        tempListRandChar.clear()
        count += 1
    }
    //Transform to a CharArray to be able to print a string out of the mutableLisOf<Char>
    val finalPass = String(tempListPassChar.toCharArray())
    println(finalPass)
}