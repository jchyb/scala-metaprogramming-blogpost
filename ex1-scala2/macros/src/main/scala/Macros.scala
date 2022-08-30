import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

import example.util.NonZeroNumber

object Macros {
  def nonZeroNum(number: Int): NonZeroNumber = macro nonZeroNum_impl 

  def nonZeroNum_impl(
      c: Context
    )(number: c.Expr[Int]) = {
    import c.universe._

    // unpack a static value from the method argument
    val Literal(Constant(constValue: Int)) = number.tree

    // construct a NonZeroNumber based on that value
		if (constValue > 0) {
			q"_root_.example.util.Positive($number)"
    } else if (constValue < 0) {
      q"_root_.example.util.Negative($number)"
    } else {
      c.abort(c.enclosingPosition, "Non zero value expected")
    }
  }
}