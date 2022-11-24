package lab1;
import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

public class CarTransporter extends TruckWithRamp{
    private int maxCarCapacity;
    private int numLoadedCars;
    private ArrayList<Car> loadedCars;
    
    public CarTransporter(int nrDoors, double enginePower, Color color, int maxCarCapacity) {
        super(nrDoors, enginePower, color);
        this.maxCarCapacity = maxCarCapacity;
        this.numLoadedCars = 0;
        this.loadedCars = new ArrayList<Car>();
        this.raiseRamp();
    }
    @Override
    public void lowerRamp() {
        if (this.isStationary()) {
            super.setRampRaised(false);
        }
    }

    @Override
    public void raiseRamp() {
        if (this.isStationary()) {
            super.setRampRaised(true);
        }
    }

    @Override
    public void gas(double amount) {
        if (super.isRampRaised()){
            super.gas(amount);
        }
    }
    
    public void addCar(Car car){
        if (Math.abs(this.getXCord() - car.getXCord()) <= 5.0 && Math.abs(this.getYCord() - car.getYCord()) <= 5.0) {
            if (this.loadedCars.size() < this.maxCarCapacity && !super.isRampRaised()) {
                loadedCars.add(car);
            }
        }
    }
    
    public void unloadCar(Car car){
        if(this.loadedCars.size() > 0 && !super.isRampRaised()){
            loadedCars.remove(car);
            super.positionCar(this.getXCord() + 5, this.getYCord() + 5);
        }
    }

    public ArrayList<Car> getCars() {
        return this.loadedCars;
    }

    public int getNumLoadedCars() {
        return this.numLoadedCars;
    }

    public int getMaxCarCapacity() {
        return this.maxCarCapacity;
    }
}