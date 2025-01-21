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
    ChatPanel cp;
    FoodGenrePanel fgp;
    FoodFindPanel ffp;
    FoodDetailPanel fdp;
    BoardList bList;
    BoardInsert bInsert;
    BoardDetail bDetail;
    BoardReply bReply;
    BoardUpdate bUpdate;
    BoardDelete bDelete;
    NewsPanel nP;
    
    CardLayout card = new CardLayout();
    
    public ControlPanel() {
        setLayout(card);
        hp = new HomePanel(this);
        add("HOME", hp);
        cp = new ChatPanel(this);
        add("CHAT", cp);
        fgp = new FoodGenrePanel(this);
        add("FOOD", fgp);
        ffp = new FoodFindPanel(this);
        add("FIND", ffp);
        fdp = new FoodDetailPanel(this);
        add("DETAIL", fdp);
        // 게시판
        bList = new BoardList(this);
        add("BLIST", bList);
        bInsert = new BoardInsert(this);
        add("BINSERT", bInsert);
        bDetail = new BoardDetail(this);
        add("BDETAIL", bDetail);
        bReply = new BoardReply(this);
        add("BREPLY", bReply);
        bUpdate = new BoardUpdate(this);
        add("BUPDATE", bUpdate);
        bDelete = new BoardDelete(this);
        add("BDELETE", bDelete);
        nP = new NewsPanel(this);
        add("NP", nP);
    }
    

}

