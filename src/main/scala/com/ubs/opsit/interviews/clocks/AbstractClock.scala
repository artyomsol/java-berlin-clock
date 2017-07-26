package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/26/17 6:00 PM.
 */
trait AbstractClock {
  val hours: Int
  val minutes: Int
  val seconds: Int

  def toPresentation: String
}
