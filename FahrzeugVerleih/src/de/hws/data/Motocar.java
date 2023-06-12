package de.hws.data;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import view.FileOutputStream;
import view.ViewManager;

public class Motocar implements Serializable {
	private long fzid;
	private String license;
	private String name;
	private String type;
	private int km;
	private Timestamp nextCheck;
	private List<Location> locations;
	// private SwingWaypoint swPoint;
	
	public Motocar(long fzId, String lic, String name, String type, int km, Timestamp nextCheck) {
		super();
		this.fzid = fzId;
		this.license = license;
		this.name = name;
		this.type = type;
		this.km = km;
		this.nextCheck = nextCheck;
	}
	
	public long getFzId() {
		return fzid;
	}
	
	public String getLicense() {
		return license;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getKm() {
		return km;
	}
	
	public void setKm(int km) {
		this.km = km;
	}
	
	public Timestamp getNextCheck() {
		return nextCheck;
	}
	
	public void setNextCheck (Timestamp nextCheck) {
		this.nextCheck = nextCheck;
	}
	
	public Location getLastPos() {
		if (locations != null && locations.size() >0) {
		}
		
	}
   
	public List<Location> getLocationList(){
		
		return locations;
	}
	
	public void addLocation(Location loc) {
		
	}
	
	// public SwingWaypoint getMyPoint () {
	//	return null;
	// }
	
	// public void setMyPoint (SwingWaypoint Swing) {
		
    //  }
	
	public String toString() {
		return null;
	}
	
	public String[] getCarData() {
		return null;
	}
	
	public String[] getCarColumns() {
		return null;
	}
	
	private void writeCarsToFile(String filePath) {
		try {
		FileOutputStream fos = new FileOutputStream(filepath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allCars);
		oos.close();
		} catch (IOException e) {
		ViewManager.getInstance().showMessage(ex.getLocalizedMessage());
		}
		}
	
	
	

}
