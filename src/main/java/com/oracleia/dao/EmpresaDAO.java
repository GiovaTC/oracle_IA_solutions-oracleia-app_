package com.oracleia.dao;

import com.oracleia.model.Empresa;
import com.oracleia.util.ConexionOracle;
import java.sql.*;
import java.util.*;

public class EmpresaDAO {
    public List<Empresa> listar() {
        List<Empresa> list = new ArrayList<>();
        String sql = "SELECT * FROM EMPRESA ORDER BY id_empresa";
        try (Connection c = ConexionOracle.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Empresa(rs.getInt("id_empresa"), rs.getString("nombre"),
                        rs.getString("direccion"), rs.getString("telefono")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void insertar(Empresa e) {
        String sql = "INSERT INTO EMPRESA (id_empresa, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, e.getIdEmpresa());
            p.setString(2, e.getNombre());
            p.setString(3, e.getDireccion());
            p.setString(4, e.getTelefono());
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM EMPRESA WHERE id_empresa = ?";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
