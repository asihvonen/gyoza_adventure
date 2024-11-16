# gyoza_adventure
This is a text adventure game, the final project for Aalto University's CS-A1110 Programming 1 course.

## Game description
Feeling nostalgic for your late mother's gyoza, you set out on an adventure to find all the ingredients necessary to cook your own gyoza at home.

## Game Design:
The game world consists of your own house, a garden , your neighbor’s place, north and south street, a farm, a forest, a butcher and a supermarket. 
This isn’t just a game of mere ingredient gathering, upon your quest you shall face multiple challenge with some of your ingredients (growing cabbage from the seed you obtained and catching the pig which is running circles around the town) as well as interact with NPCs.

## Available player actions:
help - get a list of all available commands.
get ITEMNAME - attempt to add the item into your inventory from the area you are currently standing in
drop ITEMNAME - drop an item from your inventory.
rest - do nothing for one turn.
go NORTH/EAST/SOUTH/WEST - attempt to move to a neighboring area to the direction specified.
examine ITEMNAME - gives the description of an item in your inventory. 
quit - quit the game.
inventory - shows the items and you are currently holding along with their values and weights.
plant - player plant the cabbage seed to obtain the cabbage after a certain amount of turns, or when they have obtained all of the other ingredients
talkto - player talk to the NPCs to obtain information
Victory is obtained when the player has all of the required ingredients at home to make the gyoza.

## Commands to execute example walkthrough:
go west
get seed
plant seed
go south
get mushrooms
go south
get onion
go east
go south
get seasonings
go north
go east
talkto butch
go west
rest
go west
go east
go east
go north
get flour
go west
go west
go north
get cabbage
go east
