object Main {
  def main(args: Array[String]): Unit = {
    val boolVal = false
    println(Macros.cnf("(0v1)^(2v-3)", true, false, boolVal, false))
  }
}