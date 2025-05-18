import javax.swing.*;
import java.awt.*;

public class FileUtilityGUI extends JFrame {

    public FileUtilityGUI() {
        setTitle("File Handling Utility");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Set Background Color
        getContentPane().setBackground(new Color(245, 245, 245));

        // Title Label
        JLabel title = new JLabel("File Handling Utility", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 24));
        title.setForeground(new Color(30, 30, 30));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(title, BorderLayout.NORTH);

        // Panel for Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2, 10, 10));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        // Create Buttons with styles
        JButton createFileBtn = createStyledButton("Create File");
        JButton createFolderBtn = createStyledButton("Create Folder");
        JButton readFileBtn = createStyledButton("Read File");
        JButton writeFileBtn = createStyledButton("Write to File");
        JButton deleteFileBtn=createStyledButton("Delete file");

        createFileBtn.addActionListener(e -> FileOperations.createFile(this));        
        createFolderBtn.addActionListener(e -> FileOperations.createFolder(this));
        readFileBtn.addActionListener(e -> FileOperations.readFile(this));
        writeFileBtn.addActionListener(e -> FileOperations.writeFile(this));
        deleteFileBtn.addActionListener(e -> FileOperations.deleteFileFolder(this));

        // Add buttons to panel
        buttonPanel.add(createFileBtn);
        buttonPanel.add(createFolderBtn);
        buttonPanel.add(readFileBtn);
        buttonPanel.add(writeFileBtn);
        buttonPanel.add(deleteFileBtn);
        

        add(buttonPanel, BorderLayout.CENTER);
    }

    // 🎨 Reusable method to style buttons
    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(0, 128, 128)); 
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return btn;
    }
}
