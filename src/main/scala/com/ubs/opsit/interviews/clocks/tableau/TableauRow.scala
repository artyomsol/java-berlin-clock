package com.ubs.opsit.interviews.clocks.tableau

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/26/17 7:14 PM.
 */
case class TableauRow(fields: Seq[ColoredField]) {
  def presentation: String = fields.map(_.toPresentation).mkString

  def prepend(field: ColoredField): TableauRow = copy(Seq(field) ++ fields)
}

object TableauRow {

  def ofColors(colors: Seq[FieldColor], turnOn: Seq[Int]): TableauRow = {
    require(turnOn.isEmpty || colors.length > turnOn.max, "size of tableau row less then index if field to be turned on")
    require(turnOn.isEmpty || turnOn.min >= 0, "negative field index not allowed")
    val setOn = turnOn.toSet
    val fields = colors.zipWithIndex.map { case (color, idx) => ColoredField(color, setOn.contains(idx)) }
    new TableauRow(fields)
  }

  def asColoredPositionalProgressBar(colors: Seq[FieldColor], weights: Seq[Int], progress: Int = 0): TableauRow = {
    require(colors.length == weights.length, "number of fields colors does not correspond to the number of fields weights")
    require(progress >= 0, "negative progress value allowed")
    val fields = weights.foldLeft[(Int, List[Boolean])]((0,List.empty)){case ((acc,result), weight) =>
      if (progress - acc >= weight) (acc + weight, true :: result)
      else (acc, false :: result)
    }._2.reverse.zip(colors).map { case (isOn, color) => ColoredField(color, isOn) }
    new TableauRow(fields)
  }

}
