package model;

import java.io.Serializable;
import java.util.Date;

public class Ventas implements Serializable{
    
    private Integer IDVEN;
    private Integer IDCLI;
    private Integer IDEMPL;
    private String DESVEN;
    private Double PREVEN;
    private String ESTVEN;
    

    public Integer getIDVEN() {
        return IDVEN;
    }

    public void setIDVEN(Integer IDVEN) {
        this.IDVEN = IDVEN;
    }

    public Integer getIDCLI() {
        return IDCLI;
    }

    public void setIDCLI(Integer IDCLI) {
        this.IDCLI = IDCLI;
    }

    public Integer getIDEMPL() {
        return IDEMPL;
    }

    public void setIDEMPL(Integer IDEMPL) {
        this.IDEMPL = IDEMPL;
    }
    
    public String getDESVEN() {
        return DESVEN;
    }

    public void setDESVEN(String DESVEN) {
        this.DESVEN = DESVEN;
    }

    public Double getPREVEN() {
        return PREVEN;
    }

    public void setPREVEN(Double PREVEN) {
        this.PREVEN = PREVEN;
    }

    public String getESTVEN() {
        return ESTVEN;
    }

    public void setESTVEN(String ESTVEN) {
        this.ESTVEN = ESTVEN;
    }
    
}
