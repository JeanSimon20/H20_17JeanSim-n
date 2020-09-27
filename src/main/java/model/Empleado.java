package model;

import java.io.Serializable;

public class Empleado implements Serializable{
    
    private Integer IDEMP;
    private String NOMAPE;
    private String CELEMP;
    private String DNIEMP;
    private String COREMP;
    private String SEXEMP;
    private String ESTEMP;

    public Integer getIDEMP() {
        return IDEMP;
    }

    public void setIDEMP(Integer IDEMP) {
        this.IDEMP = IDEMP;
    }

    public String getNOMAPE() {
        return NOMAPE;
    }

    public void setNOMAPE(String NOMAPE) {
        this.NOMAPE = NOMAPE;
    }

    public String getCELEMP() {
        return CELEMP;
    }

    public void setCELEMP(String CELEMP) {
        this.CELEMP = CELEMP;
    }

    public String getDNIEMP() {
        return DNIEMP;
    }

    public void setDNIEMP(String DNIEMP) {
        this.DNIEMP = DNIEMP;
    }

    public String getCOREMP() {
        return COREMP;
    }

    public void setCOREMP(String COREMP) {
        this.COREMP = COREMP;
    }

    public String getSEXEMP() {
        return SEXEMP;
    }

    public void setSEXEMP(String SEXEMP) {
        this.SEXEMP = SEXEMP;
    }

    public String getESTEMP() {
        return ESTEMP;
    }

    public void setESTEMP(String ESTEMP) {
        this.ESTEMP = ESTEMP;
    }
    
    
}
