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
  val thePork = Item("pork", "something somwthing")
  val theKnife = Item("knife", "You can now release the pig from the pain of existence.")

  /** Game areas */
  private val home        = Area("home",          "You are at your childhood home. This was where your mother took her last breath.")
  private val street1     = Area("street",        "You are on the street. There's nothing much to see here.")
  private val street2     = Area("street",        "You are on the street. There's probably more to see elsewhere.")
  private val garden      = Area("garden",        "You are in the magical little garden by your home. Here you can grow all that your heart desires.")
  private val forest      = Area("forest",        "You are in a spooky forest. There's amazing things to be found in nature. ")
  private val farm        = Area("farm",          "You are on a farm. A hillbilly town's got to have a farm somewhere near.")
  private val supermarket = Area("supermarket",   "You are in the town supermarket. There's only one supermarket and this is it.")
  private val butcher     = Area("butcher",       "You are in the butcher's shop. They always have the most beautiful red paints here.")
  private val neighbor    = Area("neighbor",      "You are now in your neighbors home. ")
  private val destination = home

  /** Relative locations of areas */
  home        .setNeighbors(Vector(                                        "south" -> street1,     "west" -> garden ))
  street1     .setNeighbors(Vector("north" -> home,    "east" -> neighbor, "south" -> street2,     "west" -> forest ))
  street2     .setNeighbors(Vector("north" -> street1, "east" -> butcher,  "south" -> supermarket, "west" -> farm   ))
  garden      .setNeighbors(Vector(                    "east" -> home,     "south" -> forest                        ))
  forest      .setNeighbors(Vector("north" -> garden,  "east" -> street1,  "south" -> farm                          ))
  farm        .setNeighbors(Vector("north" -> forest,  "east" -> street2                                           ))
  supermarket .setNeighbors(Vector("north" -> street2                                                               ))
  butcher     .setNeighbors(Vector("north" -> neighbor,                                            "west" -> street2))
  neighbor    .setNeighbors(Vector(                                         "south" -> butcher,    "west" -> street1))

  /** Items  */
  home        .addItem(Item("frying pan",  "very good for bonking"))
  garden      .addItem(Item("seed",        "do you wanna see the giants?"))
  forest      .addItem(Item("mushrooms",   "maybe you can go on a psychedelic adventures with them?"))
  farm        .addItem(Item("onion",       "tears upon the corners of your eyes"))
  supermarket .addItem(Item("seasonings",  "you wish British people actually know about the existence of this"))
  neighbor    .addItem(Item("flour",       "soft ang gentle"))

  /** Townspeople */ //edit parameters of townspeople below to also add convo!
  farm        .addTownsperson(Townsperson("francesco the farmer", farmerDialogue  ))
  supermarket .addTownsperson(Townsperson("clark the clerk",      clerkDialogue   ))
  butcher     .addTownsperson(Townsperson("butch the butcher",    butcherDialogue ))
  neighbor    .addTownsperson(Townsperson("neiro your neighbor",  neighborDialogue))

  /** The pig */
  val thePig = Pig(forest)
  forest.addPig(thePig)

  /** The character that the player controls in the game. */
  val player = Player(home) //player's startingArea is home

  /** The number of turns that have passed since the start of the game. */
  var turnCount = 0
  /** The maximum number of turns that this adventure game allows before time runs out. */
  val timeLimit = 40

  def addCabbageIntoGarden() =
    println(this.player.hasPlanted)
    if this.player.hasPlanted then
      //if this.turnCount >= 20 || this.player.hasAllIngredients then
        garden.addItem(Item("cabbage",     "You are quite disppointed that you don't get to see the giants, but hey, gyoza's way better than that"))
        println(this.player.location.description)

  /** Determines if the adventure is complete, that is, if the player has won. */
  def isComplete =
    (this.player.location == this.destination) && this.player.has("Cabbage") && this.player.has("remote")
    //additional win conditions given: the player must have the battery and remote control in their possession

  /** Determines whether the player has won, lost, or quit, thereby ending the game. */
  def isOver = this.isComplete || this.player.hasQuit || this.turnCount == this.timeLimit

  /** Returns a message that is to be displayed to the player at the beginning of the game. */
  def welcomeMessage =
    "Sizzling and steaming, crispy on the bottom and oh so tender on top, your very first taste of your late mother's gyoza was love at first bite." +
    "\n\nReminiscing in this memory, you begin to miss your mother and all the dear memories you have of her. You decide to make gyoza in honor of those memories." +
    "You check your mother's recipe book and decide to out to get all the necessary ingredients."

  /** Pig, pork, whatever it is that's running in circles */


  def catchPig() =
    if player.has("knife") && this.player.location == thePig.location then
      thePig.location.removePig(thePig)
      this.player.location.addItem(thePork)
      this.player.get("pork")
    "Pig caught, you now have pork"


  /** Message displayed to the player at the end of the game. The message
    * will be different depending on whether or not the player has completed their quest. */
  def goodbyeMessage =
    if this.isComplete then
      "Home at last... and phew, just in time! Well done!"
    else if this.turnCount == this.timeLimit then
      "Oh no! Time's up. Starved of gyoza, you collapse and die. But maybe you can meet you mother now. \nGame over!"
    else  // game over due to player quitting
      "Quitter!"


  /** Plays a turn by executing the given in-game command, such as “go west”. Returns a textual
    * report of what happened, or an error message if the command was unknown. In the latter
    * case, no turns elapse. */
  def playTurn(command: String) =
    val action = Action(command)
    thePig.move
    catchPig()
    addCabbageIntoGarden()
    val outcomeReport = action.execute(this.player)
    if outcomeReport.isDefined then
      this.turnCount += 1
    outcomeReport.getOrElse(s"""Unknown command: "$command".""")

end Adventure

