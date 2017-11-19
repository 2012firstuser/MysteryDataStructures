import com.cs210x.*;

/**
  * Class to deduce the identity of mystery data structures.
  */
public class ExperimentRunner {
	private static final int NUM_DATA_STRUCTURES_TO_DEDUCE = 5;

	public static void main (String[] args) {
		final String cs210XTeamIDForProject4 = "ashaji"; // TODO CHANGE THIS TO THE TEAM ID YOU USE TO SUBMIT YOUR PROJECT3 ON INSTRUCT-ASSIST.

		// Fetch the collections whose type you must deduce.
		// Note -- you are free to change the type parameter from Integer to whatever you want. In this
		// case, make sure to replace (over the next 4 lines of code) Integer with whatever class you prefer.
		// In addition, you'll need to pass the method getMysteryDataStructure a "sample" (an instance) of 
		// the class you want the collection to store.

		final ExperimentHandler eh = new ExperimentHandler();

		@SuppressWarnings("unchecked")
		final Collection210X<Integer>[] mysteryDataStructures = (Collection210X<Integer>[]) new Collection210X[NUM_DATA_STRUCTURES_TO_DEDUCE];

		for (int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			mysteryDataStructures[i] = MysteryDataStructure.getMysteryDataStructure(cs210XTeamIDForProject4.hashCode(), i, new Integer(0));
		}

		// Write a table of numbers (for different N -- here, we are just showing one value for simplicity) showing
		// the relationship between N and the time-cost associated with searching (with the contains method) through
		// a collection of N data.

		for(int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			Collection210X<Integer> dataStructure = mysteryDataStructures[i];

			System.out.print("Structure: ");
			System.out.println(i);

			int[][] sas = ExperimentHandler.runTestAndAverageValues(dataStructure, eh._add_smallAndSorted);

			dataStructure.clear();

			int[][] cfl = ExperimentHandler.runTestAndAverageValues(dataStructure, eh._contains_firstAndLastTest);

			dataStructure.clear();

			int[][] cmm = ExperimentHandler.runTestAndAverageValues(dataStructure, eh._contains_maxAndMin);

			dataStructure.clear();

			int[][] rs = ExperimentHandler.runTestAndAverageValues(dataStructure, eh._remove_singleChildAndLast);

			System.out.println("Add Small and Big Sorted");
			for(int j = 0; j < sas.length; j++) {
				System.out.print("n: ");
				System.out.print(sas[j][0]);
				System.out.print(" Best Case: ");
				System.out.print(sas[j][1]);
				System.out.print(" Worst Case: ");
				System.out.println(sas[j][2]);
			}

			System.out.println("Contains First and Last");
			for(int j = 0; j < cfl.length; j++) {
				System.out.print("n: ");
				System.out.print(cfl[j][0]);
				System.out.print(" Best Case: ");
				System.out.print(cfl[j][1]);
				System.out.print(" Worst Case: ");
				System.out.println(cfl[j][2]);
			}

			System.out.println("Contains Max and Min");
			for(int j = 0; j < cmm.length; j++) {
				System.out.print("n: ");
				System.out.print(cmm[j][0]);
				System.out.print(" Best Case: ");
				System.out.print(cmm[j][1]);
				System.out.print(" Worst Case: ");
				System.out.println(cmm[j][2]);
			}

			System.out.println("Remove Special");
			for(int j = 0; j < rs.length; j++) {
				System.out.print("n: ");
				System.out.print(rs[j][0]);
				System.out.print(" Best Case: ");
				System.out.print(rs[j][1]);
				System.out.print(" Worst Case: ");
				System.out.println(rs[j][2]);
			}
		}
	}
}