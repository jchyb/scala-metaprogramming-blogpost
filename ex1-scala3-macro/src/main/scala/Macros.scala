import example.util._
import scala.quoted._

object Macros {
  transparent inline def nonZeroNum(inline value: Int): NonZeroNumber =
    ${ Macros.nonZeroNumImpl('value) }

  def nonZeroNumImpl(using Quotes)(value: Expr[Int]): Expr[NonZeroNumber] = {
    val constValue = value.valueOrAbort
    if (constValue > 0) {
      '{ Positive($value) }
    } else if (constValue < 0) {
      '{ Negative($value) }
    } else {
      quotes.reflect.report.errorAndAbort("Non zero value expected")
    }
  }
}