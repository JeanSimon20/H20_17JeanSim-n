package DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class VentasDTO implements Serializable {

    private Integer IDVEN;
    private Integer IDCLI;
    private String cliente;
    private Integer IDEMP;
    private String empleado;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getIDEMP() {
        return IDEMP;
    }

    public void setIDEMP(Integer IDEMP) {
        this.IDEMP = IDEMP;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
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
