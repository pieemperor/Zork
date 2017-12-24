/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
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
public abstract class Participant
{
	 private int HP;
	 private int participantDamage;
	 private String symbol;
 
	 
	 /**
	 * set the health   
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param health
	 */
	public void setHP(int health)
	 {
		 HP = health;
	 }
	 
	 /**
	 * return the health       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getHP()
	 {
		 return HP;
	 }
	 
	 /**
	 * set the damage     
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param dmg
	 */
	public void setParticipantDamage(int dmg)
	 {
		 participantDamage = dmg;
	 }
	 
	 /**
	 * return the damage     
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getParticipantDamage()
	 {
		 return participantDamage;
	 }
 
	/**
	 * set the symbol    
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param symbol
	 */
	public void setMonsterSymbol(String symbol)
	{
		this.symbol = symbol;
	}
		
	/**
	 * return the symbol      
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public String getMonsterSymbol()
	{
		return symbol;
	}
	
	/**
	 * Create basic monster 
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param p1
	 */
	public void attackPlayer(Player p1)
	{
		p1.setHP(p1.getHP() - participantDamage); //occurs when monster attacks user
	}
 
}
