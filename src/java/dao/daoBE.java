/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Berita;

public class daoBE {
    public void addBerita(Berita berita)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(berita);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteBerita(int kode_berita)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Berita prod=(Berita)session.load(Berita.class, new Integer(kode_berita));
            session.delete(prod);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<Berita> getbyID(int kode_berita)
    {
        List<Berita> produk1=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Berita where kode_berita= :kode_berita");
            query.setInteger("kode_berita", kode_berita);
            produk1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return produk1;
    }
    
    public List<Berita> retrieveBerita()
    {
        List konss = new ArrayList();
        Berita kons1= new Berita();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Berita");
            konss= query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        return konss;
    }
    
    
    public void updateBerita(Berita berita)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(berita);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }   
    }   
}

