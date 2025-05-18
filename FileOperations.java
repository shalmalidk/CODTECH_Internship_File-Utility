import java.io.*;
import javax.swing.*;
public class FileOperations {
	public static void createFile(JFrame parent) {
		JFileChooser chooser=new JFileChooser();
		chooser.setDialogTitle("Select directory to create file");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int option=chooser.showOpenDialog(parent);
		if(option==JFileChooser.APPROVE_OPTION) {
			String dirPath=chooser.getSelectedFile().getAbsolutePath();
			String fileName=JOptionPane.showInputDialog(parent,"Enter a file name with extention( for ex. .txt)");
		
			if(fileName!= null && !fileName.trim().isEmpty()) {
				File file=new File(dirPath + File.separator +fileName);
				try {
					if(file.createNewFile()) {
						JOptionPane.showMessageDialog(parent, "File created: "+file.getAbsolutePath());
					}
					else
						JOptionPane.showMessageDialog(parent, "File already exists");
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(parent, "Error.."+e.getMessage());
				}
				
			}
		}
	}
	
	public static void createFolder(JFrame parent) {
		JFileChooser chooser= new JFileChooser();
		chooser.setDialogTitle("Select directory to create Folder");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int option=chooser.showOpenDialog(parent);
		if(option==JFileChooser.APPROVE_OPTION) {
			String dirPath=chooser.getSelectedFile().getAbsolutePath();
			String folderName=JOptionPane.showInputDialog(parent,"Enter folder name: ");
			if(folderName!=null && !folderName.trim().isEmpty()) {
				File folder=new File(dirPath+ File.separator+ folderName);
				try {
					 if(folder.mkdir())
						 JOptionPane.showMessageDialog(parent, folderName+" Folder Created..");
					 else
						 JOptionPane.showMessageDialog(parent, "Folder already exists...");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(parent,"Error..."+e.getMessage());
				}
			}
		}
	}
	
	public static void readFile(JFrame parent) {
		JFileChooser chooser=new JFileChooser();
		chooser.setDialogTitle("Select a text file to read");
		 int option=chooser.showOpenDialog(parent);
		 if(option==JFileChooser.APPROVE_OPTION) {
			 File selectedFile=chooser.getSelectedFile();
			 
			 if(selectedFile.isFile()) {
				 try(BufferedReader reader=new BufferedReader(new FileReader(selectedFile))) {
					 	StringBuilder content=new StringBuilder();
					 	String line;
					 	while((line=reader.readLine())!=null)
					 		content.append(line).append("\n");
				 
					 	JOptionPane.showMessageDialog(parent, content.toString(), "File Content", JOptionPane.INFORMATION_MESSAGE);
				
				 }
				 catch(IOException e){
					 JOptionPane.showMessageDialog(parent, e);
				 }
			 }
			 else {
				 JOptionPane.showMessageDialog(parent, "The selected file is not a file", "Invalid Selection",JOptionPane.WARNING_MESSAGE);
			 }
		 }
	}
	
	public static void writeFile(JFrame parent) {
		JTextArea textArea = new JTextArea();
		int result=JOptionPane.showConfirmDialog(parent, new JScrollPane(textArea),"Enter text to write a File",JOptionPane.OK_CANCEL_OPTION);
		
		if(result==JOptionPane.OK_OPTION) {
			String text=textArea.getText();
			
			JFileChooser chooser=new JFileChooser();
			chooser.setDialogTitle("Save file");
			
			int option=chooser.showSaveDialog(parent);
			if(option==JFileChooser.APPROVE_OPTION) {
				File fileToSave=chooser.getSelectedFile();
				
				try (BufferedWriter writer=new BufferedWriter(new FileWriter(fileToSave))) {
					writer.write(text);
					JOptionPane.showMessageDialog(parent,"File saved successfully! ","Success",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(IOException e){
					JOptionPane.showMessageDialog(parent,"Error saving file: "+e.getMessage());
				}
			}
		}
	}
	
	public static void deleteFileFolder(JFrame parent) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select a file/folder to delete");
		
		int option=chooser.showOpenDialog(parent);
		if(option==JFileChooser.APPROVE_OPTION) {
			File selected=chooser.getSelectedFile();
			
			 int confirm = JOptionPane.showConfirmDialog(parent,
			            "Are you sure you want to delete: " + selected.getName() + "?",
			            "Confirm Delete", JOptionPane.YES_NO_OPTION);
			 
			 if(confirm==JOptionPane.YES_OPTION) {
				 boolean deleted=selected.delete();
				 if(deleted)
					 JOptionPane.showMessageDialog(parent, "Deleted Successfully.");
				 else
					 JOptionPane.showMessageDialog(parent, "Deletion failed..!!!");
			 }
		}
		
	}
}
