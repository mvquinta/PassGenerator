import kotlin.random.Random


/*2020-11-27 - Objective: implement v01 code into a function to be able to call it again and again.
* Function should take user input request to know size/length and kind of password (only letters, with numbers and with
* symbols*/

fun main() {
    var finalPass: String = ""
    fun randomPass(sizeOfPass: Int = 8, lettersLow: Boolean = true, lettersUp:Boolean = true, numbers: Boolean = true, symbols: Boolean = true ): String {

        //Declare list of characters to create password
        val listAbc = listOf<Char>('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        val listNumbers = listOf<Char>('0','1', '2', '3', '4', '5', '6', '7', '8', '9')
        val listSymbols = listOf<Char>('!', '?', '(', ')', '[', ']', '{', '}', '"', '<', '>', '"', ':', ';', '.', ',',
                '-', '_', '|', '^', '~', '@', '&', '$')

        //Declare needed variables and initialize them
        val tempListRandChar = mutableListOf<Char>()
        val tempListPassChar = mutableListOf<Char>()

        //Loop that creates random chars list to generate a password.
        var count: Int = 0
        while (count < sizeOfPass ) {
            //First I create a small list with an element from each different list of chars
            if (lettersLow == false) {
                print("")
            } else {
                val a = listAbc.shuffled()
                tempListRandChar.add(a.random())
            }

            if (lettersUp == false) {
                print("")
            } else {
                val b = listAbc.shuffled()
                tempListRandChar.add(b.random().toUpperCase())
            }

            if (numbers == false) {
                print("")
            } else {
                val c = listNumbers.shuffled()
                tempListRandChar.add(c.random())
            }

            if (symbols == false) {
                print("")
            } else {
                val d = listSymbols.shuffled()
                tempListRandChar.add(d.random())
            }
            //Than from that small list I randomized it again an add that element to final char list
            //val randomChar: Int = (0 until tempListRandChar.size).random()
            tempListPassChar.add(tempListRandChar[(0 until tempListRandChar.size).random()])
            tempListRandChar.clear()
            count += 1
        }

        //Transform to a CharArray to be able to print a string out of the mutableLisOf<Char>
        finalPass = String(tempListPassChar.toCharArray())
        return finalPass
    }

    randomPass(10)
    println(finalPass)

    randomPass(12, true, true, true, true)
    println(finalPass)
}