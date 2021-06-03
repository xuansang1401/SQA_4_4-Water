/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.ConnectDB;

import entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nal
 */
public class UsersDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Users> getAllUser(){
        List<Users> list= new ArrayList<>();
        String query = "SELECT * FROM [TienNuoc].[dbo].[Users]";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Users(rs.getString(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {
        }
            
        return list;
    }
    public Users getUserById(String id){
        Users u = new Users();
        String query = "SELECT * FROM [Users] WHERE id = ?";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new Users(rs.getString(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getFloat(7)
                ));
            }
                    
        } catch (Exception e) {
           
        }
        return u;
    }
    
    public Users getUserIDMax(){
        Users u = new Users();
        String query = "SELECT * FROM [Users] WHERE Id = (SELECT MAX(Id) FROM [Users])";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new Users(rs.getString(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getFloat(7)
                ));
            }             
        } catch (Exception e) {
        }
        return u;
    }
    public String deleteUser(String uid){
        String query = "DELETE FROM [TienNuoc].[dbo].[Users]\n" +
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
    public String addUser(String name , String email, String address , String phone  , String numberWater , String totalMoney){
        String query = "INSERT INTO [TienNuoc].[dbo].[Users] VALUES(?,?,?,?,?,?);";
        try {   
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, numberWater);
            ps.setString(6, totalMoney);
            
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
    public String editUser(String name , String email, String address , String phone  , String numberWater , String totalMoney,String id){
        String query =" UPDATE [TienNuoc].[dbo].[Users]\n" +
                      " SET FullName =?,Email=?,Adress=?,Phone=?,NumberWater=?,TotalMoney=?\n" +
                      " WHERE id=?";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, numberWater);
            ps.setString(6, totalMoney);
            ps.setString(7, id);
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
    public static void main(String[] args) {
        UsersDAO dao = new UsersDAO();
        List<Users> list = dao.getAllUser();
        for (Users o : list) {
            System.out.println(o);
        }
    }
}