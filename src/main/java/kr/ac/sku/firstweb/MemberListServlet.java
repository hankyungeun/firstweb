package kr.ac.sku.firstweb;

import kr.ac.sku.dto.*;
import kr.ac.sku.service.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사용자에게만 리스트를 보여준다
		boolean loginFlag = false;
		String id = null;

		/*쿠키를 이용해 로그인 여부를 확인하는 방법
		//로그인 여부 확인
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("login".equals(cookie.getName())) {
					//로그인 한 사용자
					loginFlag = true;
					id = cookie.getValue();
					break;
				}
			}
		}
		*/

		//세션을 이용해 로그인 확인
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
		if(obj != null) {
			loginFlag = true;
			id = (String) obj;
		}

		if(loginFlag){
			//memberList 얻어오기!!!
			MemberService service = new MemberService();
			List<MemberDTO> memberList = service.getMemberList();

			//위에서 얻어온 memberList를 이용해서 회원목록 화면을 만들어준다.
			//서블릿에서 화면을 만드는것은 복잡하므로, 화면은 jsp가 만들도록 forward 해준다.

			request.setAttribute("memberList", memberList);
			request.setAttribute("userId", id);

			RequestDispatcher rd = request.getRequestDispatcher("memberList.jsp");
			rd.forward(request, response);
		} else {
			//로그인 하지 않은 사용자
			session.setAttribute("msg","회원목록은 로그인 후에 볼 수 있어요!!");
			response.sendRedirect("loginForm.jsp");
		}
	}
}
