package hero;

import Items.Armor.ArmorTypes;
import Items.Weapons.WeaponType;

public class Ranger extends Hero{

    public Ranger(String name) {
        //TODO: set initial hero attributes
        super(name,1,
                new WeaponType[] {WeaponType.BOWS},
                new ArmorTypes[]{ArmorTypes.LEATHER,ArmorTypes.MAIL});
        this.heroAttributes.setStrength(1);
        this.heroAttributes.setDexterity(7);
        this.heroAttributes.setIntelligence(1);
    }

}
