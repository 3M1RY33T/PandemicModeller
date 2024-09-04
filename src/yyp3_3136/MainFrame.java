package yyp3_3136;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import yyp3_3136.SimulationController;


public class MainFrame extends JFrame {
    private SimulationController simulationController;

    public MainFrame() {
        setTitle("Pandemic Modeler Application");
        setSize(850, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ControlPanel controlPanel = new ControlPanel();
        SimulationPanel simulationPanel = new SimulationPanel();
        simulationController = new SimulationController(simulationPanel,
                controlPanel.getInfectedCountLabel(),
                controlPanel.getRecoveredCountLabel(),
                controlPanel.getDeadCountLabel());

        controlPanel.getStartButton().addActionListener(e -> {
            int populationSize = Integer.parseInt(controlPanel.getPopulationField().getText());
            int immunityLevel1 = Integer.parseInt(controlPanel.getImmunityLevel1Field().getText());
            int immunityLevel2 = Integer.parseInt(controlPanel.getImmunityLevel2Field().getText());
            int immunityLevel3 = Integer.parseInt(controlPanel.getImmunityLevel3Field().getText());
            int immunityLevel4 = Integer.parseInt(controlPanel.getImmunityLevel4Field().getText());
            int immunityLevel5 = Integer.parseInt(controlPanel.getImmunityLevel5Field().getText());

            simulationController.startSimulation(populationSize, immunityLevel1, immunityLevel2, immunityLevel3, immunityLevel4, immunityLevel5);
        });

        controlPanel.getPauseButton().addActionListener(e -> simulationController.pauseSimulation());
        controlPanel.getResumeButton().addActionListener(e -> simulationController.resumeSimulation());

        add(controlPanel, BorderLayout.NORTH);
        add(simulationPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
