package Controller;

import dao.Tipo_ProductoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Tipo_Producto;

@Named(value = "tipo_ProductoC")
@SessionScoped
public class Tipo_ProductoC implements Serializable {

    private Tipo_ProductoImpl daos;
    private Tipo_Producto producto;
    private List<Tipo_Producto> listProducto;
    private Tipo_Producto seleccionado;

    @PostConstruct
    public void onInit() {

        try {
            listar();
            listar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrar() {
        try {
            daos.registrar(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            daos.modificar(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Tipo_Producto a) {
        try {
            a.setESTPRO("I");
            daos.modificarEst(a);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listProducto = new ArrayList<>();
            listProducto = daos.listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        daos = new Tipo_ProductoImpl();
    }

    public List<Tipo_Producto> getListare() {
        return listProducto;
    }

    public Tipo_ProductoC() {
        producto = new Tipo_Producto();
        seleccionado = new Tipo_Producto();
        daos = new Tipo_ProductoImpl();
    }

    public Tipo_ProductoImpl getDaos() {
        return daos;
    }

    public void setDaos(Tipo_ProductoImpl daos) {
        this.daos = daos;
    }

    public Tipo_Producto getProducto() {
        return producto;
    }

    public void setProducto(Tipo_Producto producto) {
        this.producto = producto;
    }

    public List<Tipo_Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(List<Tipo_Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public Tipo_Producto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Tipo_Producto seleccionado) {
        this.seleccionado = seleccionado;
    }

}
