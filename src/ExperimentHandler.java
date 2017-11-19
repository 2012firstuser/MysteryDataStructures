import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

public class ExperimentHandler {

    private static final int STEP = 100;
    private static final int DATA_POINTS = 100;
    private static final int TRIALS = 5;

    public Test _contains_firstAndLastTest,
                 _contains_anyElement;

    public ExperimentHandler() {
        _contains_firstAndLastTest = new CONTAINS_FirstAndLast();
        _contains_anyElement = new CONTAINS_MaxAndMin();
    }

    public static int[][] runTestAndAverageValues(Collection210X<Integer> c, Test test) {
        int[][] testResults = new int[DATA_POINTS][3];

        for(int trial = 0; trial < TRIALS; trial++) {
            int[][] trialResults = new int[DATA_POINTS][3];

            for(int currentStep = 1; currentStep < DATA_POINTS; currentStep++) {
                int n = currentStep * STEP;

                int[] result = test.runTest(c, n);

                testResults[currentStep][0] = n;
                testResults[currentStep][1] = testResults[currentStep][1] + result[1];
                testResults[currentStep][2] = testResults[currentStep][2] + result[2];
            }
        }

        for(int i = 0 ; i < DATA_POINTS; i++) {
            testResults[i][1] = testResults[i][1] / TRIALS;
            testResults[i][2] = testResults[i][2] / TRIALS;
        }

        return testResults;
    }

    public static int clockDifference(long startTime, long endTime) {
        return ((int) (endTime - startTime));
    }

    static class CONTAINS_FirstAndLast implements Test {
        @Override
        public int[] runTest(Collection210X<Integer> c, int n) {
            int firstElement = 0;
            int lastElement = 1;

            for(int i = 2; i < n + 2; i++) {
                c.add(i);
            }

            final long startBestCase = CPUClock.getNumTicks();
            c.contains(firstElement);
            final long endBestCase = CPUClock.getNumTicks();

            final long startWorstCase = CPUClock.getNumTicks();
            c.contains((lastElement));
            final long endWorstCase = CPUClock.getNumTicks();

            return new int[]{n, clockDifference(startBestCase, endBestCase), clockDifference(startWorstCase, endWorstCase)};
        }
    }

    static class CONTAINS_MaxAndMin implements Test{
        @Override
        public int[] runTest(Collection210X<Integer> c, int n) {
            return new int[0];
        }
    }
}
