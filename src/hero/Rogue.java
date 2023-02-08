package hero;

public class Rogue extends Hero{

    public Rogue(String name) {
        super(name);
        this.heroAttributes.setStrength(2);
        this.heroAttributes.setDexterity(6);
        this.heroAttributes.setIntelligence(1);
    }

    @Override
    public void levelUp(){
        super.levelUp();
        super.heroAttributes.setStrength(super.heroAttributes.getStrength() + 1);
        super.heroAttributes.setDexterity(super.heroAttributes.getDexterity() + 4);
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
