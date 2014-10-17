/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import teste.framework.Action;
import teste.model.Contato;
import teste.model.ContatoDao;

public class RemoveContatoAction extends Action{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try (ContatoDao dao = new ContatoDao()) {
            Contato contato = dao.buscarPorId(Long.valueOf(id));

            dao.deleta(contato);

            req.setAttribute("contato", contato);
            req.getRequestDispatcher("/WEB-INF/pages/contato-removido.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }
}