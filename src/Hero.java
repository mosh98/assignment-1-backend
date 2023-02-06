abstract class Hero {
//fields:
    //Name
    String name;
    //Level
    int level;
    //TODO: LevelAttributes

    //Equipment
    String[] equipment;
    //ValidWeaponTypes
    String[] validWeaponTypes;

    //ValidArmorTypes
    String[] validArmorTypes;

    //constructor – each hero is created by passing just a name

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.equipment = new String[2];
        this.equipment[0] = "None";
        this.equipment[1] = "None";
    }


    //Levelup - increases the level of a character by 1 and increases their LevelAttributes
    public void levelUp() {
        this.level++;
    }

    //Equip - two variants, for equipping armor and weapons
    public void equip(){

    }
    //damage- damage is calculated on the fly and not stored
    public void damage(){

    }

    //TotalAtribute- calculated on the fly and not stored
    public void totalAttribute(){

    }
    //Display -details of Hero to be displayed
    public void display(){

    }
    



}
