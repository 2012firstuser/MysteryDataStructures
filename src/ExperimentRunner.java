import java.util.*;
import com.cs210x.*;

import javax.sound.midi.SysexMessage;

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

		System.out.println(Test1(Ns, mysteryDataStructures));
	}

	public static ArrayList<ArrayList<Integer[]>> Test1(int[] Ns, Collection210X<Integer>[] mysteryDataStructures){
		ArrayList<ArrayList<Integer[]>> masterResult = new ArrayList<ArrayList<Integer[]>>();
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		final int topNode = 5;
		for(int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i ++) {
			for (int N = 0; N < Ns.length; N++) {
				fillList(mysteryDataStructures[i], Ns[N], topNode);
				Integer[] tempResult = {Ns[N], (int) checkAddBest(mysteryDataStructures[i], topNode), (int) checkAddWorst(mysteryDataStructures[i], Ns[N], topNode)};
				results.add(tempResult);

				mysteryDataStructures[i].clear();
			}
			masterResult.add((ArrayList<Integer[]>) results.clone());
			results.clear();
		}

		return masterResult;
	}

	public static ArrayList<ArrayList<Integer[]>> Test6(int[] Ns, Collection210X<Integer>[] mysteryDataStructures){
		ArrayList<ArrayList<Integer[]>> masterResult = new ArrayList<ArrayList<Integer[]>>();
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		final int topNode = 5;
		for(int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i ++) {
			for (int N = 0; N < Ns.length; N++) {
				fillList(mysteryDataStructures[i], Ns[N], topNode);
				Integer[] tempResult = {Ns[N], (int) checkBSTRemoveBest(mysteryDataStructures[i], topNode), (int) checkBSTRmoveWorst(mysteryDataStructures[i], Ns[N], topNode)};
				results.add(tempResult);

				mysteryDataStructures[i].clear();
			}
			masterResult.add((ArrayList<Integer[]>) results.clone());
			results.clear();

		}
		return masterResult;
	}

	public static void fillList(Collection210X<Integer> c, int N, int S){
		for(int i = S; i < N + S; i++){
			c.add(i);
		}
	}

	public static long checkAddBest(Collection210X<Integer> c, int S){
		final long startBest = CPUClock.getNumTicks();
		c.add(S - 1);
		final long endBest = CPUClock.getNumTicks();

		return (endBest-startBest);
	}

	public static long checkAddWorst(Collection210X<Integer> c, int N, int S){
		final long startWorst = CPUClock.getNumTicks();
		c.add(N + S + 1);
		final long endWorst = CPUClock.getNumTicks();

		return (endWorst-startWorst);
	}

	public static long checkBSTRemoveBest(Collection210X<Integer> c, int S){
		c.add(S - 1);
		final long startBest = CPUClock.getNumTicks();
		c.remove(S - 1);
		final long endBest = CPUClock.getNumTicks();

		return (endBest-startBest);
	}

	public static long checkBSTRmoveWorst(Collection210X<Integer> c, int N, int S){
		final long startWorst = CPUClock.getNumTicks();
		c.remove(N + S + 1);
		final long endWorst = CPUClock.getNumTicks();

		return (endWorst-startWorst);
	}
}