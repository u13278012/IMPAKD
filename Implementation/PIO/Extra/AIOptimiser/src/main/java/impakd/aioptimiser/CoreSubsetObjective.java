/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impakd.aioptimiser;

/**
 *
 * @author Priscilla
 */
import org.jamesframework.core.problems.objectives.evaluations.Evaluation;
import org.jamesframework.core.problems.objectives.Objective;
import org.jamesframework.core.problems.objectives.evaluations.SimpleEvaluation;
import org.jamesframework.core.subset.SubsetSolution;

/**
 * Implements the core subset selection objective: minimising the difference between all pairs of selected items.
 * 
 * @author <a href="mailto:herman.debeukelaer@ugent.be">Herman De Beukelaer</a>
 */
public class CoreSubsetObjective implements Objective<SubsetSolution, CoreSubsetData>{

    /**
     * Evaluates the given subset solution using the underlying data, by computing the average
     * distance between all pairs of selected items. If less than two items are selected,
     * the evaluation is defined to have a value of 0.0.
     * 
     * @param solution subset solution
     * @param data core subset data
     * @return evaluation with a value set to the average distance between all pairs of selected items;
     *         the value is defined to be 0.0 if less than 2 items are selected
     */
    
    @Override
    public Evaluation evaluate(SubsetSolution solution, CoreSubsetData data) {
        double value = 0.0;
        if(solution.getNumSelectedIDs() >= 2)
        {
            //At least two items selected: Compute Average Rent
            int numDist = 0;
            double sumDist = 0.0;
            Integer[] selected = new Integer[solution.getNumSelectedIDs()];
            solution.getSelectedIDs().toArray(selected);
            for(int i = 0; i < 20; i++)
            {
                for(int j = 0; j < 12; j++)
                {
                    if(selected[i] < 20 && selected[j] < 12)
                    {
                        sumDist += data.getRent(selected[i], selected[j]);
                        numDist++;
                    }
                }
            }
            
            value = sumDist/numDist;
        }
        return SimpleEvaluation.WITH_VALUE(value);
    }
    
    /**
     * Always returns <code>false</code> as this objective has to be maximized.
     * 
     * @return <code>false</code>
     */
    @Override
    public boolean isMinimizing() 
    {
        return true;
    }

}
