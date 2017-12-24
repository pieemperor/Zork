import javax.swing.JOptionPane;

/**
 * ---------------------------------------------------------------------------
 * File name: ZorkDriver.java
 * Project name: CodeStuff
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * 							 Morgan Munsey. munseymk@goldmail.etsu.edu

 * Course:  CSCI 1260-002
 * Creation Date: May 3, 2016
 * ---------------------------------------------------------------------------
 */


/**
 * Run Zork!!!
 *
 * <hr>
 * Date created: May 3, 2016
 * <hr>
 * @author Dakota Cowell and Morgan Munsey
 */
public class ZorkDriver
{

	/**
	 * Main method interacts with the user     
	 *
	 * <hr>
	 * Date created: May 3, 2016
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		Dungeon d1 = new Dungeon();
		Game game = new Game();
		Player user = new Player();
		
		//declare and create variables
		int playGame; //whether the player wishes to play the game
		int dChoice; //indicated the direction the user chooses
		int possibleMove = 0; //if the move is possible
		boolean okay = false; //if the room is okay
		boolean monster = false; //if there is a monster in the room
		boolean weapon = false; //if there is a weapon in the room
		boolean alive = true; //if the user is alive
		
		//display game info to user
		JOptionPane.showMessageDialog(null,
			  "Welcome to the Zork Game!\n" +
			  "-----------------------------------------------------------------------------------------------------" +
			  "------------------------------------------------------------------------\n"+
			  "In this game, there is a dungeon with up to 50 cells. You will\n" +
			  "begin at the north-most cell on the western side. Your goal to win the game is to make it out\n" +
			  "of the dungeon alive. The exit is somewhere on the eastern border of the dungoen.\n" +
			  "Along the way, you may be faced with monsters that must be defeated.  If you are lucky, you\n" +
			  "may find some weapons to assist in the battles you will fight.\n" +
			  "----------------------------------------------------------------------------------" +
			  "--------------------------------------------------------------------------------------------\n" +
			  "The game will continue until the player is defeated by a monster or until the player successfully \n" +
			  "exits the dungeon.  In each cell, you will be given the choice of which direction to move one cell.\n");
		
		//give user option to continue
		playGame = JOptionPane.showConfirmDialog (null, "Do you dare to enter the dungeon?", "Are You Brave?",
			JOptionPane.YES_NO_OPTION);
		
		if (playGame == JOptionPane.NO_OPTION)
		{
			System.exit (0); //end program if the user wishes to do so
		}
		
		//provide a key to users
		JOptionPane.showMessageDialog(null,
			  "Key\n" +
			  "-----------------------------\n" +
			  "P - Player\n" +
			  "-----------Monsters----------\n" +
			  "M - King Kong\n" +
			  "F - Frankenstein\n" +
			  "C - Cyclops\n" +
			  "-----------Weapons-----------\n" +
			  "S - Stick\n" +
			  "K - Knife\n" +
			  "G - Gun\n" +
			  "L - Laser\n" +
			  "B - Bomb"
			  );

		
		
		
		
		while(d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getExit ( ) == false && alive ==true) //if player is alive and not at exit, keep playing
		{
			
			if(d1.getPlayerRow() == 0 && d1.getPlayerColumn() == 0) //ensure there are no weapons of monsters in starting cell
			{
				d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].setWeaponPresent(false); 
				d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].setMonsterPresent(false);
				
			}
			
			while(!okay && d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getExit ( ) == false && alive == true)//when the room is okay, not the exit, and the player is alive
				{
				
				if (user.getHP() <= 0) //if user dies, set alive to false
				{
					alive = false;
					System.exit (0);
				}
				//the users choice of direction
				dChoice = directionMenu(d1);//the users choice of direction
				
				//try to move the user 
				possibleMove = user.move(dChoice, d1, d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getCharacters(), user);
				okay = true;
				
				if(possibleMove == 0) //let user know they can't travel that diresction
					JOptionPane.showMessageDialog(null, "You can't go that way. \n");
					okay = false;
					
				monster = d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getMonsterPresent ( ); //sets if a monster is present
				weapon = d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getWeaponPresent(); //sets if the weapon is present
				
			
			
			//If there is a weapon present, Check to see if it benefits user.  If so, pick up
			if(weapon == true)
			{
				if(user.getParticipantDamage() < user.getParticipantDamage() + 
						d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getRoomWeapon().getWeaponDamage())
				{
					user.pickUpWeapon(d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getRoomWeapon());
					JOptionPane.showMessageDialog (null, "You found a new weapon!");
					d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].setWeaponPresent(false);
				}
			}
			
			//If there is a monster, battle it
			if(monster == true)
			{
				JOptionPane.showMessageDialog (null, "There is a monster here!!!");
				JOptionPane.showMessageDialog (null, game.battle (user, d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getCharacters().get(0)));
				d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].setMonsterPresent (false);
			}
			
			//If it is the exit, display winner message
			if(d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getExit ( ) && alive == true)
			{
				JOptionPane.showMessageDialog (null, "You have beaten the dungeon");
			}
			
			else if(d1.getDungeon()[d1.getPlayerRow()][d1.getPlayerColumn()].getExit ( ) && alive == false)
			{
				JOptionPane.showMessageDialog (null, "Game Over!");
			}
			}
			
		}

	
	}//end main
	
	/**
	 * Will display menu options and return users choice
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param d1
	 * @return
	 */
	public static int directionMenu(Dungeon d1)
	{
		//create and declare variables
		int choice; //indicated the direction the user chooses
		Object[] directions = {"Go North!", "Go South!", "Go East!", "Go West!"}; //possible directions
		
		choice = JOptionPane.showOptionDialog (null, d1 + "What would you like to do next?", 
			null, JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE, null, directions, directions[3]); //prompt user
				
		return choice; //returns the direction
	}//end directionMenu

}//end ZorkDriver
