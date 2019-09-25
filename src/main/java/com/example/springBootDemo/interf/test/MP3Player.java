package com.example.springBootDemo.interf.test;

public class MP3Player implements IMobileStorage{

	@Override
	public void Read() {
		System.out.println("Reading from MP3Player……");
        System.out.println("Read finished!");
	}

	@Override
	public void Write() {
		 System.out.println("Writing to MP3Player……");
	     System.out.println("Write finished!");
	}
	/*
	 * MP3播放音乐
	 */
	public void PlayMusic(){
		System.out.println("Music is playing……");
	}
	
}
