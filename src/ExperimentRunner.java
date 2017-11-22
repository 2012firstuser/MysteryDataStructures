import com.cs210x.*;

/**
  * Class to deduce the identity of mystery data structures.
  */
public class ExperimentRunner {
	private static final int NUM_DATA_STRUCTURES_TO_DEDUCE = 5;

	public static void main (String[] args) throws Exception {
		final String cs210XTeamIDForProject4 = "ashaji"; // TODO CHANGE THIS TO THE TEAM ID YOU USE TO SUBMIT YOUR PROJECT3 ON INSTRUCT-ASSIST.

		// Fetch the collections whose type you must deduce.
		// Note -- you are free to change the type parameter from Integer to whatever you want. In this
		// case, make sure to replace (over the next 4 lines of code) Integer with whatever class you prefer.
		// In addition, you'll need to pass the method getMysteryDataStructure a "sample" (an instance) of 
		// the class you want the collection to store.

		final ExperimentHandler eh = new ExperimentHandler();
		final CSVCreator csvc = new CSVCreator();

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

			CSVCreator.exportData(ExperimentHandler.runTestAndAverageValues(dataStructure,
					eh._add_smallAndSorted), "1_runTestAndAverageValues", i);
			dataStructure.clear();

			CSVCreator.exportData(ExperimentHandler.runTestAndAverageValues(dataStructure,
					eh._contains_firstAndLastTest), "2_firstAndLastTest", i);
			dataStructure.clear();

			CSVCreator.exportData(ExperimentHandler.runTestAndAverageValues(dataStructure,
					eh._contains_maxAndMin), "3_containsTest", i);
			dataStructure.clear();

			CSVCreator.exportData(ExperimentHandler.runTestAndAverageValues(dataStructure,
					eh._remove_firstAndLast), "4_removeFirstLastTest", i);
			dataStructure.clear();

			CSVCreator.exportData(ExperimentHandler.runTestAndAverageValues(dataStructure,
					eh._remove_maxAndMin), "5_removeMaxMinTest", i);
			dataStructure.clear();

			CSVCreator.exportData(ExperimentHandler.runTestAndAverageValues(dataStructure,
					eh._remove_singleChildAndLast), "6_removeSingleChildAndLAst", i);
			dataStructure.clear();

			System.out.print("Structure ");
			System.out.print(i);
			System.out.println(" done");
		}
	}
}