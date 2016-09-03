package com.vserdiuk.xls.entity;

import java.io.Serializable;

/**
 * Created by vserdiuk on 8/19/16.
 */
public class Company {

    private String name;
    private String email;
    private String webPage;
    private boolean isFreeEmailDomain;
    private boolean isEmailValid;
    private boolean isInterior;
    private boolean isBuilding;
    private boolean isFurniture;
    private boolean isArchitecture;

    public Company() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public boolean isFreeEmailDomain() {
        return isFreeEmailDomain;
    }

    public void setFreeEmailDomain(boolean freeEmailDomain) {
        isFreeEmailDomain = freeEmailDomain;
    }

    public boolean isEmailValid() {
        return isEmailValid;
    }

    public void setEmailValid(boolean emailValid) {
        isEmailValid = emailValid;
    }

    public boolean isInterior() {
        return isInterior;
    }

    public void setInterior(boolean interior) {
        isInterior = interior;
    }

    public boolean isBuilding() {
        return isBuilding;
    }

    public void setBuilding(boolean building) {
        isBuilding = building;
    }

    public boolean isFurniture() {
        return isFurniture;
    }

    public void setFurniture(boolean furniture) {
        isFurniture = furniture;
    }

    public boolean isArchitecture() {
        return isArchitecture;
    }

    public void setArchitecture(boolean architecture) {
        isArchitecture = architecture;
    }

    public Object[] getObjects() {
        Object[] objects = new Object[9];
        objects[0] = this.name.getClass();
        objects[1] = this.email.getClass();
        objects[2] = this.webPage.getClass();
        objects[3] = ((Boolean)this.isFreeEmailDomain).getClass();
        objects[4] = ((Boolean)this.isEmailValid).getClass();
        objects[5] = ((Boolean)this.isInterior).getClass();
        objects[6] = ((Boolean)this.isBuilding).getClass();
        objects[7] = ((Boolean)this.isFurniture).getClass();
        objects[8] = ((Boolean)this.isArchitecture).getClass();
        return objects;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", webPage='" + webPage + '\'' +
                ", isFreeEmailDomain=" + isFreeEmailDomain +
                ", isEmailValid=" + isEmailValid +
                ", isInterior=" + isInterior +
                ", isBuilding=" + isBuilding +
                ", isFurniture=" + isFurniture +
                ", isArchitecture=" + isArchitecture +
                '}';
    }
}
