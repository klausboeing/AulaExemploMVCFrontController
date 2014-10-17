/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import teste.framework.Action;

public class AdicionaContatoFormAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/adiciona-contato.jsp").forward(request, response);
    }
}
