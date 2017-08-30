package domotica.command;

import domotica.model.DomoticaObject;
import domotica.model.ElectricityException;

public class closeDoorCommand implements command {

	
	DomoticaObject domObject;
	
	public closeDoorCommand(DomoticaObject object) {
		domObject = object;
	}
	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			domObject.setAllDoorsClosed();
		} 
		catch (ElectricityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void undo() {
		try {
			domObject.setAllDoorsOpen();
		} 
		catch (ElectricityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
