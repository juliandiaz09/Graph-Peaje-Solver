import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUserInterface extends JFrame implements ActionListener {
    private JComboBox<String> originComboBox;
    private JComboBox<String> destinationComboBox;
    private JTextArea resultTextArea;
    private Controller controller;

    public GraphicalUserInterface() {
        setTitle("Toll Free Route Planner");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        controller = new Controller();

        JPanel panel = new JPanel(new GridLayout(4, 1));

        JLabel origenLabel = new JLabel("City of Origin:");
        panel.add(origenLabel);

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

        JLabel destinoLabel = new JLabel("City of Destination:");
        panel.add(destinoLabel);

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

        JButton calcularRutaButton = new JButton("Calculate Route");
        calcularRutaButton.addActionListener(this);
        panel.add(calcularRutaButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        panel.add(scrollPane);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate Route")) {
            String origin = (String) originComboBox.getSelectedItem();
            String destination = (String) destinationComboBox.getSelectedItem();
            String rutaCalculada = calculateLeastCostlyRoute(origin, destination);

            resultTextArea.setText(rutaCalculada);
        }
    }

    private String calculateLeastCostlyRoute(String origin, String destination) {
        if(origin.equals(destination)){
            return "There is an error you have selected the same city, please check and repeat the process.";
        }

        return "Calculated route from " + origin + " to " + destination + "\n" +
                controller.routeLessCostly(origin, destination);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphicalUserInterface interfaz = new GraphicalUserInterface();
            interfaz.setVisible(true);
        });
    }
}
