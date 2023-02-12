package Items;

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

public class WeaponTest {
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
