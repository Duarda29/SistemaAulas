package dao;

import bean.Usuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


public class UsuariosDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
         session.beginTransaction();// todas as conexão com os bancos de dados precisam de uma...
         session.save(object);
         session.beginTransaction().commit();
        
    }
//não precisa colocar flush e clear porque o no insert apenas esta inserindo, não colo o delete e update que esta "alterandO" o banco
    @Override
    public void update(Object object) {
         session.beginTransaction();
         session.flush();// para limpar o cash do hibernate para não enviar coisas erras
         session.clear();// para limpar o cash do hibernate para não enviar coisas erras
         session.update(object);
         session.beginTransaction().commit();    }

    @Override
    public void delete(Object object) {
         session.beginTransaction();
         session.flush();
         session.clear();
         session.delete(object);
         session.beginTransaction().commit();    }

    @Override
    public Object list(int id) {
       session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuarios.class); // criteria não é para usar o SELECT * FROM usuarios
        criteria.add(Restrictions.eq("idusuarios", id));//metodo estatico( não precisa instansiar a classe), porque é uma classe.// eq é equals ele é um metodo estatico
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
               
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuarios.class); //criteria não é para usar o SELECT * FROM usuarios, estamos usando o objeto criteria porque não estamos usando mais o sql
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listNome(String nome){
        session.beginTransaction();
        Criteria crit = session.createCriteria(Usuarios.class);
        crit.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listCpf(String cpf){
        session.beginTransaction();
        Criteria crit = session.createCriteria(Usuarios.class);
        crit.add(Restrictions.like("cpf", cpf, MatchMode.ANYWHERE));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
    
    public List listNomeCpf(String nome, String cpf){
        session.beginTransaction();
        Criteria crit = session.createCriteria(Usuarios.class);
        crit.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
        crit.add(Restrictions.like("cpf", cpf, MatchMode.ANYWHERE));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listNivel(int nivel){
        session.beginTransaction();
        Criteria crit = session.createCriteria(Usuarios.class);
        crit.add(Restrictions.ge("nivel", nivel));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
     public List listNomeNivel(String nome, int nivel){
        session.beginTransaction();
        Criteria crit = session.createCriteria(Usuarios.class);
        crit.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
        crit.add(Restrictions.ge("nivel", nivel));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
  //  public static void main(String[] args) {
    //    UsuariosDAO usuariosDAO = new UsuariosDAO();
      //  List lista = usuariosDAO.listAll();
        //for(Object usuarios : lista){
          //  System.out.println("Nome:" + ((Usuarios)usuarios).getNome());
        //}
   // }
}
