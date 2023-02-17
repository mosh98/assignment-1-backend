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

public class WarriorTest {


    /**
     * Equip Weapon!
     * @result Should throw error as hero level is lower than required level of weapon
     *
     */
    @Test
    public void equipWeapon_LvlControll_shouldThrowError() throws HeroException {
        //Arrange
        Item weapon = new Weapon("Common Axe",2, Slot.WEAPON, WeaponType.AXES,2);
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon


        //Act
        Exception exception =  assertThrows(WeaponExceptions.class, () -> heroWarrior.equip(weapon));

        //Assert
        assertEquals("Hero level is lower than required level of weapon", exception.getMessage());
    }

    /**
     * Equip Armor that has a higher required level!
     * @result Should throw error as hero level is lower than required level of armor
     */
    //equipArmorLvlControll
    @Test
    public void equipHighLevelArmor_LvlControll_throwError() throws ArmorException, HeroException {
        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",10,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon

        //ACT
        Exception exception = assertThrows(ArmorException.class, () -> heroWarrior.equip(armor));

        //Assert
        assertEquals("Hero level is not enough to equip this armor", exception.getMessage());
    }

    //test for equipment of weapon & checking the equipment hashmap if it exist

    /**
     * Check Hero Name
     * @throws HeroException
     * @result Should return the name of the hero
     */
    @Test
    public void createHeroCheckName() throws HeroException {
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon
        assertEquals("Mosleh",heroWarrior.getName());
    }

    /** create Warrior with empty name,
     * @result should throw exception */

    //Create Warrior with empty name, should throw error
    @Test
    public void createHeroWithEmptyName_throwError() throws HeroException {
        //Arrange
        //& Act
        Exception exception = assertThrows(HeroException.class, () -> new Warrior(""));
        //Assert
        assertEquals("Invalid Name", exception.getMessage());
    }


    /**
     * Check Hero Level
     * @result Should return the level of the hero
     * othewise
     * @throws HeroException
     */
    @Test
    public void createHero_CheckLevel_assertEquals() throws HeroException {

        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon
        assertEquals(1,heroWarrior.getLevel());
    }

    /**
     * Check Hero Attributes
     * @throws HeroException
     */
    @Test
    public void createHero_CheckAttributeStrength_assertEquals() throws HeroException {
        //TODO: check the numbers of the hero
        Hero heroWarrior = new Warrior("Mosleh");
        assertEquals(5,heroWarrior.getHeroAttributes().getStrength());
    }


    @Test
    public void createHero_CheckAttributeDexterity_assertEquals() throws HeroException {
        //Arrange & Act
        Hero heroWarrior = new Warrior("Mosleh");

        //Assert
        assertEquals(2,heroWarrior.getHeroAttributes().getDexterity());

    }

    @Test
    public void createHero_CheckAttributeIntelligence_assertEquals() throws HeroException {
        Hero heroWarrior = new Warrior("Mosleh");
        assertEquals(1,heroWarrior.getHeroAttributes().getIntelligence());
    }

    //TODO: create Worrior and increase level, check if the attributes are increased by correct amount
    @Test
    public void increaseLevel_CheckAttributeStrength_assertEquals() throws HeroException {
        Hero heroWarrior = new Warrior("Mosleh");
        heroWarrior.increaseLevel(); // strength should increase by 3
        assertEquals(8,heroWarrior.getHeroAttributes().getStrength());
    }
    @Test
    public void increaseLevel_CheckAttributeDexterity_assertEquals() throws HeroException {
        Hero heroWarrior = new Warrior("Mosleh");
        heroWarrior.increaseLevel(); // dexterity should increase by 2
        assertEquals(4,heroWarrior.getHeroAttributes().getDexterity());
    }

    @Test
    public void increaseLevel_CheckAttributeIntelligence_assertEquals() throws HeroException {
        Hero heroWarrior = new Warrior("Mosleh");
        heroWarrior.increaseLevel(); // intelligence should increase by 1
        assertEquals(2,heroWarrior.getHeroAttributes().getIntelligence());
    }

    //test for calcDamage
    @Test
    public void calcDamage_CheckWithWeapon_assertEquals() throws HeroException {
        //Warrrior has level 1
        //Equip Axe with damage 2
        //Strength is 5

        //Arrange
        Hero heroWarrior = new Warrior("Mosleh");

        Item weapon = new Weapon("Common Axe",1, Slot.WEAPON, WeaponType.AXES,2);

        //ACT
        try {
            heroWarrior.equip(weapon);

        } catch (WeaponExceptions | ArmorException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(heroWarrior.calcDamage());
        double expectedDmg = 2*(1+(5/100));

        assertEquals(expectedDmg,heroWarrior.calcDamage(),0.0);
    }

    //create hero, check total attribute, after equipping 2 armor body and legs and increasing level, check total attribute
    @Test
    public void equipArmor_CheckTotalAttribute_assertEquals() throws HeroException, ArmorException, WeaponExceptions {
        //Arrange
        Hero heroWarrior = new Warrior("Mosleh");
        ArmorAttribute armorAttribute = new ArmorAttribute(10,10,10);
        Item armor = new Armor("Common Plate Chest",1,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Item armor2 = new Armor("Common Plate Legs",1,Slot.LEGS, ArmorTypes.PLATE,armorAttribute);

        /**
         * st: 5 + 10 + 10 + 3 = 28
         * dx: 2 + 10 + 10 + 2 = 24
         * in: 1 + 10 + 10 + 1 = 22
         */

        //ACT
        heroWarrior.equip(armor);
        heroWarrior.equip(armor2);
        heroWarrior.increaseLevel();


        HeroAttributes expectedHeroAttributes = new HeroAttributes(28,24,22);


        //Assert
        assertEquals(expectedHeroAttributes, heroWarrior.calcTotalAttributes()) ;
    }


}