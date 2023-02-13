package hero;

import HeroExceptions.WeaponExceptions;
import Items.Item;
import Items.Slot;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MageTest {

    //Equip weapon, show throw error as Mage level is lower
    @Test
    public void equipWeapon_HeroLevelLow_ThrowsException(){

        //Arrange
        Item weapon = new Weapon("witch STAFF",2, Slot.WEAPON, WeaponType.STAFFS,2);

        //Act
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        Exception exception = assertThrows(WeaponExceptions.class, () -> heroMage.equip(weapon));

        String expectedMessage = "Hero level is lower than required level of weapon";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //Create Mage check name, thorws error as name is empty string
    @Test
    public void createHeroCheckNameEmpty_ThrowsException(){

        //Arrange
        Hero heroMage = new Mage("");

        //Act
        Exception exception = assertThrows(Exception.class, () -> heroMage.getName());

        String expectedMessage = "Hero name is empty";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    //Create Normal Hero check name with AssertEquals
    @Test
    public void createHero_CheckName_assertEquals(){

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        String expectedMessage = "Mosleh";

        String actualMessage = heroMage.getName();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }



}
