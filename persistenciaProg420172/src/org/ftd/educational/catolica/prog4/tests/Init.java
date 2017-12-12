package org.ftd.educational.catolica.prog4.tests;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.ftd.educational.catolica.prog4.daos.ClientDAO;
import org.ftd.educational.catolica.prog4.daos.FornecedorDAO;
import org.ftd.educational.catolica.prog4.daos.ProdutoDAO;
import org.ftd.educational.catolica.prog4.daos.UserDAO;
import org.ftd.educational.catolica.prog4.daos.exceptions.NonexistentEntityException;
import org.ftd.educational.catolica.prog4.entities.Client;
import org.ftd.educational.catolica.prog4.entities.Fornecedor;
import org.ftd.educational.catolica.prog4.entities.Produto;
import org.ftd.educational.catolica.prog4.entities.User;

public class Init {

    private static final String PERSISTENCE_UNIT_NAME = "persistenciaPU";

    public static void main(String[] args) {

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        ProdutoDAO dao = new ProdutoDAO(factory);
//        ClientDAO dao1 = new ClientDAO(factory);
//        FornecedorDAO forn1 = new FornecedorDAO(factory);
//        
//        Produto prod = new Produto();
//        Client cliente = dao1.findClient(Long.parseLong("1101"));
//        Fornecedor fornecedor = forn1.findFornecedor(Long.parseLong("501"));
//        
//        prod.setCliente(cliente);
//        prod.setFornecedor(fornecedor);
//        prod.setNome("Abacaxi");
//        prod.setPreco(45);
//        
//        try {
//            dao.create(prod);
//            System.out.println("Criou!");
//        } catch (Exception e) {
//            System.out.println("Falha na autenticação!");
//        }
   
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
///*-------------------------------------------------------*/
//
///*-------------------------------------------------------*/
//        try{
//            User user = dao.authenticate("janazuera", "euamoojohny1234");
//            System.out.println(user.getName() + " Logou!!");
//        } catch(Exception e){
//            System.out.println("Falha na autenticação!");
//        }
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
