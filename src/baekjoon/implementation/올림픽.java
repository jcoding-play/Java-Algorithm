package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 올림픽 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        Countries countries = new Countries(initCountry(N));

        System.out.println(countries.findRankingOf(K));
    }

    private static List<Country> initCountry(int N) throws IOException {
        List<Country> countries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            countries.add(generateCountry());
        }

        return countries;
    }

    private static Country generateCountry() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int countryId = Integer.parseInt(tokenizer.nextToken());
        Medal medal = initMedal();

        return new Country(countryId, medal);
    }

    private static Medal initMedal() {
        int gold = Integer.parseInt(tokenizer.nextToken());
        int silver = Integer.parseInt(tokenizer.nextToken());
        int bronze = Integer.parseInt(tokenizer.nextToken());

        return new Medal(gold, silver, bronze);
    }

    static class Countries {
        private final List<Country> counties;

        public Countries(List<Country> countries) {
            this.counties = countries;
        }

        public int findRankingOf(int countryId) {
            Map<Integer, Integer> rankings = findRankings();

            return rankings.get(countryId);
        }

        private Map<Integer, Integer> findRankings() {
            Collections.sort(counties);

            Map<Integer, Integer> rankings = new LinkedHashMap<>();
            for (int index = 0; index < counties.size(); index++) {
                Country currentCountry = counties.get(index);
                int ranking = calculateRanking(index, currentCountry);

                rankings.put(currentCountry.getCountryId(), ranking);
            }
            return rankings;
        }

        private int calculateRanking(int currentCountryIndex, Country currentCountry) {
            int ranking = 1;

            for (int nextCountryIndex = currentCountryIndex - 1; nextCountryIndex >= 0; nextCountryIndex--) {
                Country nextCountry = counties.get(nextCountryIndex);
                if (currentCountry.hasSameMedal(nextCountry)) {
                    continue;
                }
                ranking += (nextCountryIndex + 1);
                break;
            }

            return ranking;
        }
    }

    static class Country implements Comparable<Country> {
        private final int countryId;
        private final Medal medal;

        public Country(int countryId, Medal medal) {
            this.countryId = countryId;
            this.medal = medal;
        }

        public boolean hasSameMedal(Country country) {
            return country.isMatchMedal(medal);
        }

        private boolean isMatchMedal(Medal medal) {
            return this.medal.equals(medal);
        }

        public int getCountryId() {
            return countryId;
        }

        @Override
        public int compareTo(Country other) {
            return this.medal.compareTo(other.medal);
        }
    }

    static class Medal implements Comparable<Medal> {
        private final int gold;
        private final int silver;
        private final int bronze;

        public Medal(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
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
}
