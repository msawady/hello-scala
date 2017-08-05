import scala.annotation.tailrec

/**
  * Created by masaa on 2017/07/20.
  */
object Fibonacci {

  def main(args: Array[String]): Unit = {
    printExecutionTime(println(fibo(100)))
  }

  def fibo(n: Int): Long = {
    @tailrec
    def fibo2(a: Long, b: Long, count: Int): Long = count match {
      case 0 => a
      case 1 => b
      case count => fibo2(b, a + b, count - 1)
    }

    fibo2(1, 1, n)
  }

  def printExecutionTime(proc: => Unit) = {
    val start = System.currentTimeMillis
    proc
    println((System.currentTimeMillis - start) + "msec")
  }
}
