package org.ftd.educational.catolica.prog4.tests;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.ftd.educational.catolica.prog4.daos.FornecedorDAO;
import org.ftd.educational.catolica.prog4.daos.UserDAO;
import org.ftd.educational.catolica.prog4.daos.exceptions.NonexistentEntityException;
import org.ftd.educational.catolica.prog4.entities.Fornecedor;
import org.ftd.educational.catolica.prog4.entities.User;

public class Init {
    private static final String PERSISTENCE_UNIT_NAME = "persistenciaPU";
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        FornecedorDAO dao = new FornecedorDAO(factory);

/*-------------------------------------------------------*/
//        Fornecedor fornecedor3 = new Fornecedor();
//        fornecedor3.setNome("Rensi");
//        fornecedor3.setCnpj("8456456");
//        fornecedor3.setIdade(17);
//        dao.create(fornecedor3);
/*-------------------------------------------------------*/

/*-------------------------------------------------------*/
//        Fornecedor o = dao.findFornecedor(651L);
//        System.out.println(o);
/*-------------------------------------------------------*/

/*-------------------------------------------------------*/
//        try{
//            user = dao.authenticate("janazuera", "euamoojohny1234");
//            System.out.println(user.getName() + " Logou!!");
//        } catch(Exception e){
//            System.out.println("Falha na autenticação!");
//        }
//        
/*-------------------------------------------------------*/

/*-------------------------------------------------------*/
//    Fornecedor o = dao.findFornecedor(651L);
//    System.out.println(o);
//    
//    try {
//        dao.destroy(651L); 
//        System.out.println(o);
//    } catch(NonexistentEntityException e){
//        System.out.println("Não achei!");
//    }
/*-------------------------------------------------------*/
    
/*-------------------------------------------------------*/
//List<Fornecedor> fornecedores = dao.findFornecedorEntities();
//for (Fornecedor o : fornecedores){
//    System.out.println(o);
//}
/*-------------------------------------------------------*/
      
    }   
    
}
