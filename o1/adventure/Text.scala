package o1.adventure

/*
TO DO LIST
- finish townsperson class
- write out convo maps for each townsperson (do here in text.scala)
- pass above maps as parameters in Adventure where each townsperson is added to their corresponding Area
- have separate start dialogue for butcher after first meeting?
- implement def talk in Player class
- check that def cabbage works
- def porkRunning
- def makeGyoza?? (this a definite win condition so very necessary)
- suffer more with the second area and final battle and possibly moving townspeople I guess

 */

/*
CONVO OUTLINE
iterator passes through the contents of a list of pairs of strings.
iterator always begins with first string of startDialogue (see def talk in Player class)
which string in the pair to use will depend on user input (see def respond in Player class)
 */

//Townsperson: farmer Francesco
val farmerStartDialogue = ("Farmer: Your mother's name does ring a bell", "")
val farmerDialogue1 = ("", "")
val farmerDialogue2 = ("", "")
val farmerDialogue: Vector[(String, String)] = Vector(farmerStartDialogue, farmerDialogue1, farmerDialogue2)
//Townsperson: Clark the clerk
val clerkStartDialogue = ("Clerk: Ms. Azoig? Someone like that was here years ago to grab all of our milk. It caused the great milk shortage of our town. Good times.", "")
val clerkDialogue1 = ("", "")
val clerkDialogue2 = ("", "")
val clerkDialogue = Vector(clerkStartDialogue, clerkDialogue1, clerkDialogue2)
//Townsperson: Butch the butcher
val butcherStartDialogue = ("Butcher: Damn pig running in circles around town again. Like all creatures do upon the sight of death. They run. Futile effort though.", "")
val butcherDialogue1 = ("", "")
val butcherDialogue2 = ("", "")
val butcherDialogue = Vector(butcherStartDialogue, butcherDialogue1, butcherDialogue2)
//Townsperson: Neiro your neighbor
val neighborStartDialogue = ("Neighbor: mm mmmmm mmmm", "")
val neighborDialogue1 = ("", "")
val neighborDialogue2 = ("", "")
val neighborDialogue = Vector(neighborStartDialogue, neighborDialogue1, neighborDialogue2)
