package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;

import process.StatProcessor;
import stats.LeagueStats;
import stats.BasePlayerStats;
import stats.BaseTeamStats;

public class TeamTable extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1255467011698208587L;
    
    private static final Logger logger = LogManager.getLogger(TeamTable.class);
    
    private JFrame f;
    private JTable j;
    
    public TeamTable(ActionEvent argEvent, StatProcessor argStatProcessor) {
        f = new JFrame();
        f.setTitle("Team Statistics");     
        
        logger.info("Creating list panel of teams.");
        
        LeagueStats leagueStats = argStatProcessor.getLeagueStats();
        String[] teamArray = new String[33];

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
