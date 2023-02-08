package hero;

public class Warrior extends Hero{

    public Warrior(String name) {
        super(name);
        this.heroAttributes.setStrength(5);
        this.heroAttributes.setDexterity(2);
        this.heroAttributes.setIntelligence(1);

    }
    @Override
    public void levelUp(){
        super.levelUp();
        super.heroAttributes.setStrength(super.heroAttributes.getStrength() + 3);
        super.heroAttributes.setDexterity(super.heroAttributes.getDexterity() + 2);
        super.heroAttributes.setIntelligence(super.heroAttributes.getIntelligence() + 1);
    }

    @Override
    public void equip() {

    }
    @Override
    public void damage() {
    }

    @Override
    public void totalAttribute() {
    }

    @Override
    public void display() {
    }

}
