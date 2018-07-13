package life

import org.scalatest.{MustMatchers, WordSpec}

class LifeSpec extends WordSpec with MustMatchers {

  "howManyAliveNeighbours" should {
    "return 0 when there are no alive neighbours in a sequence" in {

      val crawlie1 = Crawlie(1,1,true)
      val crawlie2 = Crawlie(1,2,false)
      val crawlie3 = Crawlie(2,1,false)
      val crawlie4 = Crawlie(2,2,false)

      val crawlies = Seq(crawlie1, crawlie2, crawlie3, crawlie4)

      crawlie1.howManyAliveNeighbours(crawlies) mustBe 0

    }
  }
}
