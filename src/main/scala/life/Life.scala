package life

case class Life(neighbours: Integer) {

  val alive = neighbours == 2 || neighbours == 3

}
