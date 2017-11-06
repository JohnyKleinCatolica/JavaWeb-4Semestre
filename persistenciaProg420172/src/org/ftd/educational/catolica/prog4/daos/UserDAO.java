package org.ftd.educational.catolica.prog4.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.ftd.educational.catolica.prog4.entities.User;

/**
 *
 * @author Fabio Tavares Dippold
 * 
 */
public class UserDAO extends UserJpaController {

    private static final long serialVersionUID = 1L;
    
    public UserDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
    public User authenticate(String user, String senha){
        EntityManager em = null;//getEntityManager();
        
        try{
            em = getEntityManager();
            return (User) em.createNamedQuery("User.Authetication")
            .setParameter("login", user)
            .setParameter("passwd", senha)
            .getSingleResult();
        } finally {
            em.close(); 
        }
    }

}
