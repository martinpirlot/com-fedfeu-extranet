package com.fedfeu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fedfeu.beans.Club;
import com.fedfeu.beans.Cup;
import com.fedfeu.beans.Member;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MySQLDatabase {
	private static MysqlDataSource dataSource;

	private static final String MYSQL_USER = "";
	private static final String MYSQL_PASSWORD = "";
	private static final String MYSQL_SERVER_NAME = "";

	static {
		dataSource = new MysqlDataSource();
		dataSource.setUser(MYSQL_USER);
		dataSource.setPassword(MYSQL_PASSWORD);
		dataSource.setServerName(MYSQL_SERVER_NAME);
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Member getMember(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Members WHERE id = ?");
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	public static List<Member> getMemberList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Member> memberList = new ArrayList<Member>();
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Members");

			rs = ps.executeQuery();

			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberList;
	}

	public static int updateMember(Member member) {
		PreparedStatement ps = null;
		int result = -1;
		try {
			ps = getConnection().prepareStatement("UPDATE Members SET id = ? WHERE id = ?;");
			ps.setString(1, member.getId());
			ps.setString(1, member.getId());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static Club getClub(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Club club = null;
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Clubs WHERE id = ?");
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				club = new Club();
				club.setId(rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return club;
	}

	public static List<Club> getClubList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Club> clubList = new ArrayList<Club>();
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Clubs");

			rs = ps.executeQuery();

			while (rs.next()) {
				Club club = new Club();
				club.setId(rs.getString("id"));
				
				clubList.add(club);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return clubList;
	}

	public static int updateClub(Club club) {
		PreparedStatement ps = null;
		int result = -1;
		try {
			ps = getConnection().prepareStatement("UPDATE Clubs SET id = ? WHERE id = ?;");
			ps.setString(1, club.getId());
			ps.setString(1, club.getId());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static Cup getCup(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cup cup = null;
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Cups WHERE id = ?");
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				cup = new Cup();
				cup.setId(rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cup;
	}

	public static List<Cup> getCupList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cup> cupList = new ArrayList<Cup>();
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Cups");

			rs = ps.executeQuery();

			while (rs.next()) {
				Cup cup = new Cup();
				
				cupList.add(cup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cupList;
	}

	public static int updateCup(Cup cup) {
		PreparedStatement ps = null;
		int result = -1;
		try {
			ps = getConnection().prepareStatement("UPDATE Cups SET id = ? WHERE id = ?;");
			ps.setString(1, cup.getId());
			ps.setString(1, cup.getId());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
