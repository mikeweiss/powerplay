package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.teamcode.models.MotorPositions

//Defines the motors and (possible) sensors
class CDHardware(hwMap: HardwareMap) {
    // Wheel motors
    var leftFrontMotor: DcMotor
    var rightFrontMotor: DcMotor
    var leftRearMotor: DcMotor
    var rightRearMotor: DcMotor

    init {
        //Defines Hardware map from Control Hub
        //TODO: Need to double check motor mapping on the driver hub and check orientation
        leftFrontMotor = hwMap.get(DcMotor::class.java, "motorLF")
        rightFrontMotor = hwMap.get(DcMotor::class.java, "motorRF")
        leftRearMotor = hwMap.get(DcMotor::class.java, "motorLR")
        rightRearMotor = hwMap.get(DcMotor::class.java, "motorRR")
    }

    fun getPositions(): MotorPositions {
        return MotorPositions(
            leftFront = leftFrontMotor.currentPosition,
            leftRear = leftRearMotor.currentPosition,
            rightFront = rightFrontMotor.currentPosition,
            rightRear = rightRearMotor.currentPosition
        )
    }

    fun setTargetPositions(motorPositions: MotorPositions) {
        leftFrontMotor.targetPosition = motorPositions.leftFront
        leftRearMotor.targetPosition = motorPositions.leftRear
        rightFrontMotor.targetPosition = motorPositions.rightFront
        rightRearMotor.targetPosition = motorPositions.rightRear
    }
}