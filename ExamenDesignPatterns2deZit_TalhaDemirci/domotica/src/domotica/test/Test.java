package domotica.test;

import java.util.*;

import domotica.command.closeDoorCommand;
import domotica.command.command;
import domotica.command.openDoorCommand;
import domotica.model.*;
import domotica.view.*;

public class Test {

	private static Random random = new Random();

	private static command laatsteCommand;
	
	private static int randomInt(int lo, int hi) {
		return lo + random.nextInt(hi - lo + 1);
	}

	private static float randomFloat(float lo, float hi) {
		return lo + random.nextFloat() * (hi - lo);
	}

	private static void round(House house) throws DomoticaException {
		{
			Living living = house.getLiving();
			living.setAircoTemperature(randomInt(15, 25));
			living.setLightLevel(randomFloat(0, 1));
			living.setRollerShutterDown(!living.isRollerShutterDown());
			living.setDoorsClosed(!living.isDoorClosed());
			living.setTvSwitchedOn(!living.isTvSwitchedOn());
			living.setTvChannel(randomInt(0, 99));
			living.setTvVolume(randomInt(0, 10));
			
			openDoors(living);
			closeDoors(living);
			
			
		}
		{
			Kitchen kitchen = house.getKitchen();
			kitchen.setAircoTemperature(randomInt(15, 25));
			kitchen.setLightLevel(randomFloat(0, 1));
			kitchen.setRollerShutterDown(!kitchen.isRollerShutterDown());
			kitchen.setDoorsClosed(!kitchen.isDoorClosed());
			kitchen.setCooktopSwitchedOn(!kitchen.isCooktopSwitchedOn());
			kitchen.setExtractorHoodSwitchedOn(!kitchen.isExtractorHoodSwitchedOn());
			kitchen.setRefrigeratorTemperature(randomInt(1, 15));
			kitchen.setFreezerTemperature(randomInt(-15, -1));
			
			openDoors(kitchen);
			closeDoors(kitchen);
		}
		{
			Bathroom bathroom = house.getBathroom();
			bathroom.setAircoTemperature(randomInt(15, 25));
			bathroom.setLightLevel(randomFloat(0, 1));
			bathroom.setRollerShutterDown(!bathroom.isRollerShutterDown());
			bathroom.setDoorsClosed(!bathroom.isDoorClosed());
			bathroom.setShowerTemperature(randomInt(10, 60));
			bathroom.setShowerFlowLevel(randomFloat(0, 1));
			bathroom.setTapTemperature(randomInt(10, 60));
			bathroom.setTapFlowLevel(randomFloat(0, 1));
			
			openDoors(bathroom);
			closeDoors(bathroom);
		}
		{
			Bedroom bedroom = house.getBedroom();
			bedroom.setAircoTemperature(randomInt(15, 25));
			bedroom.setLightLevel(randomFloat(0, 1));
			bedroom.setRollerShutterDown(!bedroom.isRollerShutterDown());
			bedroom.setDoorsClosed(!bedroom.isDoorClosed());
			bedroom.setAlarmSwitchedOn(!bedroom.isAlarmSwitchedOn());
			bedroom.setWaterbedTemperature(randomInt(10, 30));
			
			openDoors(bedroom);
			closeDoors(bedroom);
		}
	}
	
	public static void openDoors(DomoticaObject object) {
		openDoorCommand openCommand = new openDoorCommand(object);
		openCommand.execute();
		setLaatsteCommand(openCommand);
		object.update();
	}
	
	
	public static void closeDoors(DomoticaObject object) {
		closeDoorCommand closeCommand = new closeDoorCommand(object);
		closeCommand.execute();
		setLaatsteCommand(closeCommand);
		object.update();
	}
	
	public static void main(String[] args) throws DomoticaException {
		House house = new House("house");
			new HouseView(house);
		for (int i = 0; i < 100; i++) {
			round(house);
		}
		
		//testmethode
		
		Bedroom bedroom = house.getBedroom();
		openDoors(bedroom);
		closeDoors(bedroom);
		
		
	}

	public static command getLaatsteCommand() {
		return laatsteCommand;
	}

	public static void setLaatsteCommand(command laatsteCommand) {
		Test.laatsteCommand = laatsteCommand;
	}

}
