package com.oracleia.ui;

import com.oracleia.dao.*;
import com.oracleia.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Date;

public class MainFrame extends JFrame {
    private JTabbedPane tabs = new JTabbedPane();

    public MainFrame() {
        super("Oracle IA Solutions - Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        tabs.addTab("EMPRESA", createEmpresaPanel());
        tabs.addTab("EMPLEADO", createEmpleadoPanel());
        tabs.addTab("PROYECTO", createProyectoPanel());
        tabs.addTab("CLIENTE", createClientePanel());
        tabs.addTab("FACTURA", createFacturaPanel());
        tabs.addTab("TECNOLOGIA", createTecnologiaPanel());

        add(tabs);
    }

    private JPanel createEmpresaPanel() {
        EmpresaDAO dao = new EmpresaDAO();
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"ID", "NOMBRE", "DIRECCION", "TELEFONO"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        JButton btnLoad = new JButton("Cargar");
        JButton btnAdd = new JButton("Insertar ejemplo");
        JButton btnDelete = new JButton("Eliminar seleccionado");

        btnLoad.addActionListener(e -> {
            model.setRowCount(0);
            List<Empresa> list = dao.listar();
            for (Empresa em : list) {
                model.addRow(new Object[]{em.getIdEmpresa(), em.getNombre(), em.getDireccion(), em.getTelefono()});
            }
        });
        btnAdd.addActionListener(e -> {
            int nextId = model.getRowCount() + 1;
            Empresa em = new Empresa(nextId, "Empresa UI " + nextId, "Direccion UI", "000-0000");
            dao.insertar(em);
            btnLoad.doClick();
        });
        btnDelete.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                int id = (int) model.getValueAt(r, 0);
                dao.eliminar(id);
                btnLoad.doClick();
            }
        });

        JPanel top = new JPanel();
        top.add(btnLoad); top.add(btnAdd); top.add(btnDelete);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    private JPanel createEmpleadoPanel() {
        EmpleadoDAO dao = new EmpleadoDAO();
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"ID", "NOMBRE", "PUESTO", "SALARIO", "ID_EMPRESA"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        JButton btnLoad = new JButton("Cargar");
        JButton btnAdd = new JButton("Insertar ejemplo");
        JButton btnDelete = new JButton("Eliminar seleccionado");

        btnLoad.addActionListener(e -> {
            model.setRowCount(0);
            List<Empleado> list = dao.listar();
            for (Empleado em : list) {
                model.addRow(new Object[]{em.getIdEmpleado(), em.getNombre(), em.getPuesto(), em.getSalario(), em.getIdEmpresa()});
            }
        });
        btnAdd.addActionListener(e -> {
            int nextId = model.getRowCount() + 1;
            Empleado em = new Empleado(nextId, "Empleado UI " + nextId, "Dev", 3000 + nextId*10, 1);
            dao.insertar(em);
            btnLoad.doClick();
        });
        btnDelete.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                int id = (int) model.getValueAt(r, 0);
                dao.eliminar(id);
                btnLoad.doClick();
            }
        });

        JPanel top = new JPanel();
        top.add(btnLoad); top.add(btnAdd); top.add(btnDelete);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    private JPanel createProyectoPanel() {
        ProyectoDAO dao = new ProyectoDAO();
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"ID", "NOMBRE", "FECHA_INI", "FECHA_FIN", "ID_EMPRESA"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        JButton btnLoad = new JButton("Cargar");
        JButton btnAdd = new JButton("Insertar ejemplo");
        JButton btnDelete = new JButton("Eliminar seleccionado");

        btnLoad.addActionListener(e -> {
            model.setRowCount(0);
            List<Proyecto> list = dao.listar();
            for (Proyecto pr : list) {
                model.addRow(new Object[]{pr.getIdProyecto(), pr.getNombre(), pr.getFechaInicio(), pr.getFechaFin(), pr.getIdEmpresa()});
            }
        });
        btnAdd.addActionListener(e -> {
            int nextId = model.getRowCount() + 1;
            Date now = new Date();
            Proyecto pr = new Proyecto(nextId, "Proyecto UI " + nextId, now, new Date(now.getTime()+86400000L*30), 1);
            dao.insertar(pr);
            btnLoad.doClick();
        });
        btnDelete.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                int id = (int) model.getValueAt(r, 0);
                dao.eliminar(id);
                btnLoad.doClick();
            }
        });

        JPanel top = new JPanel();
        top.add(btnLoad); top.add(btnAdd); top.add(btnDelete);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    private JPanel createClientePanel() {
        ClienteDAO dao = new ClienteDAO();
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"ID", "NOMBRE", "EMAIL", "TELEFONO"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        JButton btnLoad = new JButton("Cargar");
        JButton btnAdd = new JButton("Insertar ejemplo");
        JButton btnDelete = new JButton("Eliminar seleccionado");

        btnLoad.addActionListener(e -> {
            model.setRowCount(0);
            List<Cliente> list = dao.listar();
            for (Cliente cl : list) {
                model.addRow(new Object[]{cl.getIdCliente(), cl.getNombre(), cl.getEmail(), cl.getTelefono()});
            }
        });
        btnAdd.addActionListener(e -> {
            int nextId = model.getRowCount() + 1;
            Cliente cl = new Cliente(nextId, "Cliente UI " + nextId, "ui"+nextId+"@cliente.com", "000-0000");
            dao.insertar(cl);
            btnLoad.doClick();
        });
        btnDelete.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                int id = (int) model.getValueAt(r, 0);
                dao.eliminar(id);
                btnLoad.doClick();
            }
        });

        JPanel top = new JPanel();
        top.add(btnLoad); top.add(btnAdd); top.add(btnDelete);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    private JPanel createFacturaPanel() {
        FacturaDAO dao = new FacturaDAO();
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"ID", "ID_CLIENTE", "ID_PROYECTO", "MONTO", "FECHA"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        JButton btnLoad = new JButton("Cargar");
        JButton btnAdd = new JButton("Insertar ejemplo");
        JButton btnDelete = new JButton("Eliminar seleccionado");

        btnLoad.addActionListener(e -> {
            model.setRowCount(0);
            List<Factura> list = dao.listar();
            for (Factura f : list) {
                model.addRow(new Object[]{f.getIdFactura(), f.getIdCliente(), f.getIdProyecto(), f.getMonto(), f.getFechaEmision()});
            }
        });
        btnAdd.addActionListener(e -> {
            int nextId = model.getRowCount() + 1;
            Factura f = new Factura(nextId, 1, 1, 1000 + nextId*10, new Date());
            dao.insertar(f);
            btnLoad.doClick();
        });
        btnDelete.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                int id = (int) model.getValueAt(r, 0);
                dao.eliminar(id);
                btnLoad.doClick();
            }
        });

        JPanel top = new JPanel();
        top.add(btnLoad); top.add(btnAdd); top.add(btnDelete);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    private JPanel createTecnologiaPanel() {
        TecnologiaDAO dao = new TecnologiaDAO();
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"ID", "NOMBRE", "VERSION"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        JButton btnLoad = new JButton("Cargar");
        JButton btnAdd = new JButton("Insertar ejemplo");
        JButton btnDelete = new JButton("Eliminar seleccionado");

        btnLoad.addActionListener(e -> {
            model.setRowCount(0);
            List<Tecnologia> list = dao.listar();
            for (Tecnologia t : list) {
                model.addRow(new Object[]{t.getIdTecnologia(), t.getNombre(), t.getVersion()});
            }
        });
        btnAdd.addActionListener(e -> {
            int nextId = model.getRowCount() + 1;
            Tecnologia t = new Tecnologia(nextId, "Tecnologia UI " + nextId, "v1.0");
            dao.insertar(t);
            btnLoad.doClick();
        });
        btnDelete.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                int id = (int) model.getValueAt(r, 0);
                dao.eliminar(id);
                btnLoad.doClick();
            }
        });

        JPanel top = new JPanel();
        top.add(btnLoad); top.add(btnAdd); top.add(btnDelete);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }
}
