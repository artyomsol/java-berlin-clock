package com.ubs.opsit.interviews

import com.ubs.opsit.interviews.clocks.BerlinClock._
import com.ubs.opsit.interviews.clocks.BerlinClockRenderers

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews
 * Created by asoloviov on 7/26/17 5:02 PM.
 */

object BerlinClockTimeConverter extends StrangeTimeConverter()(BerlinClockConverter(BerlinClockRenderers.StraightAndDirtyBerlinClockRenderer))