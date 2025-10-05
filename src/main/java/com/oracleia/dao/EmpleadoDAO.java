package com.oracleia.dao;

import com.oracleia.model.Empleado;
import com.oracleia.util.ConexionOracle;
import java.sql.*;
import java.util.*;

public class EmpleadoDAO {
    public List<Empleado> listar() {
        List<Empleado> list = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADO ORDER BY id_empleado";
        try (Connection c = ConexionOracle.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Empleado(rs.getInt("id_empleado"), rs.getString("nombre"),
                        rs.getString("puesto"), rs.getDouble("salario"), rs.getInt("id_empresa")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void insertar(Empleado e) {
        String sql = "INSERT INTO EMPLEADO (id_empleado, nombre, puesto, salario, id_empresa) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, e.getIdEmpleado());
            p.setString(2, e.getNombre());
            p.setString(3, e.getPuesto());
            p.setDouble(4, e.getSalario());
            p.setInt(5, e.getIdEmpresa());
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM EMPLEADO WHERE id_empleado = ?";
        try (Connection c = ConexionOracle.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
