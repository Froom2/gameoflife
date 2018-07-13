package life

import org.scalatest.{MustMatchers, WordSpec}

class LifeSpec extends WordSpec with MustMatchers {

  "life" when {
    "property alive is checked" should {
      "return false if it has fewer than 2 neighbours" in {
        val life1 = Life(1)
        life1.alive mustBe false
      }
      "return true if it has 2 or 3 neighbours" in {
        val life2 = Life(2)
        life2.alive mustBe true
        val life3 = Life(3)
        life3.alive mustBe true
      }
      "return true if it has more than 3 neighbours" in {
        val life2 = Life(4)
        life2.alive mustBe false
        val life3 = Life(6)
        life3.alive mustBe false
      }
    }
  }

}
