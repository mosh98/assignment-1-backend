package Items;

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

        try{
            heroWarrior.equip(weapon);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //assert of is the weapon in the equipment hashmap
        assertEquals(weapon,
                heroWarrior.getEquipment().get(Slot.WEAPON));
    }

}
