package com.ubs.opsit.interviews.clocks

import java.util.regex.Pattern

import org.specs2.matcher.Matchers

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/26/17 8:57 PM.
 */
class BerlinClockTest extends org.specs2.mutable.Specification with Matchers {

  import BerlinClockRenderers.AdvancedBerlinClockRenderer
  "BerlinClock" should {
    "create BerlinClock with correct parameters" in {
      BerlinClock(13, 17, 1) must haveClass[BerlinClock[String]]
    }
    "check allowed hours values" in {
      val expectedMessagePattern = Pattern.quote("hours value must be in interval [0;24]")
      BerlinClock(-1, 17, 1) must throwAn[IllegalArgumentException](expectedMessagePattern)
      BerlinClock(25, 17, 1) must throwAn[IllegalArgumentException](expectedMessagePattern)
      BerlinClock(0, 17, 1) must haveClass[BerlinClock[String]]
    }
    "check allowed hours values for midnight (24:00:00) " in {
      val expectedMessagePattern = Pattern.quote("both minutes and seconds must be 0 when hours set to 24")
      BerlinClock(24, 17, 1) must throwAn[IllegalArgumentException](expectedMessagePattern)
      BerlinClock(24, 0, 0) must haveClass[BerlinClock[String]]
    }
    "check allowed minutes values" in {
      val expectedMessagePattern = Pattern.quote("minutes value must be in interval [0;59]")
      BerlinClock(13, -5, 1) must throwAn[IllegalArgumentException](expectedMessagePattern)
      BerlinClock(13, 60, 1) must throwAn[IllegalArgumentException](expectedMessagePattern)
    }
    "check allowed seconds values" in {
      val expectedMessagePattern = Pattern.quote("seconds value must be in interval [0;59]")
      BerlinClock(13, 5, -100) must throwAn[IllegalArgumentException](expectedMessagePattern)
      BerlinClock(13, 59, 100) must throwAn[IllegalArgumentException](expectedMessagePattern)
      BerlinClock(0, 59, 59) must haveClass[BerlinClock[String]]
    }
  }
}
