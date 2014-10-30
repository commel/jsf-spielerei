/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holarse.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author britter
 */
@ManagedBean
@RequestScoped
public class Login {
    
    @ManagedProperty(value = "#{authenticate}")
    private Authenticate authenticate;
    
    private String username;
    private String password;
    
    public String authenticate() {
        try {
            authenticate.authenticate(username, password);
        } catch (AuthException e) {
             final FacesMessage message = new FacesMessage(e.getMessage());
             FacesContext.getCurrentInstance().addMessage("loginform:username", message);
             return "login";
        }
        
        return "fun";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Authenticate getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
    }
   
}
