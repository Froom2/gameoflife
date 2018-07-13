package life

case class Crawlie(xCoord: Integer, yCoord: Integer, alive: Boolean) {

  def howManyAliveNeighbours(crawlies: Seq[Crawlie]): Integer = {

    val neighbours = crawlies.filter(crawlie =>
      crawlie.yCoord == (yCoord + 1) || crawlie.xCoord == (xCoord + 1) ||
        crawlie.yCoord == (yCoord - 1) || crawlie.xCoord == (xCoord - 1)
    )

    val aliveNeighbours = neighbours.filter(_.alive)

    aliveNeighbours.size

  }

  def nextCrawlie(crawlies:Seq[Crawlie]): Crawlie = {

    val aliveCrawlies = howManyAliveNeighbours(crawlies)

    Crawlie(xCoord, yCoord, aliveCrawlies==2 || aliveCrawlies==3)
  }

}

case class CrawlieSnapshot(crawlies: Seq[Crawlie]){

  def generateNextCrawlieSnapshot: CrawlieSnapshot = {
    val newCrawlies = crawlies.map(_.nextCrawlie(crawlies))
    CrawlieSnapshot(newCrawlies)
  }

}