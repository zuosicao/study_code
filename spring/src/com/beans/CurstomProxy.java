package com.beans;

public class CurstomProxy {
	private Curstom trueCurstom;
	
	public CurstomProxy()
	{
	}
	public CurstomProxy(Curstom trueCurstom)
	{
		this.trueCurstom = trueCurstom;
	}
	
	public Curstom getTrueCurstom() {
		return trueCurstom;
	}

	public void setTrueCurstom(Curstom trueCurstom) {
		this.trueCurstom = trueCurstom;
	}
	
	public void goShoppiing()
	{
		System.out.println("I'm a proxy!!");
		trueCurstom.goShoppiing();
	}
}
