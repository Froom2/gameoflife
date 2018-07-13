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

    "return 1 when there is 1 alive neighbour in a sequence" in {

      val crawlie1 = Crawlie(1,1,true)
      val crawlie2 = Crawlie(1,2,true)
      val crawlie3 = Crawlie(2,1,false)
      val crawlie4 = Crawlie(2,2,false)

      val crawlies = Seq(crawlie1, crawlie2, crawlie3, crawlie4)

      crawlie1.howManyAliveNeighbours(crawlies) mustBe 1

    }

    "return 2 when there are 2 alive neighbours in a sequence" in {

      val crawlie1 = Crawlie(1,1,true)
      val crawlie2 = Crawlie(1,2,true)
      val crawlie3 = Crawlie(2,1,true)
      val crawlie4 = Crawlie(2,2,false)

      val crawlies = Seq(crawlie1, crawlie2, crawlie3, crawlie4)

      crawlie1.howManyAliveNeighbours(crawlies) mustBe 2

    }
  }
}
