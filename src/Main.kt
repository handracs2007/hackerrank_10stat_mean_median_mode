import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.hackerrank.com/challenges/s10-basic-statistics/problem

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.use { read ->
        // Ignore the number of digits
        read.readLine()

        val numbers = read.readLine().split(" ").map { it.toDouble() }.sorted()
        val mean = numbers.sum() / numbers.size.toDouble()
        val median =
            if (numbers.size % 2 == 1) numbers[numbers.size / 2] else (numbers[numbers.size / 2] + numbers[numbers.size / 2 - 1]) / 2.0
        val mode = numbers.map { number -> number to numbers.count { it == number } }.maxBy { it.second }!!.first

        // Print the mean
        println("%.1f".format(mean))
        println("%.1f".format(median))
        println("%.0f".format(mode))
    }
}