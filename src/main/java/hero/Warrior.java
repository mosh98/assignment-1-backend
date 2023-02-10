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

    @Override
    public void increaseLevel() {
        super.setLevel(super.getLevel()+1);
        this.heroAttributes.setStrength(this.heroAttributes.getStrength()+3);
        this.heroAttributes.setDexterity(this.heroAttributes.getDexterity()+2);
        this.heroAttributes.setIntelligence(this.heroAttributes.getIntelligence()+1);
    }
}
