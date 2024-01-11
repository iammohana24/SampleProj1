//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.random.Random
fun main()
{
    // Generate a random Roman numeral
    val randomRomanNumeral = generateRandomRomanNumeral()

    // Convert the random Roman numeral to integer
    val convertedNumber = convertToInteger(randomRomanNumeral)

    // Print the results
    println("Random Roman Numeral: $randomRomanNumeral")
    println("Converted Number: $convertedNumber")

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
