package o1.adventure

class Townsperson(val name: String, val dialogue: Map[String, String], val startDialogue: String):
  
  private var spokenTo = false
  
  def alreadySpokenTo = this.spokenTo
  def nowSpokenTo() = this.spokenTo = true
  
  override def toString = this.name
  
  def getDialogue(response: String): Option[String] = dialogue.get(response)

end Townsperson
