package hero;

import HeroAttributes.HeroAttributes;
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

public class MageTest {

    //Equip weapon, show throw error as Mage level is lower
    @Test
    public void equipWeapon_HeroLevelLow_ThrowsException() throws HeroException {

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
    public void createHero_CheckNameEmpty_ThrowsException() throws HeroException {

        //Arrange & Act
        Exception exception = assertThrows(HeroException.class, () -> new Mage(""));

        String expectedMessage = "Invalid Name";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals( expectedMessage, actualMessage );
    }

    //Create Normal Hero check name with AssertEquals
    @Test
    public void createHero_CheckName_assertEquals() throws HeroException {

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        String expectedMessage = "Mosleh";

        String actualMessage = heroMage.getName();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //Equip Armor check if hero level is lower than required level of armor
    @Test
    public void equipArmor_HeroLevelLow_ThrowsException() throws ArmorException, HeroException {

        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",10,Slot.BODY, ArmorTypes.PLATE,armorAttribute);

        //Act
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        Exception exception = assertThrows(ArmorException.class, () -> heroMage.equip(armor));

        String expectedMessage = "Hero level is not enough to equip this armor";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //Equip Armor check if hero level is higher than required level of armor
    @Test
    public void equipArmor_HeroLevelHigh_ThrowsException() throws ArmorException, HeroException {

        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",3,Slot.BODY, ArmorTypes.CLOTH,armorAttribute);

        //Act
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        Exception exception = assertThrows(ArmorException.class, () -> heroMage.equip(armor));

        String expectedMessage = "Hero level is not enough to equip this armor";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //Equip Armor check if hero level is equal to required level of armor
    @Test
    public void equipArmor_HeroLevelEqual_ThrowsException() throws ArmorException, HeroException {

        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",3,Slot.BODY, ArmorTypes.PLATE,armorAttribute);

        //Act
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        Exception exception = assertThrows(ArmorException.class, () -> heroMage.equip(armor));

        String expectedMessage = "Hero level is not enough to equip this armor";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //Create Hero, increase level and check if level is increased
    @Test
    public void createHero_IncreaseLevel_assertEquals() throws HeroException {

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        heroMage.increaseLevel();

        String expectedMessage = "2";

        String actualMessage = Integer.toString(heroMage.getLevel());

        //Assert
        assertEquals(expectedMessage, actualMessage);


    }

    //_____________________________ATTRIBUTE TEST_____________________________

    /**
     * A Mage begins at level 1 with:
     * Strength : 1
     * Dexterity: 1
     * Intelligence: 8
     * _____________________________
     * Every time a Mage levels up, they gain:
     * Strength : +1
     * Dexterity: +1
     * Intelligence: +5
     */
    //Create Hero and check attribute strength
    @Test
    public void createHero_CheckAttributeStrength_assertEquals() throws HeroException {

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        String expectedMessage = "1";

        String actualMessage = Integer.toString(heroMage.getHeroAttributes().getStrength());

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //Create Hero and check attribute dexterity
    @Test
    public void createHero_CheckAttributeDexterity_assertEquals() throws HeroException {

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        String expectedMessage = "1";

        String actualMessage = Integer.toString(heroMage.getHeroAttributes().getDexterity());

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //create hero and check attribute intelligence
    @Test
    public void createHero_CheckAttributeIntelligence_assertEquals() throws HeroException {

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        String expectedMessage = "8";

        String actualMessage = Integer.toString(heroMage.getHeroAttributes().getIntelligence());

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //Increase level and check attribute strength
    @Test
    public void increaseLevel_CheckAttributeStrength_assertEquals() throws HeroException {

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        heroMage.increaseLevel();

        String expectedMessage = "2";

        String actualMessage = Integer.toString(heroMage.getHeroAttributes().getStrength());

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //Increase level and check attribute dexterity
    @Test
    public void increaseLevel_CheckAttributeDexterity_assertEquals() throws HeroException {

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        heroMage.increaseLevel();

        String expectedMessage = "2";

        String actualMessage = Integer.toString(heroMage.getHeroAttributes().getDexterity());

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void increaseLevel_CheckAttributeIntelligence_assertEquals() throws HeroException {

        //Arrange
        Hero heroMage = new Mage("Mosleh"); //Mage has to have a weapon

        //Act
        heroMage.increaseLevel();

        String expectedMessage = "13";

        String actualMessage = Integer.toString(heroMage.getHeroAttributes().getIntelligence());

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //______________________________________CHECK HERO DAMAGE NUMBERS  ____________________________________
    //check if Mage Hero calculate dmg after eqipping weapon
    //@Mage
    @Test
    public void mageEquipWeapon_CalculateDmg_ShouldReturnDmg() throws WeaponExceptions, ArmorException, HeroException {

        //Arrange
        Item weapon = new Weapon("Common STAFF",0,Slot.WEAPON, WeaponType.STAFFS,5);
        Hero heroMage = new Mage("Mage"); //Mage has to have a weapon

        //Act
        heroMage.equip(weapon);

        //Assert
        assertEquals(5.0,heroMage.calcDamage(),0.0);

    }

    //check if mage hero calculate dmg after equipping armor and weapon
    @Test
    public void mageEquipArmorAndWeapon_CalculateDmg_ShouldReturnDmg() throws WeaponExceptions, ArmorException, HeroException {

        //Arrange
        Item weapon = new Weapon("Common STAFF",0,Slot.WEAPON, WeaponType.STAFFS,5);

        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,2);
        Item armor = new Armor("Common Plate Chest",1,Slot.BODY, ArmorTypes.CLOTH,armorAttribute);
        Hero heroMage = new Mage("Mage"); //Mage has to have a weapon


        //Act
        heroMage.equip(weapon);
        heroMage.equip(armor);

        //Assert
        assertEquals(5.0,heroMage.calcDamage(),0.0);

    }

    //check if mage hero calculate dmg after equipping armor and weapon and increase level


    //check display for mage hero
    @Test
    public void mageEquipArmorAndWeaponAndIncreaseLevel_CalculateDmg_ShouldReturnDmg() throws WeaponExceptions, ArmorException, HeroException {

        //Arrange
        Item weapon = new Weapon("Common STAFF", 0, Slot.WEAPON, WeaponType.STAFFS, 5);

        ArmorAttribute armorAttribute = new ArmorAttribute(1, 0, 5);
        Item armor = new Armor("Common Plate Chest", 1, Slot.BODY, ArmorTypes.CLOTH, armorAttribute);
        Hero heroMage = new Mage("Mosh Mage"); //Mage has to have a weapon

        //Act

        heroMage.equip(weapon);

        heroMage.equip(armor);

        heroMage.increaseLevel();

        //Assert
        //assertEquals(18, heroMage.displayHero());
        assertEquals(5.0,heroMage.calcDamage(),0.0);




    }
    //create hero, check total attribute after equipping 2 armor and increasing level
    @Test
    public void createHeroEquip2Armor_checkTotalAttributeAfterLevelUp_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armorBody = new Armor("Super Leather",1, Slot.BODY, ArmorTypes.CLOTH, new ArmorAttribute(10,10,10));
        Item armorLegs = new Armor("Super leather",1, Slot.LEGS, ArmorTypes.CLOTH, new ArmorAttribute(10,10,10));
        Hero mage = new Mage("Mage");

        // st: 1+10+10+1 = 22
        // dt: 1+10+10+1 = 22
        // SI: 8+10+10+5 = 33

        //Act
        mage.equip(armorBody);
        mage.equip(armorLegs);

        mage.increaseLevel();

        HeroAttributes expectedHeroAttributes = new HeroAttributes(22,22,33);


        //Assert
        assertEquals(expectedHeroAttributes, mage.calcTotalAttributes());
    }


}
