package hero;

import Items.Armor.ArmorTypes;
import Items.Weapons.WeaponType;

import java.util.ArrayList;
import java.util.Objects;

public class Warrior extends Hero{

    public Warrior(String name) {
        //TODO: FIX 2nd argument EQUIPMENT
        super(name,1,
                new WeaponType[] {WeaponType.AXES,WeaponType.HAMMERS,WeaponType.SWORDS},
                new ArmorTypes[]{ArmorTypes.MAIL,ArmorTypes.PLATE});

        this.heroAttributes.setStrength(5);
        this.heroAttributes.setDexterity(2);
        this.heroAttributes.setIntelligence(1);

    }


}
