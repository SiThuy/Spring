package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import model.CategoryRepository;

public class CategoryInterceptor implements HandlerInterceptor {
	CategoryRepository repository = new CategoryRepository();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("categories", repository.getCategories());
		return true;
	}

}
