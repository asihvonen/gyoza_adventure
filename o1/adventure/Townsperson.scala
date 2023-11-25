package o1.adventure

class Townsperson(val name: String, val dialogue: Map[String, String], val startingDialogue: String):

  /** Returns a short textual representation of the item (its name, that is). */
  override def toString = this.name
  def getDialogue(response: String): Option[String] = dialogue.get(response)

end Townsperson
