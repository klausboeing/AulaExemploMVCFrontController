/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.framework;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.ServletRequestDataBinder;

/**
 *
 * @author Klaus Boeing
 */
public abstract class Action {
    
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void bind(HttpServletRequest request, Object entity) {
        ServletRequestDataBinder db = new ServletRequestDataBinder(entity);
        db.registerCustomEditor(Calendar.class, new CalendarPropertyEditor("yyyy-MM-dd"));
        db.bind(request);
    }
    
    
}
