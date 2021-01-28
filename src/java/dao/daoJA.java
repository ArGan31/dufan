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
import pojo.Jadwal;

public class daoJA {
    public void addJadwal(Jadwal jadwal)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(jadwal);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteJadwal(int kode_jadwal)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Jadwal prod=(Jadwal)session.load(Jadwal.class, new Integer(kode_jadwal));
            session.delete(prod);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<Jadwal> getbyID(int kode_jadwal)
    {
        List<Jadwal> produk1=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Jadwal where kode_jadwal= :kode_jadwal");
            query.setInteger("kode_jadwal", kode_jadwal);
            produk1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return produk1;
    }
    
    public List<Jadwal> retrieveJadwal()
    {
        List konss = new ArrayList();
        Jadwal kons1= new Jadwal();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Jadwal");
            konss= query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        return konss;
    }
    
    
    public void updateJadwal(Jadwal jadwal)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(jadwal);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }   
    }   
}
