/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

/**
 *
 * @author Diana
 */
public class CalculateROI {
    double a = 0;
    double rate = 0;
    final int yearsToPayOffBond = 20;
    
    public  static void main(String[] args) {
        CalculateROI roi = new CalculateROI();
        roi.discountRate(9.5);
    }
    /**
     *
     * @param i
     * @return 
    */
    public  double discountRate(double i){
        rate = (i/100.00) /12;
        a = (1 - Math.pow(1+rate, -(yearsToPayOffBond*12))) / rate;
        //System.out.println(a);
        return a;
    }

}
