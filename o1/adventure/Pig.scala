package o1.adventure
import scala.util.Random

class Pig(private val dropArea: Area):

  private var currentLocation = this.dropArea

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
<<<<<<< HEAD
    val route1 = Vector[Area]( //route1 currentLocation should be neighbor
      this.currentLocation,
      this.currentLocation.neighbor("south").getOrElse(currentLocation),  //butcher
      this.currentLocation.neighbor("west").getOrElse(currentLocation),   //street2
      this.currentLocation.neighbor("west").getOrElse(currentLocation),   //farm
      this.currentLocation.neighbor("north").getOrElse(currentLocation),  //forest
      this.currentLocation.neighbor("east").getOrElse(currentLocation),   //street1
      this.currentLocation.neighbor("east").getOrElse(currentLocation))   //neighbor
    val route2 = Vector[Area]( //route2 currentLocation should be street2
      this.currentLocation,
      this.currentLocation.neighbor("east").getOrElse(currentLocation),   //butcher
      this.currentLocation.neighbor("north").getOrElse(currentLocation),  //neighbor
      this.currentLocation.neighbor("west").getOrElse(currentLocation),   //street1
      this.currentLocation.neighbor("west").getOrElse(currentLocation),   //forest
      this.currentLocation.neighbor("south").getOrElse(currentLocation))  //farm
    if dropArea.name == "neighbor" then
      previousLocation.removePig(this)
      this.currentLocation = route1(count)
      this.currentLocation.addPig(this)
    else if dropArea.name == "street" then
      previousLocation.removePig(this)
      this.currentLocation = route2(count)
      this.currentLocation.addPig(this)
    count += 1
    if count == route1.length then
      count == 0
=======
    previousLocation.removePig(this)
    this.currentLocation = nextLocation
    this.currentLocation.addPig(this)
    println(this.currentLocation.name)
>>>>>>> 2a4c28b73edd9983067d88e1f81a4ecdaf1dcc4a


