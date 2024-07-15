package q3
object Fibonacci {

  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def printFibonacciNumbers(n: Int): Unit = {
    for (i <- 0 until n) {
      print(fibonacci(i) + " ")
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    val n = 10 
    println(s"First $n Fibonacci numbers:")
    printFibonacciNumbers(n)
  }
}
