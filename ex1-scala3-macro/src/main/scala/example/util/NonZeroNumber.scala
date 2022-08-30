package example.util

sealed trait NonZeroNumber
case class Positive(value: Int) extends NonZeroNumber
case class Negative(value: Int) extends NonZeroNumber