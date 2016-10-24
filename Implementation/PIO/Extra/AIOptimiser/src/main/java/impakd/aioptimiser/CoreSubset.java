package impakd.aioptimiser;

/**
 *
 * @author Priscilla
 */
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
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
        ProblemDefinition problem = new ProblemDefinition(20, 12, 2);         
        
        //Run the PSO Algorithm
	NondominatedPopulation result = new Executor()
                                .withProblemClass(ProblemDefinition.class, 20, 12, 2)
                                .withAlgorithm("SMPSO") //Particle Swarm Optimiser
                                .withMaxEvaluations(1000)
                                .distributeOnAllCores()
                                .run();
		
                double[] solutions = new double[problem.getNumberOfMonths() * problem.getNumberOfYears()];
		for (Solution solution : result) 
                {
                        for(int i = 0; i < solution.getNumberOfVariables(); i++)
                        {
                            solutions[i] = Double.parseDouble(solution.getVariable(i).toString());
                        }
                
		}
       
        System.out.println("HILL CLIMBING");        
        int subsetSize = problem.getNumberOfYears();
        int timeLimit = 1;  //Has to calculate the results quickly
        
        //Define dataSet
        double[][] dataSet = new double[problem.getNumberOfYears()][problem.getNumberOfMonths()];
        int count = 0;
        
        for(int i = 0; i < problem.getNumberOfYears(); i++)
        {
            for(int j = 0; j < problem.getNumberOfMonths(); j++)
            {
                dataSet[i][j] = solutions[count];
                count++;
            }
        }
        
        run(subsetSize, timeLimit, problem, dataSet, solutions);
    }
    
    //Insertion Sort
    public static double[] doInsertionSort(double[] input){
         
        double temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
    
    private static void run(int subsetSize, int timeLimit, ProblemDefinition problem,double[][] dataSet, double[] solution)
    {
        
            //Call CoreSubsetData Methods
            CoreSubsetData data = new CoreSubsetDataReader(dataSet,problem.getNumberOfYears(), problem.getNumberOfMonths()).processDataToBeEvaluated();

            //Create objective
            CoreSubsetObjective objective = new CoreSubsetObjective();
   
            //Create subset problem
            SubsetProblem<CoreSubsetData> problemSet = new SubsetProblem(data, objective, subsetSize);

            //Create Random Descent Search with Single Swap Neighbourhood - Hill Climbing
            RandomDescent<SubsetSolution> search = new RandomDescent<>(problemSet, new SingleSwapNeighbourhood());
            
            //Set maximum runtime
            search.addStopCriterion(new MaxRuntime(timeLimit, TimeUnit.SECONDS));
            
            //Start search
            search.start();
            
            HashSet<Integer> ids = new HashSet<Integer>();
            
            //Print best solution and evaluation
            if(search.getBestSolution() != null)
            {
                ids.addAll(search.getBestSolution().getSelectedIDs());
            }

            //Dispose Search
            search.dispose();
            
            //Get optimised rent values
            double[] rent = new double[problem.getNumberOfYears()];
            
            for(int i = 0; i < 20; i++)
            {
                //Add optimised rent values from the subset and return it
                if(ids.contains(i))
                    rent[i] = (double) Math.round(solution[i]);
            }
            
            //Print Optimised Rent
            /*for(int i = 0; i < rent.length; i++)
            {
                System.out.print(rent[i] + " ");
            }
            
            System.out.println("");*/
            
            //Sort the rent values in ascending order
            double[] finalRent = doInsertionSort(rent);
            /*return doInsertionSort(rent);*/
            
            //Print Sorted Rent Values
            /*System.out.print("Final Rent: ");
            for(int i = 0; i < rent.length; i++)
            {
                System.out.print(finalRent[i] + " ");
            }*/
    }
    
}
    
