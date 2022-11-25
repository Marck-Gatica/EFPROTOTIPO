package traslados.controlador;

import logistica.controlador.*;
import seguridad.controlador.*;

/*
actualización 0209 Juan Miguel Sandoval Chile ESTA ES LA ************************
*/
public class clsProductos {
    private int prodcodigo;
    private String prodnombre;
    private float prodexistencia;//sper_nombre;
    private String prodestatus;


    public clsProductos() {
    }

    public clsProductos(int sid) {
   
         this.prodcodigo = sid;
    }
     
      public int getProdcodigo() {
        return prodcodigo;
    }

    public void setProdcodigo(int sid) {
        this.prodcodigo = sid;
    }
    
      public String getProdnombre() {
        return prodnombre;
    }

    public void setProdnombre(String Prodnombre) {
        this.prodnombre = Prodnombre;
    }
        public Float getProdexistencia() {
        return prodexistencia;
    }

    public void setProdexistencia(Float Prodexistencia) {
        this.prodexistencia = Prodexistencia;
    }
    
    
      public String getProdestatus() {
        return prodestatus;
    }

    public void setProdestatus(String Prodestatus) {
        this.prodestatus = Prodestatus;
    }

}