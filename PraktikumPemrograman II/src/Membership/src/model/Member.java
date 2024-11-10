/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Membership.src.model;

/**
 *
 * @author fadhi
 */

public class Member {
    private String id;
    private String nama;
    private JenisMember jenisMember;

    // Default constructor
    public Member() {}

    // Parameterized constructor
    public Member(String id, String nama, JenisMember jenisMember) {
        this.id = id;
        this.nama = nama;
        this.jenisMember = jenisMember;
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

    public void setJenisMember(JenisMember jenisMember) {
        if (jenisMember != null) {
            this.jenisMember = jenisMember;
        } else {
            throw new IllegalArgumentException("JenisMember cannot be null");
        }
    }

    public JenisMember getJenisMember() {
        return jenisMember;
    }

    @Override
    public String toString() {
        return "Member{id='" + id + "', nama='" + nama + "', jenisMember=" + jenisMember + "}";
    }
}
