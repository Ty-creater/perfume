package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Items;
import util.DBHelper;

public class ItemsDAO {
	// 获得所有的商品信息
	public ArrayList<Items> getAllItems()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>(); // 商品集合
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select * from perfume;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) 
			{
				Items item = new Items();
				item.setId(rs.getInt("Id"));
				item.setName(rs.getString("Name"));
				item.setEngName(rs.getString("EngName"));
				item.setBrand(rs.getString("Brand"));
				item.setPrice(rs.getDouble("Price"));
				item.setDesc(rs.getString("Desc"));
				item.setPhoto(rs.getString("Photo"));
				item.setStock(rs.getInt("Stock"));
				list.add(item);// 把一个商品加入集合
			}
			return list; // 返回集合。
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			// 释放数据集对象
			if (rs != null)
			{
				try
				{
					rs.close();
					rs = null;
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null)
			{
				try
				{
					stmt.close();
					stmt = null;
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
	// 根据商品编号获得商品资料
	public Items getItemsById(int id)
	{
		Connection conn = null;
		PreparedStatement stmt = null;	
		ResultSet rs = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select * from perfume where id=?;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next())
			{
				Items item = new Items();
				item.setId(rs.getInt("Id"));
				item.setName(rs.getString("Name"));
				item.setEngName(rs.getString("EngName"));
				item.setBrand(rs.getString("Brand"));
				item.setPrice(rs.getDouble("Price"));
				item.setDesc(rs.getString("Desc"));
				item.setPhoto(rs.getString("Photo"));
				item.setStock(rs.getInt("Stock"));
				return item;
			}
			else
			{
				return null;
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			// 释放数据集对象
			if (rs != null)
			{
				try
				{
					rs.close();
					rs = null;
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null)
			{
				try
				{
					stmt.close();
					stmt = null;
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
}
