package basiclibrary;

import java.util.*;

public class Library {
    public int[] roll(int n) {
        // If a number less than 1 is passed, throw an error
        if (n < 1) {
            throw new IllegalArgumentException("Number of rolls must be greater than 0");
        }

        Random rand = new Random();
        int[] rolls = new int[n];

        for (int i = 0; i < rolls.length; i++) {
            //nextInt method returns value between 0 (inclusive) and specified bound (exclusive). For 1 - 6:
            int roll = rand.nextInt(6) + 1;
            rolls[i] = roll;
        }

        return rolls;
    }

    public boolean containsDuplicates(int[] arr) {
        // If an empty array is passed, throw an error
        if (arr.length == 0) {
            throw new IllegalArgumentException("Input array must not be empty.");
        }

        // I looked up how to use hash sets in Java because they're particularly suited to this kind of problem
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }

    public double calculateAverage(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Input array must not be empty.");
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (double) sum / arr.length;
    }

    public int[] findLowestAverageSubArray(int[][] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Input array must not be empty.");
        }

        // Initialize an array with nothing in it and a smallest average that caps at the primitive data type limit
        int[] lowestAverageSubArray = null;
        double lowestAverage = Double.MAX_VALUE;

        // Iterate over each array and update the smallestAverage and smallestSubarray
        for (int i = 0; i < arr.length; i++) {
            int[] subArray = arr[i];

            if (subArray.length == 0) {
                throw new IllegalArgumentException("Input array must not be empty.");
            }

            double average = calculateAverage(subArray);

            if (average < lowestAverage) {
                lowestAverage = average;
                lowestAverageSubArray = subArray;
            }
        }

        return lowestAverageSubArray;
    }

    public List<String> analyzeWeatherData(int[][] weatherData) {
        if (weatherData.length == 0) {
            throw new IllegalArgumentException("Input array must not be empty.");
        }

        Set<Integer> temperatureSet = new HashSet<>();
        int maxTemperature = Integer.MIN_VALUE;
        int minTemperature = Integer.MAX_VALUE;

        for (int i = 0; i < weatherData.length; i++) {
            if (weatherData[i].length == 0) {
                throw new IllegalArgumentException("Input array must not contain empty arrays.");
            }

            for (int j = 0; j< weatherData[i].length; j++) {
                int temperature = weatherData[i][j];
                if (!temperatureSet.contains(temperature)) {
                    temperatureSet.add((temperature));
                }
                if (maxTemperature < temperature) {
                    maxTemperature = temperature;
                }
                if (minTemperature > temperature) {
                    minTemperature = temperature;
                }
            }
        }

        // Report high/low
        System.out.printf("High: %d\n", maxTemperature);
        System.out.printf("Low: %d\n", minTemperature);

        // Iterate over the temperature range and add to unseenTemperatures
        List<String> unseenTemperatures = new ArrayList<>();
        for (int i = minTemperature + 1; i < maxTemperature; i++) {
            if (!temperatureSet.contains(i)) {
                String unseenTemperature = String.format("Never saw temperature: %d", i);
                unseenTemperatures.add(unseenTemperature);
                System.out.println(unseenTemperature);
            }
        }

        return unseenTemperatures;
    }

    public List<String> tally(List<String> votesList) {
        // The problem statement doesn't say there's exactly one winner. I've modified the return type to be a List<String> to handle multiple winners in the event of a tie.

        if (votesList.isEmpty()) {
            throw new IllegalArgumentException("Input List must not be empty.");
        }

        // Use a hash map to tally the votes and keep track of the winner and initialize a currentWinner in the hash map
        String currentWinner = "";
        HashMap<String, Integer> votes = new HashMap<>();
        // Keep track of the maximum number of votes
        int maxVotes = 0;

        for (String candidate : votesList) {
            if (candidate.isEmpty()) {
                throw new IllegalArgumentException("Input List must not contain empty strings.");
            }

            updateVotes(candidate, votes);
            int candidateVotes = votes.get(candidate);

            if (candidateVotes > maxVotes) {
                currentWinner = candidate;
                maxVotes = candidateVotes;
                // Check if there's a tie
            } else if (candidateVotes == maxVotes && !currentWinner.equals(candidate)) {
                // Since there is no current winner, set it to an empty string
                currentWinner = "";
                maxVotes = candidateVotes;
            }
        }

        // Create a list to store the winner or winners
        List<String> winners = new ArrayList<>();

        // Loop through the candidates again and add any tied candidates to the list of winners
        for (String candidate : votes.keySet()) {
            if (votes.get(candidate) == maxVotes) {
                winners.add(candidate);
            }
        }

        return winners;
    }

    public void updateVotes(String candidate, HashMap<String, Integer> votes) {
        if (!votes.containsKey(candidate)) {
            votes.put(candidate, 1);
        } else {
            votes.put(candidate, votes.get(candidate) + 1);
        }
    }
}