package Items;

import HeroExceptions.HeroException;
import HeroExceptions.WeaponExceptions;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;
import hero.Hero;
import hero.Warrior;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class WeaponTest {

    @Test
    public void equipWeapon_tryEquping_assertEqualsWeaponObject() throws HeroException {

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

    /**
     * When created, check correct name
     */
    @Test
    public void createWeapon_checkName_assertName() throws HeroException {
        Item weapon = new Weapon("Common Axe",1, Slot.WEAPON, WeaponType.AXES,2);
        assertEquals("Common Axe", weapon.getName());
    }

    /**
     * When created, check if name is not empty
     * @throws IllegalArgumentException
     */
    @Test
    public void createWeapon_checkNameNotEmpty_assertName() throws IllegalArgumentException {

        //Arrange
        String name = "";

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Weapon(name,1, Slot.WEAPON, WeaponType.AXES,2));

        //Assert
        assertEquals("Invalid Name", exception.getMessage());

    }

    /**
     * When created, check required level
     * @throws WeaponExceptions
     */
    @Test
    public void createWeapon_checkRequiredLevel_assertRequiredLevel() throws WeaponExceptions {

        //Arrange
        int requiredLevel = 1;

        //Act
        Item weapon = new Weapon("Common Axe",requiredLevel, Slot.WEAPON, WeaponType.AXES,2);

        //Assert
        assertEquals(requiredLevel, weapon.getRequiredLevel());

    }
    /**
     * When created, check correct slot
     * @throws WeaponExceptions
     *
     */
    @Test
    public void createWeapon_checkSlot_assertSlot() {

        //Arrange
        Slot slot = Slot.WEAPON;

        //Act
        Item weapon = new Weapon("Common Axe",1, slot, WeaponType.AXES,2);

        //Assert
        assertEquals(slot, weapon.getSlot());

    }

    /**
     * When created, check correct weapon damage
     *
     */
    @Test
    public void createWeapon_checkWeaponDamage_assertWeaponDamage() throws WeaponExceptions {

        //Arrange
        int weaponDamage = 2;

        //Act
        Item weapon = new Weapon("Common Axe",1, Slot.WEAPON, WeaponType.AXES,weaponDamage);

        //Assert
        assertEquals(weaponDamage, ((Weapon) weapon).getWeaponDamage());

    }




}
