package impakd.aioptimiser;

import java.util.HashMap;
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
		 * Construction of a new, user-defined function DTLZ2
                 * To be specified - number of decision values (results) and objectives.
		 */
                final int months = 12; //Number of months in a year
                int numberOfYears;
//              Property property;
                HashMap<Integer, Double> lowerBounds, upperBounds;
                double rent[][];
                
		public ProblemDefinition()  //Default Constructor
                {
			super(12, 2);
                        this.numberOfYears = 20;
                        lowerBounds = new HashMap<>();
                        upperBounds = new HashMap<>();
                        rent = new double[50][months];
		}
                
                public ProblemDefinition(int numberOfYears, int numberOfObjectives)  //Default Constructor
                {
			super(12, 2);
                        this.numberOfYears = numberOfYears;
                        lowerBounds = new HashMap<>();
                        upperBounds = new HashMap<>();
                        rent = new double[this.numberOfYears][months];
		}
                
                /*public ProblemDefinition(int numberOfObjectives, Property property, int numberOfYears) 
                {
			super(numberOfDecisionValues, numberOfObjectives);
                        this.property = property;
                        lowerBounds = new HashMap<>();
                        upperBounds = new HashMap<>();
                        rent = new double[numberOfYears][months];
		}*/

		/**
		 * Constructs a new solution and defines the bounds of the decision
		 * variables.
		 */
                
		@Override
		public Solution newSolution() {
                    //Optimise the rent to breakeven - to pay up the expenses. It makes up the profit of the property owner.
                    Random rand = new Random(); 
                    double profit, expenses, rentValue = 4600.0, rentIncrease = 0.06;
                    double interest = 0, monthlyRent = 0, total = 0, k = 0;
                    
                    Solution solution = new Solution(getNumberOfVariables(), getNumberOfObjectives());
                    for(int n = 0; n < numberOfYears; n++)
                    {
			for (int i = 0; i < getNumberOfVariables(); i++) {
                               
                                //Get the profit made and the expenses
                                profit = rand.nextInt(9000) + 1;
                                expenses = rand.nextInt(8000) + 1;
                                
                                total = profit + expenses;
                                interest = rand.nextInt(80) + 1; //First month of every year - Accumulated
                                if(k != 0)
                                {
                                    monthlyRent = (rentValue * (k * rentIncrease) + rentValue);
                                    System.out.println("Rent: " + monthlyRent);
                                }
                                else
                                {
                                    rent[n][i] = rentValue;
                                }
                                monthlyRent += (profit) + interest;
                                
                                //Set the solution bounds to achieve break-even - How much is needed to pay off the expenses
                                if(profit < expenses)
                                {
                                    
                                    if(monthlyRent  < (expenses))
                                    {
                                        
                                        while(monthlyRent  < expenses)
                                        {
                                            monthlyRent +=  (monthlyRent * 0.005); // (0.06/12) - Do a mini monthly increase to see if it makes a difference
                                        }
                                    }
                                   setLowerBound(i, monthlyRent);
                                   setUpperBound(i, monthlyRent + ((profit/total)));
                                   solution.setVariable(i, new RealVariable(getLowerBound(i),getUpperBound(i)));
                                }
                                else
                                {
                                    setLowerBound(i,rentValue);
                                    setUpperBound(i, rentValue +  (rentIncrease * rentValue));
                                    solution.setVariable(i, new RealVariable(rentValue, rentValue +  (rentIncrease * rentValue)));
                                }  
			}
                        rentValue += (rentIncrease * rentValue) + rentValue;
                        k++;
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
                
                //Getters and Setters for the Decision Values
                public void setUpperBound(int i, double bound)
                {
                    upperBounds.put(i, bound);
                }
                
                public void setLowerBound(int i, double bound)
                {
                    lowerBounds.put(i, bound);
                }
                
                public double getUpperBound(int i)
                {
                    return upperBounds.get(i);
                }
                
                public double getLowerBound(int i)
                {
                    return lowerBounds.get(i);
                }
                
                public HashMap<Integer, Double> getUpperBounds()
                {
                    return upperBounds;
                }
                
                public HashMap<Integer, Double> getLowerBounds()
                {
                    return lowerBounds;
                }
                
                //Get Rent(Data in 2D Array)
                double[][] getDataArray()
                {
                    for(int i = 0; i < 20; i++)
                    {
                        for(int j = 0; j < 12; j++)
                        {
                            System.out.println("Rent Value: " + this.rent[i][j]);
                        }
                    }
                    return this.rent;
                }
                
                //Get number of years and months
                int getNumberOfYears()
                {
                    return this.numberOfYears;
                }
                
                int getNumberOfMonths()
                {
                    return this.months;
                }
                
}
