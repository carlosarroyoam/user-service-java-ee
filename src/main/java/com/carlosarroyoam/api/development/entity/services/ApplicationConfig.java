/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosarroyoam.api.development.entity.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * 
 * @author Carlos Alberto Arroyo Martínez <carlosarroyoam@gmail.com>
 */
@javax.ws.rs.ApplicationPath("webservices")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.carlosarroyoam.api.development.entity.services.NotificationServices.class);
        resources.add(com.carlosarroyoam.api.development.entity.services.NotificationsCloudServices.class);
        resources.add(com.carlosarroyoam.api.development.entity.services.UserAuthenticationServices.class);
        resources.add(com.carlosarroyoam.api.development.entity.services.UserServices.class);
    }
    
}