package com.example.springBootDemo.interf.test;

/*
 * U盘
 */
public class FlashDisk implements IMobileStorage{

	@Override
	public void Read() {
		 System.out.println("Reading from FlashDisk……");
		 System.out.println("Read finished!");
	}

	@Override
	public void Write() {
		System.out.println("Writing to FlashDisk……");
		System.out.println("Write finished!");
	}
	
}
