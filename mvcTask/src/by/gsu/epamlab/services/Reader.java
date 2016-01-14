package by.gsu.epamlab.services;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class Reader {
	
	private static enum KeyEnum { CONTROL, NUMBERS; }
	
	public String fileName;
	public String control;
	public String[] numbers;
	
	
	
	public Reader() {
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String[] getNumbers(){
		getLoadSettings();
		return numbers;
	}
	
	public String getControl() {
		return control;
	}

	private void getLoadSettings(){
		ResourceBundle resourcesBundle = ResourceBundle.getBundle(fileName);
		Enumeration<String> keys = resourcesBundle.getKeys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			KeyEnum keyEnum = KeyEnum.valueOf(key.toUpperCase());
			switch (keyEnum) {
				case  CONTROL: {
					this.control=resourcesBundle.getString(key).trim();
					break;
				}
				case NUMBERS: {
					String stringNumbers = resourcesBundle.getString(key);
					this.numbers=stringNumbers.split(",");
					break;
				}
			}
		}
	}
}
