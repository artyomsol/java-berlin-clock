package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/26/17 7:14 PM.
 */
class TableauRow(fields: Seq[ColoredField]) {
  def presentation: String = fields.map(_.toPresentation).mkString
}

object TableauRow {
  def apply(fields: ColoredField*): TableauRow = new TableauRow(fields.toList)

  def ofColors(colors: Seq[FieldColor], turnOn: Seq[Int]): TableauRow = {
    require(turnOn.isEmpty || colors.length > turnOn.max, "size of tableau row less then index if field to be turned on")
    require(turnOn.isEmpty || turnOn.min >= 0, "negative field index not allowed")
    val setOn = turnOn.toSet
    val fields = colors.zipWithIndex.map { case (color, idx) => ColoredField(color, setOn.contains(idx)) }
    new TableauRow(fields)
  }
}
