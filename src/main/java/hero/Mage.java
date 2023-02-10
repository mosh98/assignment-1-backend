package hero;

import Items.Armor.ArmorTypes;
import Items.Weapons.WeaponType;

public class Mage extends Hero{

    public Mage(String name) {
        super(name,1,
                new WeaponType[] {WeaponType.STAFFS,WeaponType.WANDS},
                new ArmorTypes[]{ArmorTypes.CLOTH});
        //TODO: set initial hero attributes
        this.heroAttributes.setStrength(1);
        this.heroAttributes.setDexterity(1);
        this.heroAttributes.setIntelligence(8);
    }

    @Override
    public void increaseLevel() {
        super.setLevel(super.getLevel()+1);
        this.heroAttributes.setStrength(this.heroAttributes.getStrength()+1);
        this.heroAttributes.setDexterity(this.heroAttributes.getDexterity()+1);
        this.heroAttributes.setIntelligence(this.heroAttributes.getIntelligence()+5);
    }
}
