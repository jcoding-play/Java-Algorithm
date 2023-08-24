package baekjoon.implementation.b14503.domain.strategy;

@FunctionalInterface
public interface MovingStrategy {

    int[] move(int row, int column, int direction);
}
