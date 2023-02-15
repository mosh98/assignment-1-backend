package hero;

import HeroExceptions.HeroException;
import Items.Armor.ArmorTypes;
import Items.Slot;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;

public class Rogue extends Hero{

    public Rogue(String name) throws HeroException {
        super(name,1,
                new WeaponType[] {WeaponType.DAGGERS,WeaponType.SWORDS},
                new ArmorTypes[]{ArmorTypes.LEATHER,ArmorTypes.MAIL});
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

    @Override
    public double calcDamage() {
        int weaponDmg = 1;
        //check if weapon is equipped
        if(super.getEquipment().get(Slot.WEAPON) != null){


            weaponDmg = ((Weapon) super.getEquipment().get(Slot.WEAPON)).getWeaponDamage();
        }

        double heroDmg = weaponDmg * ((double)  (1 + (this.heroAttributes.getDexterity()  /100)));
        return  heroDmg;
    }



}
