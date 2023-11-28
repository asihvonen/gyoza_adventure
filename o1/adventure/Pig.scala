package o1.adventure
import scala.util.Random

class Pig(dropArea: Area):

  private var currentLocation = dropArea

  val pigRun = Vector("north", "west", "west", "south", "east", "east")

  def location = currentLocation

  var counter = 0

  val random = Random(15)

  private def directionOf =
    //var dir = random.nextInt(4)
    //val a = direction(dir)
    //println(dir)
    //a
    pigRun(counter)
    counter += 1
    if counter == 5 then
      counter = 0



  def nextLocation: Area =
    var newLocation = this.currentLocation.neighbor(directionOf).getOrElse(currentLocation)
    //while newLocation == this.currentLocation do
      //newLocation = this.currentLocation.neighbor(directionOf).getOrElse(currentLocation)
    newLocation

  def move =
    val previousLocation = this.currentLocation
    previousLocation.removePig(this)
    this.currentLocation = nextLocation
    this.currentLocation.addPig(this)
    println(this.currentLocation.name)


