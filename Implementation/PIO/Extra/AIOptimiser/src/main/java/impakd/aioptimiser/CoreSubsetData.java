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

    public CoreSubsetData(String[] names, double[][] data){
        // store data
        this.names = names;
        this.data = data;
        // infer IDs: 0..N-1 in case of N items
        // (indices in distance matrix and name array)
        ids = new HashSet<>();
        for(int id=0; id<names.length; id++){
            ids.add(id);
        }
    }

    public Set<Integer> getIDs() {
        return ids;
    }
    
    public String getName(int id){
    return names[id];
}

    public double getDistance(int id1, int id2){
    return data[id1][id2];
    }
}
