package org.firstinspires.ftc.teamcode.drive.robot;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.geometry.Vector2d;
@Config
@Autonomous(group = "robot")
public class AutoTest1 extends LinearOpMode {


    @Override
//wait for start

        public void runOpMode() {
            SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

            // We want to start the bot at x: 10, y: -8, heading: 90 degrees
            Pose2d startPose = new Pose2d(-63, 50, Math.toRadians(0));

            drive.setPoseEstimate(startPose);

            Trajectory traj1 = drive.trajectoryBuilder(startPose)
                    .splineTo(new Vector2d(0, 40), Math.toRadians(0))
                    .build();

            Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                    .strafeLeft(20)
                    .build();

            drive.followTrajectory(traj1);
            drive.followTrajectory(traj2);
    }
}