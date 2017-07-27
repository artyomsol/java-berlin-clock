package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/27/17 11:32 AM.
 */

/**
 * Result type parametrized class of functions deriving clock representation of type P from AbstractClock instance provided
 * @tparam P type of the clock representation value returned by function implementation
 */
trait ClockRenderer[P] extends ((AbstractClock) => P) {
  def apply(aClock: AbstractClock): P
}
