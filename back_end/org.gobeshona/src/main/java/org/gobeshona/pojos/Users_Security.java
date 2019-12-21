/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.pojos;

/**
 *
 * @author Dell-3460
 */
public class Users_Security
    {

        private String username;
        private String password;
        private int enabled;

    public Users_Security(String username, String password, int enabled)
        {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        }
    
        
        
    public String getUsername()
        {
        return username;
        }

    public void setUsername(String username)
        {
        this.username = username;
        }

    public String getPassword()
        {
        return password;
        }

    public void setPassword(String password)
        {
        this.password = password;
        }

    public int getEnabled()
        {
        return enabled;
        }

    public void setEnabled(int enabled)
        {
        this.enabled = enabled;
        }
        
    }
