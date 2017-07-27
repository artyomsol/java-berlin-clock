package com.ubs.opsit.interviews.clocks

import com.ubs.opsit.interviews.clocks.tableau._

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/27/17 11:24 AM.
 */
object BerlinClockRenderers {
  implicit final val AdvancedBerlinClockRenderer = new ClockRenderer[String] {
    override def apply(aClock: AbstractClock): String = {

      val tableau: Seq[TableauRow] = Seq(secondsRow, hoursRow, hoursRow, minutesRow1, minutesRow2)
        .zip(
          Seq(secondsFieldsOn _, fiveHoursFieldsOn _, hoursFieldsOn _, fiveMinutesFieldsOn _, minutesFieldsOn _)
            // generating the collection of indices of turned ON fields
            // by implementing different collection generation algorithms for custom tow/fields map it is possible
            // to develop any kind of custom tableau view and strange time encodings (for ex. matrix of pixels or circle segments)
            .map(turnedOnFieldsEvaluator => 0 until turnedOnFieldsEvaluator(aClock))
        ).map { case (colors, turnedOn) => TableauRow.ofColors(colors, turnedOn) }

      tableau.map(_.presentation).mkString("\n")
    }
  }
  implicit final val ProgressBarBerlinClockRenderer = new ClockRenderer[String] {
    override def apply(aClock: AbstractClock): String = {
      val timeSeconds = aClock.hours * 3600 + aClock.minutes * 60 + aClock.seconds
      val tableau: TableauRow = TableauRow.asColoredPositionalProgressBar(continuousTableauRow, continuousTableauRowWeights, timeSeconds)
        .prepend(ColoredField(Yellow, timeSeconds % 2 == 0))
      val (row1, tail1) = tableau.presentation.splitAt(1)
      val (row2, tail2) = tail1.splitAt(4)
      val (row3, tail3) = tail2.splitAt(4)
      val (row4, row5) = tail3.splitAt(11)
      "%s%n%s%n%s%n%s%n%s".format(row1, row2, row3, row4, row5)
    }
  }
  implicit final val StraightAndDirtyBerlinClockRenderer = new ClockRenderer[String] {
    override def apply(aClock: AbstractClock): String = {
      val timeSeconds = aClock.hours * 3600 + aClock.minutes * 60 + aClock.seconds
      val secondsChar = if (timeSeconds % 2 == 0) "Y" else "O"
      val result: String = continuousTableauRow.map(_.toChar).zip(continuousTableauRowWeights)
      .foldLeft[(Int,String)]((0,secondsChar)){case ((acc,s),(char,weight)) =>
        if (timeSeconds - acc >= weight) (acc + weight, s + char) else (acc, s + 'O')
      }._2
      val (row1, tail1) = result.splitAt(1)
      val (row2, tail2) = tail1.splitAt(4)
      val (row3, tail3) = tail2.splitAt(4)
      val (row4, row5) = tail3.splitAt(11)
      "%s%n%s%n%s%n%s%n%s".format(row1, row2, row3, row4, row5)
    }
  }
  final private val secondsRow: Seq[FieldColor] = Seq(Yellow)
  final private val hoursRow: Seq[FieldColor] = Seq(Red, Red, Red, Red)
  final private val minutesRow1: Seq[FieldColor] = Seq(Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow)
  final private val minutesRow2: Seq[FieldColor] = Seq(Yellow, Yellow, Yellow, Yellow)
  private val continuousTableauRow = hoursRow ++ hoursRow ++ minutesRow1 ++ minutesRow2
  // 5 hours = 18000 seconds
  // 1 hour = 3600 seconds
  // 5 minutes = 300 seconds
  private val continuousTableauRowWeights = Seq(
    18000, 18000, 18000, 18000,
    3600, 3600, 3600, 3600,
    300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300,
    60, 60, 60, 60
  )

  private def secondsFieldsOn(aClock: AbstractClock): Int = (aClock.seconds + 1) % 2

  private def fiveHoursFieldsOn(aClock: AbstractClock): Int = aClock.hours / 5

  private def hoursFieldsOn(aClock: AbstractClock): Int = aClock.hours % 5

  private def fiveMinutesFieldsOn(aClock: AbstractClock): Int = aClock.minutes / 5

  private def minutesFieldsOn(aClock: AbstractClock): Int = aClock.minutes % 5
}
