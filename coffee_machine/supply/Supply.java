package coffee_machine.supply;

/**
 * Data class for supplies
 */
public class Supply {;
    public int water;
    public int milk;
    public int beans;
    public Supply(int water, int milk, int beans) {
        String messageError = "%1$s should be a greater or equal 0.";
        if(water < 0) throw new SupplyError(String.format(messageError, "Water"));
        if(milk < 0) throw new SupplyError(String.format(messageError, "Milk"));
        if(beans < 0) throw new SupplyError(String.format(messageError, "Beans"));
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }
}

