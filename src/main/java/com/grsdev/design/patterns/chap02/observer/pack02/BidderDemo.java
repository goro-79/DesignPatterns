package com.grsdev.design.patterns.chap02.observer.pack02;

import java.util.Observable;
import java.util.Observer;
import static java.lang.System.out;

public class BidderDemo {

	public static void main(String[] args) throws InterruptedException {

		StarStockPrize stock=new StarStockPrize();
		
		StockBuyer buyer1=new StockBuyer("buyer1");
		StockBuyer buyer2=new StockBuyer("buyer2");
		StockBuyer buyer3=new StockBuyer("buyer3");
		
		
		stock.addObserver(buyer1);
		stock.addObserver(buyer2);
		stock.addObserver(buyer3);
		
		stock.setPrice(0);
		stock.bid(1);
		out.println(">>> final price <<<");
		stock.showPrice();
	}

}


class StarStockPrize extends Observable{
	
	private int price;
	
	public StarStockPrize(){
		
		price=(int)(Math.random()*100);
	}
	
	public void showPrice(){
		out.println("stock >>> current price : "+price);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void bid(int bid) throws InterruptedException {
		if(bid>price){
			price=bid;
			out.println("stock >>> price changed to : "+price);
			setChanged();
			notifyObservers();
		}
		Thread.sleep(10000);
	}
	
}


class StockBuyer implements Observer{
	
	String name;
	
	public StockBuyer(String name) {
		this.name=name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		int bid=(int)(Math.random()*100);
		
		out.println(name + " >>> biding : "+bid);
		
		try {
			((StarStockPrize)o).bid(bid);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
