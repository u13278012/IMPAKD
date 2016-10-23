package impakd.aioptimiser;

/**
 *
 * @author Priscilla
 */
public class CoreSubsetDataReader 
{
    private final double[][] data; //Stores the rent,  variables to be evaluated
    private final int numberOfYears, months;
    
    public CoreSubsetDataReader(double [][]dataList , int numberOfYears, int months) 
    {
        this.numberOfYears = numberOfYears;
        this.months = months;
        data = new double[this.numberOfYears][this.months];
        for(int i = 0; i < this.numberOfYears; i++)
        {
            for(int j = 0; j < this.months; j++)
            {
                data[i][j] = dataList[i][j];
            }
        }

    }
    
    public CoreSubsetData processDataToBeEvaluated()
    {
         String[] names = new String[numberOfYears * months];
         
         for(int i = 0; i < numberOfYears * months; i++)
         {
             names[i] = "rent" + String.valueOf(i);
         }
        
        //Create and return data object
        return new CoreSubsetData(names, data, numberOfYears, months);
    }
}
