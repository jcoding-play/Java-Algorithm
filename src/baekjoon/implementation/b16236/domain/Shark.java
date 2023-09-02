package baekjoon.implementation.b16236.domain;

import java.util.Objects;

public class Shark {
    private static final int DEFAULT_SHARK_SIZE = 2;

    private int size;
    private int numberOfEatenFish = 0;

    public Shark(int size) {
        this.size = size;
    }

    public Shark() {
        this(DEFAULT_SHARK_SIZE);
    }

    public boolean canMove(Board board, int x, int y) {
        return board.canSharkMoveTo(x, y, size);
    }

    public void eatFish(Board board, int x, int y) {
        if (board.canSharkEatFish(x, y, size)) {
            move(board, x, y);
            checkSize();
            return;
        }
        throw new IllegalArgumentException("상어의 크기보다 크거나 같은 물고기는 먹을 수 없습니다.");
    }

    public void move(Board board, int x, int y) {
        board.moveSharkTo(x, y);
    }

    private void checkSize() {
        numberOfEatenFish++;

        if (numberOfEatenFish == size) {
            size++;
            numberOfEatenFish = 0;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shark shark = (Shark) o;
        return size == shark.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
