package o1.adventure

class Townsperson(val name: String, val dialogue: Vector[(String, String)]):
  /*
  private var spokenTo = false
  def alreadySpokenTo = this.spokenTo
  def nowSpokenTo() = this.spokenTo = true
   */
  private var alreadySpokenTo = index >= 1
  private var index = 0
  def getDialogue(): (String, String) =
    val indexNow = index
    index += 1
    dialogue(indexNow)

  override def toString = this.name

end Townsperson
