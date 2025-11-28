/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoController {
    private final AlmacenamientoService service = new AlmacenamientoService(new AlmacenamientoDAO());

    public AlmacenamientoDTO registrarIngreso(String producto, double cantidad, java.time.LocalDate ingreso) {
        AlmacenamientoDTO dto = new AlmacenamientoDTO();
        dto.setProducto(producto);
        dto.setCantidad(cantidad);
        dto.setFechaIngreso(ingreso);
        return service.registrar(dto);
    }

    public List<AlmacenamientoDTO> listarInventario() {
        return service.listar();
    }
}
