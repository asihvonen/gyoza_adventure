package o1.adventure

/** The class `Adventure` represents text adventure games. An adventure consists of a player and
  * a number of areas that make up the game world. It provides methods for playing the game one
  * turn at a time and for checking the state of the game.
  *
  * N.B. This version of the class has a lot of “hard-coded” information that pertains to a very
  * specific adventure game that involves a small trip through a twisted forest. All newly created
  * instances of class `Adventure` are identical to each other. To create other kinds of adventure
  * games, you will need to modify or replace the source code of this class. */
class Adventure:

  /** The name of the game */
  val title = "Gyoza Adventure"

  /** Game areas */
  private val home        = Area("Home",          "You are at home.")
  private val street1     = Area("Street",        "You are on the street.")
  private val street2     = Area("Street",         "You are on the street")
  private val garden      = Area("Garden",         "You are in the garden by your home.")
  private val forest      = Area("Forest",         "You are a forest.")
  private val farm        = Area("Farm",            "You are on a farm.")
  private val supermarket = Area("Supermarket",     "You are in the town supermarket.")
  private val butcher     = Area("Butcher",         "You are in the butcher's shop.")
  private val neighbor    = Area("Neighbor",        "You are at your neighbor's home.")
  private val destination = home

  /** Relative locations of areas */
  home        .setNeighbors(Vector(                                                                "west" -> garden ))
  street1     .setNeighbors(Vector("north" -> home,    "east" -> neighbor, "south" -> street2,     "west" -> forest ))
  street2     .setNeighbors(Vector("north" -> street1, "east" -> butcher,  "south" -> supermarket, "west" -> farm   ))
  garden      .setNeighbors(Vector(                    "east" -> home                                               ))
  forest      .setNeighbors(Vector(                    "east" -> street1                                            ))
  farm        .setNeighbors(Vector(                    "east" -> street2                                            ))
  supermarket .setNeighbors(Vector("north" -> street2                                                               ))
  butcher     .setNeighbors(Vector("north" -> neighbor,                                            "west" -> street2))
  neighbor    .setNeighbors(Vector(                                         "south" -> butcher,    "west" -> street1))

  /** Items  */
  //clearing   .addItem(Item("battery", "It's a small battery cell. Looks new."))
  //southForest.addItem(Item("remote", "It's the remote control for your TV.\nWhat it was doing in the forest, you have no idea.\nProblem is, there's no battery."))

  /** The character that the player controls in the game. */
  val player = Player(home) //player's startingArea is home

  /** The number of turns that have passed since the start of the game. */
  var turnCount = 0
  /** The maximum number of turns that this adventure game allows before time runs out. */
  val timeLimit = 40


  /** Determines if the adventure is complete, that is, if the player has won. */
  def isComplete =
    (this.player.location == this.destination) && this.player.has("battery") && this.player.has("remote")
    //additional win conditions given: the player must have the battery and remote control in their possession

  /** Determines whether the player has won, lost, or quit, thereby ending the game. */
  def isOver = this.isComplete || this.player.hasQuit || this.turnCount == this.timeLimit

  /** Returns a message that is to be displayed to the player at the beginning of the game. */
  def welcomeMessage =
    "Sizzling and steaming, crispy on the bottom and oh so tender on top, your very first taste of your late mother's gyoza was love at first bite." +
    "\n\nReminiscing in this memory, you begin to miss your mother and all the dear memories you have of her. You decide to make gyoza in honor of those memories." +
    "You check your mother's recipe book and decide to set out to get all the necessary ingredients."


  /** Message displayed to the player at the end of the game. The message
    * will be different depending on whether or not the player has completed their quest. */
  def goodbyeMessage =
    if this.isComplete then
      "Home at last... and phew, just in time! Well done!"
    else if this.turnCount == this.timeLimit then
      "Oh no! Time's up. Starved of entertainment, you collapse and weep like a child.\nGame over!"
    else  // game over due to player quitting
      "Quitter!"


  /** Plays a turn by executing the given in-game command, such as “go west”. Returns a textual
    * report of what happened, or an error message if the command was unknown. In the latter
    * case, no turns elapse. */
  def playTurn(command: String) =
    val action = Action(command)
    val outcomeReport = action.execute(this.player)
    if outcomeReport.isDefined then
      this.turnCount += 1
    outcomeReport.getOrElse(s"""Unknown command: "$command".""")

end Adventure

