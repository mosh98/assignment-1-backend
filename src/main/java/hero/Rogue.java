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

    @Override
    public void increaseLevel() {
        super.setLevel(super.getLevel()+1);
        this.heroAttributes.setStrength(this.heroAttributes.getStrength()+1);
        this.heroAttributes.setDexterity(this.heroAttributes.getDexterity()+4);
        this.heroAttributes.setIntelligence(this.heroAttributes.getIntelligence()+1);
    }



}
