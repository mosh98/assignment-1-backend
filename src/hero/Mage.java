package hero;

public class Mage extends Hero{

    public Mage(String name) {
        super(name);
        //TODO: set initial hero attributes
        this.heroAttributes.setStrength(1);
        this.heroAttributes.setDexterity(1);
        this.heroAttributes.setIntelligence(8);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        super.heroAttributes.setDexterity(super.heroAttributes.getDexterity() + 1);
        super.heroAttributes.setIntelligence(super.heroAttributes.getIntelligence() + 5);
        super.heroAttributes.setStrength(super.heroAttributes.getStrength() + 1);
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
