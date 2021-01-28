/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author priyanto
 */
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Admin;

public class daoAD {
    public List<Admin> validateLogin(String admin, String password)
    {
        List<Admin> admin1=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Admin where admin= :admin and password= :password");
            query.setString("admin", admin);
            query.setString("password", password);
            admin1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return admin1;
    }
}