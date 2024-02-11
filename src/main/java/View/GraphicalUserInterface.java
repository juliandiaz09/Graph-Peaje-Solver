package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the Graphical User Interface for the Toll Free Route Planner application.
 */
public class GraphicalUserInterface extends JFrame implements ActionListener {
    /** Combo box for selecting the origin city. */
    private JComboBox<String> originComboBox;
    /** Combo box for selecting the destination city. */
    private JComboBox<String> destinationComboBox;
    /** Text area for displaying the result. */
    private JTextArea resultTextArea;
    /** Controller.Controller instance for managing routes and costs. */
    private Controller controller;

    /** Constructor for the View.GraphicalUserInterface class. */
    public GraphicalUserInterface() {
        setTitle("Toll Free Route Planner");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        controller = new Controller();

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JLabel originLabel = new JLabel("Model.City of Origin:");
        panel.add(originLabel);

        originComboBox = new JComboBox<>();
        originComboBox.addItem("Medellin");
        originComboBox.addItem("Bogota");
        originComboBox.addItem("Cali");
        originComboBox.addItem("Manizales");
        originComboBox.addItem("Pereira");
        originComboBox.addItem("Cartagena");
        originComboBox.addItem("Bucaramanga");
        originComboBox.addItem("Santa Marta");
        panel.add(originComboBox);

        JLabel destinationLabel = new JLabel("Model.City of Destination:");
        panel.add(destinationLabel);

        destinationComboBox = new JComboBox<>();
        destinationComboBox.addItem("Medellin");
        destinationComboBox.addItem("Bogota");
        destinationComboBox.addItem("Cali");
        destinationComboBox.addItem("Manizales");
        destinationComboBox.addItem("Pereira");
        destinationComboBox.addItem("Cartagena");
        destinationComboBox.addItem("Bucaramanga");
        destinationComboBox.addItem("Santa Marta");
        panel.add(destinationComboBox);

        JButton calculateRouteButton = new JButton("Calculate Route");
        calculateRouteButton.addActionListener(this);
        panel.add(calculateRouteButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        panel.add(scrollPane);

        add(panel);
    }

    /** Handles the action performed event.
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate Route")) {
            String origin = (String) originComboBox.getSelectedItem();
            String destination = (String) destinationComboBox.getSelectedItem();
            String calculatedRoute = calculateLeastCostlyRoute(origin, destination);

            resultTextArea.setText(calculatedRoute);
        }
    }

    /** Calculates the least costly route between two cities.
     * @param origin The origin city.
     * @param destination The destination city.
     * @return A string representation of the calculated route.
     */
    private String calculateLeastCostlyRoute(String origin, String destination) {
        if(origin.equals(destination)){
            return "There is an error you have selected the same city, please check and repeat the process.";
        }

        return "Calculated route from " + origin + " to " + destination + "\n" +
                controller.routeLessCostly(origin, destination);
    }

    /** The main method to start the application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphicalUserInterface gui = new GraphicalUserInterface();
            gui.setVisible(true);
        });
    }
}
