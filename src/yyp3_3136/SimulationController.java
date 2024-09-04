package yyp3_3136;

import yyp3_3136.Person;
import yyp3_3136.SimulationPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

import javax.swing.JLabel;

public class SimulationController {
    private List<Person> persons;
    private SimulationPanel simulationPanel;
    private Timer timer;
    private JLabel infectedCountLabel;
    private JLabel recoveredCountLabel;
    private JLabel deadCountLabel;

    public SimulationController(SimulationPanel simulationPanel, JLabel infectedCountLabel, JLabel recoveredCountLabel, JLabel deadCountLabel) {
        this.simulationPanel = simulationPanel;
        this.infectedCountLabel = infectedCountLabel;
        this.recoveredCountLabel = recoveredCountLabel;
        this.deadCountLabel = deadCountLabel;
        this.persons = new ArrayList<>();

        SimulationPanel thatSimulationPanel = this.simulationPanel;
        
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Person person : persons) {
                	if(person.isAlive()) {
                        person.move();
                        person.setCycleCounter(person.getCycleCounter()+1);
                        if(person.isInfected() && person.getCycleCounter()>150) {
                        	
                        	Random rand = new Random();
                        	boolean isDead = false;
                        	int chance = rand.nextInt(100);
                            if (person.getImmunityStatus() == 1 && chance <= 10) {
                            	isDead=true;
                            } else if (person.getImmunityStatus() == 2 && chance <= 7) {
                                isDead=true;
                            } else if (person.getImmunityStatus() == 3 && chance <= 3) {
                                isDead = true;
                            } else if (person.getImmunityStatus() == 4 && chance <= 1) {
                                isDead = true;
                            } else if (person.getImmunityStatus() == 5 && chance <= 3) {
                                isDead = true;
                            }
                        	
                            if(isDead) {
                            	person.setAlive(false);
                            	person.setColor(Color.BLACK);                            	
                            } else {
                            	person.setInfected(false);
                            	person.setColor(Color.GREEN);
                            	person.setImmunityStatus(5);
                            	person.setCycleCounter(1);
                            }
                        }                		
                	}
                }
                checkCollisions();
                updateStatistics();
                thatSimulationPanel.repaint();
            }
        });
    }

    public void startSimulation(int populationSize, int immunityLevel1, int immunityLevel2, int immunityLevel3, int immunityLevel4, int immunityLevel5) {
        persons.clear();
        Random rand = new Random();
        
        for (int i = 0; i < immunityLevel1; i++) {
            persons.add(new Person(1, Color.BLUE));
        }
        
        for (int i = 0; i < immunityLevel2; i++) {
            persons.add(new Person(2, Color.CYAN));
        }
        
        for (int i = 0; i < immunityLevel3; i++) {
            persons.add(new Person(3, Color.YELLOW));
        }
        
        for (int i = 0; i < immunityLevel4; i++) {
            persons.add(new Person(4, Color.MAGENTA));
        }
        
        for (int i = 0; i < immunityLevel5; i++) {
            persons.add(new Person(5, Color.GREEN));
        }
        
        int remainingPopulation = populationSize - (immunityLevel1 + immunityLevel2 + immunityLevel3 + immunityLevel4 + immunityLevel5);
        for (int i = 0; i < remainingPopulation; i++) {
            persons.add(new Person(1, Color.BLUE));
        }
        
        persons.get(0).setInfected(true);
        simulationPanel.setPersons(persons);
        timer.start();
    }

    public void pauseSimulation() {
        timer.stop();
    }

    public void resumeSimulation() {
        timer.start();
    }

    private void checkCollisions() {
        for (int i = 0; i < persons.size(); i++) {
            for (int j = i + 1; j < persons.size(); j++) {
                persons.get(i).checkCollision(persons.get(j));
            }
        }
    }

    private void updateStatistics() {
        int infectedCount = 0;
        int recoveredCount = 0;
        int deadCount = 0;
        for (Person person : persons) {
            if (person.isInfected() && person.isAlive()) infectedCount++;
            if (person.getColor() == Color.GREEN) recoveredCount++;
            if (person.getColor() == Color.BLACK) deadCount++;
        }
        infectedCountLabel.setText("Infected: " + infectedCount);
        recoveredCountLabel.setText("Recovered: " + recoveredCount);
        deadCountLabel.setText("Dead: " + deadCount);
    }
}
