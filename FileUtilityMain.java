import javax.swing.SwingUtilities;

public class FileUtilityMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SwingUtilities.invokeLater(() -> {
            new FileUtilityGUI().setVisible(true);
        });

	}

}
