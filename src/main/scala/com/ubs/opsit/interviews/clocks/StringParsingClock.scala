package com.ubs.opsit.interviews.clocks

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks.berlinclock
 * Created by asoloviov on 7/26/17 5:43 PM.
 */

/**
 * Trait for some clock of type T with ability to instantiate itself from string time representation
 * @tparam T type of concrete AbstractClock implementation
 */
trait StringParsingClock[T <: AbstractClock] {
  /**
   * Instantiate the clock of type T with time specified by string
   * @param aTime the string denoting the time new clock instance to be set to
   * @return clock of type T instance with aTime set in it
   */
  def fromString(aTime: String): T
}
