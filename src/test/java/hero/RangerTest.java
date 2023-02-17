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

public class RangerTest {

    //Create hero with empty name, should throw error
    @Test
    public void createHero_WithEmptyName_throwError() throws HeroException {
        //Arrange
        //& Act
        Exception exception = assertThrows(HeroException.class, () -> new Ranger(""));
        //Assert
        assertEquals("Invalid Name", exception.getMessage());
    }

    //create hero, equip weapon with high required level, should throw error
    @Test
    public void createHero_WithWeaponWithHighRequiredLevel_throwError() throws HeroException {
        //Arrange
        Item weapon = new Weapon("DAGGER",2, Slot.WEAPON, WeaponType.DAGGERS,10);
        Hero heroRanger = new Ranger("Mosleh");

        Exception exception = assertThrows(WeaponExceptions.class, () ->heroRanger.equip(weapon) );
        //Assert
        assertEquals("Hero level is lower than required level of weapon", exception.getMessage());
    }

    //create hero, equip armor with high required level, should throw error
    @Test
    public void createHero_WithArmorWithHighRequiredLevel_throwError() throws HeroException, ArmorException {
        //Arrange
        Item armor = new Armor("Common Plate Chest",10,Slot.BODY, ArmorTypes.PLATE,new ArmorAttribute(10,10,10));
        Hero heroRanger = new Ranger("Mosleh");

        Exception exception = assertThrows(ArmorException.class, () ->heroRanger.equip(armor) );

        //Assert
        assertEquals("Hero level is not enough to equip this armor", exception.getMessage());
    }

    //create hero, check name
    @Test
    public void createHero_CheckName() throws HeroException {
        //Arrange
        Hero heroRanger = new Ranger("Mosleh");
        //Act
        String name = heroRanger.getName();
        //Assert
        assertEquals("Mosleh", name);
    }


    //create hero check level
    @Test
    public void createHero_CheckLevel() throws HeroException {
        //Arrange
        Hero heroRanger = new Ranger("Mosleh");
        //Act
        int level = heroRanger.getLevel();
        //Assert
        assertEquals(1, level);
    }

    //create hero check attributes
    @Test
    public void createHero_CheckAttributes() throws HeroException {
        //Arrange
        Hero heroRanger = new Ranger("Mosleh");
        //Act
        HeroAttributes rangerAttr = new HeroAttributes(1,7,1);

        //Assert
        assertEquals(rangerAttr, heroRanger.calcTotalAttributes());
    }

    //create hero, equip weapon of wrong type, should throw error
    @Test
    public void createHero_EquipWeaponOfWrongType_throwError() throws HeroException {
        //Arrange
        Item weapon = new Weapon("DAGGER",1, Slot.WEAPON, WeaponType.DAGGERS,10);
        Hero heroRanger = new Ranger("Mosleh");

        Exception exception = assertThrows(WeaponExceptions.class, () ->heroRanger.equip(weapon) );
        //Assert
        assertEquals("Weapon TYPE Exception", exception.getMessage());
    }

    @Test
    public void createHero_EquipArmorOfWrongType_throwError() throws HeroException, ArmorException {
        //Arrange
        Item armor = new Armor("Common Plate Chest",1,Slot.BODY, ArmorTypes.PLATE,new ArmorAttribute(10,10,10));
        Hero heroRanger = new Ranger("Mosleh");

        Exception exception = assertThrows(ArmorException.class, () ->heroRanger.equip(armor) );

        //Assert
        assertEquals("Armor type is not compatible with hero class", exception.getMessage());
    }

    //create hero, equip weapon of right type, check damage

    @Test
    public void createHero_EquipWeaponOfRightType_checkDamage() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item weapon = new Weapon("DAGGER",1, Slot.WEAPON, WeaponType.BOWS,10);
        Hero heroRanger = new Ranger("Mosleh");
        //Act
        heroRanger.equip(weapon);
        //Assert
        assertEquals(10.0, heroRanger.calcDamage(),0.0);
    }

    //create hero, check total damage with no weapon
    @Test
    public void createHero_CheckTotalDamageWithNoWeapon() throws HeroException {
        //Arrange
        Hero heroRanger = new Ranger("Mosleh");
        //Act
        double damage = heroRanger.calcDamage();
        //Assert
        assertEquals(1.0, damage,0.0);
    }

    //create hero, replace weapon and check damage
    @Test
    public void createHero_ReplaceWeapon_checkDamage() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item weapon = new Weapon("DAGGER",1, Slot.WEAPON, WeaponType.BOWS,10);
        Item weapon2 = new Weapon("DAGGER",1, Slot.WEAPON, WeaponType.BOWS,20);
        Hero heroRanger = new Ranger("Mosleh");
        //Act
        heroRanger.equip(weapon);
        heroRanger.equip(weapon2);
        //Assert
        assertEquals(20.0, heroRanger.calcDamage(),0.0);
    }

    //create hero, equip weapon and armor and check damage
    @Test
    public void createHero_EquipWeaponAndArmor_checkDamage() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item weapon = new Weapon("DAGGER",1, Slot.WEAPON, WeaponType.BOWS,10);
        Item armor = new Armor("Common Plate Chest",1,Slot.BODY, ArmorTypes.LEATHER,new ArmorAttribute(10,10,10));
        Hero heroRanger = new Ranger("Mosleh");
        //Act
        heroRanger.equip(weapon);
        heroRanger.equip(armor);
        //Assert
        assertEquals(10.0, heroRanger.calcDamage(),0.0);
    }

    //create hero, check display
    @Test
    public void createHero_CheckDisplay() throws HeroException {

        //Arrange
        Hero heroRanger = new Ranger("Mosleh");

        //Act
        StringBuilder display = heroRanger.displayHero();

        //System.out.println(display.toString());
        String expected = "Name: Mosleh\n" +
                "Class: Ranger\n" +
                "Level: 1\n" +
                "Total Strength: 1\n" +
                "Total Dexterity: 7\n" +
                "Total Intelligence: 1\n" +
                "Total Attributes: 9\n" ;

        //Assert
        assertEquals(expected, display.toString());
    }










}
