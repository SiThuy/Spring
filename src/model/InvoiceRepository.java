package model;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class InvoiceRepository extends Repository {
	public int add(Invoice obj) {
		return jdbc.update("CALL AddInvoice(?, ?, ?, ?, ?)", obj.getId(), obj.getMemberId(), obj.getEmail(),
				obj.getTel(), obj.getAddress());
	}

	

}
