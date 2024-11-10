/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Membership.src.dao;

import src.Membership.src.db.MySqlConnection;
import src.Membership.src.model.JenisMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JenisMemberDao {

    // Insert method
    public int insert(JenisMember jenisMember) {
        int result = -1;
        String sql = "INSERT INTO jenis_member (id, nama) VALUES (?, ?)";

        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, jenisMember.getId());
            statement.setString(2, jenisMember.getNama());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging instead of printStackTrace in production
        }

        return result;
    }

    // Update method
    public int update(JenisMember jenisMember) {
        int result = -1;
        String sql = "UPDATE jenis_member SET nama = ? WHERE id = ?";

        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, jenisMember.getNama());
            statement.setString(2, jenisMember.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging instead of printStackTrace in production
        }

        return result;
    }

    // Delete method
    public int delete(JenisMember jenisMember) {
        int result = -1;
        String sql = "DELETE FROM jenis_member WHERE id = ?";

        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, jenisMember.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging instead of printStackTrace in production
        }

        return result;
    }

    // Find all method
    public List<JenisMember> findAll() {
        List<JenisMember> list = new ArrayList<>();
        String sql = "SELECT * FROM jenis_member";

        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                JenisMember jenisMember = new JenisMember();
                jenisMember.setId(resultSet.getString("id")); // Assuming id is an integer
                jenisMember.setNama(resultSet.getString("nama"));
                list.add(jenisMember);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging instead of printStackTrace in production
        }

        return list;
    }
}
