package com.example.springBootDemo.interf.test;

public class ToTest {
    public void program1(){
        Computer computer = new Computer();
        IMobileStorage mp3Player = new MP3Player();
        IMobileStorage flashDisk = new FlashDisk();
        IMobileStorage moblieHardDisk = new MobileHardDisk();

        System.out.println("我把我的MP3播放器插入我的电脑，并复制了一些音乐到它:");
        computer.set_usbDrive(mp3Player);
        computer.WriteData();
        System.out.println("====================");

        System.out.println("嗯，我还想把一部很棒的电影从移动硬盘拷贝到我的电脑上:");
        computer.set_usbDrive(moblieHardDisk);
        computer.ReadData();
        System.out.println("====================");

        System.out.println("好的!我必须从我的闪存盘上读取一些文件，然后把另一个文件复制到它上面:");
        computer.set_usbDrive(flashDisk);
        computer.ReadData();
        computer.WriteData();
        System.out.println();
	}
}	
