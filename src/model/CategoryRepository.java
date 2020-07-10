package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import mapper.CategoryMapper;

public class CategoryRepository extends Repository {
	public List<Category> getCategorys() {
		return (List<Category>) jdbc.query("SELECT * FROM category", new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
			}
		});
	}

	/* ADD */
	public int add(Category obj) {
		return jdbc.update("INSERT INTO Category(CategoryId, CategoryName, ParentId) VALUES(?, ?, ?)", obj.getId(),
				obj.getName(), obj.getParent());
	}

	/* EDIT */
	public Category getCategory(int id) {

		return jdbc.queryForObject("SELECT * FROM Category WHERE CategoryId = ?", new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
			}
		}, id);
	}

	public int edit(Category obj) {
		return jdbc.update("UPDATE Category SET CategoryName = ? , ParentId = ? WHERE CategoryId = ?", obj.getName(),
				obj.getParent(), obj.getId());
	}

	public List<Cart> getCarts(String id) {
		return jdbc.query("CALL GetCarts(?)", new RowMapper<Cart>() {
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Cart(rs.getString("CartId"), rs.getInt("ProductId"), rs.getString("Title"),
						rs.getString("ImageUrl"), rs.getInt("Price"), rs.getShort("Quantity"));
			}
		}, id);
		}
	public List<Category> getCategories() {
		String sql = "SELECT * FROM Category";
		return jdbc.query(sql, new CategoryMapper());
	}


}
