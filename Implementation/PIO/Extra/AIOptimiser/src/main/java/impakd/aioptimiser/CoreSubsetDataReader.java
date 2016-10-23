package impakd.aioptimiser;

/**
 *
 * @author Priscilla
 */
public class CoreSubsetDataReader 
{
    double[][] data; //Stores the rent,  variables to be evaluated
    String type;  //Specifies the type of data to be evaluated
    double[][] dataList;
    int numberOfYears, months;
    
    public CoreSubsetDataReader(double [][]dataList , int numberOfYears, int months) 
    {
        this.type = type;
        this.numberOfYears = numberOfYears;
        this.months = months;
        this.data = dataList;

    }
    
    public CoreSubsetData processDataToBeEvaluated()
    {
         String[] names = new String[numberOfYears];
         
         for(int i = 0; i < numberOfYears; i++)
         {
             names[i] = "rent" + String.valueOf(i);
         }
        
        // create and return data object
        return new CoreSubsetData(names, data);
    }
}
