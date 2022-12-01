package lab2;

import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    private String modelName; // The car model name
    
    public Saab95(){
        super(2, 125.0, Color.red);
        this.modelName = "Saab95";
        this.turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) {
            turbo = 1.3;
        } 
        return enginePower * 0.01 * turbo;
    }

}
