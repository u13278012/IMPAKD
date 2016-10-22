/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impakd.aioptimiser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Priscilla
 */
public class CoreSubsetFileReader 
{
     /**
     * Reads an input file containing the item names and distance matrix.
     * 
     * @param filePath input file path
     * @return core subset data as read from the input file
//     * @throws FileNotFoundException if the file does not exist
     */
    public CoreSubsetData read(String filePath) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(filePath));
        sc.useLocale(Locale.US);
        // read names - expenses - 0, rent - total pre-tax income / 40, shortfall - 0
        String[] names = sc.nextLine().split(",");
        
        //
        int n = names.length;
        // read distance matrix
        double[][] dist = new double[n][n];
        String[] row;
        for(int r=0; r<n; r++){
            row = sc.nextLine().split(",");
            for(int c=0; c<n; c++){
                dist[r][c] = Double.parseDouble(row[c]);
            }
        }
        // create and return data object
        return new CoreSubsetData(names, dist);
    }
    
}
