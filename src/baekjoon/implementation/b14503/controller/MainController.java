package baekjoon.implementation.b14503.controller;

import baekjoon.implementation.b14503.domain.robot.Direction;
import baekjoon.implementation.b14503.domain.robot.Point;
import baekjoon.implementation.b14503.domain.robot.RobotCleaner;
import baekjoon.implementation.b14503.domain.robot.Room;
import baekjoon.implementation.b14503.service.CleaningService;
import baekjoon.implementation.b14503.view.InputView;
import baekjoon.implementation.b14503.view.OutputView;

import java.io.IOException;

public class MainController {
    private static final String DELIMITER = " ";

    private final InputView inputView;
    private final OutputView outputView;

    public MainController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() throws IOException {
        CleaningService cleaningService = initCleaningService();

        cleaningService.cleanRoom();
        outputView.printResult(cleaningService.getNumberOfCleanedPoint());
    }

    private CleaningService initCleaningService() throws IOException {
        String[] roomSize = inputView.inputRoomSize().split(DELIMITER);
        int N = Integer.parseInt(roomSize[0]);
        int M = Integer.parseInt(roomSize[1]);

        return new CleaningService(initRobotCleaner(), initRoom(N, M));
    }

    private RobotCleaner initRobotCleaner() throws IOException {
        String[] source = inputView.inputPointAndDirection().split(DELIMITER);

        return new RobotCleaner(initPoint(source), initDirection(source));
    }

    private Point initPoint(String[] source) {
        int row = Integer.parseInt(source[0]);
        int column = Integer.parseInt(source[1]);
        return new Point(row, column);
    }

    private Direction initDirection(String[] source) {
        int inputDirection = Integer.parseInt(source[2]);
        return new Direction(inputDirection);
    }

    private Room initRoom(int N, int M) throws IOException {
        int[][] roomInfo = inputView.inputRoomInfo(N, M);
        return new Room(roomInfo);
    }
}
