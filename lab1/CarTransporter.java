package lab1;
import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends TruckWithRamp{
    private int maxCarCapacity;
    private int numLoadedCars;
    private ArrayList<Car> loadedCars;
    
    public CarTransporter(int nrDoors, double enginePower, Color color, int maxCarCapacity) {
        super(nrDoors, enginePower, color);
        this.maxCarCapacity = maxCarCapacity;
        this.numLoadedCars = 0;
        this.loadedCars = new ArrayList<Car>();
    }
    @Override
    public void lowerRamp() {
        super.setRampRaised(false);
    }

    @Override
    public void raiseRamp() {
        super.setRampRaised(true);
    }

    
    public void addCar(Car car){
        if(this.loadedCars.size() < this.maxCarCapacity){
            loadedCars.add(car);
        }
    }
    public void removeCar(Car car){
        if(this.loadedCars.size() > 0){
            loadedCars.remove(car);
            
        }
    }
}