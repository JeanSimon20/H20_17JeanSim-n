package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteImpl extends Conexion implements ICRUD<Cliente> {

    @Override
    public void registrar(Cliente clin) throws Exception {
        String sql = "insert into Cliente"
                + "(NOMCLI, DIRCLI, TELCLI, ESTCLI) values (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, clin.getNOMCLI());
            ps.setString(2, clin.getDIRCLI());
            ps.setString(3, clin.getTELCLI());
            ps.setString(4, "A");
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
    public void modificar(Cliente clin) throws Exception {
        String sql = "update Cliente set"
                + " NOMCLI=?, DIRCLI=?, TELCLI=?, ESTCLI=? where IDCLI=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, clin.getNOMCLI());
            ps.setString(2, clin.getDIRCLI());
            ps.setString(3, clin.getTELCLI());
            ps.setString(4, "A");
            ps.setInt(5, clin.getIDCLI());
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
    public void modificarEst(Cliente cli) throws Exception {
        String sql = "update Cliente set"
                + " ESTCLI = 'I' where IDCLI=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, cli.getIDCLI());
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
    public void eliminar(Cliente gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar() throws Exception {
        List<Cliente> listado = new ArrayList<>();
        Cliente cli;
        String sql = "SELECT * FROM CLIENTE WHERE CLIENTE.ESTCLI = 'A' ORDER BY NOMCLI";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cli = new Cliente();
                cli.setIDCLI(rs.getInt("IDCLI"));
                cli.setNOMCLI(rs.getString("NOMCLI"));
                cli.setDIRCLI(rs.getString("DIRCLI"));
                cli.setTELCLI(rs.getString("TELCLI"));
                cli.setESTCLI(rs.getString("ESTCLI"));
                listado.add(cli);
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

