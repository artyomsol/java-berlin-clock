package com.ubs.opsit.interviews.clocks

import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

import scala.util.Random

/**
 * Project: java-berlin-clock
 * Package: com.ubs.opsit.interviews.clocks
 * Created by asoloviov on 7/27/17 5:43 PM.
 */
class BerlinClockRenderers$Test extends Specification with Matchers with TestsData {

  import BerlinClockRenderers._

  "BerlinClockRenderers$Test" should {
    "provide equivalent the BerlinClock renderers as".txt
    "correct StraightAndDirtyBerlinClockRenderer" in {
      StraightAndDirtyBerlinClockRenderer(testClock1) must_=== testClock1Presentation
      StraightAndDirtyBerlinClockRenderer(testClock2) must_=== testClock2Presentation
      StraightAndDirtyBerlinClockRenderer(testClock3) must_=== testClock3Presentation
      StraightAndDirtyBerlinClockRenderer(testClock4) must_=== testClock4Presentation
    }

    "correct AdvancedBerlinClockRenderer" in {
      AdvancedBerlinClockRenderer(testClock1) must_=== testClock1Presentation
      AdvancedBerlinClockRenderer(testClock2) must_=== testClock2Presentation
      AdvancedBerlinClockRenderer(testClock3) must_=== testClock3Presentation
      AdvancedBerlinClockRenderer(testClock4) must_=== testClock4Presentation
    }

    "correct ProgressBarBerlinClockRenderer" in {
      ProgressBarBerlinClockRenderer(testClock1) must_=== testClock1Presentation
      ProgressBarBerlinClockRenderer(testClock2) must_=== testClock2Presentation
      ProgressBarBerlinClockRenderer(testClock3) must_=== testClock3Presentation
      ProgressBarBerlinClockRenderer(testClock4) must_=== testClock4Presentation
    }

    "equivalent on the complete definition field" in {
      // will check some reasonable number of iterations
      (0 to 8640).map { _ =>
        val clock = new AbstractClock {
          override val hours: Int = Random.nextInt(24)
          override val minutes: Int = Random.nextInt(60)
          override val seconds: Int = Random.nextInt(60)
        }
        val repr = StraightAndDirtyBerlinClockRenderer(clock)
        ProgressBarBerlinClockRenderer(clock) must_=== repr
        AdvancedBerlinClockRenderer(clock) must_=== repr
      }
    }
  }
}
