package com.logic;

public class A{
	int p1;
	public A(int p1){
		this.p1 = p1;
		System.out.println("A()"+p1);
	}
	
	public void initBn(){
		System.out.println("initBn()...");
	}
	
	public void destroyBn(){
		System.out.println("destroyBn()...");
	}
	
	@Override
	public String toString(){
		return "a="+p1;
	}
}
