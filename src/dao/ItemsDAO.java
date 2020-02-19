package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Items;
import util.DBHelper;

public class ItemsDAO {
	// ������е���Ʒ��Ϣ
	public ArrayList<Items> getAllItems()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>(); // ��Ʒ����
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select * from perfume;"; // SQL���
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
				list.add(item);// ��һ����Ʒ���뼯��
			}
			return list; // ���ؼ��ϡ�
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			// �ͷ����ݼ�����
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
			// �ͷ�������
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
	// ������Ʒ��Ż����Ʒ����
	public Items getItemsById(int id)
	{
		Connection conn = null;
		PreparedStatement stmt = null;	
		ResultSet rs = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select * from perfume where id=?;"; // SQL���
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
			// �ͷ����ݼ�����
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
			// �ͷ�������
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
