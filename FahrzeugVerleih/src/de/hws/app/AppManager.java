package de.hws.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.hws.data.Customer;
import de.hws.data.Location;
import de.hws.data.Motocar;
import view.ViewManager;

public class AppManager implements Serializable {

	private static AppManager instance;
	private List<Motocar> allCars = new ArrayList<Motocar>();
	private List<Customer> allCustomers = new ArrayList<Customer>();

	private AppManager() {

	}

	public static AppManager getInstance() {

		if (instance == null) {
			instance = new AppManager();
		}
		return null;

	}

	public long createId(String license, String name, String type, int km, Timestamp nextCheck, Location loc) {
		return 0;

	}

	public void createMotorcar() {

	}

	public void deleteCar(String license) {

	}

	private void writeCarsToFile(String filepath) {
		try {
			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(allCars);
			oos.close();
		} catch (IOException e) {
			ViewManager.getInstance().showMessage(e.getLocalizedMessage());
		}
	}

	private void readCarsFromFile(String filepath) {
		try {
			FileInputStream fis = new FileInputStream(filepath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			allCars = (ArrayList<Motocar>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void exportCarsToFile(String filepath) {

	}

	private List<Motocar> importCarsFromFile(String filepath) {
		return null;

	}

	private void writeCustomersToFile(String filepath, List<Motocar> cars) {
		try {
			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(allCustomers);
			oos.close();
		} catch (IOException e) {
			ViewManager.getInstance().showMessage(e.getLocalizedMessage());
		}
	}

	private void readCustomersFromFile(String filepath) {
		try {
			FileInputStream fis = new FileInputStream(filepath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			allCustomers = (ArrayList<Customer>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void exportCustomersToFile(String filepath) {

	}

	private List<Customer> importCustomersFromFile(String filepath) {
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

	public List<Motocar> getCars() {
		return null;
	}

	public List<Customer> getCustomers() {
		return null;
	}

	public Motocar getSpecificCar(long id) {
		return null;

	}

	public void resetSelections() {

	}

	public void createCustomer(String name, String vorname, String adresse) {

	}

	public void deleteCustomer(int cld) {

	}

	public List<Customer> getCustomer() {
		return null;

	}

	public Customer getSpecificCustomer(long id) {
		return null;

	}

	public void addBike(BikeData bike) {
		bikeData.add(bike);
		writeDataToFile();
	}

	public void writeDataToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("bikedata.json");
			DataOutputStream dos = new DataOutputStream(fos);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(bikeData);
			dos.writeUTF(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readDataFromFile() {
		try {
			FileInputStream fis = new FileInputStream("bikedata.json");
			DataInputStream dis = new DataInputStream(fis);
			String json = dis.readUTF();
			Gson gson = new Gson();
			bikeData = gson.fromJson(json, ArrayList.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
