package ui;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import process.StatProcessor;

public class ControllerFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = -1053501639122547673L;

    private static final Logger logger_ = Logger.getLogger(ControllerFrame.class.getSimpleName());
    
    private final Button buttonExit = new Button("Exit");
    private final Button buttonTeamList = new Button("Team List");
     
    private static StatProcessor statProccessor;
    private static Panel mainPanel;

    public ControllerFrame(StatProcessor argStatProcessor) {
        statProccessor = argStatProcessor;
        mainPanel = new Panel();
        
        logger_.info("Generating main window.");
        
        setLayout(new GridLayout(2, 1));
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent argEvent) {
               buttonExit.doLayout();
           }
        });
        
        buttonExit.addActionListener(this);
        buttonTeamList.addActionListener(this);
        mainPanel.add(buttonTeamList);
        mainPanel.add(buttonExit);
        
        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent argEvent) {
        if (argEvent.getSource() == buttonExit) {
            System.exit(9);
        }
        if (argEvent.getSource() == buttonTeamList) {
            textButtonPressed(argEvent);
        }   
    }

    private void textButtonPressed(ActionEvent argEvent) {
        this.dispose();
        new TeamTable(argEvent, statProccessor);
    }
}
