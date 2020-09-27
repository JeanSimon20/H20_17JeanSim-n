package model;

import java.io.Serializable;

public class Tipo_Producto implements Serializable{
    
    private Integer IDTIP;
    private String NOMPRO;
    private String ESTPRO;

    public Integer getIDTIP() {
        return IDTIP;
    }

    public void setIDTIP(Integer IDTIP) {
        this.IDTIP = IDTIP;
    }

    public String getNOMPRO() {
        return NOMPRO;
    }

    public void setNOMPRO(String NOMPRO) {
        this.NOMPRO = NOMPRO;
    }

    public String getESTPRO() {
        return ESTPRO;
    }

    public void setESTPRO(String ESTPRO) {
        this.ESTPRO = ESTPRO;
    }
    
}
