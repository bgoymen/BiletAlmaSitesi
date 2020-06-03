/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Document;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Göymen
 */
public class DocumentDao extends DBConnection {

    public List<Document> read(int id) {
        List<Document> list = new ArrayList<>();
        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from document");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt("user_id") == id) {
                    Document d = new Document(rs.getInt("user_id"), rs.getString("filePath"), rs.getString("fileName"), rs.getString("fileType"));
                    list.add(d);
                }

            }
        } catch (SQLException e) {
            System.out.println("Hata(DocumenDao(read): " + e.getMessage());
        }
        return list;
    }

    public void create(Document d) {

        List<Document> list = this.read(d.getUser_id());
        if (list != null) {
            try {
                PreparedStatement pst = this.connect().prepareStatement("delete from document where user_id=" + d.getUser_id());
                pst.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Hata(DocumenDao(create1): " + e.getMessage());
            }
        }
        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into document(user_id,filePath,fileName,fileType) values(?,?,?,?)");

            pst.setInt(1, d.getUser_id());
            pst.setString(2, d.getFilePath());
            pst.setString(3, d.getFileName());
            pst.setString(4, d.getFileType());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Hata(DocumenDao(create2): " + e.getMessage());
        }
    }
}
