/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Profile;
import javax.ejb.Local;

/**
 *
 * @author Kudzai
 */
@Local
public interface PIOBeanLocal {

    void register(Profile profile);
    
}
