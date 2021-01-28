package pojo;
// Generated Oct 24, 2020 11:44:40 PM by Hibernate Tools 4.3.1
import dao.daoBE;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/**
 * Berita generated by hbm2java
 */
@ManagedBean
public class Berita  implements java.io.Serializable {


     private int kodeBerita;
     private String terbaru;
     private String message;

    public Berita() {
    }

    public Berita(int kodeBerita, String terbaru) {
        this.kodeBerita = kodeBerita;
        this.terbaru = terbaru;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
   
    public int getKodeBerita() {
        return this.kodeBerita;
    }
    
    public void setKodeBerita(int kodeBerita) {
        this.kodeBerita = kodeBerita;
    }
    
    public String getTerbaru() {
        return this.terbaru;
    }
    
    public void setTerbaru(String terbaru) {
        this.terbaru = terbaru;
    }
    
    public void save()
    {
        daoBE pdao=new daoBE();
        pdao.addBerita(this);
        kodeBerita=0;
        terbaru="";
    }

    public void delete()
    {    
        daoBE pdao=new daoBE();
        pdao.deleteBerita(kodeBerita);
        kodeBerita=0;
        terbaru="";
        this.message="data dihapus";
    }

    public String getbyid()
    { 
        daoBE pdao=new daoBE();
        List<Berita> prod=pdao.getbyID(kodeBerita);
        if(prod != null){
            if(prod.size() == 1){
                terbaru=prod.get(0).terbaru;
                this.message = "data ditemukan";
                return "admin_updelBerita";
            }else{
                this.message = "data kosong";
                terbaru="";
                }  
        }   
        return "admin_updelBerita";
    }

    public List<Berita> getallrecords()
    {
        daoBE pdao=new daoBE();
        List<Berita> prod=pdao.retrieveBerita();
        return prod;
    }

    public void update()
    {
        daoBE pdao=new daoBE();
        pdao.updateBerita(this);
        kodeBerita=0;
        terbaru="";
        this.message="data diubah";
    }
}

