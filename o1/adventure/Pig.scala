package o1.adventure
import scala.util.Random

class Pig(private val dropArea: Area):

  private var currentLocation = dropArea

  val direction = Vector("north", "east", "south", "west")

  def dropPlace = this.dropArea

  def location = currentLocation

  private def directionOf =
    var dir = Random(15).nextInt(4)
    direction(dir)

  def nextLocation: Area =
    var newLocation = this.currentLocation.neighbor(directionOf).getOrElse(currentLocation)
    while newLocation == this.currentLocation do
      newLocation = this.currentLocation.neighbor(directionOf).getOrElse(currentLocation)
    newLocation

  def move =
    val previousLocation = this.currentLocation
    previousLocation.removePig(this)
    this.currentLocation = nextLocation
    this.currentLocation.addPig(this)
    println(this.currentLocation.name)


