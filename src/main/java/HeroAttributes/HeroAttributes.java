package HeroAttributes;

public class HeroAttributes {
    int strength;
    int dexterity;
    int intelligence;

    int armourAttribute;

    public HeroAttributes() {

    }

    public HeroAttributes(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    /*TODO:
    *    You are to make a class to encapsulate these attributes, it should be called HeroAttribute. This class should have
    *    methods to add two instances together and return the sum OR increase the one instance by a specified amount. Which
    *    to use is up to you on what best suits your solution. */


    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }
    public int getIntelligence() {
        return intelligence;
    }

}
