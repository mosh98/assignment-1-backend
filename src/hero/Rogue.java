package hero;

import Items.Armor.ArmorTypes;
import Items.Weapons.WeaponType;

public class Rogue extends Hero{

    public Rogue(String name) {
        super(name,1,
                new WeaponType[] {WeaponType.DAGGERS,WeaponType.SWORDS},
                new ArmorTypes[]{ArmorTypes.LEATHER,ArmorTypes.PLATE});
        this.heroAttributes.setStrength(2);
        this.heroAttributes.setDexterity(6);
        this.heroAttributes.setIntelligence(1);
    }



}
