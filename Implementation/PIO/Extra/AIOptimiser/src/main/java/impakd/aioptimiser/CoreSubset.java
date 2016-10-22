package impakd.aioptimiser;

/**
 *
 * @author Priscilla
 */

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.jamesframework.core.subset.SubsetProblem;
import org.jamesframework.core.subset.SubsetSolution;
import org.jamesframework.core.search.algo.RandomDescent;
import org.jamesframework.core.subset.neigh.SingleSwapNeighbourhood;
import org.jamesframework.core.search.stopcriteria.MaxRuntime;
import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

//import org.jamesframework.examples.util.ProgressSearchListener;

/**
 * Main class for the basic core subset selection example (example 1A).
 * 
 * @author <a href="mailto:herman.debeukelaer@ugent.be">Herman De Beukelaer</a>
 */
public class CoreSubset {
    
    /**
     * Runs the core subset selection problem. Expects three parameters: (1) the input file path, (2) the desired
     * core subset size and (3) the runtime limit (in seconds). The input is specified in a CSV file in which the
     * first row (header) lists the N item names and the subsequent N rows describe a symmetric (N x N) distance matrix.
     * The distance matrix indicates the distance between each pair of items, where the rows follow the same order as
     * the columns, as indicated by the header row.
     * 
     * @param args array containing the input file path, subset size and runtime limit
     */
    public static void main(String[] args) {
        
        System.out.println("PARTICLE SWARM OPTIMISATION");
        //configure and run this experiment
		NondominatedPopulation result = new Executor()
				.withProblem("UF1")
				.withAlgorithm("NSGAII")
				.withMaxEvaluations(10000)
				.run();
		
		//display the results
		System.out.format("Objective1  Objective2%n");
		
		for (Solution solution : result) {
			System.out.format("%.4f      %.4f%n",
					solution.getObjective(0),
					solution.getObjective(1));
		}
        
        System.out.println("#########################");
        System.out.println("# CORE SUBSET SELECTION #");
        System.out.println("#########################");
       
        int subsetSize = Integer.parseInt(args[0]);
        int timeLimit = Integer.parseInt(args[1]);
        run(subsetSize, timeLimit);
    }
    
    private static void run(int subsetSize, int timeLimit){
        
        /***************/
        /* PARSE INPUT */
        /***************/
        
//        System.out.println("# PARSING INPUT");
//        System.out.println("Reading file: " + filePath);
        
            //Call CoreSubsetData Methods
            double dataList[] = new double[20];
            
            for(int i = 0; i < 20; i++)
            {
                if(i != 0)
                    dataList[i] *= 0.7; //Assuming increase is 7%
                else
                    dataList[i] = 4500.0; //Initial Rent
            }
            
            CoreSubsetData data = new CoreSubsetDataReader(dataList, "rent", 20).processDataToBeEvaluated();
        
            /**********************/
            /* SAMPLE CORE SUBSET */
            /**********************/

            System.out.println("# SAMPLING CORE SUBSET");

            System.out.println("Dataset size: " + data.getIDs().size());
            System.out.println("Subset size: " + subsetSize);
            System.out.println("Time limit: " + timeLimit + " seconds");

            // create objective
            CoreSubsetObjective obj = new CoreSubsetObjective();
            // create subset problem
            SubsetProblem<CoreSubsetData> problem = new SubsetProblem<>(data, obj, subsetSize);

            // create random descent search with single swap neighbourhood
            RandomDescent<SubsetSolution> search = new RandomDescent<>(problem, new SingleSwapNeighbourhood());
            // set maximum runtime
            search.addStopCriterion(new MaxRuntime(timeLimit, TimeUnit.SECONDS));
            // attach listener
//            search.addSearchListener(new ProgressSearchListener());

            // start search
            search.start();

            // print best solution and evaluation
            if(search.getBestSolution() != null){
                System.out.println("Best solution (IDs): "
                                        + search.getBestSolution().getSelectedIDs());
                System.out.println("Best solution (names): "
                                        + search.getBestSolution().getSelectedIDs()
                                                                  .stream()
                                                                  .map(data::getName)
                                                                  .collect(Collectors.toSet()));
                System.out.println("Best solution evaluation: "
                                        + search.getBestSolutionEvaluation());
            } else {
                System.out.println("No valid solution found...");
            }

            // dispose search
            search.dispose();
            
        
    }
    
}
    
