package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/26/17 6:49 PM.
 */
sealed trait FieldColor {
  def toChar: Char
}

object Red extends FieldColor {
  override def toChar: Char = 'R'
}

object Yellow extends FieldColor {
  override def toChar: Char = 'Y'
}