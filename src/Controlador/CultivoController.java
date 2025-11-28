/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CultivoDAO;
import Enum.EstadoCrecimiento;
import Enum.TipoCultivo;
import Modelo.CultivoDTO;
import Servicios.CultivoServicios;
import java.sql.Date;
import java.util.List;



/**
 *
 * @author gipsy
 */
public class CultivoController {
    private final CultivoServicios servicios = new CultivoServicios(new CultivoDAO());
   public CultivoDTO crearCultivo(String Nombre, TipoCultivo tipo, double AreaSembrada, EstadoCrecimiento  estadoCrecimiento, Date FechaSiembra, Date FechaCosecha) {
        CultivoDTO dto = new CultivoDTO();
        dto.setNombre(Nombre);
        dto.setTipo(tipo);
        dto.setAreaSembrada(AreaSembrada);
        dto.setEstadoCrecimiento(estadoCrecimiento);
        dto.setFechaSiembra(FechaSiembra);
        dto.setFechaCosecha(FechaCosecha);
        return servicios.crear(dto);
    }
  
    public List<CultivoDTO> listarCultivos(String filtroNombre)
    { return servicios.listar(filtroNombre);
    }
    public boolean actualizarCultivo(CultivoDTO dto) 
    { return servicios.actualizar(dto); 
    }
    public boolean eliminarCultivo(int id)
    { return servicios.eliminar(id);
    }
}
 

