package o1.adventure
import scala.util.Random

class Pig(dropArea: Area):

  private var currentLocation = dropArea

  val direction = Vector("north", "east", "south", "west")

  def dropPlace = this.dropArea

  def location = currentLocation

  val random = Random(15)

  private def directionOf =
    var dir = random.nextInt(4)
    val a = direction(dir)
    println(dir)
    a


  def nextLocation: Area =
    var newLocation = this.currentLocation.neighbor("south").getOrElse(currentLocation)
    //while newLocation == this.currentLocation do
      //newLocation = this.currentLocation.neighbor(directionOf).getOrElse(currentLocation)
    newLocation

  def move =
    val previousLocation = this.currentLocation
    previousLocation.removePig(this)
    this.currentLocation = nextLocation
    this.currentLocation.addPig(this)
    println(this.currentLocation.name)


