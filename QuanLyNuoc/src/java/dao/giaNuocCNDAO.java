/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.ConnectDB;
import entity.giaNuocCN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nal
 */
public class giaNuocCNDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public giaNuocCN getGiaNuocIDMax(){
        giaNuocCN u = new giaNuocCN();
        String query = "SELECT * FROM [TienNuoc].[dbo].[GiaNuocCaNhan] WHERE Id = (SELECT MAX(Id) FROM [TienNuoc].[dbo].[GiaNuocCaNhan])";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new giaNuocCN(rs.getInt(1),
                        rs.getString(2), 
                        rs.getFloat(3), 
                        rs.getInt(4)
                ));
            }             
        } catch (Exception e) {
        }
        return u;
    }
    public List<giaNuocCN> getAllgiaNuocCN(){
        List<giaNuocCN> list= new ArrayList<>();
        String query = "SELECT * FROM [TienNuoc].[dbo].[GiaNuocCaNhan]";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new giaNuocCN(rs.getInt(1),
                        rs.getString(2), 
                        rs.getFloat(3), 
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
        }
            
        return list;
    }
    public giaNuocCN getGiaNuocById(String id){
        giaNuocCN u = new giaNuocCN();
        String query = "SELECT * FROM [GiaNuocCaNhan] WHERE id = ?";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new giaNuocCN(rs.getInt(1),
                        rs.getString(2), 
                        rs.getFloat(3), 
                        rs.getInt(4)
                ));
            }
                    
        } catch (Exception e) {
        }
        return u;
    }
    public String deleteGiaNuocCN(String uid){
        String query = "DELETE FROM [TienNuoc].[dbo].[GiaNuocCaNhan]\n" +
                        " WHERE id = ?;";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
           int count = ps.executeUpdate();
            if(count > 0){
                return "X??a th??nh c??ng";
            }else{
                return "X??a kh??ng th??nh c??ng";
            }
            
        } catch (Exception e) {
             return "X??a kh??ng th??nh c??ng";
        }
    }
    public String addGiaNuocCN(String luongNuoc , String donGia, String namApdung ){
        String query = "INSERT INTO [TienNuoc].[dbo].[GiaNuocCaNhan] VALUES(?,?,?);";
        try {
           
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, luongNuoc);
            ps.setString(2, donGia);
            ps.setString(3, namApdung);
            int count = ps.executeUpdate();
            if(count > 0){
                return "Th??m th??nh c??ng";
            }else{
                return "Th??m kh??ng th??nh c??ng";
            }
            
        } catch (Exception e) {
            return "Th??m kh??ng th??nh c??ng";
        }
    }
    public String editGiaNuocCN(String luongNuoc , String donGia, String namApdung ,String id){
        String query =" UPDATE [TienNuoc].[dbo].[GiaNuocCaNhan]\n" +
                      " SET luongNuoc =?,donGia=?,namApDung=?\n" +
                      " WHERE id=?";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, luongNuoc);
            ps.setString(2, donGia);
            ps.setString(3, namApdung);
            ps.setString(4, id);
            int count = ps.executeUpdate();
            if(count > 0){
                return "C???p nh???t th??nh c??ng";
            }else{
                return "C???p nh???t kh??ng th??nh c??ng";
            }            
        } catch (Exception e) {
            return "C???p nh???t kh??ng th??nh c??ng";
        }
    }

}
