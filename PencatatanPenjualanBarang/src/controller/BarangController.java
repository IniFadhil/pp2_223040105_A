/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Barang;
import model.BarangMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import view.BarangForm;

import javax.swing.*;
import java.util.List;

public class BarangController {
    private BarangForm view;
    private SqlSessionFactory sessionFactory;

    public BarangController(BarangForm view, SqlSessionFactory sessionFactory) {
        this.view = view;
        this.sessionFactory = sessionFactory;
    }

    public void loadTable() {
        try (SqlSession session = sessionFactory.openSession()) {
            BarangMapper mapper = session.getMapper(BarangMapper.class);
            List<Barang> barangList = mapper.getAllBarang();
            view.updateTable(barangList);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }

    public void saveBarang(Barang barang) {
        try (SqlSession session = sessionFactory.openSession()) {
            BarangMapper mapper = session.getMapper(BarangMapper.class);
            if (barang.getId() == 0) {
                mapper.insertBarang(barang);
            } else {
                mapper.updateBarang(barang);
            }
            session.commit();
            loadTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }

    public void deleteBarang(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            BarangMapper mapper = session.getMapper(BarangMapper.class);
            mapper.deleteBarang(id);
            session.commit();
            loadTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }
}
