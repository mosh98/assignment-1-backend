package hero;

import HeroAttributes.HeroAttributes;
import Items.Slot;
import Items.WeaponType;

import java.util.HashMap;

abstract class Hero {

    //fields GENREAL:
    //Name
    private String name;
    //Level
    private int level;

    //TODO: LevelAttributes

    //Equipment
    private String[] equipment; //TODO: FIX THIS

    //ValidWeaponTypes
    private String[] validWeaponTypes; //TODO: FIX THIS

    //ValidArmorTypes
    private String[] validArmorTypes; //TODO: FIX THIS

    //
    public HeroAttributes heroAttributes;

    public HashMap<Slot, WeaponType> weaponMap = new HashMap<Slot,WeaponType>();

    //_________________________________________________________
    //constructor – each hero is created by passing just a name

    public Hero(String name) {


        this.name = name;
        this.level = 1;
        this.equipment = new String[2];
        this.equipment[0] = "None";
        this.equipment[1] = "None";
        this.heroAttributes = null;
    }


    //Levelup - increases the level of a character by 1 and increases their LevelAttributes
    public  void levelUp(){
        this.level++;
    }

    //TODO: Equip - two variants, for equipping armor and weapons
    public abstract void equip();

    //TODO:damage-damage is calculated on the fly and not stored
    public abstract void damage();


    //TODO: TotalAtribute- calculated on the fly and not stored
    public abstract void totalAttribute();


    //TODO: Display -details of hero.Hero to be displayed
    public abstract void display();

}
