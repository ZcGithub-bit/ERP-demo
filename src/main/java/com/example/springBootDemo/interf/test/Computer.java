package com.example.springBootDemo.interf.test;

public class Computer {
	
	private IMobileStorage _usbDrive;
	
    public IMobileStorage get_usbDrive() {
        return _usbDrive;
    }
    
    public void set_usbDrive(IMobileStorage _usbDrive) {
        this._usbDrive = _usbDrive;
    }

    public Computer(){
    		
    }

    public Computer(IMobileStorage _usbDrive) {
        this._usbDrive = _usbDrive;
    }
    
    public void ReadData(){
        this._usbDrive.Read();
    }

    public void WriteData(){
        this._usbDrive.Write();
    }
}
