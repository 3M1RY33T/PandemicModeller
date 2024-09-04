package yyp3_3136;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class SimulationPanel extends JPanel {
	 private List<Person> persons;

    public SimulationPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (persons != null) {
            for (Person person : persons) {
                g.setColor(person.getColor());
                g.fillOval(person.getxCoordinate(), person.getyCoordinate(), 10, 10);
            }
        }
    }
}
