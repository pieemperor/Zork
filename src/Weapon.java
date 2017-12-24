/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Project5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * 							 Morgan Munsey. munseymk@goldmail.etsu.edu

 * Course:  CSCI 1260-002
 * Creation Date: Apr 26, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * Create a weapon
 *
 * <hr>
 * Date created: Apr 26, 2016
 * <hr>
 * @author Dakota Cowell and Morgan Munsey
 */
public abstract class Weapon
{
	private int weaponDamage;
	private String weaponSymbol;

	
	/**
	 *set the weapon damage       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param inputDamage
	 */
	public void  setWeaponDamage(int inputDamage)
	{
		weaponDamage = inputDamage;
	}

	/**
	 * return the weapon damage       
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getWeaponDamage()
	{
		return weaponDamage;
	}

	/**
	 * set the weapon symbol    
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @param symbol
	 */
	public void setWeaponSymbol(String symbol)
	{
		weaponSymbol = symbol;
	}
	
	/**
	 * return the weapon symbol      
	 *
	 * <hr>
	 * Date created: May 4, 2016
	 *
	 * <hr>
	 * @return
	 */
	public String getWeaponSymbol()
	{
		return weaponSymbol;
	}
	
	
}
