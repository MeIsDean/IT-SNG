package de.hws.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import de.hws.data.*;

import view.ViewManager;

public class AppManager {

	private static AppManager instance;
	private ArrayList<Motocar> allCars = new ArrayList<Motocar>();
	private ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	
	
	private AppManager() {
		
	}
	
	public static AppManager getInstance() {
		if(instance == null) {
			instance = new AppManager();
		}
		return instance;
	}
	
	public long createId() {
		return (Long) null;
	}
	
	public void createMotocar(String licence, String name, String type, int km, Timestamp nextCheck, Location loc) {
		
	}
	
	public void deleteCar(String licence) {
		
	}
	
	private void writeCarsToFile(String filepath, List<Motocar> cars) {
		try {
			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(allCars);
			oos.close();
			} catch (IOException e) {
			ViewManager.getInstance().showMessage(ex.getLocalizedMessage());
			}
	}
	
	private List<Motocar> readCarsFromFile(String filepath){
		try {
			FileInputStream fis = new FileInputStream(filepath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			allCars = (ArrayList<Motocar>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		return allCars;
	}
	
	private void writeCustomersToFile(String filepath, List<Customer> customer) {
		
	}
	
	private List<Customer> readCustomerFromFile(String filepath){
		return null;
	}
	
	private void exportCustomersToFile(String filepath) {
	}
	
	private List<Customer> importCustomersToFile(String filepath){
		return null;
	}
	
	public void readData() {
		
	}
	
	public void saveData() {
		
	}
	
	public void importData() {
		
	}
	
	public void exportData() {
		
	}
	
	public List<Motocar> getCars(){
		return allCars;
	}
	public List<Customer> getCustomers(){
		return null;
	}
	
	public Motocar getSpecificCar(long id) {
		return null;
	}
	
	public void resetSelection() {
		
	}
	
	public void createCustomer(String name, String vorname, String adresse) {
		
	}
	
	public void deleteCustomer(int cid) {
		
	}
	
	public List<Customer> getCustomer(){
		return allCustomers;
	}
	
	public Customer getSpecificCustomer(long id) {
		return null;
	}
	
	public void addBike(BikeData bike) {
		bikeData.add(bike);
		writeDataToFile();
		}

	private void writeDataToFile() {
		// TODO Auto-generated method stub
		
	}

	
}
