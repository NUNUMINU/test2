package test.api;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import test.dao.PetitionDao;
import test.dto.Petition;
import test.dao.ReplyDao;
import test.dto.Reply;

/**
 * Servlet implementation class ReadPet
 */
@WebServlet("/ReadPet")
public class ReadPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		PetitionDao dao = new PetitionDao();
		Petition pet;
		ReplyDao redao = new ReplyDao();
		List<Reply> re;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		pet = dao.getPetbyId(id);
		re = redao.getReplyByRef(id);
		
		request.setAttribute("pet", pet);
		request.setAttribute("writerID", pet.getWriterId());
		request.setAttribute("isAns", pet.getisAns());
		request.setAttribute("petid", id);
		request.setAttribute("reply", re);

		RequestDispatcher requestdispatcher = request.getRequestDispatcher("jsp/view.jsp");
		requestdispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
