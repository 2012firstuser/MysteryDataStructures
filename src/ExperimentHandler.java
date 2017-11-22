import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

/**
 * Outer class to store store all of the different experients that we ran  on the data structures
 */
public class ExperimentHandler {

    private static final int STEP = 100;
    private static final int DATA_POINTS = 100;
    private static final int TRIALS = 500;

    /**
     * Declaring all of the tests that we have
     */
    public Test _add_smallAndSorted,
                _contains_firstAndLastTest,
                _contains_maxAndMin,
                _remove_singleChildAndLast,
                _remove_firstAndLast,
                _remove_maxAndMin;

    /**
     * Constructor. Intilalizes all of the tests
     */
    public ExperimentHandler() {
        _add_smallAndSorted = new ADD_SmallAndSorted();
        _contains_firstAndLastTest = new CONTAINS_FirstAndLast();
        _contains_maxAndMin = new CONTAINS_MaxAndMin();
        _remove_singleChildAndLast = new REMOVE_SecondNodeAndLastElement();
        _remove_firstAndLast = new REMOVE_FirstAndLast();
        _remove_maxAndMin = new REMOVE_MaxAndMin();
    }

    /**
     * Test1 for the experiment. For greater detail, look at our report
     */
    static class ADD_SmallAndSorted implements Test {
        /**
         * Runs test1
         * @param c Mystery collection
         * @param n number of elements
         * @return Array of [n, bestCaseTime, worstCaseTime]
         */
        @Override
        public int[] runTest(Collection210X<Integer> c, int n) {
            final int rootNode = 5;

            for(int i = rootNode; i < n + rootNode; i++) {
                c.add(i);
            }

            final long startBestCase = CPUClock.getNumTicks();
            c.add(rootNode - 1);
            final long endBestCase = CPUClock.getNumTicks();

            final long startWorstCase = CPUClock.getNumTicks();
            c.add(n + rootNode + 1);
            final long endWorstCase = CPUClock.getNumTicks();

            return new int[]{n, clockDifference(startBestCase, endBestCase), clockDifference(startWorstCase, endWorstCase)};
        }
    }

    /**
     * Test2 for the experiment. For greater detail, look at our report
     */
    static class CONTAINS_FirstAndLast implements Test {
        /**
         * Runs test2
         * @param c Mystery collection
         * @param n number of elements
         * @return Array of [n, bestCaseTime, worstCaseTime]
         */
        @Override
        public int[] runTest(Collection210X<Integer> c, int n) {
            int firstElement = 0;
            int lastElement = 1;

            c.add(firstElement);

            for(int i = 2; i < n + 2; i++) {
                c.add(i);
            }

            c.add(lastElement);


            final long startBestCase = CPUClock.getNumTicks();
            c.contains(firstElement);
            final long endBestCase = CPUClock.getNumTicks();

            final long startWorstCase = CPUClock.getNumTicks();
            c.contains(lastElement);
            final long endWorstCase = CPUClock.getNumTicks();

            return new int[]{n, clockDifference(startBestCase, endBestCase), clockDifference(startWorstCase, endWorstCase)};
        }
    }

    /**
     * Test3 for the experiment. For greater detail, look at our report
     */
    static class CONTAINS_MaxAndMin implements Test{
        @Override
        /**
         * Runs test3
         * @param c Mystery collection
         * @param n number of elements
         * @return Array of [n, bestCaseTime, worstCaseTime]
         */
        public int[] runTest(Collection210X<Integer> c, int n) {
            int minValue = -1;
            int maxValue = Integer.MAX_VALUE - 100;

            for(int i = 0; i < n - 2; i++) {
                c.add((int) (i + (Math.random() * 1000)));

                if(i == n / 3) {
                    c.add(minValue);
                }
                if(i == n * 2 / 3) {
                    c.add(maxValue);
                }
            }

            final long startBestCase = CPUClock.getNumTicks();
            c.contains(maxValue);
            final long endBestCase = CPUClock.getNumTicks();

            final long startWorstCase = CPUClock.getNumTicks();
            c.contains(minValue);
            final long endWorstCase = CPUClock.getNumTicks();

            return new int[]{n, clockDifference(startBestCase, endBestCase), clockDifference(startWorstCase, endWorstCase)};
        }
    }

