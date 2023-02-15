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
    private boolean checkName(String name){
        /**
         * @param name
         * @return true if the name is valid
         * @return false if the name is invalid
         * checking name using regex.
         */
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

        // Adding the attributes from equipped armor to current hero attributes
        // Removing the attributes from unequipped armor from current hero attributes

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
      /**
       * @param armor
       * @return void
       * Assigning attributes to hero
       */
      this.heroAttributes.setStrength(this.heroAttributes.getStrength() + armor.getArmorAttribute().getStrength());
      this.heroAttributes.setDexterity(this.heroAttributes.getDexterity() + armor.getArmorAttribute().getDexterity());
      this.heroAttributes.setIntelligence(this.heroAttributes.getIntelligence() + armor.getArmorAttribute().getIntelligence()); }

    //remove previous armor attributes from hero
    private void removeArmorAttributeFromHero(Armor armor){
        /**
         * @param armor
         * @return void
         * Removing attributes from hero
         */

        this.heroAttributes.setStrength(this.heroAttributes.getStrength() - armor.getArmorAttribute().getStrength());
        this.heroAttributes.setDexterity(this.heroAttributes.getDexterity() - armor.getArmorAttribute().getDexterity());
        this.heroAttributes.setIntelligence(this.heroAttributes.getIntelligence() - armor.getArmorAttribute().getIntelligence());

    }

    public HeroAttributes getHeroAttributes() {
        return heroAttributes;
    }

    public int calcTotalAttributes(){
        /**
         * @return int
         * Calculate the total attributes of the hero
         * including the attributes of the equipped armor
         */

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

    public abstract double calcDamage();

    //TODO: Show Hero with correct subclass name
    public void displayHero() {
        /**
         * @return StringBuilder
         * Displaying the hero with all the attributes
         */
        StringBuilder hero = new StringBuilder();
        hero.append("Name: ").append(this.getName()).append("\n");
        hero.append("Class: ").append(this.getClass().asSubclass(this.getClass()).getSimpleName()).append("\n");
        hero.append("Level: ").append(this.getLevel()).append("\n");
        hero.append("Total Strength: ").append(this.getHeroAttributes().getStrength()).append("\n");
        hero.append("Total Dexterity: ").append(this.getHeroAttributes().getDexterity()).append("\n");
        hero.append("Total Intelligence: ").append(this.getHeroAttributes().getIntelligence()).append("\n");
        hero.append("Total Attributes: ").append(this.calcTotalAttributes()).append("\n");
        System.out.println(hero);

    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
