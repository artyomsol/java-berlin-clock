package com.ubs.opsit.interviews

import com.ubs.opsit.interviews.clocks.{AbstractClock, StringParsingClock}

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews
 * Created by asoloviov on 7/26/17 5:39 PM.
 */
class StrangeTimeConverter[T <: AbstractClock : StringParsingClock] extends TimeConverter {
  override def convertTime(aTime: String): String = implicitly[StringParsingClock[T]].fromString(aTime).toPresentation
}
