package hero;

import HeroAttributes.HeroAttributes;

abstract class Hero {
//fields GENREAL:
    //Name
    String name;
    //Level
    int level = 1;

    //TODO: LevelAttributes

    //Equipment
    String[] equipment; //TODO: FIX THIS

    //ValidWeaponTypes
    String[] validWeaponTypes; //TODO: FIX THIS

    //ValidArmorTypes
    String[] validArmorTypes; //TODO: FIX THIS

    //
    HeroAttributes heroAttributes;



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


    //TOOD: TotalAtribute- calculated on the fly and not stored
    public abstract void totalAttribute();


    //TODO: Display -details of hero.Hero to be displayed
    public abstract void display();

}
