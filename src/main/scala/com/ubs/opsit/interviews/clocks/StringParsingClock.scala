package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks.berlinclock
 * Created by asoloviov on 7/26/17 5:43 PM.
 */
trait StringParsingClock[T <: AbstractClock] {
  def fromString(aTime: String): T
}
