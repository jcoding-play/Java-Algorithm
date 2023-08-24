package baekjoon.implementation.b14503.service;

import baekjoon.implementation.b14503.domain.robot.RobotCleaner;
import baekjoon.implementation.b14503.domain.robot.Room;

public class CleaningService {
    private final RobotCleaner robotCleaner;
    private final Room room;
    private int numberOfCleanedPoint = 0;

    public CleaningService(RobotCleaner robotCleaner, Room room) {
        this.robotCleaner = robotCleaner;
        this.room = room;
    }

    public void cleanRoom() {
        firstStep();
        secondStep();
    }

    private void firstStep() {
        if (!robotCleaner.isCleanedPoint(room)) {
            robotCleaner.cleanCurrentPoint(room);
            numberOfCleanedPoint++;
        }
    }

    private void secondStep() {
        if (robotCleaner.hasNotUncleanedPointAround(room)) {
            if (robotCleaner.canMoveBackward(room)) {
                robotCleaner.moveBackward();
                cleanRoom();
            }
            return;
        }

        thirdStep();
    }

    private void thirdStep() {
        while (true) {
            robotCleaner.turn();

            if (robotCleaner.canMoveForward(room)) {
                robotCleaner.moveForward();
                cleanRoom();
                return;
            }
        }
    }

    public int getNumberOfCleanedPoint() {
        return numberOfCleanedPoint;
    }
}