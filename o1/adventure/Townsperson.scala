package o1.adventure

class Townsperson(val name: String, val dialogue: Vector[(String, String)]):

  def alreadySpokenTo: Boolean = index >= 1
  private var index = 0

  def getDialogue(): Option[(String, String)] =
    val indexNow = index
    index += 1
    if indexNow < dialogue.length then Option(dialogue(indexNow))
    else None

  override def toString = this.name

end Townsperson
