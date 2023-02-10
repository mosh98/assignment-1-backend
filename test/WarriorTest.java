import HeroExceptions.ArmorException;
import HeroExceptions.WeaponExceptions;
import Items.Armor.Armor;
import Items.Armor.ArmorAttribute;
import Items.Armor.ArmorTypes;
import Items.Slot;
import Items.Item;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;

import hero.Hero;
import hero.Warrior;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void equipArmorLvlControll(){
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



}