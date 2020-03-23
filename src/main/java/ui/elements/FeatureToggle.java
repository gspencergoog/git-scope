package ui.elements;

import eu.hansolo.custom.SteelCheckBox;
import implementation.Manager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FeatureToggle extends SteelCheckBox implements Element {

    private final Manager manager;

    public FeatureToggle(Manager manager) {

        this.manager = manager;

        this.createElement();
        this.addListener();

    }

    public void createElement() {

        String text = "Toggle between HEAD and target branch (ALT + H)";
        this.setToolTipText(text);

    }

    public void addListener() {

        this.addActionListener(e -> {
            manager.doCompareAndUpdate();
        });

//        this.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                manager.doCompareAndUpdate();
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });
//
//        this.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                manager.doCompareAndUpdate();
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

    }

}
