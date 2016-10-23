package impakd.aioptimiser;

import java.util.HashSet;
import java.util.Set;
import org.jamesframework.core.problems.datatypes.IntegerIdentifiedData;

/**
 *
 * @author Priscilla
 */

public class CoreSubsetData implements IntegerIdentifiedData
{
     // item names
    private String[] names;
    // distance matrix
    private double[][] data;
    // IDs
    private Set<Integer> ids;
    
    int years, months;

    public CoreSubsetData(String[] names, double[][] data, int years, int months){
        // store data
        names = new String[names.length];
        this.data = new double[years][months];
        this.names = names;
        this.years = years;
        this.months = months;
        for(int i = 0; i < years; i++)
        {
            for(int j = 0; j < months; j++)
            {
                this.data[i][j] = data[i][j];
            }
        }
        // infer IDs: 0..N-1 in case of N items
        // (indices in distance matrix and name array)
        ids = new HashSet<>();
        int count = 0;
        
        for(int id = 0; id< this.years * this.months; id++)
        {
            if(count > 20)
                count = 0;
            ids.add(count);
            count++;
        }
    }

    @Override
    public Set<Integer> getIDs() {
        return ids;
    }
    
    public String getName(int id){
    return names[id];
}

    public double getRent(int id1, int id2)
    {
        return data[id1][id2];
    }
}
