package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Empleado;

public class EmpleadoImpl extends Conexion implements ICRUD<Empleado> {

    @Override
    public void registrar(Empleado emp) throws Exception {
        String sql = "insert into Empleado"
                + "(NOMAPE, CELEMP, DNIEMP, COREMP, SEXEMP, ESTEMP) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, emp.getNOMAPE());
            ps.setString(2, emp.getCELEMP());
            ps.setString(3, emp.getDNIEMP());
            ps.setString(4, emp.getCOREMP());
            ps.setString(5, emp.getSEXEMP());
            ps.setString(6, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en registrar ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificar(Empleado emp) throws Exception {
        String sql = "update Empleado set"
                + " NOMAPE=?, CELEMP=?, DNIEMP=?, COREMP=?, SEXEMP=?, ESTEMP=? where IDEMP=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, emp.getNOMAPE());
            ps.setString(2, emp.getCELEMP());
            ps.setString(3, emp.getDNIEMP());
            ps.setString(4, emp.getCOREMP());
            ps.setString(5, emp.getSEXEMP());
            ps.setString(6, "A");
            ps.setInt(7, emp.getIDEMP());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificarEst(Empleado emp) throws Exception {
        String sql = "update Empleado set"
                + " ESTEM = 'I' where IDEMP=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, emp.getIDEMP());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en ModificarEst ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void eliminar(Empleado gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> listar() throws Exception {
        List<Empleado> listado = new ArrayList<>();
        Empleado emp;
        String sql = "SELECT * FROM EMPLEADO";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                emp = new Empleado();
                emp.setIDEMP(rs.getInt("IDEMP"));
                emp.setNOMAPE(rs.getString("NOMAPE"));
                emp.setCELEMP(rs.getString("CELEMP"));
                emp.setDNIEMP(rs.getString("DNIEMP"));
                emp.setCOREMP(rs.getString("COREMP"));
                emp.setSEXEMP(rs.getString("SEXEMP"));
                emp.setESTEMP(rs.getString("ESTEMP"));
                listado.add(emp);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la lisa ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

}
