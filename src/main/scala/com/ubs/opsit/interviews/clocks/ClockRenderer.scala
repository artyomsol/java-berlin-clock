package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/27/17 11:32 AM.
 */
trait ClockRenderer[P] extends ((AbstractClock) => P) {
  def apply(aClock: AbstractClock): P
}
