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
import com.fedfeu.config.Config;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MySQLDatabase {
	private static MysqlDataSource dataSource;

	static {
		dataSource = new MysqlDataSource();
		dataSource.setUser(Config.getProperty(Config.MYSQL_USER));
		dataSource.setPassword(Config.getProperty(Config.MYSQL_PASSWORD));
		dataSource.setServerName(Config.getProperty(Config.MYSQL_SERVER));
		dataSource.setDatabaseName(Config.getProperty(Config.MYSQL_DATABASE));
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Member getMember(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Members WHERE id = ?");
			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setFirstName(rs.getString("firstName"));
				member.setLastName(rs.getString("lastName"));
				member.setMail(rs.getString("mail"));
				member.setPhone(rs.getString("phone"));
				member.setBirthDate(rs.getDate("birthDate"));
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
				member.setFirstName(rs.getString("firstName"));
				member.setLastName(rs.getString("lastName"));
				member.setMail(rs.getString("mail"));
				member.setPhone(rs.getString("phone"));
				member.setBirthDate(rs.getDate("birthDate"));
				
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
			ps = getConnection().prepareStatement("UPDATE Members SET firstName = ?, lastName = ?, mail = ?, phone = ?, birthDate = ? WHERE id = ?;");
			ps.setString(1, member.getFirstName());
			ps.setString(1, member.getLastName());
			ps.setString(1, member.getMail());
			ps.setString(1, member.getPhone());
			ps.setDate(1, member.getBirthDate());
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

	public static Club getClub(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Club club = null;
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Clubs WHERE id = ?");
			ps.setString(1, id);

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

	public static Cup getCup(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cup cup = null;
		try {
			ps = getConnection().prepareStatement("SELECT * FROM Cups WHERE id = ?");
			ps.setString(1, id);

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
		} catch (SQLException | NullPointerException e) {
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
