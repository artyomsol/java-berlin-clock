package com.ubs.opsit.interviews

import com.ubs.opsit.interviews.clocks.{AbstractClock, ClockPresentation, StringParsingClock}

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews
 * Created by asoloviov on 7/26/17 5:39 PM.
 */

/**
 * Idea to convert time from String time to String clock quite strange but still we should implement the TimeConverter interface
 * With StrangeTimeConverter class we will use ClockPresentation[String] extension of some AbstractClock to get the
 * ClockRenderer able to produce string presentation of clock. Implicit (or explicit) StringParsingClock[T]
 * should be provided to refer the concrete Clock used
 * @tparam T concrete class type of AbstractClock with ClockPresentation[String]
 */
class StrangeTimeConverter[T <: AbstractClock with ClockPresentation[String] : StringParsingClock] extends TimeConverter {
  override def convertTime(aTime: String): String = implicitly[StringParsingClock[T]].fromString(aTime).getPresentation
}
