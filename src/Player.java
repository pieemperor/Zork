import java.util.ArrayList;

/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * 							 Morgan Munsey. munseymk@goldmail.etsu.edu

 * Course:  CSCI 1260-002
 * Creation Date: Apr 26, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Apr 26, 2016
 * <hr>
 * @author Dakota Cowell and Morgan Munsey
 */
public class Player extends Participant
{
	Weapon myWeapon;
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: May 4, 2016 
	 *
	 * 
	 */
	public Player()
	{
		setHP(100); //players health
		setParticipantDamage(5); //amount of damage player can cause
	}
	
	
	/**
	 * attack the monster     
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param m1
	 */
	public void attackMonster(Participant m1)
	{
		m1.setHP(m1.getHP( ) - getParticipantDamage()); //players damage on monster
	}
	
	/**
	 * pick up the weapon       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param w
	 */
	public void pickUpWeapon(Weapon w)
	{
		setParticipantDamage(getParticipantDamage() + w.getWeaponDamage()); //players damage with weapon
	}
	
	
	//return 0 if they can't go that way - return 1 if cell is the exit
	/**
	 * Move the player      
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param direction
	 * @param dun
	 * @param part
	 * @param p1
	 * @return
	 */
	public int  move(int direction, Dungeon dun, ArrayList <Participant> part, Player p1) 
	{
		int possible = 0; //indicates if user can't move in that direction to a different cell
		
		dun.getDungeon()[dun.getPlayerRow()][dun.getPlayerColumn()].removeParticipant(
			dun.getDungeon()[dun.getPlayerRow()][dun.getPlayerColumn()].getCharacters ( ).size() - 1); //removes participant from current cell to place in new cell
		dun.getDungeon()[dun.getPlayerRow()][dun.getPlayerColumn()].setPlayerPresent(false);

		//North
		if(direction == 0 && dun.getPlayerRow() > 0) 
		{
			dun.setPlayerRow (dun.getPlayerRow() - 1);
			possible = -1;
		}
		//South
		else if(direction == 1 && dun.getPlayerRow() < dun.getDungeonHeight() - 1)
		{
			dun.setPlayerRow(dun.getPlayerRow() + 1);
			possible = -1;
		}
		//East
		else if(direction == 2 && dun.getPlayerColumn() < dun.getDungeonWidth() - 1)
		{
			dun.setPlayerColumn(dun.getPlayerColumn() + 1);
			possible = -1;
		}
		//West
		else if(direction == 3 && dun.getPlayerColumn() > 0)
		{
			dun.setPlayerColumn(dun.getPlayerColumn() - 1);
			possible = -1;
		}
		

			dun.getDungeon()[dun.getPlayerRow()][dun.getPlayerColumn()].addParticipant(p1);
			dun.getDungeon()[dun.getPlayerRow()][dun.getPlayerColumn()].setPlayerPresent(true);
		
		return possible;
	}
}
