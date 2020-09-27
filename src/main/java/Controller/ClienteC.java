package Controller;

import dao.ClienteImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Cliente;

@Named(value = "clienteC")
@SessionScoped
public class ClienteC implements Serializable {

    private ClienteImpl daos;
    private Cliente cliente;
    private List<Cliente> clientes;
    private Cliente seleccionado;

    @PostConstruct
    public void onInit() {

        try {
            listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClienteC() {
        cliente = new Cliente();
        seleccionado = new Cliente();
        daos = new ClienteImpl();
    }

    public void registrar() {
        try {
            daos.registrar(cliente);
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
            daos.modificar(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Cliente p) {
        try {
            p.setESTCLI("I");
            daos.modificarEst(p);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            clientes = new ArrayList<>();
            clientes = daos.listar();
        } catch (Exception e) {

        }
    }

    public void limpiar() {
        cliente = new Cliente();
    }

    public ClienteImpl getDaos() {
        return daos;
    }

    public void setDaos(ClienteImpl daos) {
        this.daos = daos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
    }

}
