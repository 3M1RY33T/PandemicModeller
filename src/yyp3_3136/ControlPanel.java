package yyp3_3136;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {
    private JTextField populationField;
    private JTextField immunityLevel1Field;
    private JTextField immunityLevel2Field;
    private JTextField immunityLevel3Field;
    private JTextField immunityLevel4Field;
    private JTextField immunityLevel5Field;
    private JButton startButton;
    private JButton pauseButton;
    private JButton resumeButton;
    private JLabel infectedCountLabel;
    private JLabel recoveredCountLabel;
    private JLabel deadCountLabel;

    public ControlPanel() {
    	setLayout(new BorderLayout());
    	
    	JPanel inPanel = new JPanel(new GridLayout(7, 2));
        
    	populationField = new JTextField("1000");
        immunityLevel1Field = new JTextField("350");
        immunityLevel2Field = new JTextField("350");
        immunityLevel3Field = new JTextField("200");
        immunityLevel4Field = new JTextField("100");
        immunityLevel5Field = new JTextField("0");


        JPanel ctrlPanel = new JPanel(new GridLayout(2, 3));
        
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        resumeButton = new JButton("Resume");
        
        infectedCountLabel = new JLabel("Infected: 0");
        recoveredCountLabel = new JLabel("Recovered: 0");
        deadCountLabel = new JLabel("Dead: 0");

        inPanel.add(new JLabel("Population:"));
        inPanel.add(populationField);
        inPanel.add(new JLabel("Immunity Level 1:"));
        inPanel.add(immunityLevel1Field);
        inPanel.add(new JLabel("Immunity level 2:"));
        inPanel.add(immunityLevel2Field);
        inPanel.add(new JLabel("Immunity level 3:"));
        inPanel.add(immunityLevel3Field);
        inPanel.add(new JLabel("Immunity level 4:"));
        inPanel.add(immunityLevel4Field);
        inPanel.add(new JLabel("Immunity level 5:"));
        inPanel.add(immunityLevel5Field);
        inPanel.add(new JLabel(""));
        
        ctrlPanel.add(startButton);
        ctrlPanel.add(pauseButton);
        ctrlPanel.add(resumeButton);
        ctrlPanel.add(infectedCountLabel);
        ctrlPanel.add(recoveredCountLabel);
        ctrlPanel.add(deadCountLabel);
        
        add(inPanel, BorderLayout.NORTH);
        add(ctrlPanel, BorderLayout.SOUTH);
    }

    public JTextField getPopulationField() {
        return populationField;
    }

    public JTextField getImmunityLevel1Field() {
        return immunityLevel1Field;
    }

    public JTextField getImmunityLevel2Field() {
        return immunityLevel2Field;
    }

    public JTextField getImmunityLevel3Field() {
        return immunityLevel3Field;
    }

    public JTextField getImmunityLevel4Field() {
        return immunityLevel4Field;
    }

    public JTextField getImmunityLevel5Field() {
        return immunityLevel5Field;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getResumeButton() {
        return resumeButton;
    }

    public JLabel getInfectedCountLabel() {
        return infectedCountLabel;
    }

    public JLabel getRecoveredCountLabel() {
        return recoveredCountLabel;
    }

    public JLabel getDeadCountLabel() {
        return deadCountLabel;
    }
}
