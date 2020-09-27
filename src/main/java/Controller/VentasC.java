package Controller;

import DTO.VentasDTO;
import Services.VentasServiceImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "ventasC")
@SessionScoped
public class VentasC implements Serializable {

    VentasServiceImpl ventaServiceImpl = new VentasServiceImpl();
    private List<VentasDTO> listVentaDTO = new ArrayList<>();
    private VentasDTO ventaDTO = new VentasDTO();
    private VentasDTO seleccionado = new VentasDTO();
        
    @PostConstruct
    public void onInit() {

        try {
            listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrar() {
        try {
            ventaServiceImpl.crear(ventaDTO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            ventaServiceImpl.modificar(seleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Integer IDVEN) {
        try {
            ventaServiceImpl.modificarEstado(IDVEN);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listVentaDTO = new ArrayList<>();
            listVentaDTO = ventaServiceImpl.listar();
        } catch (Exception e) {

        }
    }

    public VentasC() {
    }
    
        public List<VentasDTO> getListVentaDTO() {
        return listVentaDTO;
    }

    public void setListVentaDTO(List<VentasDTO> listVentaDTO) {
        this.listVentaDTO = listVentaDTO;
    }

    public VentasDTO getVentaDTO() {
        return ventaDTO;
    }

    public void setVentaDTO(VentasDTO ventaDTO) {
        this.ventaDTO = ventaDTO;
    }

    public VentasDTO getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(VentasDTO seleccionado) {
        this.seleccionado = seleccionado;
    }

    
    

}
