package com.oracleia.dao;

import com.oracleia.model.Cliente;
import com.oracleia.util.ConexionOracle;
import java.sql.*;
import java.util.*;

public class ClienteDAO {
    public List<Cliente> listar() {
        List<Cliente> list = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE ORDER BY id_cliente";
        try (Connection c = ConexionOracle.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"),
                        rs.getString("email"), rs.getString("telefono")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void insertar(Cliente cl) {
        String sql = "INSERT INTO CLIENTE (id_cliente, nombre, email, telefono) VALUES (?, ?, ?, ?)";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, cl.getIdCliente());
            p.setString(2, cl.getNombre());
            p.setString(3, cl.getEmail());
            p.setString(4, cl.getTelefono());
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM CLIENTE WHERE id_cliente = ?";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
