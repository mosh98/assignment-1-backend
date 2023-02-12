package hero;

import HeroAttributes.HeroAttributes;
import HeroExceptions.ArmorException;
import HeroExceptions.WeaponExceptions;
import Items.Armor.Armor;
import Items.Armor.ArmorTypes;
import Items.Item;
import Items.Slot;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;

import java.util.HashMap;

public abstract class Hero {

    //fields GENREAL:
    //Name
    private String name;
    //Level
    private int level;

    //TODO: LevelAttributes

    //Equipment

    //ValidWeaponTypes
    private WeaponType[] validWeaponTypes; //TODO: FIX THIS

    //ValidArmorTypes
    private ArmorTypes[] validArmorTypes; //TODO: FIX THIS


    //
    public HeroAttributes heroAttributes;

    public HashMap<Slot, Item> equipment = new HashMap<Slot,Item>();

    //_________________________________________________________
    //constructor – each hero is created by passing just a name

    public Hero(String name, int level, WeaponType[] validWeaponTypes, ArmorTypes[] validArmorTypes) {
        this.name = name;
        this.level = level;
        this.validWeaponTypes = validWeaponTypes;
        this.validArmorTypes = validArmorTypes;
        this.heroAttributes = new HeroAttributes();

        //
        equipment.put(Slot.WEAPON,null);
        equipment.put(Slot.HEAD,null);
        equipment.put(Slot.LEGS,null);
        equipment.put(Slot.BODY,null);
    }

    public HashMap<Slot, Item> getEquipment() {
        return equipment;
    }

    public int getLevel() {
        return level;
    }

    public abstract void increaseLevel();

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }


    public void equip(Item weaponOrArmor) throws ArmorException, WeaponExceptions {

        /**
         * @param weaponOrArmor
         * @throws ArmorException
         * @throws WeaponException
         * 1. Check if the item is a weapon or armor
         * 2. Check if the item(either armor or weapon) is valid for the hero
         * 3. if not throw approriate error
         * 4. otherwise, Equip the item and put it in the equipment HashMap
         */

        if(weaponOrArmor instanceof Weapon){

            //controll if the weapon is valid
            if(weaponOrArmor.getRequiredLevel() <= this.level) {
                //controll if the weapon is valid
                for (WeaponType validWeaponType : validWeaponTypes) {
                    //this if statement check if slot is weapon and if the weapon type is valid for the hero
                    if (validWeaponType == ((Weapon) weaponOrArmor).getWeaponType()) {
                        if(weaponOrArmor.getSlot() == Slot.WEAPON) {
                            equipment.put(Slot.WEAPON, weaponOrArmor);
                        }
                        break;
                    }else {
                        //throw
                        throw new WeaponExceptions("Weapon TYPE Exception");
                    }
                }
            }else {
                throw new WeaponExceptions("Weapon Required Level Exception");
            }
        }

        //the exact same exception format but for armour
            if(weaponOrArmor instanceof Armor){

            //controll if the armor is valid
            if(weaponOrArmor.getRequiredLevel() <= this.level) { //check level requirement

                for (int i = 0; i < validArmorTypes.length; i++) {

                    ArmorTypes validArmorType = validArmorTypes[i];
                    if (validArmorType == ((Armor) weaponOrArmor).getArmorTypes()) {

                        if(weaponOrArmor.getSlot() == Slot.HEAD) {
                            equipment.put(Slot.HEAD, weaponOrArmor);
                            break;
                        }else if(weaponOrArmor.getSlot() == Slot.BODY) {
                            equipment.put(Slot.BODY, weaponOrArmor);
                            break;
                        }else if(weaponOrArmor.getSlot() == Slot.LEGS) {
                            equipment.put(Slot.LEGS,  weaponOrArmor);
                            break;
                        }

                    }
                    if(i == validArmorTypes.length ) {
                        throw new ArmorException("Armor TYPE Exception");
                    }
                }
            }else {
                //throw armour exception
                throw new ArmorException("Armor Required Level Exception");
            }
        }

    }
    public HeroAttributes getHeroAttributes() {
        return heroAttributes;
    }

    public int calcTotalAttributes(){
        int sumOfCurrentHeroAttributes = this.getHeroAttributes().getStrength()+this.getHeroAttributes().getDexterity()+this.getHeroAttributes().getIntelligence();
        int sumOfCurrentAromorAttributes = 0;
        //iterate through the equipment hashmap
        for (Item item : equipment.values()) {
            if(item != null && item.getSlot() != Slot.WEAPON) { //re-configure the if statement
                sumOfCurrentAromorAttributes += ((Armor) item).getArmorAttribute().getStrength() + ((Armor) item).getArmorAttribute().getDexterity() + ((Armor) item).getArmorAttribute().getIntelligence();
            }
        }

        return sumOfCurrentHeroAttributes + sumOfCurrentAromorAttributes;
    }

    public abstract int calcDamage();


    //TODO: Show HERO desplay. Make it abstract class.


    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
