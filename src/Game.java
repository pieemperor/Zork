import java.util.*;

/**
 * ---------------------------------------------------------------------------
 * File name: Game.java
 * Project name: Project5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * 							 Morgan Munsey. munseymk@goldmail.etsu.edu
 * Course:  CSCI 1260-002
 * Creation Date: Apr 26, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * The battle in the game
 *
 * <hr>
 * Date created: Apr 26, 2016
 * <hr>
 * @author Dakota Cowell and Morgan Munsey
 */
public class Game
{
	public Game()
	{
		


	}//end Game
	
	public String battle(Player p1, Participant monster)
	{
		String str = "";
		Random rand = new Random();
		
		while(monster.getHP ( ) > 0 && p1.getHP ( ) > 0) //if the monster is still alive and so is the player, fight
		{
			if(rand.nextInt(100) > 10) //hit
			{
				p1.attackMonster (monster);
				str += "You hit the monster!  " +
					   "Monster health: "+ monster.getHP()  +"\n";
								
			}
			else //miss
			{
				str+= "You missed the monster. \n";
			}
			
			
			if(rand.nextInt(100) > 20 && monster.getHP ( ) > 0) //if monster is still alive, it attacks
			{
				monster.attackPlayer (p1);
				str += "You've been hit. " +
				"Your health: " + p1.getHP() +"\n";
			}
			else if (monster.getHP() <= 0) //if monster is dead, nothing
			{
				str+= "";
			}
			else //monster misses
			{
				str+= "The monster missed you. \n";
			}
		}
		
		if(p1.getHP() <= 0) //player died
		{
			str += "You died...Game Over!";
		}
		else //monster died
		{
			str += "The monster died.  You may continue";
		}
		
		return str;
	}
}
