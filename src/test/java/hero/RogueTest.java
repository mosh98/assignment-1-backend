package hero;

import HeroExceptions.ArmorException;
import HeroExceptions.HeroException;
import HeroExceptions.WeaponExceptions;
import Items.Armor.Armor;
import Items.Armor.ArmorAttribute;
import Items.Armor.ArmorTypes;
import Items.Item;
import Items.Slot;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RogueTest {
    /**
     * Rogues – Dagger, Sword
     */


    //check equip weapon hero lvl low
    @Test
    public void equipWeapon_HeroLvlLow_throwException() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item weapon = new Weapon("Super Dagger",2, Slot.WEAPON, WeaponType.DAGGERS, 10);
        Hero rogue = new Rogue("Rogue");

        //Act
        Exception exception = assertThrows(WeaponExceptions.class, () -> {
            rogue.equip(weapon);
        });


        //Assert
        assertEquals("Hero level is lower than required level of weapon", exception.getMessage());

    }

    //check equip Armor, hero lvl too low
    @Test
    public void equipArmor_HeroLvlLow_throwException() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armor = new Armor("Super Mail",2, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Hero rogue = new Rogue("Rogue");

        //Act
        Exception exception = assertThrows(ArmorException.class, () -> {
            rogue.equip(armor);
        });


        //Assert
        assertEquals("Hero level is lower than required level of armor", exception.getMessage());

    }
}
