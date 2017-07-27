package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/27/17 12:38 PM.
 */

/**
 * Interface for some AbstractClock adding presentation generating function
 * @tparam P the type of the representation value generated
 */
trait ClockPresentation[P] {
  this: AbstractClock =>
  def getPresentation: P
}
