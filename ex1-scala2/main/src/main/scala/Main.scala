object Main {
  def main(args: Array[String]): Unit = {
		println(Macros.nonZeroNum(5))
		println(Macros.nonZeroNum(15))
		println(Macros.nonZeroNum(-5))
    // println(Macros.nonZeroNum(0)) // will cause compiletime error
	}
}