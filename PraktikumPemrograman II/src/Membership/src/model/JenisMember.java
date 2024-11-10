/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Membership.src.model;

/**
 *
 * @author fadhi
 */

public class JenisMember {
    private String id;
    private String nama;

    // Default constructor
    public JenisMember() {}

    // Parameterized constructor
    public JenisMember(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
    }

    public String getId() {
        return id;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            throw new IllegalArgumentException("Nama cannot be null or empty");
        }
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return "JenisMember{id='" + id + "', nama='" + nama + "'}";
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}