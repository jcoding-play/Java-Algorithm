package baekjoon.implementation.b8979.domain;

import java.util.Objects;

public class Medal implements Comparable<Medal> {
    private static final int MIN_NUMBER_OF_MEDAL = 0;

    private final int gold;
    private final int silver;
    private final int bronze;

    public Medal(int gold, int silver, int bronze) {
        validateMedal(gold, silver, bronze);

        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    private void validateMedal(int gold, int silver, int bronze) {
        if (gold < MIN_NUMBER_OF_MEDAL || silver < MIN_NUMBER_OF_MEDAL || bronze < MIN_NUMBER_OF_MEDAL) {
            throw new IllegalArgumentException("메달의 개수가 0보다 작을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medal medal = (Medal) o;
        return gold == medal.gold && silver == medal.silver && bronze == medal.bronze;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gold, silver, bronze);
    }

    @Override
    public int compareTo(Medal other) {
        if (this.gold == other.gold && this.silver == other.silver) {
            return other.bronze - this.bronze;
        }
        if (this.gold == other.gold) {
            return other.silver - this.silver;
        }
        return other.gold - this.gold;
    }
}
