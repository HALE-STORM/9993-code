package frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix6.hardware.TalonFX;


public class Shooter  extends SubsystemBase {
    private final TalonFX ShooterMotor = new TalonFX(2);
    public final AnalogInput analogBeam = new AnalogInput(0);
    public final int beamDistance = 10; //Change this to change what distance the analog beam break detects as an object

    
public Shooter(){
    setDefaultCommand(stopShooter().ignoringDisable(true));
}

   
    public Command runShooter() {
      return Commands.run(
          () -> ShooterMotor.setVoltage(4),
  
          this
      );
    }

    public Command runIntake() {
      return Commands.run(
        () -> ShooterMotor.setVoltage(1),

        this
        );
    }
  
  
    public Command ejectShooter() {
      return Commands.run(
          () -> ShooterMotor.setVoltage(-0.5)
      );
    }
  
    public Command stopShooter(){
      return Commands.run(
        () -> ShooterMotor.setVoltage(0),
        this
      );
    }

    public Command autoIntake() {
      return runIntake().until(beamBroken)
      //.andThen(runEjectShooter().until(beamNotBroken))
      .andThen(stopShooter());
    }
    
    public Command smartIntake(){
      return runIntake().until(beamBroken)
      //.andThen(runEjectShooter().until(beamNotBroken))
      .andThen(stopShooter());
    
    }

    public Command smartShooter() {
      return runIntake().until(beamNotBroken); // Runs auto intake until the beam is not broken.
    }





    
  public double getRawValue() {  
    return analogBeam.getValue();
  }
  
  public double getVoltage() {
    return analogBeam.getVoltage();
  }
  

  public void updateDashboard() {
    SmartDashboard.putNumber("Beam Raw Value", getRawValue());
    SmartDashboard.putNumber("Beam Voltage", getVoltage());
    SmartDashboard.putNumber("Beam Threshold", beamDistance);
    //SmartDashboard.putBoolean("Beam Broken", beamBroken);
  }
  
  public BooleanSupplier beamBroken = () -> analogBeam.getValue() <= beamDistance;
  public BooleanSupplier beamNotBroken = () -> analogBeam.getValue() > beamDistance;


  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}




