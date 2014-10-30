/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holarse.web;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author britter
 */
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {
    
    private String currentUser;
    private int counter = 0;

    public String logout() {
        currentUser = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "index";
    }
    
    public void wipe() {
        counter = 0;
    }
    
    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
    
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public void inc() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
}
