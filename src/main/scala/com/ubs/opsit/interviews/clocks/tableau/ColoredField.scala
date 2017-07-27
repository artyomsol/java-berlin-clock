package com.ubs.opsit.interviews.clocks.tableau

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/26/17 7:03 PM.
 */
case class ColoredField(color: FieldColor, isOn: Boolean) {

  import ColoredField._

  def toPresentation: Char = if (isOn) color.toChar else OFF_FIELD_PRESENTATION
}

object ColoredField {
  final val OFF_FIELD_PRESENTATION = 'O'
}