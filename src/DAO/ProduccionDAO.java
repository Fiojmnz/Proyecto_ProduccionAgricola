/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DB.ConnectionFactory;
import Enum.Destino;
import Modelo.Produccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author AsusVivobook
 */
public class ProduccionDAO {
public boolean agregar(Produccion p) {
        String sql = "INSERT INTO produccion(Cultivoid, Fecha, CantidadRecolectada,Calidad, Destino) VALUES (";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, p.getCultivoId());
            ps.setDate(2, p.getFecha());
            ps.setDouble(3, p.getCantidadRecolectada());
            ps.setString(4, p.getCalidad());
            ps.setString(5, p.getDestino().name());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) { if (rs.next()) p.setId(rs.getInt(1)); }
            return true;
        } catch (SQLException e) { throw new RuntimeException("Error a la agregar producción", e); }
    }

    public List<Produccion> listarPorFecha(Date desde, Date hasta) {
        String sql = "SELECT * FROM produccion WHERE fecha BETWEEN  AND ";
        List<Produccion> list = new ArrayList<>();
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, desde);
            ps.setDate(2, hasta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
            return list;
        } catch (SQLException e) { throw new RuntimeException("Error a la listar producción", e); }
    }

    private Produccion map(ResultSet rs) throws SQLException {
        Produccion p = new Produccion();
        p.setId(rs.getInt("id"));
        p.setCultivoId(rs.getInt("CultivoId"));
        p.setFecha(rs.getDate("Fecha"));
        p.setCantidadRecolectada(rs.getDouble("CantidadRecolectada"));
        p.setCalidad(rs.getString("Calidad"));
       p.setDestino(Destino.valueOf(rs.getString("Destino")));
        return p;
    }
}