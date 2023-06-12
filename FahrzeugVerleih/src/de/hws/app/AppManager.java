package de.hws.app;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import de.hws.data.*;

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
		
	}
	
	private List<Motocar> readCarsFromFile(String filepath){
		return null;
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
	
	
}
