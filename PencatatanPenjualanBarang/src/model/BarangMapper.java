/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface BarangMapper {
    @Select("SELECT * FROM barang")
    List<Barang> getAllBarang();

    @Insert("INSERT INTO barang (nama, stok, harga, kategori) VALUES (#{nama}, #{stok}, #{harga}, #{kategori})")
    void insertBarang(Barang barang);

    @Update("UPDATE barang SET nama=#{nama}, stok=#{stok}, harga=#{harga}, kategori=#{kategori} WHERE id=#{id}")
    void updateBarang(Barang barang);

    @Delete("DELETE FROM barang WHERE id=#{id}")
    void deleteBarang(int id);
}
