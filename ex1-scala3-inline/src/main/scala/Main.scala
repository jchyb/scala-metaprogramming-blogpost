import example.util._

object Main {

  def main(args: Array[String]): Unit = {
    println(nonZeroNum(5))
    println(nonZeroNum(15))
    println(nonZeroNum(-5))
    // nonZeroNum(0) // will cause compiletime error
  }

  inline def nonZeroNum(inline value: Int): NonZeroNumber = {
    inline if (value > 0) {
      Positive(value)
    } else inline if (value < 0) {
      Negative(value)
    } else {
      scala.compiletime.error("Non zero value expected")
    }
  }
}