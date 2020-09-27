package model;

import java.io.Serializable;

public class Cliente implements Serializable{
    
    private Integer IDCLI;
    private String NOMCLI;
    private String DIRCLI;
    private String TELCLI;
    private String ESTCLI;

    public String getESTCLI() {
        return ESTCLI;
    }

    public void setESTCLI(String ESTCLI) {
        this.ESTCLI = ESTCLI;
    }

    public Integer getIDCLI() {
        return IDCLI;
    }

    public void setIDCLI(Integer IDCLI) {
        this.IDCLI = IDCLI;
    }

    public String getNOMCLI() {
        return NOMCLI;
    }

    public void setNOMCLI(String NOMCLI) {
        this.NOMCLI = NOMCLI;
    }

    public String getDIRCLI() {
        return DIRCLI;
    }

    public void setDIRCLI(String DIRCLI) {
        this.DIRCLI = DIRCLI;
    }

    public String getTELCLI() {
        return TELCLI;
    }

    public void setTELCLI(String TELCLI) {
        this.TELCLI = TELCLI;
    }
    
    
}
