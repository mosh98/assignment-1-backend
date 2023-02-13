package Items.Armor;

import HeroExceptions.ArmorException;
import Items.Item;
import Items.Slot;

public class Armor extends Item {
    private ArmorTypes armorTypes;

    private ArmorAttribute armorAttribute;

    public Armor(String name, int requiredLevel, Slot slot, ArmorTypes armorTypes, ArmorAttribute armorAttribute) throws ArmorException {
        super(name,requiredLevel,slot);

        if(slot == Slot.WEAPON){
            throw new ArmorException("ArmorType can't be WEAPON");
        }

        this.armorTypes = armorTypes;

        this.armorAttribute = armorAttribute;
    }

    public ArmorTypes getArmorTypes() {
        return armorTypes;
    }

    public ArmorAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public void setArmorAttribute(ArmorAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }
}
