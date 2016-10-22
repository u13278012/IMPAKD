package impakd.aioptimiser;

import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.problem.AbstractProblem;
import org.moeaframework.core.variable.RealVariable;
import java.util.Random;

/**
 *
 * @author Priscilla
 */
public class ProblemDefinition extends AbstractProblem 
{

		/**
		 * Constructs a new instance of the DTLZ2 function, defining it
		 * to include 20 decision variables and 1 objectives.
		 */
                final int months = 12; //Number of months in a year
                
		public ProblemDefinition() 
                {
			super(20, 1);
		}

		/**
		 * Constructs a new solution and defines the bounds of the decision
		 * variables.
		 */
		@Override
		public Solution newSolution() {
                    //Optimise the rent to breakeven - to pay up the expenses
                    Random rand = new Random(); 
                    double profit, expenses, rent = 6700.0, rentIncrease = 0.06;
                    double difference, interest;
                    
                    Solution solution = new Solution(getNumberOfVariables(), getNumberOfObjectives());

			for (int i = 0; i < getNumberOfVariables(); i++) {
                                
                                //Get the profit made and the expenses
                                
                                profit = rand.nextInt(9000) + 1;
                                expenses = rand.nextInt(8000) + 1;
                                
                                //Set the solution bounds to achieve break-even - How much it pay off the expenses
                                if(profit < expenses)
                                {
                                    interest = rand.nextInt(800) + 1; //Yearly - Accumulated
                                    
                                   //solution.setVariable(i, new RealVariable(,));
                                }
                                else
                                {
                                    solution.setVariable(i, new RealVariable(rent, rent *  rentIncrease));
                                }  
                                rent *= rentIncrease;
				
			}

			return solution;
		}
		
		/**
		 * Extracts the decision variables from the solution, evaluates the
		 * Rosenbrock function, and saves the resulting objective value back to
		 * the solution. 
     * @param solution
		 */
		@Override
		public void evaluate(Solution solution) {
			double[] x = EncodingUtils.getReal(solution);
			double[] f = new double[numberOfObjectives];

			int k = numberOfVariables - numberOfObjectives + 1;

			double g = 0.0;
			for (int i = numberOfVariables - k; i < numberOfVariables; i++) {
				g += Math.pow(x[i] - 0.5, 2.0);
			}

			for (int i = 0; i < numberOfObjectives; i++) {
				f[i] = 1.0 + g;

				for (int j = 0; j < numberOfObjectives - i - 1; j++) {
					f[i] *= Math.cos(0.5 * Math.PI * x[j]);
				}

				if (i != 0) {
					f[i] *= Math.sin(0.5 * Math.PI * x[numberOfObjectives - i - 1]);
				}
			}

			solution.setObjectives(f);
		}
}
