/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import models.Product;

/**
 *
 * @author thanh
 */
public class DAO extends DBContext {
    //doc tat ca cac ban ghi tu categories ra

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(
                        rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("describe"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    //Tim 1 Category co id
    public Category getCategoryById(int id) {
        String sql = "select * from Categories where ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(
                        rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("describe"));
                return c;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public List<Product> getProductByCid(int cid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[name]\n"
                + "      ,[quantity]\n"
                + "      ,[price]\n"
                + "      ,[releaseDate]\n"
                + "      ,[describe]\n"
                + "      ,[image]\n"
                + "      ,[cid]\n"
                + "  FROM [dbo].[products]\n"
                + "  WHERE 1=1";
        if (cid != 0) {
            sql += " and cid=" + cid;

        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getString("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = getCategoryById(rs.getInt("cid"));
                p.setCategory(c);
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> search(String key, Date from, Date to, Double price1, Double price2, int cid) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where 1=1 ";
        if (key != null && !key.equals("")) {
            sql += "and name like '%" + key + "%' or describe like '%" + key + "%'";
        }
        if (from != null) {
            sql += " and releaseDate>='" + from + "'";
        }
        if (to != null) {
            sql += " and releaseDate<='" + to + "'";
        }
        if (price1 != null) {
            sql += " and price>=" + price1;
        }
        if (price2 != null) {
            sql += " and price<=" + price2;
        }
        if(cid!=0){
            sql+=" and cid="+cid;
        }
        try {
              PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getString("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = getCategoryById(rs.getInt("cid"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
