/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author u06437985100
 */
        
        //DAO abstract serve como esqueleto para as outras classes
public abstract class DAO_Abstract {
    Session session;//variavel publica a classe
    
    public DAO_Abstract() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
}
    
    
    
    //void significa sem retorno
    public abstract void insert(Object object);
    public abstract void update(Object object);
    public abstract void delete(Object object);
    public abstract Object list(int id);
    public abstract List listAll();
    
   // public void mensagem(String texto){
     //   System.out.println(texto);
       
    //}
 
    
}
