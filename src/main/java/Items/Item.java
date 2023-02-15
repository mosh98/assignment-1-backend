package Items;

import HeroExceptions.HeroException;
import Items.Weapons.WeaponType;

public abstract class Item {
    private String name;
    private int requiredLevel;

    //private
    private Slot slot;


    public Item(String name, int requiredLevel, Slot slot) {

        if(checkName(name) == true){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Invalid Name");
        }

        this.requiredLevel = requiredLevel;
        this.slot = slot;
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


    public String getName() {
        return name;
    }


    public int getRequiredLevel() {
        return requiredLevel;
    }


    public Slot getSlot() {
        return slot;
    }

    }
