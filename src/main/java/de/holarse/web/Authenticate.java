/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holarse.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author britter
 */
@RequestScoped
@ManagedBean
public class Authenticate {
    
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;    
    
    public void authenticate(final String username, final String password) throws AuthException {
        if (username.equals("comrad") && password.equals("comrad222")) {
            sessionBean.setCurrentUser(username);
        } else {
            throw new AuthException("Falsche Zugangsdaten");
        }        
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
}
