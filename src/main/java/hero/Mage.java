package hero;

import HeroExceptions.HeroException;
import Items.Armor.ArmorTypes;
import Items.Slot;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;

public class Mage extends Hero{

    public Mage(String name) throws HeroException {
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
        /**
         * Increase the attributes for the given HERO accoriding to the requirements
         * Mage increases level by 1
         * Mage increases strength by 1
         * Mage increases dexterity by 1
         * Mage increases intelligence by 5
         */

        super.setLevel(super.getLevel()+1);
        super.heroAttributes.setStrength(super.heroAttributes.getStrength()+1);
        super.heroAttributes.setDexterity(super.heroAttributes.getDexterity()+1);
        super.heroAttributes.setIntelligence(super.heroAttributes.getIntelligence()+5);
    }

    @Override
    public double calcDamage() {
        /**
         * Calculate the damage for the given HERO according to the requirements
         */
        int weaponDmg = 1;

        //check if weapon is equipped
        if(super.getEquipment().get(Slot.WEAPON) != null){
            weaponDmg = ((Weapon) super.getEquipment().get(Slot.WEAPON)).getWeaponDamage();
        }

        int intelligence = this.heroAttributes.getIntelligence();



        double heroDmg = weaponDmg * ((double)  (1 + (intelligence  /100)));
        return  heroDmg;
    }
}
