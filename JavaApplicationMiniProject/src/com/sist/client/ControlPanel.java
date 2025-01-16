package com.sist.client;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import com.sist.chat.*;

import javax.swing.*;
public class ControlPanel extends JPanel {
    HomePanel hp;
    ChatRoom cr;
    CardLayout card = new CardLayout();

    public ControlPanel() {
        setLayout(card);
        hp = new HomePanel(this);
        add("HOME", hp);
        cr = new ChatRoom(this);
        add("CHAT", cr);
    }

}

