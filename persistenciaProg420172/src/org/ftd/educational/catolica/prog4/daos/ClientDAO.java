/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftd.educational.catolica.prog4.daos;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author johny.klein
 */
public class ClientDAO extends ClientJpaController{

    public ClientDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
}
