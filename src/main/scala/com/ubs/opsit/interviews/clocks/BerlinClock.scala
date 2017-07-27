package com.ubs.opsit.interviews.clocks

import java.time.LocalTime
import java.time.format.{DateTimeFormatter, ResolverStyle}


/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks.berlinclock
 * Created by asoloviov on 7/26/17 5:38 PM.
 */
case class BerlinClock[P: ClockRenderer](hours: Int, minutes: Int, seconds: Int) extends AbstractClock with ClockPresentation[P] {
  require(hours >= 0 && hours <= 24, "hours value must be in interval [0;24]")
  require(minutes >= 0 && minutes <= 59, "minutes value must be in interval [0;59]")
  require(seconds >= 0 && seconds <= 59, "seconds value must be in interval [0;59]")
  require(hours != 24 || minutes == 0 && minutes == 0, "both minutes and seconds must be 0 when hours set to 24")

  def getPresentation: P = implicitly[ClockRenderer[P]].apply(this)
}

object BerlinClock {
  implicit def BerlinClockConverter[P: ClockRenderer] = new StringParsingClock[BerlinClock[P]] {
    def fromString(aTime: String): BerlinClock[P] = aTime match {
      case "24:00:00" => Midnight
      case time =>
        val localTime = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME.withResolverStyle(ResolverStyle.STRICT))
        new BerlinClock(localTime.getHour, localTime.getMinute, localTime.getSecond)
    }
  }

  final def Midnight[P: ClockRenderer]: BerlinClock[P] = new BerlinClock(24, 0, 0)
}
