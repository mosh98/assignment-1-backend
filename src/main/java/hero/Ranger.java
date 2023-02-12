package hero;

import Items.Armor.ArmorTypes;
import Items.Slot;
import Items.Weapons.Weapon;
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

    @Override
    public void increaseLevel() {
        super.setLevel(super.getLevel()+1);
        this.heroAttributes.setStrength(this.heroAttributes.getStrength()+1);
        this.heroAttributes.setDexterity(this.heroAttributes.getDexterity()+5);
        this.heroAttributes.setIntelligence(this.heroAttributes.getIntelligence()+1);

    }

    @Override
    public int calcDamage() {
        int weaponDmg = 1;
        //check if weapon is equipped
        if(super.getEquipment().get(Slot.WEAPON) != null){

            weaponDmg = ((Weapon)super.getEquipment().get(Slot.WEAPON)).getWeaponDamage();
        }

        float heroDmg = weaponDmg * ((float)  (1 + (this.heroAttributes.getDexterity()  /100)));

        return (int) heroDmg;
    }
}
