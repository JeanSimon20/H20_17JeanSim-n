package dao;

import DTO.VentasDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Ventas;

public class VentasImpl extends Conexion {

    public void crear(Ventas ven) throws Exception {
        String sql = "insert into Ventas"
                + "(IDCLI, IDEMP, DESVEN, PREVEN, ESTVEN) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, ven.getIDCLI());
            ps.setInt(2, ven.getIDEMPL());
            ps.setString(3, ven.getDESVEN());
            ps.setDouble(4, ven.getPREVEN());
            ps.setString(5, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en registrar Producto" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificar(Ventas ven) throws Exception {
        String sql = "update Ventas set"
                + " IDCLI=?, IDEMP=?, DESVEN=?, PREVEN=?, ESTVEN=? where IDVEN=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, ven.getIDCLI());
            ps.setInt(2, ven.getIDEMPL());
            ps.setString(3, ven.getDESVEN());
            ps.setDouble(4, ven.getPREVEN());
            ps.setString(5, "A");
            ps.setInt(6, ven.getIDVEN());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en modificar Producto" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificarEst(Ventas ven) throws Exception {
        String sql = "update Ventas set"
                + " ESTVEN = 'I' where IDVEN=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, ven.getIDVEN());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en ModificarEst ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public List<VentasDTO> listar() throws Exception {
        List<VentasDTO> listado = new ArrayList<>();
        VentasDTO ven = null;
        String sql = "select VENTAS.IDVEN, VENTAS.DESVEN, VENTAS.PREVEN, VENTAS.ESTVEN, CLIENTE.IDCLI, CLIENTE.NOMCLI, EMPLEADO.IDEMP, EMPLEADO.NOMAPE from ventas\n"
                + "inner join CLIENTE ON CLIENTE.IDCLI = VENTAS.IDCLI\n"
                + "inner join EMPLEADO ON EMPLEADO.IDEMP = VENTAS.IDEMP";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ven.setIDVEN(rs.getInt("IDVEN"));
                ven.setDESVEN(rs.getString("DESVEN"));
                ven.setPREVEN(rs.getDouble("PREVEN"));
                ven.setESTVEN(rs.getString("ESTVEN"));
                ven.setIDCLI(rs.getInt("IDCLI"));
                ven.setCliente(rs.getString("NOMCLI"));
                ven.setIDEMP(rs.getInt("IDEMP"));
                ven.setEmpleado(rs.getString("NOMAPE"));
                listado.add(ven);
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
