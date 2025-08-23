package frc.robot.subsystems.AutoCommands;

//import com.fasterxml.jackson.annotation.JsonTypeInfo.None;

/* PETER - NOTE ABOUT PATH PLANNER
 * 
 * In order to get more accurate results via path planner, I am updating the setting variables that are off (probably from last year (2024))
 * Here are the original values.
 * Mass: 74.088
 * MOI: 6.883
 * Bumper Width and Length: 0.9
 * Wheel Radius: 0.048
 * Drive Gearing: 5.143
 * True Max Drive Speed: 5.45  
 * Wheel COF: 1.2
 * Drive Current Limit: 60
 * All offsets: 0.273
 * FL (X) +
 * FL (Y) +
 * FR (X) +
 * FR (Y) -
 * BL (X) -
 * BL (Y) +
 * BR (X) -
 * BR (Y) -
 */

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.Elevator;
import frc.robot.subsystems.Shooter.Shooter;

public class AutoCommands extends SubsystemBase {
    public Shooter shooter = new Shooter();
    public Elevator botelevator = new Elevator();

    public double fourthLevel = 61.0111; //13.036621 / 13.331055
    public double elevatorBase = 0;

    public Command elevatorHeightfourth() {
        return botelevator.goToHeight(fourthLevel);
    }
/*
    public Command smartShooter() {
        return shooter.smartShooter();
    }

    public Command smartIntake() {
        return shooter.smartIntake();
    }

    public Command autoIntake() {
        return shooter.autoIntake();
    }
*/
    public Command resetElevator() {
        return botelevator.goToHeight(elevatorBase);
    }

    public Command runShooter() {
        return shooter.runShooter();
    }

    public Command ejectShooter() {
        return shooter.ejectShooter();
    }

    public Command stopShooter() {
        return shooter.stopShooter();
    }

    public Command runIntake() {
        return shooter.runIntake();
    }
}
