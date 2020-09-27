package Services;

import DTO.VentasDTO;
import dao.VentasImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ventas;

public class VentasServiceImpl implements VentasService {

    VentasImpl dao = new VentasImpl();

    @Override
    public void crear(VentasDTO ventasDTO) {
        Ventas ven = new Ventas();
        ven.setIDVEN(ventasDTO.getIDVEN());
        ven.setDESVEN(ventasDTO.getDESVEN());
        ven.setPREVEN(ventasDTO.getPREVEN());
        ven.setESTVEN(ventasDTO.getESTVEN());
        ven.setIDCLI(ventasDTO.getIDCLI());
        ven.setIDEMPL(ventasDTO.getIDEMP());
        try {
            dao.crear(ven);
        } catch (Exception ex) {
            Logger.getLogger(VentasServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(VentasDTO ventasDTO) {
        Ventas ven = new Ventas();
        ven.setIDVEN(ventasDTO.getIDVEN());
        ven.setDESVEN(ventasDTO.getDESVEN());
        ven.setPREVEN(ventasDTO.getPREVEN());
        ven.setESTVEN(ventasDTO.getESTVEN());
        ven.setIDCLI(ventasDTO.getIDCLI());
        ven.setIDEMPL(ventasDTO.getIDEMP());
        try {
            dao.modificar(ven);
        } catch (Exception ex) {
            Logger.getLogger(VentasServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEstado(Integer IDVEN) {
         Ventas ven = new Ventas();
        ven.setIDVEN(IDVEN);
        ven.setESTVEN("I");
        try {
            dao.modificarEst(ven);
        } catch (Exception ex) {
            Logger.getLogger(VentasServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<VentasDTO> listar() throws Exception {
        return dao.listar();
    }

}
