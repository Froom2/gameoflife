package life

import org.scalatest.{MustMatchers, WordSpec}

class LifeSpec extends WordSpec with MustMatchers {

  "howManyAliveNeighbours" when {
    "there are no alive crawlie neighbours" should {
      "return 0" in {

        val testCrawlie = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, false)
        val crawlie3 = Crawlie(2, 1, false)
        val crawlie4 = Crawlie(2, 2, false)

        val crawlies = Seq(testCrawlie, crawlie2, crawlie3, crawlie4)

        testCrawlie.howManyAliveNeighbours(crawlies) mustEqual 0

      }
    }

    "there are crawlie neighbours to right angles of the crawlie" should {
      "return 1 when there is 1 alive neighbour in a sequence" in {

        val testCrawlie = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, true)
        val crawlie3 = Crawlie(2, 1, false)
        val crawlie4 = Crawlie(2, 2, false)

        val crawlies = Seq(testCrawlie, crawlie2, crawlie3, crawlie4)

        testCrawlie.howManyAliveNeighbours(crawlies) mustEqual 1

      }

      "return 2 when there are 2 alive neighbours in a sequence" in {

        val testCrawlie = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, true)
        val crawlie3 = Crawlie(2, 1, true)
        val crawlie4 = Crawlie(2, 2, false)

        val crawlies = Seq(testCrawlie, crawlie2, crawlie3, crawlie4)

        testCrawlie.howManyAliveNeighbours(crawlies) mustEqual 2

      }

      "return 1 when there is 1 alive neighbour in a sequence behind the crawlie" in {

        val crawlie1 = Crawlie(1, 1, true)
        val testCrawlie = Crawlie(1, 2, true)
        val crawlie3 = Crawlie(2, 1, false)
        val crawlie4 = Crawlie(2, 2, false)

        val crawlies = Seq(crawlie1, testCrawlie, crawlie3, crawlie4)

        testCrawlie.howManyAliveNeighbours(crawlies) mustEqual 1

      }

      "return 1 when there is 1 alive neighbour in a sequence above the crawlie" in {

        val crawlie1 = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, false)
        val testCrawlie = Crawlie(2, 1, true)
        val crawlie4 = Crawlie(2, 2, false)

        val crawlies = Seq(crawlie1, crawlie2, testCrawlie, crawlie4)

        testCrawlie.howManyAliveNeighbours(crawlies) mustEqual 1

      }
    }

    "there are crawlie neighbours to diagonals from the crawlie" should {

      "return 1 when there is 1 alive neighbour in a sequence" in {

        val testCrawlie = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, false)
        val crawlie3 = Crawlie(2, 1, false)
        val crawlie4 = Crawlie(2, 2, true)

        val crawlies = Seq(testCrawlie, crawlie2, crawlie3, crawlie4)

        testCrawlie.howManyAliveNeighbours(crawlies) mustEqual 1

      }
    }

    "there are alive crawlies not next to the crawlie" should {
      "return 0 if there aren't any immediate alive crawlies" in {

        val testCrawlie = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, false)
        val crawlie3 = Crawlie(2, 1, false)
        val crawlie4 = Crawlie(2, 2, false)
        val crawlie5 = Crawlie(3, 1, true)
        val crawlie6 = Crawlie(3, 2, false)

        val crawlies = Seq(testCrawlie, crawlie2, crawlie3, crawlie4, crawlie5, crawlie6)

        testCrawlie.howManyAliveNeighbours(crawlies) mustEqual 0

      }
    }
  }

  "nextCrawlie" should {
    "return a new dead crawlie" when {
      "there are no alive neighbours" in {
        val testCrawlie = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, false)
        val crawlie3 = Crawlie(2, 1, false)
        val crawlie4 = Crawlie(2, 2, false)

        val crawlies = Seq(testCrawlie, crawlie2, crawlie3, crawlie4)

        testCrawlie.nextCrawlie(crawlies) mustEqual Crawlie(1, 1, false)
      }
    }
    "return a new alive crawlie" when {
      "there are 2 alive neighbours" in {
        val testCrawlie = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, true)
        val crawlie3 = Crawlie(2, 1, true)
        val crawlie4 = Crawlie(2, 2, false)

        val crawlies = Seq(testCrawlie, crawlie2, crawlie3, crawlie4)

        testCrawlie.nextCrawlie(crawlies) mustEqual Crawlie(1, 1, true)
      }
      "there are 3 alive neighbours" in {
        val testCrawlie = Crawlie(1, 1, true)
        val crawlie2 = Crawlie(1, 2, true)
        val crawlie3 = Crawlie(2, 1, true)
        val crawlie4 = Crawlie(2, 2, true)

        val crawlies = Seq(testCrawlie, crawlie2, crawlie3, crawlie4)

        testCrawlie.nextCrawlie(crawlies) mustEqual Crawlie(1, 1, true)
      }
    }
  }

  "generateNextCrawlieSnapshot" should {
    "generate a new sequence of crawlies" in {

      val crawlie1 = Crawlie(1, 1, true)
      val crawlie2 = Crawlie(1, 2, true)
      val crawlie3 = Crawlie(2, 1, true)
      val crawlie4 = Crawlie(2, 2, false)

      val crawlies = Seq(crawlie1, crawlie2, crawlie3, crawlie4)

      val testSnapshot = CrawlieSnapshot(crawlies)

      val expectedNewSnapshot = CrawlieSnapshot(Seq(
        crawlie1,
        crawlie2,
        crawlie3,
        crawlie4.copy(alive = true)
      ))
      
      testSnapshot.generateNextCrawlieSnapshot mustEqual expectedNewSnapshot

    }
  }

  "generateWorld" should {
    "return a sequence of the given number of snapshots" in {

      val crawlie1 = Crawlie(1, 1, true)
      val crawlie2 = Crawlie(1, 2, true)
      val crawlie3 = Crawlie(2, 1, true)
      val crawlie4 = Crawlie(2, 2, false)
      val crawlieNew = Crawlie(2, 2, true)

      val crawlies = Seq(crawlie1, crawlie2, crawlie3, crawlie4)

      val testSnapshot = CrawlieSnapshot(crawlies)

      val newSnapshot = CrawlieSnapshot(Seq(crawlie1, crawlie2, crawlie3, crawlieNew))

      testSnapshot.generateWorld(2) mustBe Seq(
        testSnapshot, newSnapshot
      )

    }
  }
}
