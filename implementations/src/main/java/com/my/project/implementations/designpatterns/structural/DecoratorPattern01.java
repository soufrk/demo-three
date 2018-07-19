package com.my.project.implementations.designpatterns.structural;

public class DecoratorPattern01 {

    public static void main(String[] args) {
	/*
	 * Component component = new ComponentA(); ComponentDecorator decorator = new
	 * NowShowing(component); decorator.show();
	 */

	/*
	 * // Select a Component to be decorated Component component = new ComponentB();
	 * // Select a Decorator for decoration. ComponentDecorator decorator = new
	 * NowShowing(component); // Delegate decoration decorator.show();
	 */

	// Select a Component to be decorated
	Component component = new ComponentB();
	// Select a Decorator for decoration.
	ComponentDecorator decorator = new ToniteShowing(component);
	// Delegate decoration
	decorator.show();

    }

}

/**
 * Abstract Base class representing the component to be decorated.
 * 
 * @author soufrk
 *
 */
abstract class Component {

    /**
     * Encapsulating the functionality to be decorated.
     */
    public void show() {
	System.out.println("Method not implemented");
    }
}

/**
 * Abstract Base decorator class that decorates the component. Must be sibling
 * of the component that gets decorated. Decorator HAS-A Component, which gets
 * decorated.
 * 
 * @author soufrk
 *
 */
abstract class ComponentDecorator extends Component {

    /**
     * Instance of the component
     */
    Component component;

    /**
     * Functionality of decorating. To be implemented by each decorator.
     */
    @Override
    abstract public void show();

}

/**
 * Concrete implementation of a Component.
 * 
 * @author soufrk.
 *
 */
class ComponentA extends Component {

    @Override
    public void show() {
	System.out.print("showing A");
    }
}

/**
 * Concrete implementation of a Component.
 * 
 * @author soufrk
 *
 */
class ComponentB extends Component {
    @Override
    public void show() {
	System.out.print("showing B");
    }
}

/**
 * Concrete implementation of a Decorator.
 * 
 * @author soufrk
 *
 */
class NowShowing extends ComponentDecorator {

    /**
     * Assigning instance of the Component
     * 
     * @param component
     */
    public NowShowing(Component component) {
	this.component = component;
    }

    /**
     * Providing implementation of implementation of this Decorator.
     */
    @Override
    public void show() {
	System.out.print("Now, ");
	component.show();
	System.out.println("");

    }

}

/**
 * Concrete implementation of a Decorator.
 * 
 * @author soufrk
 *
 */
class ToniteShowing extends ComponentDecorator {

    /**
     * Assigning instance of the Component
     * 
     * @param component
     */
    public ToniteShowing(Component component) {
	this.component = component;
    }

    /**
     * Providing implementation of implementation of this Decorator.
     */
    @Override
    public void show() {
	System.out.print("Tonite we'r ");
	component.show();
	System.out.println("");

    }

}
