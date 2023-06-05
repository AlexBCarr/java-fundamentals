package basiclibrary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void testNumberOfRolls() {
        Library classUnderTest = new Library();
        // Ensure that rolls array returns the right number of rolls
        int[] rolls = classUnderTest.roll(5);
        int numberOfRolls = rolls.length;
        assertEquals(5, numberOfRolls);
    }

    @Test void testRollsRange() {
        // Ensure that rolls array returns rolls that are between 1 and 6 for every roll
        Library classUnderTest = new Library();
        int[] rolls = classUnderTest.roll(5);
        for (int roll : rolls) {
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test void testRollIllegalArgumentException() {
        try {
            Library classUnderTest = new Library();
            classUnderTest.roll(-2);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test void testContainsDuplicatesIsTrue() {
        Library classUnderTest = new Library();
        int[] testArr = {1, 2, 3, 4, 4};
        assertTrue(classUnderTest.containsDuplicates(testArr));
    }

    @Test void testContainsDuplicatesIsFalse() {
        Library classUnderTest = new Library();
        int[] testArr = {1, 2, 3, 4, 5};
        assertFalse(classUnderTest.containsDuplicates(testArr));
    }

    @Test void testContainsDuplicatesIllegalArgumentException() {
        try {
            Library classUnderTest = new Library();
            int[] testArr = {};
            classUnderTest.containsDuplicates(testArr);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test void testCalculateAverageWithDelta() {
        Library classUnderTest = new Library();
        int[] testArr = {2, 2, 2, 2, 2};
        int expectedAverage = 2;
        // set delta to avoid floating point imprecision
        double delta = 0.00001;
        double actualAverage = classUnderTest.calculateAverage(testArr);
        assertEquals(expectedAverage, actualAverage, delta);
    }

    @Test void testCalculateAverageIllegalArgumentException() {
        try {
            Library classUnderTest = new Library();
            int[] testArr = {};
            classUnderTest.calculateAverage(testArr);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test void testFindLowestAverageSubArray() {
        Library classUnderTest = new Library();
        int[][] testArr = {
                {0, 0, 0, 2, 3, 4, 5},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };
        int[] expectedArr = {0, 0, 0, 2, 3, 4, 5};
        int[] actualArr = classUnderTest.findLowestAverageSubArray(testArr);
        assertArrayEquals(expectedArr, actualArr);
    }

    @Test void testFindLowestAverageSubArrayOuterArrayIllegalArgumentException() {
        try {
            Library classUnderTest = new Library();
            int[][] testArr = {};
            classUnderTest.findLowestAverageSubArray(testArr);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test void testFindLowestAverageSubArrayInnerArrayIllegalArgumentException() {
        try {
            Library classUnderTest = new Library();
            int[][] testArr = {
                    {},
                    {57, 65, 65, 70, 72, 65, 51},
                    {55, 54, 60, 53, 59, 57, 61},
                    {65, 56, 55, 52, 55, 62, 57}
            };
            classUnderTest.findLowestAverageSubArray(testArr);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test void testAnalyzeWeatherDataUnseenTemperatures() {
        Library classUnderTest = new Library();
        int[][] testArr = {
                {66, 64, 58, 65, 70, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };

        List<String> expectedArrayList = new ArrayList<>(Arrays.asList(
                "Never saw temperature: 63",
                "Never saw temperature: 67",
                "Never saw temperature: 68",
                "Never saw temperature: 69",
                "Never saw temperature: 71"

        ));
        List<String> actualArrayList = classUnderTest.analyzeWeatherData(testArr);
        assertIterableEquals(expectedArrayList, actualArrayList);
    }

    @Test void testAnalyzeWeatherDataOuterArrayIllegalArgumentException() {
        try {
            Library classUnderTest = new Library();
            int[][] testArr = {};
            classUnderTest.findLowestAverageSubArray(testArr);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test void testAnalyzeWeatherDataInnerArrayIllegalArgumentException() {
        try {
            Library classUnderTest = new Library();
            int[][] testArr = {
                    {},
                    {57, 65, 65, 70, 72, 65, 51},
                    {55, 54, 60, 53, 59, 57, 61},
                    {65, 56, 55, 52, 55, 62, 57}
            };
            classUnderTest.findLowestAverageSubArray(testArr);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test
    public void testTallForSingleWinner() {
        Library classUnderTest = new Library();
        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Bush");
        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("Bush");
        List<String> actualWinners = classUnderTest.tally(votes);
        assertEquals(expectedWinners, actualWinners);
    }

    @Test
    public void testTallyForTie() {
        Library classUnderTest = new Library();
        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Hedge");
        votes.add("Hedge");
        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("Bush");
        expectedWinners.add("Hedge");
        List<String> actualWinners = classUnderTest.tally(votes);
        assertTrue(actualWinners.containsAll(expectedWinners), "The list should contain both Bush and Hedge");
    }

    @Test void testTallyForEmptyList() {
        try {
            Library classUnderTest = new Library();
            List<String> votes = new ArrayList<>();
            classUnderTest.tally(votes);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test void testTallyForEmptyString() {
        try {
            Library classUnderTest = new Library();
            List<String> votes = new ArrayList<>();
            votes.add("Bush");
            votes.add("");
            votes.add("Hedge");
            classUnderTest.tally(votes);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
        }
    }

    @Test
    public void testUpdateVotesForExistingCandidate() {
        Library classUnderTest = new Library();
        HashMap<String, Integer> votes = new HashMap<>();
        votes.put("Bush", 2);
        String candidate = "Bush";
        classUnderTest.updateVotes(candidate, votes);
        assertEquals(3, votes.get(candidate));
    }

    @Test
    public void testUpdateVotesForNewCandidate() {
        Library classUnderTest = new Library();
        HashMap<String, Integer> votes = new HashMap<>();
        String candidate = "Shrub";
        classUnderTest.updateVotes(candidate, votes);
        assertEquals(1, votes.get(candidate));
    }
}
