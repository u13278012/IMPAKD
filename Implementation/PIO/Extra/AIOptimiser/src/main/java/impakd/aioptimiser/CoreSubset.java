package impakd.aioptimiser;

/**
 *
 * @author Priscilla
 */
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
public class CoreSubset 
{
    
    public static void main(String[] args) 
    {
        
        System.out.println("PARTICLE SWARM OPTIMISATION");
        
        //Define a new Property object... Pass in the property object in correct constructor
        ProblemDefinition problem = new ProblemDefinition(240, 12, 2); 
        Solution newSolution = problem.newSolution();
        
        //Run the PSO Algorithm
		NondominatedPopulation result = new Executor()
                                .withProblemClass(ProblemDefinition.class)
                                .withAlgorithm("SMPSO")
                                .withMaxEvaluations(200)
                                .distributeOnAllCores()
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
       
        int subsetSize = problem.getNumberOfYears();
        int timeLimit = 1;  //Has to calculate the results quickly
        run(subsetSize, timeLimit, problem);
    }
    
    private static void run(int subsetSize, int timeLimit, ProblemDefinition problem)
    {
        
        /***************/
        /* PARSE INPUT */
        /***************/
        
//        System.out.println("# PARSING INPUT");
//        System.out.println("Reading file: " + filePath);
        
            //Call CoreSubsetData Methods
            CoreSubsetData data = new CoreSubsetDataReader(problem.getDataArray(),problem.getNumberOfYears(), problem.getNumberOfMonths()).processDataToBeEvaluated();
            
            /**********************/
            /* SAMPLE CORE SUBSET */
            /**********************/

            System.out.println("# SAMPLING CORE SUBSET");

            System.out.println("Dataset size: " + data.getIDs().size());
            System.out.println("Subset size: " + subsetSize);
            System.out.println("Time limit: " + timeLimit + " seconds");

            // create objective
            CoreSubsetObjective objective = new CoreSubsetObjective();
   
            // create subset problem
            SubsetProblem<CoreSubsetData> problemSet = new SubsetProblem(data, objective, subsetSize);

            // create random descent search with single swap neighbourhood - Hill Climbing
            RandomDescent<SubsetSolution> search = new RandomDescent<>(problemSet, new SingleSwapNeighbourhood());
            // set maximum runtime
            search.addStopCriterion(new MaxRuntime(timeLimit, TimeUnit.SECONDS));
            // attach listener
//            search.addSearchListener(new ProgressSearchListener());

            //Start search
            search.start();

            //Print best solution and evaluation
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

            //Dispose Search
            search.dispose();
            
        
    }
    
}
    
