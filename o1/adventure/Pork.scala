package o1.adventure

class Pork(dropArea: Area, route: Vector, description: String):

  private var currentLocation = dropArea

  def location = this.currentLocation

  def run(step: Int) =
    val route