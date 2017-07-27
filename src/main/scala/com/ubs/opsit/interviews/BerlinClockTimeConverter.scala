package com.ubs.opsit.interviews

import com.ubs.opsit.interviews.clocks.BerlinClock._
import com.ubs.opsit.interviews.clocks.BerlinClockRenderers

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews
 * Created by asoloviov on 7/26/17 5:02 PM.
 */

/**
 * TimeConverter instance for BerlinClock
 * As an instance of the StrangeTimeConverter it could be parametrized (implicitly or explicitly) with the
 * BerlinClockConverter build on one of BerlinClockRenderers (see com.ubs.opsit.interviews.clocks.BerlinClockRenderers) :
 * - AdvancedBerlinClockRenderer
 * - ProgressBarBerlinClockRenderer
 * - StraightAndDirtyBerlinClockRenderer
 */
object BerlinClockTimeConverter extends StrangeTimeConverter()(BerlinClockConverter(BerlinClockRenderers.StraightAndDirtyBerlinClockRenderer))