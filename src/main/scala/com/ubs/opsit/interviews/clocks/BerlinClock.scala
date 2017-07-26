package com.ubs.opsit.interviews.clocks

import java.time.LocalTime
import java.time.format.{DateTimeFormatter, ResolverStyle}


/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks.berlinclock
 * Created by asoloviov on 7/26/17 5:38 PM.
 */
case class BerlinClock(hours: Int, minutes: Int, seconds: Int) extends AbstractClock {
  require(hours >= 0 && hours <= 24, "hours value must be in interval [0;24]")
  require(minutes >= 0 && minutes <= 59, "minutes value must be in interval [0;59]")
  require(seconds >= 0 && seconds <= 59, "seconds value must be in interval [0;59]")
  require(hours != 24 || minutes == 0 && minutes == 0, "both minutes and seconds must be 0 when hours set to 24")

  import com.ubs.opsit.interviews.clocks.BerlinClock._

  private val tableau: Seq[TableauRow] = Seq(secondsRow, hoursRow, hoursRow, minutesRow1, minutesRow2)
    .zip(
      Seq(secondsFieldsOn, fiveHoursFieldsOn, hoursFieldsOn, fiveMinutesFieldsOn, minutesFieldsOn)
        .map(onFieldNumber => 0 until onFieldNumber)
    )
    .map { case (colors, turnedOn) => TableauRow.ofColors(colors, turnedOn) }

  def toPresentation: String = tableau.map(_.presentation).mkString("\n")

  private def secondsFieldsOn: Int = (seconds + 1) % 2

  private def fiveHoursFieldsOn: Int = hours / 5

  private def hoursFieldsOn: Int = hours % 5

  private def fiveMinutesFieldsOn: Int = minutes / 5

  private def minutesFieldsOn: Int = minutes % 5
}

object BerlinClock {
  final val secondsRow: Seq[FieldColor] = Seq(Yellow)
  final val hoursRow: Seq[FieldColor] = Seq(Red, Red, Red, Red)
  final val minutesRow1: Seq[FieldColor] = Seq(Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow)
  final val minutesRow2: Seq[FieldColor] = Seq(Yellow, Yellow, Yellow, Yellow)
  final val MIDNIGHT24: BerlinClock = new BerlinClock(24, 0, 0)
  implicit val BerlinClockConverter = new StringParsingClock[BerlinClock] {
    def fromString(aTime: String): BerlinClock = aTime match {
      case "24:00:00" => BerlinClock.MIDNIGHT24
      case time =>
        val localTime = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME.withResolverStyle(ResolverStyle.STRICT))
        new BerlinClock(localTime.getHour, localTime.getMinute, localTime.getSecond)
    }
  }
}
