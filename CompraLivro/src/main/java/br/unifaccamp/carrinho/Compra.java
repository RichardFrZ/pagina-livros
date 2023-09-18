package br.unifaccamp.carrinho;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



/**
 * Servlet implementation class Compra
 */
public class Compra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList<Livro> cadastro = new ArrayList<Livro>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compra() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void VerificaLivro(){
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		Integer acessCount = (Integer) session.getAttribute("acessCount");
		if (acessCount == null) {
			acessCount = new Integer(0);
			
		} else {
			acessCount = new Integer(acessCount.intValue() + 1);
		}
		
		session.setAttribute("acessCount", acessCount);
		
		PrintWriter out = response.getWriter();
		String codigo = request.getParameter("LivroCode");
		String titulo = request.getParameter("LivroTitle");
		Float valor = (Float.parseFloat(request.getParameter("LivroPrice")));
		
		Integer Find = 0;
		
		if(cadastro.size() == 0) {
		Livro livro = new Livro();
		livro.setCodigo(codigo);
		livro.setTitulo(titulo);
		livro.setValor(valor);
		livro.setQuantidade(1);
		
		cadastro.add(livro);
		}
		else {
			for (int i = 0; i < cadastro.size(); i++) {
				if(codigo.equals(cadastro.get(i).getCodigo())) {
					cadastro.get(i).setQuantidade(cadastro.get(i).getQuantidade() + 1);
					Find = 1;
					break;
				}

			}
			if(Find == 0) {
				
				Livro livro = new Livro();
				livro.setCodigo(codigo);
				livro.setTitulo(titulo);
				livro.setValor(valor);
				livro.setQuantidade(1);
				
				cadastro.add(livro);
				
			}
		}
		Float totallivro = (float)0;
		Float totalcompra = (float)0;
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang = \"pt-br\">\r\n"
				+ " <head>\r\n"
				+ " <title> Lista de Compras </title>\r\n"
				+ " <meta charset = \"utf-8\">\r\n"
				+ " </head>\r\n"
				+ " <body>\r\n"
				+ " <h1> LISTA DE COMPRAS</h1>"
				+ " <table border=\"2\">\r\n"
				+ "    <tr>\r\n"
				+ "         <td>Código</td>\r\n"
				+ "         <td>Titulo</td>\r\n"
				+ "         <td>Valor</td>\r\n"
				+ " 		<td>Quantidade</td>\r\n"
				+ " 		<td>Total</td>\r\n"
				+ "    </tr>");
		for (int i = 0; i < cadastro.size(); i++) {
			
			totallivro = cadastro.get(i).getValor()*cadastro.get(i).getQuantidade();
			totalcompra += totallivro;
			out.println("<tr>"
						+ "		<td>" + cadastro.get(i).getCodigo() + "</td>"
						+ "		<td>" + cadastro.get(i).getTitulo() + "</td>"
						+ "		<td>" + cadastro.get(i).getValor()  + "</td>"
						+ "		<td>" +	cadastro.get(i).getQuantidade() + "</td>"
						+ "     <td>" + totallivro + "</td>"
						);

		}
		out.println("<tr>"
				+ "<td colspan='4'>SOMA TOTAL</td>"
				+ "<td>"+ totalcompra + "</td>"
				+ "</tr>"
				+ "</table> <br>"
				+ "<a href='http://localhost:8080/CompraLivro/Loja.html'>Voltar</a>"
				+ "</body>"
				+ "</html>"
				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
