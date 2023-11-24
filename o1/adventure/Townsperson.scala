package o1.adventure

class Townsperson(val name: String, val description: String):

  /** Returns a short textual representation of the item (its name, that is). */
  override def toString = this.name

  def dialogueOne   = ""
  def dialogueTwo   = ""
  def dialogueThree = ""

end Townsperson
