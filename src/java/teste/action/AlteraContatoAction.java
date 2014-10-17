/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import teste.framework.Action;
import teste.model.Contato;
import teste.model.ContatoDao;

public class AlteraContatoAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contato contato = new Contato();

        bind(request, contato);
        
        try (ContatoDao dao = new ContatoDao()) {
            dao.edita(contato);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        request.getRequestDispatcher("/WEB-INF/pages/contato-alterado.jsp").forward(request, response);
    }
}