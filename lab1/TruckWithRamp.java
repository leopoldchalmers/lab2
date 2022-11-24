package lab1;

import java.awt.Color;

public class TruckWithRamp extends Truck implements HasRamp{
    private boolean rampRaised;
    private double rampAngle;
    private double rampAngleChange;

	public TruckWithRamp(int nrDoors, double enginePower, Color color) {
		super(nrDoors, enginePower, color);
        this.rampRaised = false;
        this.rampAngle = 0;
        this.rampAngleChange = 2.0;
	}

    @Override
	public void lowerRamp(){
        if (rampAngle - rampAngleChange > 0) {
            rampAngle -= rampAngleChange;
        } else {
            this.rampAngle = 0;
            this.setRampRaised(false);
        }
	}
    
    @Override
	public void raiseRamp() {
        if(super.getCurrentSpeed() <= 0) {
		    if(rampAngle + rampAngleChange < 70){
                rampAngle += rampAngleChange;
            } else {
                this.rampAngle = 70;
        }
        this.setRampRaised(true);
        }
	}

    protected void setRampRaised(boolean b) {
        this.rampRaised = b;
    }

    public boolean isRampRaised() {
        return this.rampRaised;
    }

    public double getRampAngle() {
        return this.rampAngle;
    }
    
}