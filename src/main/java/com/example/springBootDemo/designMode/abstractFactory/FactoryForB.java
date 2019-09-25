package com.example.springBootDemo.designMode.abstractFactory;

public class FactoryForB implements produce{

	@Override
    public String get() {
        return new Bfa().B1("B123");
    }

}
