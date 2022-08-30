import example.util._

object Main {
  def check(num: Positive): Unit = println(s"Compiled! Hooray!")

  def main(args: Array[String]): Unit = {
    check(nonZeroNum(5))
  }

  transparent inline def nonZeroNum(inline value: Int): NonZeroNumber = {
    inline if (value > 0) {
      Positive(value)
    } else inline if (value < 0) {
      Negative(value)
    } else {
      scala.compiletime.error("Non zero value expected")
    }
  }
}