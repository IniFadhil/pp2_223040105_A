/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author T U F
 */
import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import view.BarangForm;

import java.io.InputStream;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // Berikan sqlSessionFactory ke BarangForm
            SwingUtilities.invokeLater(() -> new BarangForm(sqlSessionFactory));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

