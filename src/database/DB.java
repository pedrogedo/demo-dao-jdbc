package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection connection = null;

	/**
	 * Método estático para fazer conexão com Banco de Dados
	 * 
	 * @return
	 */
	public static Connection openConnection() {
		if (connection == null) {
			try {
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
				connection = DriverManager.getConnection(url, properties);
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		return connection;
	}

	/**
	 * Método estático para fechar a conexão com Banco de Dados
	 */
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	/**
	 * Método estático para carregar as informações do arquivo db.properties de
	 * configurações do Banco de Dados
	 * 
	 * @return
	 */
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties properties = new Properties();
			properties.load(fs);
			return properties;
		} catch (IOException e) {
			throw new DBException(e.getMessage());
		}
	}
	
	/**
	 * Método estático para fechar a conexão com Statement
	 * @param st
	 */
	public static void closeStatment(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	/**
	 * Método estático para fechar a conexão com ResultSet
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
}
