package com.grsdev.design.patterns.chap01.strategey.pack01;

/**
 * @author gaurav salvi
 *
 */
public abstract class Duck {
	
	private String name;
	
	private QuckBehaviour quackBehaviour;
	
	private FlyBehaviour flyBehaviour;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuckBehaviour getQuackBehaviour() {
		return quackBehaviour;
	}

	public void setQuackBehaviour(QuckBehaviour quackBehaviour) {
		this.quackBehaviour = quackBehaviour;
	}

	public FlyBehaviour getFlyBehaviour() {
		return flyBehaviour;
	}

	public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
		this.flyBehaviour = flyBehaviour;
	}
	
	public void display(){
		System.out.println(">>> displaying duck : "+getName());
	}
	
	public void quack(){
		if(quackBehaviour==null)System.out.println("quack behaviour is not implemented");
		else quackBehaviour.quack();
	}

	
	public void fly(){
		if(flyBehaviour==null)System.out.println("fly behaviour is not implemented");
		else flyBehaviour.fly();
	}
}
