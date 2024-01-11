//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.random.Random
import kotlin.system.measureTimeMillis
fun main()
{
    // Measure the execution time of the entire process
    val totalTime = measureTimeMillis {
    // Generate a random Roman numeral
    val randomRomanNumeral = generateRandomRomanNumeral()

    // Convert the random Roman numeral to integer
    val convertedNumber = convertToInteger(randomRomanNumeral)

    // Print the results
    println("Random Roman Numeral: $randomRomanNumeral")
    println("Converted Number: $convertedNumber")
}
    // Print the total execution time
    println("Total Execution For randomRomanNumeralandconvertedNumber Time: $totalTime in milliseconds")

    val totalTime1 = measureTimeMillis {
        // Generate a random integer between 1 and 2899
        val randomNumber = Random.nextInt(1, 2900)

        // Convert the random integer to Roman numeral
        val romanNumeral = convertToRoman(randomNumber)

        // Convert the Roman numeral back to integer
        val convertedNumber1 = convertToInteger(romanNumeral)

        // Print the results
        println("Random Number: $randomNumber")
        println("Roman Numeral: $romanNumeral")
        println("Converted Number: $convertedNumber1")
    }
    println("Total Execution For RandomNumberGeneratorRomanNumeral Time: $totalTime in milliseconds")
}
//generate the randomRomanNumeral.
fun generateRandomRomanNumeral(): String
{
    val numerals = arrayOf("I", "V", "X", "L", "C", "D", "M")
    val randomLength = Random.nextInt(1, 6) // Random length between 1 and 5
    val result = StringBuilder()

    repeat(randomLength) {
        result.append(numerals[Random.nextInt(numerals.size)])
    }

    return result.toString()
}

 // Convert to Integer
fun convertToInteger(romanNumeral: String): Int {
    val numeralMap = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50,
        'C' to 100, 'D' to 500, 'M' to 1000
    )

    var result = 0
    var prevValue = 0

    for (numeral in romanNumeral.reversed()) {
        val value = numeralMap[numeral] ?: 0

        if (value < prevValue) {
            result -= value
        } else {
            result += value
        }

        prevValue = value
    }

    return result
}

//Convert to Roman
fun convertToRoman(number: Int): String {
    val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val numerals = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    val result = StringBuilder()

    var remaining = number
    for (i in values.indices) {
        while (remaining >= values[i]) {
            result.append(numerals[i])
            remaining -= values[i]
        }
    }

    return result.toString()
}
