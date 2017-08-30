package domotica.command;

import domotica.model.DomoticaObject;
import domotica.model.ElectricityException;

public class openDoorCommand implements command {

	DomoticaObject domObject;
	
	public openDoorCommand(DomoticaObject object) {
		domObject = object;
	}
	
	@Override
	public void execute() {
		try {
			domObject.setAllDoorsOpen();
		} 
		catch (ElectricityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void undo() {
		try {
			domObject.setAllDoorsClosed();
		} 
		catch (ElectricityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
