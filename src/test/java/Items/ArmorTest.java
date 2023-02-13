package Items;

import HeroExceptions.ArmorException;
import Items.Armor.Armor;
import Items.Armor.ArmorAttribute;
import Items.Armor.ArmorTypes;
import hero.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ArmorTest {

    /**
     * Equip Armor!
     * Checking different configuration of armor and if the hero throws anything
     *
     */

    //DONE: check if armor throws exception when trying to equip armor of wrong type
    //DONE: check if armor throws exception when trying to equip armor of wrong slot

    //test for equipment of armor  & checking the equipment hasmap if it exist
    @Test
    public void equipArmor_checkSlot_TRUE() throws ArmorException {
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",1,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon

        try {
            heroWarrior.equip(armor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //assert of is the armor in the equipment hashmap
        assertEquals(armor,heroWarrior.getEquipment().get(Slot.BODY));
    }


    /** ____________________________________CHECK WRONG ARMOR TYPE____________________________________ **/

    //check if armor throws exception when trying to equip armor of wrong type for Warrior
    //@Warrior
    @Test
    public void equipArmor_WrongType_ShouldThrowException() throws ArmorException {
        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",0,Slot.BODY, ArmorTypes.LEATHER,armorAttribute);
        Hero heroWarrior = new Warrior("Mosleh"); //Warrior has to have a weapon

        //Act
        Exception exception = assertThrows(ArmorException.class, () -> heroWarrior.equip(armor) );

        String expectedMessage = "Armor type is not compatible with hero class";

        String actualMessage = exception.getMessage();
        //System.out.println(actualMessage);

        //Assert
        assertEquals(expectedMessage, actualMessage);

    }

    //check if armor throws exception when trying to equip armor of wrong type for Mage
    //@Mage
    @Test
    public void mageEqiupArmor_WrongType_ShouldThrowException() throws ArmorException {
        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",0,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Hero heroWarrior = new Mage("mage"); //Warrior has to have a weapon

        //Act
        Exception exception = assertThrows(ArmorException.class, () -> heroWarrior.equip(armor));

        String expectedMessage = "Armor type is not compatible with hero class";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //check if armor throws exception when trying to equip armor of wrong type for Rogue
    //@Rogue
    @Test //rogueEqiupArmor_WrongType_ShouldThrowException
    public void rogueEqiupArmor_WrongType_ShouldThrowException() throws ArmorException {
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",0,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Hero heroWarrior = new Rogue("Rogue"); //Warrior has to have a weapon

        //assert of armor thorws error
        Exception exception = assertThrows(ArmorException.class, () -> heroWarrior.equip(armor));

        String expectedMessage = "Armor type is not compatible with hero class";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    //check if armor throws exception when trying to equip armor of wrong type for Ranger
    //@Ranger
    @Test
    public void rangerEqiupArmor_WrongType_ShouldThrowException() throws ArmorException {
        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",0,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Hero heroWarrior = new Rogue("Ranger"); //Warrior has to have a weapon

        //Act & assert of armor thorws error
        Exception exception = assertThrows(ArmorException.class, () -> heroWarrior.equip(armor));

        String expectedMessage = "Armor type is not compatible with hero class";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    /** ____________________________________CHECK WRONG ARMOR SLOT____________________________________ **/

    //check if armor throws exception when trying to equip armor of wrong slot
    //@Warrior
    @Test
    public void equipArmor_WrongSlot_ShouldThrowException(){

        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);


        //Act & assert
        Exception exception =  assertThrows(ArmorException.class, () -> new Armor("Common Plate Chest",0,Slot.WEAPON, ArmorTypes.PLATE,armorAttribute));

        String expectedMessage = "ArmorType can't be WEAPON";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);

    }

    //** ____________________________________CHECK HERO CANNOT GET HIGHER LEVEL ARMOR____________________________________ **/

    //check if Mage Hero can equip armor of higher level
    //@Mage
    @Test
    public void mageEquipArmor_HigherLevel_ShouldThrowException() throws ArmorException {
        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",3,Slot.BODY, ArmorTypes.PLATE,armorAttribute);
        Hero heroMage = new Mage("Mage"); //Mage has to have a weapon

        //Act & assert of armor thorws error
        Exception exception = assertThrows(ArmorException.class, () -> heroMage.equip(armor));

        String expectedMessage = "Hero level is not enough to equip this armor";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //check if Warrior Hero can equip armor of higher level
    //@Warrior
    @Test
    public void warriorEquipArmor_HigherLevel_ShouldThrowException() throws ArmorException {

        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",3, Slot.BODY, ArmorTypes.PLATE, armorAttribute);
        Hero heroWarrior = new Warrior("Warrior"); //Warrior has to have a weapon

        //Act & assert of armor thorws error
        Exception exception = assertThrows(ArmorException.class, () -> heroWarrior.equip(armor));

        String expectedMessage = "Hero level is not enough to equip this armor";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //check if Rogue Hero can equip armor of higher level
    //@Rogue
    @Test
    public void rogueEquipArmor_HigherLevel_ShouldThrowException() throws ArmorException {
        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",3,Slot.BODY, ArmorTypes.MAIL,armorAttribute);
        Hero heroRogue = new Rogue("Rogue"); //Mage has to have a weapon

        //Act & assert of armor thorws error
        Exception exception = assertThrows(ArmorException.class, () -> heroRogue.equip(armor));

        String expectedMessage = "Hero level is not enough to equip this armor";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //check if Ranger Hero can equip armor of higher level
    //@Ranger
    @Test
    public void rangerEquipArmor_HigherLevel_ShouldThrowException() throws ArmorException {
        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",3,Slot.BODY, ArmorTypes.LEATHER,armorAttribute);
        Hero heroRanger = new Ranger("Ranger"); //Mage has to have a weapon

        //Act & assert of armor thorws error
        Exception exception = assertThrows(ArmorException.class, () -> heroRanger.equip(armor));

        String expectedMessage = "Hero level is not enough to equip this armor";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    //check if Mage Hero can equip armor of higher level
    //@Mage
    @Test
    public void mageEquipArmor_LowerLevel_ShouldThrowException() throws ArmorException {
        //Arrange
        ArmorAttribute armorAttribute = new ArmorAttribute(1,0,0);
        Item armor = new Armor("Common Plate Chest",3,Slot.BODY, ArmorTypes.CLOTH,armorAttribute);
        Hero heroMage = new Mage("Mage"); //Mage has to have a weapon

        //Act & assert of armor thorws error
        Exception exception = assertThrows(ArmorException.class, () -> heroMage.equip(armor));

        String expectedMessage = "Hero level is not enough to equip this armor";

        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }





}
