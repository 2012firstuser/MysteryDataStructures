import java.util.*;
import com.cs210x.*;
import javafx.scene.chart.XYChart;
import sun.plugin2.gluegen.runtime.CPU;

/**
  * Class to deduce the identity of mystery data structures.
  */
public class ExperimentRunner {
	private static final int NUM_DATA_STRUCTURES_TO_DEDUCE = 5;

	public static void main (String[] args) {
		final String cs210XTeamIDForProject4 = "ashaji"; // TODO CHANGE THIS TO THE TEAM ID YOU USE TO SUBMIT YOUR PROJECT3 ON INSTRUCT-ASSIST.
		final int[] Ns = { 1, 2, 5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };

		// Fetch the collections whose type you must deduce.
		// Note -- you are free to change the type parameter from Integer to whatever you want. In this
		// case, make sure to replace (over the next 4 lines of code) Integer with whatever class you prefer.
		// In addition, you'll need to pass the method getMysteryDataStructure a "sample" (an instance) of 
		// the class you want the collection to store.

		@SuppressWarnings("unchecked")
		final Collection210X<Integer>[] mysteryDataStructures = (Collection210X<Integer>[]) new Collection210X[NUM_DATA_STRUCTURES_TO_DEDUCE];

		for (int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			mysteryDataStructures[i] = MysteryDataStructure.getMysteryDataStructure(cs210XTeamIDForProject4.hashCode(), i, new Integer(0));
		}

		// Write a table of numbers (for different N -- here, we are just showing one value for simplicity) showing
		// the relationship between N and the time-cost associated with searching (with the contains method) through
		// a collection of N data.

		for(int N = 0; N < Ns.length; N++) {
			System.out.println(Ns[N]);
			for (int i = 0; i < 5; i++) {
				checkBSTAdd(mysteryDataStructures[i], Ns[N]);
				mysteryDataStructures[i].clear();
			}
		}
	}

	public static void checkBSTAdd(Collection210X<Integer> c, int N){
		int S = 5;
		for(int i = 0; i < N + S; i++){
			c.add(i);
		}

		final long startBest = CPUClock.getNumTicks();
		c.add(S - 2);
		final long endBest = CPUClock.getNumTicks();

		final long startWorst = CPUClock.getNumTicks();
		c.add(N + S + 2);
		final long endWorst = CPUClock.getNumTicks();

		System.out.println("Best:" + "\t" + (endBest-startBest));
		System.out.println("Worst:" + "\t" + (endWorst-startWorst));
	}
}