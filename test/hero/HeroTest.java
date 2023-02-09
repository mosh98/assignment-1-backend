package hero;

import HeroExceptions.ArmorException;
import HeroExceptions.WeaponExceptions;
import Items.Armor.Armor;
import Items.Armor.ArmorAttribute;
import Items.Armor.ArmorTypes;
import Items.Slot;
import Items.Item;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {


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
    public void equipWeapon(){
        Item weapon = new Weapon("Common Axe",1, Slot.WEAPON, WeaponType.AXES,2);
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon

        //heroWarrior.equip(weapon);
        try{
            heroWarrior.equip(weapon);

        }catch (Exception e){

            System.out.println(e.getMessage());

        }

        //assert of is the weapon in the equipment hashmap
        assertEquals(weapon,
                heroWarrior.getEquipment().get(Slot.WEAPON));
    }

    //test for equipment of armor  & checking the equipment hasmap if it exist
    @Test
    public void equipArmor(){
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",1,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon

        try {
            heroWarrior.equip(armor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //assert of is the armor in the equipment hashmap
        assertEquals(armor,heroWarrior.getEquipment().get(Slot.BODY));

    }
}