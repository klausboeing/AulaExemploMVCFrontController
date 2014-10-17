/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import teste.framework.Action;
import teste.model.ContatoDao;

public class ListaContatosAction extends Action{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ContatoDao dao = new ContatoDao()) {
            req.setAttribute("contatos", dao.getLista());
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        req.getRequestDispatcher("/WEB-INF/pages/lista-contatos.jsp").forward(req, resp);
    }
}
