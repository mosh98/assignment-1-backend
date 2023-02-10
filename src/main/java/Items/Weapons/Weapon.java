package Items.Weapons;

import Items.Item;
import Items.Slot;

public class Weapon extends Item {
    private WeaponType weaponType;
    private int weaponDamage;
    public Weapon(String name, int requiredLevel, Slot slot, WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel, slot);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;

        //fix weapon details

    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }


}
