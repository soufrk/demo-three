package com.my.project.implementations.designpatterns.structural;

public class DecoratorPattern02 {

    public static void main(String agrs[]) {
	Sub sub = new ItalianBMT(Bread.MULTIGRAIN);
	new OnionDecorator(sub);
	new CheeseDecorator(sub);
	sub.prepare();
    }
}

abstract class Sub {

    /**
     * Encapsulating the functionality to be decorated.
     */
    abstract public void start();

    public void prepare() {
	start();
	System.out.println("Choice of Bread:" + bread.getName());
	System.out.println("Veg Stuffings:\n" + vegStuffing);
    }

    public Sub(Bread bread) {
	this.bread = bread;
	this.vegStuffing = "";
    }

    protected Bread bread;
    protected String vegStuffing;
}

enum Bread {

    MULTIGRAIN("9 Grain Wheat"), MULTIGRAIN_HONEY_OAT("9 Grain Honey Oat"), PARMESAN("Italian Parmesan oregano");
    // ITALIAN, HEARTY_ITALIAN;

    private String name;

    private Bread(String name) {
	this.name = name;
    }

    public String getName() {
	return this.name;
    }
}

class ItalianBMT extends Sub {

    public ItalianBMT(Bread bread) {
	super(bread);
    }

    @Override
    public void start() {
	System.out.println("Preparing an Italian B.M.T Sub");
    }

}

class TurkeyAndChicken extends Sub {
    public TurkeyAndChicken(Bread bread) {
	super(bread);
    }

    @Override
    public void start() {
	System.out.println("Preparing a Turkey And Chicken Sub");
    }

}

abstract class AbstractStuffingDecorator {
    protected Sub sub;
    // protected String decoration;

    // abstract public void getDecoration();

    /*
     * public String getStuffings(){ return decoration; }
     */

    public AbstractStuffingDecorator(Sub sub, String decoration) {
	// this.decoration += decoration + "\n";
	this.sub = sub;
	sub.vegStuffing += decoration + "\n";
    }
}

class LettuceDecorator extends AbstractStuffingDecorator {
    LettuceDecorator(Sub sub) {
	super(sub, "Adding Lettuce");
    }
}

class OnionDecorator extends AbstractStuffingDecorator {
    public OnionDecorator(Sub sub) {
	super(sub, "Adding Onions");
    }
}

class CheeseDecorator extends AbstractStuffingDecorator {
    public CheeseDecorator(Sub sub) {
	super(sub, "Adding Cheese");
    }
}

/*
 * class EggAndCheese extends Sub{
 * 
 * }
 */