    /**
     * Test4 for the experiment. For greater detail, look at our report
     */
    static class REMOVE_SecondNodeAndLastElement implements Test {
        /**
         * Runs test4
         * @param c Mystery collection
         * @param n number of elements
         * @return Array of [n, bestCaseTime, worstCaseTime]
         */
        @Override
        public int[] runTest(Collection210X<Integer> c, int n) {
            final int rootNode = 5;
            final int rootNodeLeftChild = 3;
            final int maxValue = 10000;
            final int lastNode = maxValue + 5;

            c.add(rootNode);

            for(int i = rootNode; i < n + rootNode; i++) {
                c.add((int) (rootNode + (Math.random() * (maxValue - 5)) + 1));
            }

            c.add(rootNodeLeftChild);
            c.add(lastNode);

            final long startBestCase = CPUClock.getNumTicks();
            c.remove(rootNodeLeftChild);
            final long endBestCase = CPUClock.getNumTicks();

            c.add((n + rootNode) / 2);

            final long startWorstCase = CPUClock.getNumTicks();
            c.remove(lastNode);
            final long endWorstCase = CPUClock.getNumTicks();

            return new int[]{n, clockDifference(startBestCase, endBestCase), clockDifference(startWorstCase, endWorstCase)};
        }
    }

    /**
     * Test5 for the experiment. For greater detail, look at our report
     */
    static class REMOVE_FirstAndLast implements Test {
        /**
         * Runs test5
         * @param c Mystery collection
         * @param n number of elements
         * @return Array of [n, bestCaseTime, worstCaseTime]
         */
        @Override
        public int[] runTest(Collection210X<Integer> c, int n) {
            int firstElement = 0;
            int lastElement = 1;

            c.add(firstElement);

            for(int i = 2; i < n + 2; i++) {
                c.add(i);
            }

            c.add(lastElement);


            final long startBestCase = CPUClock.getNumTicks();
            c.remove(firstElement);
            final long endBestCase = CPUClock.getNumTicks();

            c.add(n / 2);

            final long startWorstCase = CPUClock.getNumTicks();
            c.remove(lastElement);
            final long endWorstCase = CPUClock.getNumTicks();

            return new int[]{n, clockDifference(startBestCase, endBestCase), clockDifference(startWorstCase, endWorstCase)};
        }
    }

    /**
     * Test6 for the experiment. For greater detail, look at our report
     */
    static class REMOVE_MaxAndMin implements Test {
        /**
         * Runs test6
         * @param c Mystery collection
         * @param n number of elements
         * @return Array of [n, bestCaseTime, worstCaseTime]
         */
        @Override
        public int[] runTest(Collection210X<Integer> c, int n) {
            int minValue = -1;
            int maxValue = Integer.MAX_VALUE - 100;

            // TODO: Remove duplicate code
            for(int i = 0; i < n - 2; i++) {
                c.add((int) (i * (Math.random() * 1000)));

                if(i == n / 3) {
                    c.add(minValue);
                }
                if(i == n * 2 / 3) {
                    c.add(maxValue);
                }
            }

            final long startBestCase = CPUClock.getNumTicks();
            c.remove(maxValue);
            final long endBestCase = CPUClock.getNumTicks();

            c.add(n/2);

            final long startWorstCase = CPUClock.getNumTicks();
            c.remove(minValue);
            final long endWorstCase = CPUClock.getNumTicks();

            return new int[]{n, clockDifference(startBestCase, endBestCase), clockDifference(startWorstCase, endWorstCase)};
        }
    }

    /**
     * Method to run test and average the values over TRIALS times. This method is kind of funky because it takes in
     * a class. That class must implement the test method, and this method will execute the runTest() method within
     * the Test. What we are essentially doing is creating a method pointer in Java
     * @param c MysteryDataStructure
     * @param test Which test to run on the MysteryDataStructure
     * @return 2D int array in the format [n, bestTime, worstTime] for all n in the data set
     */
    public static int[][] runTestAndAverageValues(Collection210X<Integer> c, Test test) {
        int[][] testResults = new int[DATA_POINTS][3];

        for(int trial = 0; trial < TRIALS; trial++) {
            for(int currentStep = 0; currentStep < DATA_POINTS; currentStep++) {
                int n = (currentStep + 1) * STEP;

                int[] result = test.runTest(c, n);

                testResults[currentStep][0] = n;
                testResults[currentStep][1] = testResults[currentStep][1] + result[1];
                testResults[currentStep][2] = testResults[currentStep][2] + result[2];

                c.clear();
            }
        }

        for(int i = 0 ; i < DATA_POINTS; i++) {
            testResults[i][1] = testResults[i][1] / TRIALS;
            testResults[i][2] = testResults[i][2] / TRIALS;
        }

        return testResults;
    }

    /**
     * Helper method to determien the difference between a start and end time
     * @param startTime time when the test was started
     * @param endTime time when the test was ended
     * @return the difference between the two times.
     */
    public static int clockDifference(long startTime, long endTime) {
        return ((int) (endTime - startTime));
    }
}
