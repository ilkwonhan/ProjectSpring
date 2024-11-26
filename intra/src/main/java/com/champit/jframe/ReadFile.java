package com.champit.jframe;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadFile extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;

    //constructor
    public ReadFile() {
        super("Kyu Browser");

        addressBar = new JTextField("Enter a URL!");
        addressBar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        loadCrap(event.getActionCommand());
                        // URL 로 가는 방법 1 (직접 type)
                    }
                }
        );
        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false); // only view i
        display.addHyperlinkListener( // URL 로 가는 방법 2 (링크 클릭)
                // 웹페이지를 불렀을때 모든 링크가 클릭되길 기다린다.
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent event) {
                        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                            loadCrap(event.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }

    //load crap to display on the screen
    private void loadCrap(String userText) {
        try{
            display.setPage(userText); // setPage가 웹 페이지에 들어가는거 다한다
            addressBar.setText(userText);
        } catch (Exception e){
            System.out.println("crap!");
        }
    }
}