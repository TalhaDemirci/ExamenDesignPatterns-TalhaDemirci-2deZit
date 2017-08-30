package domotica.model;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public abstract class DomoticaObject extends Observable implements Serializable {

	private String id;

	DomoticaObject(String id) {
		this.id = id;
	}

	public String getId() {	return id; }

	public String toString() {
		return getId();
	}
	
	public void setChanged() {
		super.setChanged();
	}
	
}
