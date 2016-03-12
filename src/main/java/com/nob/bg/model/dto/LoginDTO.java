/**
 * 
 */
package com.nob.bg.model.dto;

/**
 * @author jorismelchior
 * 
 */
public class LoginDTO {
    private String userName;
    private String password;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("[LoginDTO - userName:%s password:%s]", userName, password);
    }
}
/* That's All Folks !! */