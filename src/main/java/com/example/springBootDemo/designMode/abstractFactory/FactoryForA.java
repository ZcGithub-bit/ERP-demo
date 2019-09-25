package com.example.springBootDemo.designMode.abstractFactory;

public class FactoryForA implements produce{

	@Override
	public String get() {
		return new Aaf().A1("A123");
	}

}
