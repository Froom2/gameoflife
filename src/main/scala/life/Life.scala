package life

case class Life(aliveNeighbours: Integer, wasAlive: Boolean, willBeAlive: Boolean) {

  val alive = aliveNeighbours == 2 || aliveNeighbours == 3

}

case class Crawlie(xCoord: Integer, yCoord: Integer, alive: Boolean) {

  def howManyAliveNeighbours(crawlies: Seq[Crawlie]): Integer = {

    val neighbours = crawlies.filter(crawlie =>
      crawlie.yCoord == (yCoord + 1) || crawlie.xCoord == (xCoord + 1)
    )
    val aliveNeighbours = neighbours.filter(_.alive)

    aliveNeighbours.size

  }

}

case class World(crawlies: Seq[Crawlie]){


}