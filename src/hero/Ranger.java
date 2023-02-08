package hero;

public class Ranger extends Hero{

    public Ranger(String name) {
        //TODO: set initial hero attributes
        super(name);
        this.heroAttributes.setStrength(1);
        this.heroAttributes.setDexterity(7);
        this.heroAttributes.setIntelligence(1);
    }

    @Override
    public void levelUp(){
        super.levelUp();
        super.heroAttributes.setStrength(super.heroAttributes.getStrength() + 1);
        super.heroAttributes.setDexterity(super.heroAttributes.getDexterity() + 5);
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
