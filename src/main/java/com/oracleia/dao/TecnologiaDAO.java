package com.oracleia.dao;

import com.oracleia.model.Tecnologia;
import com.oracleia.util.ConexionOracle;
import java.sql.*;
import java.util.*;

public class TecnologiaDAO {
    public List<Tecnologia> listar() {
        List<Tecnologia> list = new ArrayList<>();
        String sql = "SELECT * FROM TECNOLOGIA ORDER BY id_tecnologia";
        try (Connection c = ConexionOracle.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Tecnologia(rs.getInt("id_tecnologia"), rs.getString("nombre"),
                        rs.getString("version")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void insertar(Tecnologia t) {
        String sql = "INSERT INTO TECNOLOGIA (id_tecnologia, nombre, version) VALUES (?, ?, ?)";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, t.getIdTecnologia());
            p.setString(2, t.getNombre());
            p.setString(3, t.getVersion());
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM TECNOLOGIA WHERE id_tecnologia = ?";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
