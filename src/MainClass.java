import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass extends JFrame implements ActionListener {

    // Declare the necessary components for the application
    private JLabel title, nameLabel, dateLabel, activityLabel, durationLabel, goalLabel, progressLabel;
    private JTextField nameField, dateField, durationField, goalField, progressField;
    private JTextArea reportArea;
    private JButton saveButton, reportButton;
    private JPanel mainPanel, inputPanel, reportPanel;

    public MainClass() {
        // Set the frame properties
        setTitle("Fitness Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create the main panel
        mainPanel = new JPanel(new BorderLayout());

        // Create the title label
        title = new JLabel("Fitness Tracker");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);

        // Create the input panel and add components to it
        inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField();
        dateLabel = new JLabel("Date: ");
        dateField = new JTextField();
        activityLabel = new JLabel("Activity: ");
        JComboBox<String> activityBox = new JComboBox<>(new String[] {"Running", "Cycling", "Swimming", "Weightlifting", "Yoga"});
        durationLabel = new JLabel("Duration (mins): ");
        durationField = new JTextField();
        goalLabel = new JLabel("Goal (mins): ");
        goalField = new JTextField();
        progressLabel = new JLabel("Progress (mins): ");
        progressField = new JTextField();
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(activityLabel);
        inputPanel.add(activityBox);
        inputPanel.add(durationLabel);
        inputPanel.add(durationField);
        inputPanel.add(goalLabel);
        inputPanel.add(goalField);
        inputPanel.add(progressLabel);
        inputPanel.add(progressField);
        inputPanel.add(saveButton);

        // Create the report panel and add components to it
        reportPanel = new JPanel(new BorderLayout());
        reportButton = new JButton("Generate Report");
        reportButton.addActionListener(this);
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportPanel.add(reportButton, BorderLayout.NORTH);
        reportPanel.add(new JScrollPane(reportArea), BorderLayout.CENTER);

        // Add the components to the main panel
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(reportPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        add(mainPanel);

        // Display the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            // Get the values entered by the user
            String name = nameField.getText();
            String date = dateField.getText();
            String activity = (String) ((JComboBox<String>) inputPanel.getComponent(5)).getSelectedItem();
            int duration = Integer.parseInt(durationField.getText());
            int goal = Integer.parseInt(goalField.getText());
            int progress = Integer.parseInt(progressField.getText());

            // Create a summary of the user's input
            String summary = "Name: " + name + "\n"
                    +"Date: " + date + "\n"
                    + "Activity: " + activity + "\n"
                    + "Duration: " + duration + " mins\n"
                    + "Goal: " + goal + " mins\n"
                    + "Progress: " + progress + " mins\n";
            // Add the summary to the report area
            reportArea.append(summary);
            reportArea.setCaretPosition(reportArea.getDocument().getLength());

            // Clear the input fields
            nameField.setText("");
            dateField.setText("");
            durationField.setText("");
            goalField.setText("");
            progressField.setText("");

        } else if (e.getSource() == reportButton) {
            // Generate a report of the user's input
            String report = reportArea.getText();
            JOptionPane.showMessageDialog(this, report, "Fitness Tracker Report", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MainClass();
    }
}