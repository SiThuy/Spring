package model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class Repository {
	final protected JdbcTemplate jdbc;

	public Repository() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/minishop?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		jdbc = new JdbcTemplate(dataSource);
	}

}
