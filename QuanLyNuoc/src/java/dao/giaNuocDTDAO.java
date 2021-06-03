/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.ConnectDB;
import entity.giaNuocDT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nal
 */
public class giaNuocDTDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<giaNuocDT> getAllgiaNuocDT(){
        List<giaNuocDT> list= new ArrayList<>();
        String query = "SELECT * FROM [TienNuoc].[dbo].[GiaNuocDoanThe]";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new giaNuocDT(rs.getInt(1),
                        rs.getString(2), 
                        rs.getFloat(3), 
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
        }
            
        return list;
    }
    public giaNuocDT getGiaNuocById(String id){
        giaNuocDT u = new giaNuocDT();
        String query = "SELECT * FROM [GiaNuocDoanThe] WHERE id = ?";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new giaNuocDT(rs.getInt(1),
                        rs.getString(2), 
                        rs.getFloat(3), 
                        rs.getInt(4)
                ));
            }
                    
        } catch (Exception e) {
        }
        return u;
    }
    public String deleteGiaNuocDT(String uid){
        String query = "DELETE FROM [TienNuoc].[dbo].[GiaNuocDoanThe]\n" +
                        " WHERE id = ?;";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
           int count = ps.executeUpdate();
            if(count > 0){
                return "Xóa thành công";
            }else{
                return "Xóa không thành công";
            }
            
        } catch (Exception e) {
             return "Xóa không thành công";
        }
    }
    public String addGiaNuocDT(String doiTuong , String donGia, String namApdung ){
        String query = "INSERT INTO [TienNuoc].[dbo].[GiaNuocDoanThe] VALUES(?,?,?);";
        try {
           
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, doiTuong);
            ps.setString(2, donGia);
            ps.setString(3, namApdung);
            int count = ps.executeUpdate();
            if(count > 0){
                return "Thêm thành công";
            }else{
                return "Thêm không thành công";
            }
            
        } catch (Exception e) {
            return "Thêm không thành công";
        }
    }
    public String editGiaNuocDT(String doiTuong , String donGia, String namApdung ,String id){
        String query =" UPDATE [TienNuoc].[dbo].[GiaNuocDoanThe]\n" +
                      " SET doiTuong=?,donGia=?,namApDung=?\n" +
                      " WHERE id=?";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, doiTuong);
            ps.setString(2, donGia);
            ps.setString(3, namApdung);
            ps.setString(4, id);
            int count = ps.executeUpdate();
            if(count > 0){
                return "Cập nhật thành công";
            }else{
                return "Cập nhật không thành công";
            }            
        } catch (Exception e) {
            return "Cập nhật không thành công";
        }
    }
}
