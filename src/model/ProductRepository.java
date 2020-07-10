package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class ProductRepository extends Repository {
	public int count() {
		return jdbc.queryForObject("SELECT COUNT(*) AS Total FROM Product", new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getInt("Total");
			}
		});
	}

	public List<Product> getProducts(int index, int size) {
		return jdbc.query("SELECT * FROM Product LIMIT ?, ?", new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
						rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
			}
		}, (index - 1) * size, size);
	}

	public Product getProduct(int id) {
		return jdbc.queryForObject("SELECT * FROM Product WHERE ProductId = ?", new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				return new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
						rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
			}
		}, id);
	}

	public List<Product> search(String q) {
		return jdbc.query("SELECT * FROM Product WHERE Title LIKE ?", new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
						rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
			}
		}, "%" + q + "%");
	}

}
