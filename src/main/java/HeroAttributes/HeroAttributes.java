package HeroAttributes;

import java.util.Objects;

public class HeroAttributes {
    int strength;
    int dexterity;
    int intelligence;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroAttributes that = (HeroAttributes) o;
        return strength == that.strength && dexterity == that.dexterity && intelligence == that.intelligence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, dexterity, intelligence);
    }

    @Override
    public String toString() {
        return "HeroAttributes{" +
                "strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                '}';
    }
}
