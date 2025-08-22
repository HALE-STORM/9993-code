package frc.robot.subsystems.AutoCommands;

import com.fasterxml.jackson.annotation.JsonTypeInfo.None;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.Elevator;
import frc.robot.subsystems.Shooter.Shooter;

public class AutoCommands extends SubsystemBase {
    public Shooter shooter = new Shooter();
    public Elevator botelevator = new Elevator();

    public double fourthLevel = 61.0111; //13.036621 / 13.331055
    public double elevatorBase = 0.5;

    public void updateDashboard() {
        shooter.updateDashboard();
    }

    public Command elevatorHeightfourth() {
        return botelevator.goToHeight(fourthLevel);
    }

    public Command smartShooter() {
        return shooter.smartShooter();
    }

    public Command smartIntake() {
        return shooter.smartIntake();
    }

    public Command autoIntake() {
        return shooter.autoIntake();
    }

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
