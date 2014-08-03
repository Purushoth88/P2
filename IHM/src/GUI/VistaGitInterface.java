package GUI;

import java.awt.event.ActionListener;
import java.io.File;

public interface VistaGitInterface {
	
	File[] getPathName();
	String getCommitText();
	void controlador(ActionListener ctr);
	void setTextPath(String pathName);
	
	String ADD = "add";
	String REMOVER = "del";
	String COMMIT = "commit";
	String UNDO = "undo";
	String BROWSER = "browser";
	
}
