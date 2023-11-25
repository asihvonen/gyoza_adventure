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
startingDialogue: actual starting dialogue + response1 + response2
secondDialogue: reactionTOResponse1or2 + response3 + response4
...and so on? (where response1 and response2 are just some letters or numbers than the player will input as "respond A")
if we want a conversation containing two responses from player, then we will need six possible dialogues for the townsperson.
 */

//Townsperson: farmer Francesco
val farmerStartDialogue = "Your mother's name does ring a bell"
val farmerDialogue = Map[String, String]()
//Townsperson: Clark the clerk
val clerkStartDialogue = "Ms. Azoig? Someone like that was here years ago to grab all of our milk. I caused the great milk shortage of our town. Good times."
val clerkDialogue = Map[String, String]()
//Townsperson: Butch the butcher
val butcherStartDialogue = "Damn pig running in circles around town again. Like all creatures do upon the sight of death. They run. Futile effort tho."
val butcherDialogue = Map[String, String]()
//Townsperson: Neiro your neighbor
val neighborStartDialogue = "mm mmmmm mmmm"
val neighborDialogue = Map[String, String]()
