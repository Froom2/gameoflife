package life

case class Life(aliveNeighbours: Integer, wasAlive: Boolean, willBeAlive: Boolean) {

  val alive = aliveNeighbours == 2 || aliveNeighbours == 3

}

case class Crawlie(xCoord: Integer, yCoord: Integer, alive: Boolean) {

  def howManyAliveNeighbours(crawlies: Seq[Crawlie]): Integer = {
    0
  }

}

case class World(crawlies: Seq[Crawlie]){


}