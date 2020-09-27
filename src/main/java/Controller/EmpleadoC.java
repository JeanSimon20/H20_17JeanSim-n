package Controller;

import dao.EmpleadoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Empleado;

@Named(value = "empleadoC")
@SessionScoped
public class EmpleadoC implements Serializable {

    private EmpleadoImpl daos;
    private Empleado empleado;
    private List<Empleado> empleados;
    private Empleado seleccionado;

    @PostConstruct
    public void onInit() {

        try {
            listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EmpleadoC() {
        empleado = new Empleado();
        seleccionado = new Empleado();
        daos = new EmpleadoImpl();
    }
    
    
    public void registrar() {
        try {
            daos.registrar(empleado);
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
            daos.modificar(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Empleado p) {
        try {
            p.setESTEMP("I");
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
            empleados = new ArrayList<>();
            empleados = daos.listar();
        } catch (Exception e) {

        }
    }

    public void limpiar() {
        empleado = new Empleado();
    }

    public EmpleadoImpl getDaos() {
        return daos;
    }

    public void setDaos(EmpleadoImpl daos) {
        this.daos = daos;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Empleado getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Empleado seleccionado) {
        this.seleccionado = seleccionado;
    }

}
