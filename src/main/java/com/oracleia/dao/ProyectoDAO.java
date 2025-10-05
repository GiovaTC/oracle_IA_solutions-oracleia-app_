package com.oracleia.dao;

import com.oracleia.model.Proyecto;
import com.oracleia.util.ConexionOracle;
import java.sql.*;
import java.util.*;

public class ProyectoDAO {
    public List<Proyecto> listar() {
        List<Proyecto> list = new ArrayList<>();
        String sql = "SELECT * FROM PROYECTO ORDER BY id_proyecto";
        try (Connection c = ConexionOracle.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Proyecto(rs.getInt("id_proyecto"), rs.getString("nombre"),
                        rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getInt("id_empresa")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void insertar(Proyecto pto) {
        String sql = "INSERT INTO PROYECTO (id_proyecto, nombre, fecha_inicio, fecha_fin, id_empresa) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, pto.getIdProyecto());
            p.setString(2, pto.getNombre());
            p.setDate(3, new java.sql.Date(pto.getFechaInicio().getTime()));
            p.setDate(4, new java.sql.Date(pto.getFechaFin().getTime()));
            p.setInt(5, pto.getIdEmpresa());
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM PROYECTO WHERE id_proyecto = ?";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
