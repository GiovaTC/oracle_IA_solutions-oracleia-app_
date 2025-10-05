package com.oracleia.dao;

import com.oracleia.model.Factura;
import com.oracleia.util.ConexionOracle;
import java.sql.*;
import java.util.*;

public class FacturaDAO {
    public List<Factura> listar() {
        List<Factura> list = new ArrayList<>();
        String sql = "SELECT * FROM FACTURA ORDER BY id_factura";
        try (Connection c = ConexionOracle.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Factura(rs.getInt("id_factura"), rs.getInt("id_cliente"),
                        rs.getInt("id_proyecto"), rs.getDouble("monto"), rs.getDate("fecha_emision")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void insertar(Factura f) {
        String sql = "INSERT INTO FACTURA (id_factura, id_cliente, id_proyecto, monto, fecha_emision) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, f.getIdFactura());
            p.setInt(2, f.getIdCliente());
            p.setInt(3, f.getIdProyecto());
            p.setDouble(4, f.getMonto());
            p.setDate(5, new java.sql.Date(f.getFechaEmision().getTime()));
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM FACTURA WHERE id_factura = ?";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
