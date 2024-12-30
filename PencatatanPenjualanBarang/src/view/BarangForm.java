/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.BarangController;
import model.Barang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory; // Tambahkan import ini

public class BarangForm extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtNama, txtStok, txtHarga, txtKategori;
    private JButton btnSave, btnDelete, btnReset;
    private BarangController controller;

    public BarangForm(SqlSessionFactory sessionFactory) { // Tambahkan parameter ini
        setTitle("Pencatatan Penjualan Barang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Inisialisasi controller dengan sessionFactory
        controller = new BarangController(this, sessionFactory);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nama", "Stok", "Harga", "Kategori"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panelForm = new JPanel(new GridLayout(5, 2));
        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("Stok:"));
        txtStok = new JTextField();
        panelForm.add(txtStok);

        panelForm.add(new JLabel("Harga:"));
        txtHarga = new JTextField();
        panelForm.add(txtHarga);

        panelForm.add(new JLabel("Kategori:"));
        txtKategori = new JTextField();
        panelForm.add(txtKategori);

        btnSave = new JButton("Simpan");
        btnSave.addActionListener(e -> {
            Barang barang = new Barang();
            barang.setNama(txtNama.getText());
            barang.setStok(Integer.parseInt(txtStok.getText()));
            barang.setHarga(Double.parseDouble(txtHarga.getText()));
            barang.setKategori(txtKategori.getText());
            controller.saveBarang(barang);
        });

        btnDelete = new JButton("Hapus");
        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                controller.deleteBarang(id);
            }
        });

        btnReset = new JButton("Reset");
        btnReset.addActionListener(e -> resetForm());

        panelForm.add(btnSave);
        panelForm.add(btnDelete);
        add(panelForm, BorderLayout.SOUTH);

        controller.loadTable();
        setVisible(true);
    }

    public void updateTable(List<Barang> barangList) {
        tableModel.setRowCount(0);
        for (Barang barang : barangList) {
            tableModel.addRow(new Object[]{barang.getId(), barang.getNama(), barang.getStok(), barang.getHarga(), barang.getKategori()});
        }
    }

    private void resetForm() {
        txtNama.setText("");
        txtStok.setText("");
        txtHarga.setText("");
        txtKategori.setText("");
    }
}
