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
        Exception exception = assertThrows(ArmorException.class, () -> {rogue.equip(armor);});


        //Assert
        assertEquals("Hero level is lower than required level of armor", exception.getMessage());

    }

    //create hero, check name
    @Test
    public void createHero_checkName_assertEquals() throws HeroException {
        //Arrange
        Hero rogue = new Rogue("Rogue");

        //Act
        String name = rogue.getName();

        //Assert
        assertEquals("Rogue", name);
    }

    //create hero, check lvl
    @Test
    public void createHero_checkLvl_assertEquals() throws HeroException {
        //Arrange
        Hero rogue = new Rogue("Rogue");

        //Act
        int lvl = rogue.getLevel();

        //Assert
        assertEquals(1, lvl);
    }

    //create hero, check strength attribute after equping 1 armor on body
    @Test
    public void createHeroEquipArmor_checkStrengthAttribute_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armor = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(armor);
        int strength = rogue.heroAttributes.getStrength();

        //Assert
        assertEquals(12, strength);
    }

    //create hero, check dexterity attribute after equping 1 armor on body
    @Test
    public void createHeroEquipArmor_checkDexterityAttribute_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armor = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(armor);
        int dexterity = rogue.heroAttributes.getDexterity();

        //Assert
        assertEquals(16, dexterity);
    }

    //create hero, check intelligence attribute after equping 1 armor on body
    @Test
    public void createHeroEquipArmor_checkIntelligenceAttribute_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armor = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(armor);
        int intelligence = rogue.heroAttributes.getIntelligence();

        //Assert
        assertEquals(11, intelligence);
    }

    //create hero, check strength attribute after equiping 2 armor on body and legs
    @Test
    public void createHeroEquip2Armor_checkStrengthAttribute_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armorBody = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Item armorLegs = new Armor("Super Mail",1, Slot.LEGS, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(armorBody);
        rogue.equip(armorLegs);

        int strength = rogue.heroAttributes.getStrength();

        //Assert
        assertEquals(22, strength);
    }

    //create hero, check dexterity attribute after equiping 2 armor on body and legs
    @Test
    public void createHeroEquip2Armor_checkDexterityAttribute_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armorBody = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Item armorLegs = new Armor("Super Mail",1, Slot.LEGS, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(armorBody);
        rogue.equip(armorLegs);
        int dexterity = rogue.heroAttributes.getDexterity();

        //Assert
        assertEquals(26, dexterity);
    }

    //create hero, check intelligence attribute after equiping 2 armor on body and legs
    @Test
    public void createHeroEquip2Armor_checkIntelligenceAttribute_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armorBody = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Item armorLegs = new Armor("Super Mail",1, Slot.LEGS, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(armorBody);
        rogue.equip(armorLegs);
        int intelligence = rogue.heroAttributes.getIntelligence();

        //Assert
        assertEquals(21, intelligence);
    }

    //create hero check intelligence attribute after replacing an armor on body
    @Test
    public void createHeroEquipArmor_checkIntelligenceAttributeAfterReplacingArmor_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armorBody = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Item armorBody2 = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(30,30,30));
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(armorBody);
        rogue.equip(armorBody2);
        int intelligence = rogue.heroAttributes.getIntelligence();

        //Assert
        assertEquals(31, intelligence);
    }

    //create hero check ArmorAttribute objects  after replacing an armor on body
    @Test
    public void createHeroEquipArmor_checkArmorAttributeAfterReplacingArmor_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item armorBody = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(10,10,10));
        Item armorBody2 = new Armor("Super Mail",1, Slot.BODY, ArmorTypes.LEATHER, new ArmorAttribute(20,30,20));
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(armorBody);
        rogue.equip(armorBody2);

        ArmorAttribute armorAttribute = ( (Armor) rogue.getEquipment().get(Slot.BODY) ).getArmorAttribute();

        //Assert
        assertEquals( ((Armor) armorBody2).getArmorAttribute() , armorAttribute);
    }

    //________________________________DAMAGE CONTROLL_____________________________________

    //create hero, check total damage with no weapon
    @Test
    public void createHeroNoWeapon_checkTotalDamage_assertEquals() throws HeroException {
        //Arrange
        Hero rogue = new Rogue("Rogue");

        //Act
        double totalDamage = rogue.calcDamage();

        System.out.println(totalDamage);

        //Assert
        assertEquals(1.0, totalDamage,0.0);
    }

    //create hero, check total damage with 1 weapon
    @Test
    public void createHeroWithWeapon_checkTotalDamage_assertEquals() throws HeroException, WeaponExceptions, ArmorException {
        //Arrange
        Item weapon = new Weapon("Super Sword",1, Slot.WEAPON, WeaponType.SWORDS, 10);
        Hero rogue = new Rogue("Rogue");

        //Act
        rogue.equip(weapon);
        double totalDamage = rogue.calcDamage();

        //Assert
        assertEquals(10.6, totalDamage,0.0);
    }





}
