/**
 * 
 */
package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.UserDao;
import com.bank.po.User;
import com.bank.util.DBUtil;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserDao的实现类
 * @version bank 2.0
 */
public class UserDao4MySqlImpl implements UserDao {

	/* (non-Javadoc)
	 * @see com.bank.dao.UserDao#addUser(com.bank.po.User)
	 * 添加用户
	 */
	public void addUser(User user) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "insert into bank_user values(null,?,?,?)");
		try {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setDouble(3, user.getMoney());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
	}

	/*  
	 * 通过用户名查找用户，返回一个User类型的对象
	 */
	public User findUserByUsername(String username, String passwrod) {
		User user = null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from bank_user where username=?");
		ResultSet rs = null;
		try {
			pstmt.setString(1, username);
			rs = DBUtil.getRs(pstmt);
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMoney(rs.getDouble("money"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return user;
	}

	/*  
	 * 通过id更新用户的金额
	 */
	public User saveMoneyById(double money,int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "update bank_user set money=? where id=?");
		try {
			pstmt.setDouble(1, money);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return this.findUserById(id);
	}

	/*  
	 * 通过id找到用户名
	 */
	public User findUserById(int id) {
		User  user = null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from bank_user where id=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, id);
			rs = DBUtil.getRs(pstmt);
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMoney(rs.getDouble("money"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return user;
	}

	/*  
	 * 通过id更新用户金额
	 */
	public User getMoneyById(double money, int id) {
		User user = null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "update bank_user set money=? where id=?");
		try {
			pstmt.setDouble(1, money);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return this.findUserById(id);
	}

	/*  
	 * 通过id查询金额
	 */
	public User checkMoneyById(int id) {
		User user = null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select money from bank_user where id=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, id);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				user = new User();
				user.setMoney(rs.getDouble("money"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return user;
	}

	/*  
	 * 通过用户名更新用户的金额
	 */
	public User transferMoney(String username, double money) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "update bank_user set money=? where username=?");
		try {
			pstmt.setDouble(1, money);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return this.findUserByUsername(username);
	}
	
	
	/*  
	 * 通过id更新用户的金额
	 */
	public User transferMoney(int id, double money) {
		User user = null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "update bank_user set money=? where id=?");
		ResultSet rs = null;
		try {
			pstmt.setDouble(1, money);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return this.findUserById(id);
	}

	/*  
	 * 通过用户名找user
	 */
	public User findUserByUsername(String username) {
		User user = null;
		Connection conn =DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from bank_user where username=?");
		ResultSet rs = null;
		try {
			pstmt.setString(1, username);
			rs = DBUtil.getRs(pstmt);
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMoney(rs.getDouble("money"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return user;
	}

	
}
