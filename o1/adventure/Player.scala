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
  def townspeopleHere: Option[Townsperson] = this.currentLocation.getTownspeople
  private var planted = false

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

  def hasPlanted = this.planted

  def plant(theSeed: String): String =
    if theSeed == "seed" then
      if this.currentLocation.name == "garden" && this.has("seed") then
        this.planted = true
        this.possessions -= theSeed
        "Seed succesfully planted."
      else
        "Unsuccessful." + (if !this.has("seed") then "You need to have the seed first" else "You need to be in the garden to plant the seed")
    else
      s"You can't plant ${theSeed}, you have to plant a seed."

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

  def talkTo(townspersonName: String): String =
    if townspeopleHere.nonEmpty then //if there is a townsperson in the area -> this is always false for some reason
    //include in above if statement: townspeopleHere.get.name == townspersonName
      val speaker: Townsperson = townspeopleHere.get
      if speaker.alreadySpokenTo then
        s"You have already spoken to $townspersonName."
      else s"You talk to $townspersonName./n " + speaker.getDialogue().get._1
    else
      s"You can't talk to $townspersonName because they're not here. Maybe you ought to talk to the local optician instead."

  def respond(response: String): String =
    if townspeopleHere.nonEmpty then
      val speaker: Townsperson = townspeopleHere.get //assumes there's only one townsperson in an area
      if speaker.alreadySpokenTo then
        speaker.getDialogue() match
          case Some( (dialogue1, dialogue2) ) => if response == "A" then dialogue1 else dialogue2
          case None => ""
      else
        s"You have already spoken to ${speaker.name}."
    else
      "Who exactly are you responding to when you're not talking to anyone to begin with?"

  def help(): String = ???

  def hasAllIngredients = (this.has("pork") && this.has("flour") && this.has("onion") && this.has("mushrooms") && this.has("seasonings"))

/*
  def make(theGyoza: String) =
    if theGyoza = "gyoza" && this.hasAllIngredients && this.has("frying pan") then
      //remove all ingredients from inventory: .clear()? (but if frying pan is in the inventory...)
      //add gyoza to inventory
 */

  //def canMakeGyoza(): Boolean = this.possessions.size == 6 && this.location
  //number of ingredients now hard-coded!! also this doesn't really work because a lot of info needed for this is found in Adventure.scala...

end Player

