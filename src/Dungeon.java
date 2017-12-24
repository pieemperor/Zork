import java.util.Random;

/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java
 * Project name: Project5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * 							 Morgan Munsey. munseymk@goldmail.etsu.edu

 * Course:  CSCI 1260-002
 * Creation Date: Apr 30, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Apr 30, 2016
 * <hr>
 * @author Dakota Cowell  and Morgan Munsey
 */
public class Dungeon
{
	Random rand = new Random();
	int dungeonWidth = 0;
	int dungeonHeight = 0;
	int exitPosition;
	int partySize;
	private boolean exitCreated = false;
	private Room[][] dungeon;
	private int playerRow = 0; //keeps track of which row the player is in
	private int playerColumn = 0; //keeps track of which column the player is in
	

	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: May 4, 2016 
	 *
	 * 
	 */
	public Dungeon()
	{
		setDungeonWidth(rand.nextInt(6) +5);
		setDungeonHeight(rand.nextInt(5) + 1);
		dungeon = new Room[dungeonHeight][dungeonWidth];
		
		exitPosition = createExit();
		for(int row = 0; row < dungeonHeight; row++)
		{
			for(int col = 0; col < dungeonWidth; col++)
			{
				dungeon[row][col] = new Room();
				
				if(col == dungeonWidth -1 && row == exitPosition && !exitCreated)
				{
					dungeon[row][col].setExit (true);
					exitCreated = true;
				}
			}
		}
		
		dungeon[0][0].addParticipant(new Player());
		dungeon[0][0].setPlayerPresent(true);
		

	}




	/**
	 * set dungeon       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param dungeon
	 */
	public void setDungeon(Room[][] dungeon)
	{
		this.dungeon = dungeon;
	}
	
	/**
	 * return dungeon         
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public Room[][] getDungeon()
	{
		return dungeon;
	}
	
	/**
	 * set player column location   
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param column
	 */
	public void setPlayerColumn(int column)
	{
		playerColumn = column;
	}

	/**
	 * return player column location    
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getPlayerColumn( )
	{
		return playerColumn;
	}
	
	/**
	 * set player row location      
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param row
	 */
	public void setPlayerRow(int row)
	{
		playerRow = row;
	}
	
	/**
	 * return player row location         
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getPlayerRow()
	{
		return playerRow;
	}
	
	/**
	 * set dungeon width  
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param width
	 */
	public void setDungeonWidth(int width)
	{
		dungeonWidth = width;
	}
	
	/**
	 * return dungeon width       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getDungeonWidth()
	{
		return dungeonWidth;
	}
	
	/**
	 * set dungeon height     
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param height
	 */
	public void setDungeonHeight(int height)
	{
		dungeonHeight = height;
	}
	
	/**
	 * return dungeon height        
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getDungeonHeight()
	{
		return dungeonHeight;
	}
	
	/**
	 * create the exit    
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int createExit()
	{
		Random rand = new Random();
		int temp;
		
		temp = rand.nextInt(dungeonHeight);
		
		return temp;
	}
	
	
	
	
	/**
	 * Display the dungeon    
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
		String str ="";
		
		for(int row = 0; row < getDungeonHeight(); row++)
		{
			for(int col = 0; col < getDungeonWidth(); col++)
			{
				str += getDungeon()[row][col];
			}
			str += "\n";
		}
		
		return str;
	}
	
}
