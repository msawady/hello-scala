import java.lang.Math.sqrt

/**
  * Created by masaa on 2017/07/04.
  */

object PrimeNum {
  def main(args: Array[String]): Unit = {
    var primes: List[Int] = List[Int](2) // 2が素数であることは自明とする
    printExecutionTime {
      for (i <- 3 to 10000 by 2) { // 奇数だけチェック
        if (isPrime(primes, i)) {
          primes = i :: primes // 先頭に要素を追加していく
        }
      }
      println(primes.reverse) // 最後に reverse
    }
  }

  def isPrime(primes: List[Int], target: Int): Boolean = {
    val max: Int = sqrt(target).toInt // チェックする必要があるのは平方数までだけ。
    !primes.filter(p => p <= max).exists(p => target % p == 0)
  }

  def printExecutionTime(proc: => Unit) = {
    val start = System.currentTimeMillis
    proc
    println((System.currentTimeMillis - start) + "msec")
  }
}

