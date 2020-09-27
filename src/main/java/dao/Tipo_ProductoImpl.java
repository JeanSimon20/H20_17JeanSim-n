package dao;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.Tipo_Producto;

public class Tipo_ProductoImpl extends Conexion implements ICRUD<Tipo_Producto> {

    @Override
    public void registrar(Tipo_Producto tip) throws Exception {
        String sql = "Insert into Tipo_Producto"
                + "(NOMPRO, ESTPRO) values(?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, tip.getNOMPRO());
            ps.setString(2, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en registrar Tipo_Producto" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificar(Tipo_Producto tip) throws Exception {
        String sql = "update Tipo_Producto set"
                + " NOMPRO=?, ESTPRO=? where IDTIP=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, tip.getNOMPRO());
            ps.setString(2, "A");
            ps.setInt(3, tip.getIDTIP());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en modificar Tipo_Producto" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificarEst(Tipo_Producto tip) throws Exception {
        String sql = "update Tipo_Producto set"
                + " ESTPRO = 'I' where IDTIP=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, tip.getIDTIP());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en ModificarEst Producto" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void eliminar(Tipo_Producto gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tipo_Producto> listar() throws Exception {
        List<Tipo_Producto> listado = new ArrayList<>();
        Tipo_Producto tip;
        String sql = "SELECT * FROM TIPO_PRODUCTO";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tip = new Tipo_Producto();
                tip.setIDTIP(rs.getInt("IDTIP"));
                tip.setNOMPRO(rs.getString("NOMPRO"));
                tip.setESTPRO(rs.getString("ESTPRO"));
                listado.add(tip);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la lista Tipo Producto" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

}
