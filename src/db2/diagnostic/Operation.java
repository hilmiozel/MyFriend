/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2.diagnostic;

/**
 *
 * @author Rasit
 */
public class Operation {
    String name;
    String host;
    String password;
    String[] commands;

    public Operation(String name, String host, String password, String[] commands) {
        this.name = name;
        this.host = host;
        this.password = password;
        this.commands = commands;
    }

    public Operation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getCommands() {
        return commands;
    }

    public void setCommands(String[] commands) {
        this.commands = commands;
    }
    
    
    
}
