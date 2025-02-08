/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aitor.ra5.controller;

import java.awt.event.ActionEvent;
import java.util.EventListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author aitor
 */
public interface Listeners extends EventListener{
    
    public void actionPerformed(ActionEvent ae);
    
    public void stateChanged(ChangeEvent evt);
}
