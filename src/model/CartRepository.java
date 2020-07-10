package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class CartRepository extends Repository {
	public List<Cart> getCarts(String id){
		return jdbc.query("CALL GetCarts(?)", new RowMapper<Cart>() {
		@Override
		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Cart(rs.getString("CartId"), rs.getInt("ProductId"),
		rs.getString("Title"), rs.getString("ImageUrl"), rs.getInt("Price"), rs.getShort("Quantity") );
		}
		}, id);
		}
		
		public int add(Cart obj) {
		return jdbc.update("CALL AddCart(?, ?, ?, ?)", obj.getId(), obj.getMemberId(),
		obj.getProductId(), obj.getQuantity());
		}
		

}
