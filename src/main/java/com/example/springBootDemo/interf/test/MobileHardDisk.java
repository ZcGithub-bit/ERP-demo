package com.example.springBootDemo.interf.test;

/*
 * 移动硬盘
 */
public class MobileHardDisk implements IMobileStorage{

	@Override
	public void Read() {
		System.out.println("Reading from MobileHardDisk……");
        System.out.println("Read finished!");
	}

	@Override
	public void Write() {
		System.out.println("Writing to MobileHardDisk……");
	    System.out.println("Write finished!");
	}
	
}
