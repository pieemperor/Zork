import java.util.*;

/**
 * ---------------------------------------------------------------------------
 * File name: Room.java
 * Project name: Project5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * 							 Morgan Munsey. munseymk@goldmail.etsu.edu

 * Course:  CSCI 1260-002
 * Creation Date: Apr 27, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * Create a room
 *
 * <hr>
 * Date created: Apr 27, 2016
 * <hr>
 * @author Dakota Cowell and Morgan Munsey
 */
public class Room
{
	private ArrayList <Participant> characters = new ArrayList<Participant>();
	private Weapon roomWeapon;
	private boolean monsterPresent;
	private boolean weaponPresent;
	private boolean playerPresent;
	private boolean exit;
	Random rand = new Random();

	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: May 4, 2016 
	 *
	 * 
	 */
	public Room()
	{
		//Create Monster
		if(rand.nextInt(10000) < 5000)
		{
			setMonsterPresent(true);
			int temp;
			temp = rand.nextInt(3);
			if(temp == 0)
			{
				addParticipant(new KingKong());
			}
			else if(temp == 1)
			{
				addParticipant(new Frankenstein());
			}
			else
			{
				addParticipant(new Cyclops());
			}
		}
		
		
		//Create weapon
		if(rand.nextInt(100) < 10)
		{
			setWeaponPresent(true);
			int temp2;
			temp2 = rand.nextInt(5);
			
			if(temp2 == 0)
			{
				setRoomWeapon(new Stick());
			}
			else if(temp2 == 1)
			{
				setRoomWeapon(new Knife());
			}
			else if(temp2 == 2)
			{
				setRoomWeapon(new Gun());
			}			
			else if(temp2 == 3)
			{
				setRoomWeapon(new Laser());
			}
			else if(temp2 == 4)
			{
				setRoomWeapon(new Bomb());
			}
		}
		
		//Set exit to false
		setExit(false);
		
		

	}
	
	/**
	 * set the exit location    
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param b
	 */
	public void setExit (boolean b)
	{
		exit = b;
	}
	
	/**
	 * return the exit location     
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public boolean getExit()
	{
		return exit;
	}

	/**
	 * set the characters to position in array list    
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param position
	 * @param character
	 */
	public void setCharacters(int position, Participant character)
	{
		characters.set(position, character);
	}
	
	/**
	 * add participant to array list     
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param character
	 */
	public void addParticipant(Participant character)
	{
		characters.add (character);
	}
	
	/**
	 * remove participant from array list     
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param pToRemove
	 */
	public void  removeParticipant(int pToRemove)
	{

			characters.remove (pToRemove);
	}
	
	public int getSize()
	{
		return characters.size();
	}
	
	/**
	 * return the arraylist       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public ArrayList <Participant> getCharacters()
	{
		return characters;
	}
	
	/**
	 * set the weapon in the room        
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param w
	 */
	public void setRoomWeapon(Weapon w)
	{
		roomWeapon = w;
	}
	
	/**
	 * return which weapon is in the room       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public Weapon getRoomWeapon()
	{
		return roomWeapon;
	}

	
	/**
	 * @return monsterPresent
	 */
	public boolean getMonsterPresent ( )
	{
		return monsterPresent;
	}

	
	/**
	 * @param monsterPresent the monsterPresent to set
	 */
	public void setMonsterPresent (boolean monsterPresent)
	{
		this.monsterPresent = monsterPresent;
	}


	/**
	 * @return weaponPresent
	 */
	public boolean getWeaponPresent ( )
	{
		return weaponPresent;
	}

	
	/**
	 * @param weaponPresent the weaponPresent to set
	 */
	public void setWeaponPresent (boolean weaponPresent)
	{
		this.weaponPresent = weaponPresent;
	}
	
	/**
	 * set if player is present in the room       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param playerPresent
	 */
	public void setPlayerPresent(boolean playerPresent)
	{
		this.playerPresent = playerPresent;
	}
	
	/**
	 * return if player is present       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public boolean getPlayerPresent()
	{
		return playerPresent;
	}
	
	/**
	 * Display the room     
	 *
	 * <hr>
	 * Date created: May 4, 2016 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String str = "|";
	
		
		if(playerPresent)
		{
			str += "P";
		}
		
		else
		{
			str += "_";
		}
		
		if(monsterPresent)
		{
			str += characters.get(0).getMonsterSymbol();
		}
		else
		{
			str += "_";
		}
		
		if(weaponPresent)
		{
			str += roomWeapon.getWeaponSymbol();
		}
		else
		{
			str += "_";
		}
		
		if(exit)
		{
			str += "E";
		}
		else
		{
			str += "_";
		}
		
		str += "|";
		
		return str;
	}

}
