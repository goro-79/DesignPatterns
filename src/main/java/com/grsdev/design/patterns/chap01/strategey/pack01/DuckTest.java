package com.grsdev.design.patterns.chap01.strategey.pack01;

/**
 * @author gaurav salvi
 *
 */
public class DuckTest {

	public static void main(String[] args) {
		
		Duck duck=new MallardDuck();
		
		
		duck.setFlyBehaviour(()-> System.out.println(">>> mallard duck is flying ..."));
		
		duck.display();
		duck.fly();
		duck.quack();
		duck.setQuackBehaviour(()->System.out.println("quack ... quack ... quack ..."));
		duck.quack();

	}

}
