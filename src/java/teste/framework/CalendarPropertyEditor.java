/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.framework;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Klaus Boeing
 */
public class CalendarPropertyEditor extends PropertyEditorSupport{

    private final String pattern;

    public CalendarPropertyEditor(String pattern) {
        this.pattern = pattern;
    }
    
    @Override
    public void setAsText(String string) throws IllegalArgumentException {
        if(string == null){
            return;
        }
        try {
            Calendar value = Calendar.getInstance();
            value.setTime(new SimpleDateFormat(pattern).parse(string));
            setValue(value);
        } catch (ParseException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public String getAsText() {
        if(getValue() != null){
            return new SimpleDateFormat(pattern).format(((Calendar) getValue()).getTime());
        }
        return null;
    }
}
