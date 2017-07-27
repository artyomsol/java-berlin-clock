package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/27/17 6:09 PM.
 */
trait TestsData {
  val testClock1 = new AbstractClock {
    override val hours: Int = 13
    override val minutes: Int = 17
    override val seconds: Int = 1
  }
  val testClock1Presentation = "O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO"
  val testClock2 = new AbstractClock {
    override val hours: Int = 24
    override val minutes: Int = 0
    override val seconds: Int = 0
  }
  val testClock2Presentation = "Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO"
  val testClock3 = new AbstractClock {
    override val hours: Int = 0
    override val minutes: Int = 0
    override val seconds: Int = 0
  }
  val testClock3Presentation = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO"
  val testClock4 = new AbstractClock {
    override val hours: Int = 23
    override val minutes: Int = 59
    override val seconds: Int = 59
  }
  val testClock4Presentation = "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY"

}
