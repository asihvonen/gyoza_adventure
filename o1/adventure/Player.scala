package o1.adventure

import scala.collection.mutable.Map

/** A `Player` object represents a player character controlled by the real-life user
  * of the program.
  *
  * A player object’s state is mutable: the player’s location and possessions can change,
  * for instance.
  *
  * @param startingArea  the player’s initial location */
class Player(startingArea: Area):

  private var currentLocation = startingArea           // gatherer: changes in relation to the previous location
  private var quitCommandGiven = false                 // one-way flag
  private var possessions = Map[String, Item]()        // Map of the items that a player has in their possession
  private var townspeopleHere = this.currentLocation.getTownspeople()
  var planted = false

  /** Determines if the player has indicated a desire to quit the game. */
  def hasQuit = this.quitCommandGiven

  /** Returns the player’s current location. */
  def location = this.currentLocation

  //Returns the player's current possessions
  def inventory =
    if this.possessions.isEmpty then "You are empty-handed."
    else "You are carrying: \n" + this.possessions.keys.mkString("\n")

  /** Attempts to move the player in the given direction. This is successful if there
    * is an exit from the player’s current location towards the direction name. Returns
    * a description of the result: "You go DIRECTION." or "You can't go DIRECTION." */
  def go(direction: String) =
    val destination = this.location.neighbor(direction)
    this.currentLocation = destination.getOrElse(this.currentLocation)
    if destination.isDefined then "You go " + direction + "." else "You can't go " + direction + "."


  /** Causes the player to rest for a short while (this has no substantial effect in game terms).
    * Returns a description of what happened. */
  def rest() =
    "You rest for a while. Better get a move on, though."

<<<<<<< HEAD
=======

  def plant(theSeed: String): Boolean =
    if theSeed == "seed" then
      if this.currentLocation == garden && this.has("seed") then
        this.planted = true
        this.possessions -= theSeed
        "Seed succesfully planted."
      else
        "Unsuccessful, you either plan it in the wrong place, or you need to have the seed first."
    else
      "You can't plan this item, you have to plan a seed."



>>>>>>> dda76cef37c286a10bf78318a718601d2ad4be7e
  /** Signals that the player wants to quit the game. Returns a description of what happened within
    * the game as a result (which is the empty string, in this case). */
  def quit() =
    this.quitCommandGiven = true
    ""

  /** Returns a brief description of the player’s state, for debugging purposes. */
  override def toString = "Now at: " + this.location.name

  def get(itemName: String): String =
    if this.location.contains(itemName) then //if there is an item in the player's current location
      this.possessions += itemName -> this.location.removeItem(itemName).get //then the item is added to the player's inventory and removed from the location
      s"You pick up the ${itemName}."
    else
      s"There is no ${itemName} here to pick up."

  def drop(itemName: String): String =
    if this.possessions.contains(itemName) then //if the item is in the player's possession
      this.location.addItem(this.possessions(itemName)) //the item is added to the area
      this.possessions -= itemName //and the item is removed from the player's inventory
      s"You drop the $itemName." //returns description of successful item drop
    else
      "You don't have that!" //returns description of unsuccessful item drop

  def examine(itemName: String): String =
    if this.possessions.contains(itemName) then
      s"You look closely at the $itemName.\n${this.possessions(itemName).description}"
    else
      "If you want to examine something, you need to pick it up first."

  def has(itemName: String): Boolean = this.possessions.contains(itemName)
  //Determines whether the player is carrying an item of the given name.

   def plant(theSeed: String): String =
    //var success = false -> why do we need this function to return a Boolean at all? (I've changed return type for now)
    if theSeed == "seed" then
      if this.currentLocation.name == "garden" && this.has("seed") then
        this.possessions -= theSeed
        //how to call def addCabbageIntoGarden (found in Adventure class) from here?
        "Seed succesfully planted."
        //success = true
      else
        "Unsuccessful, you either plan it in the wrong place, or you need to have the seed first."
    else
      "You can't plan this item, you have to plan a seed."

  def talk(townspersonName: String): String =
    if this.location.resides(townspersonName) then
      if townspeopleHere(townspersonName).alreadySpokenTo then //we don't want to repeat start dialogues
        s"You have already spoken to $townspersonName."
      else
        townspeopleHere(townspersonName).nowSpokenTo()
        s"You talk to $townspersonName./n" + townspeopleHere(townspersonName).startDialogue
    else
      s"You can't talk to $townspersonName because they're not in ${this.location}. Maybe you ought to talk to the local optician instead."

<<<<<<< HEAD
  def respond(response: String): String =
    townspeopleHere.head._2.getDialogue(response).getOrElse("You have entered an invalid response")
=======
  def respond(reponse: String): String =

>>>>>>> dda76cef37c286a10bf78318a718601d2ad4be7e

  def help(): String = ???
  //def canMakeGyoza(): Boolean = this.possessions.size == 6 && this.location
  //number of ingredients now hard-coded!! also this doesn't really work because a lot of info needed for this is found in Adventure.scala...

end Player

