package kr.ac.sku.firstweb;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter(filterName ="/MyFilter",urlPatterns="/*")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        System.out.println("MyFilter 생성");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("MyFilter destory() 실행");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("MyFilter doFilter() 전");
		chain.doFilter(request, response);
		System.out.println("MyFilter doFilter() 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFilter init()실행!!");
	}

}