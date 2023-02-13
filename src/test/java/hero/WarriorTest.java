package hero;

import HeroExceptions.ArmorException;
import HeroExceptions.WeaponExceptions;
import Items.Armor.Armor;
import Items.Armor.ArmorAttribute;
import Items.Armor.ArmorTypes;
import Items.Item;
import Items.Slot;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;
import hero.Hero;
import hero.Warrior;
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
    public void equipWeaponLvlControll(){
        //ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        //Item armor = new Armor("Common Plate Chest",0,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Item weapon = new Weapon("Common Axe",2, Slot.WEAPON, WeaponType.AXES,2);
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon


        //assert of weapon thorws error
        assertThrows(WeaponExceptions.class, () -> heroWarrior.equip(weapon));

    }

    /**
     * Equip Armor!
     * @result Should throw error as hero level is lower than required level of armor
     */
    //equipArmorLvlControll
    @Test
    public void equipArmorLvlControll() throws ArmorException {
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",10,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon

        //assert of armor thorws error
        assertThrows(ArmorException.class, () -> heroWarrior.equip(armor));

    }

    //test for equipment of weapon & checking the equipment hasmap if it exist


    @Test
    public void createHeroCheckName(){
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon
        assertEquals("Mosleh",heroWarrior.getName());
    }

    //TODO: create Warrior with empty name, should throw exception
  /*  @Test
    public void createHeroCheckNameEmpty(){
        Hero heroWarrior = new Warrior("");
        assertThrows(Exception.class, () -> heroWarrior.getName());
    }*/

    @Test
    public void createHeroCheckLevel(){

        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon
        assertEquals(1,heroWarrior.getLevel());
    }

    @Test
    public void createHeroCheckAttributeStrength(){
        //TODO: check the numbers of the hero
        Hero heroWarrior = new Warrior("Mosleh");
        assertEquals(5,heroWarrior.getHeroAttributes().getStrength());

    }

    @Test
    public void createHeroCheckAttributeDexterity(){
        //TODO: check the numbers of the hero
        Hero heroWarrior = new Warrior("Mosleh");
        assertEquals(2,heroWarrior.getHeroAttributes().getDexterity());

    }

    @Test
    public void createHeroCheckAttributeIntelligence(){
        Hero heroWarrior = new Warrior("Mosleh");
        assertEquals(1,heroWarrior.getHeroAttributes().getIntelligence());
    }

    //TODO: create Worrior and increase level, check if the attributes are increased by correct amount
    @Test
    public void increaseLevelCheckAttributeStrength(){
        Hero heroWarrior = new Warrior("Mosleh");
        heroWarrior.increaseLevel(); // strength should increase by 3
        assertEquals(8,heroWarrior.getHeroAttributes().getStrength());
    }
    @Test
    public void increaseLevelCheckAttributeDexterity(){
        Hero heroWarrior = new Warrior("Mosleh");
        heroWarrior.increaseLevel(); // dexterity should increase by 2
        assertEquals(4,heroWarrior.getHeroAttributes().getDexterity());
    }

    @Test
    public void increaseLevelCheckAttributeIntelligence(){
        Hero heroWarrior = new Warrior("Mosleh");
        heroWarrior.increaseLevel(); // intelligence should increase by 1
        assertEquals(2,heroWarrior.getHeroAttributes().getIntelligence());
    }

    //test for calcDamage
    @Test
    public void calcDamageCheckWithWeapon(){
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
        int expectedDmg = 2*(1+(5/100));

        assertEquals(expectedDmg,heroWarrior.calcDamage());
    }






}