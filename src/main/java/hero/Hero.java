package hero;

import HeroAttributes.HeroAttributes;
import HeroExceptions.ArmorException;
import HeroExceptions.HeroException;
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


    //Equipment

    //ValidWeaponTypes
    private WeaponType[] validWeaponTypes;

    //ValidArmorTypes
    private ArmorTypes[] validArmorTypes;


    //
    public HeroAttributes heroAttributes;

    public HashMap<Slot, Item> equipment = new HashMap<Slot,Item>();

    //constructor – each hero is created by passing just a name
    public Hero(String name, int level, WeaponType[] validWeaponTypes, ArmorTypes[] validArmorTypes) throws HeroException {

        if(checkName(name) == true){
            this.name = name;
        }else {
            throw new HeroException("Invalid Name");
        }

        this.level = level;
        this.validWeaponTypes = validWeaponTypes;
        this.validArmorTypes = validArmorTypes;
        this.heroAttributes = new HeroAttributes();

        equipment.put(Slot.WEAPON,null);
        equipment.put(Slot.HEAD,null);
        equipment.put(Slot.LEGS,null);
        equipment.put(Slot.BODY,null);
    }
    public boolean checkName(String name){


        return name.matches("[a-zA-Z- ]+");

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
         * 3. if not throw appropriate error
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
                throw new WeaponExceptions("Hero level is lower than required level of weapon");
            }
        }

        //TODO: Add the attributes from equipped armor to current hero attributes
        //the exact same exception format but for armour
            if(weaponOrArmor instanceof Armor){

            //controll if the armor is valid
            if(weaponOrArmor.getRequiredLevel() <= this.level) { //check level requirement

                for (int i = 0; i < validArmorTypes.length; i++) {

                    ArmorTypes validArmorType = validArmorTypes[i];

                    if (validArmorType == ((Armor) weaponOrArmor).getArmorTypes()) {

                        if(weaponOrArmor.getSlot() == Slot.HEAD) {

                            if(equipment.get(Slot.HEAD) != null) {
                                removeArmorAttributeFromHero((Armor) equipment.get(Slot.HEAD));
                            }

                            equipment.put(Slot.HEAD, weaponOrArmor);
                            addArmorAttributeToHero((Armor) weaponOrArmor); //add armor attributes to hero

                            break;

                        }else if(weaponOrArmor.getSlot() == Slot.BODY) {

                            if(equipment.get(Slot.BODY) != null) {
                                removeArmorAttributeFromHero((Armor) equipment.get(Slot.BODY));
                            }
                            equipment.put(Slot.BODY, weaponOrArmor);
                            addArmorAttributeToHero((Armor) weaponOrArmor);
                            break;

                        }else if(weaponOrArmor.getSlot() == Slot.LEGS) {

                            if(equipment.get(Slot.LEGS) != null) {
                                removeArmorAttributeFromHero((Armor) equipment.get(Slot.LEGS));
                            }
                            equipment.put(Slot.LEGS, weaponOrArmor);
                            addArmorAttributeToHero((Armor) weaponOrArmor);
                            break;

                        }
                    }

                    if(i == validArmorTypes.length-1 ) {
                        throw new ArmorException("Armor type is not compatible with hero class");
                    }
                }
            }else {
                //throw armour exception
                throw new ArmorException("Hero level is not enough to equip this armor");
            }
        }
    }

  private void addArmorAttributeToHero(Armor armor){
      this.heroAttributes.setStrength(this.heroAttributes.getStrength() + armor.getArmorAttribute().getStrength());
      this.heroAttributes.setDexterity(this.heroAttributes.getDexterity() + armor.getArmorAttribute().getDexterity());
      this.heroAttributes.setIntelligence(this.heroAttributes.getIntelligence() + armor.getArmorAttribute().getIntelligence()); }

    //remove previous armor attributes from hero
    private void removeArmorAttributeFromHero(Armor armor){

        this.heroAttributes.setStrength(this.heroAttributes.getStrength() - armor.getArmorAttribute().getStrength());
        this.heroAttributes.setDexterity(this.heroAttributes.getDexterity() - armor.getArmorAttribute().getDexterity());
        this.heroAttributes.setIntelligence(this.heroAttributes.getIntelligence() - armor.getArmorAttribute().getIntelligence());

    }

    public HeroAttributes getHeroAttributes() {
        return heroAttributes;
    }

    public int calcTotalAttributes(){

        int sumOfCurrentHeroAttributes = this.getHeroAttributes().getStrength()+ this.getHeroAttributes().getDexterity()+ this.getHeroAttributes().getIntelligence();
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

    //TODO: Show HERO display. Make it abstract class.
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
