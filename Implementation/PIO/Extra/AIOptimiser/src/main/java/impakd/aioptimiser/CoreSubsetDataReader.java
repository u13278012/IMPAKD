package impakd.aioptimiser;

/**
 *
 * @author Priscilla
 */
public class CoreSubsetDataReader 
{
    double[][] data; //Stores the rent,  variables to be evaluated
    String type;  //Specifies the type of data to be evaluated
    double[] dataList;
    int numberOfYears;
    
    public CoreSubsetDataReader(double []dataList , String type, int numberOfYears) 
    {
        this.type = type;
        this.numberOfYears = numberOfYears;
        this.dataList = new double[numberOfYears];
        this.data = new double[numberOfYears][numberOfYears];
        
        //Copy values of data list
        for(int i = 0; i < numberOfYears; i++ )
        {
            this.dataList[i] = dataList[i];
        }
    }
    
    public CoreSubsetData processDataToBeEvaluated()
    {
         String[] names = new String[numberOfYears];
         
         for(int i = 0; i < numberOfYears; i++)
         {
             names[i] = type + String.valueOf(i);
         }
        
         //Size of names array
        int n = names.length;
  
        for(int row = 0; row < n; row++)
        {
            for(int column = 0; column <n; column++){
                data[row][column] = dataList[column];
            }
        }
        // create and return data object
        return new CoreSubsetData(names, data);
    }
    
    
}
