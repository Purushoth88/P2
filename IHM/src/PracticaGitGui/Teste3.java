package PracticaGitGui;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepository;

public class Teste3 {


	/**
	 * @param args
	 * @throws IOException 
	 * @throws GitAPIException 
	 * @throws NoFilepatternException 
	 */
	public static void main(String[] args) throws IOException, NoFilepatternException, GitAPIException {
//		Repository rep = new FileRepository(new File("C:/tmp/hello/.git"));
//		rep.create(true);
//		Git git = new Git(rep);
//		
//		//git.add().addFilepattern("C: " +File.separator + "tmp"+File.separator+"hello.txt").call();
//		git.add().addFilepattern("hello.txt");
//		git.commit().setMessage("primeiro commit").call();
		
		Repository rep = new FileRepository(new File("C:/tmp/.git"));
		rep.create();
		Git git=new Git(rep);
		
		
		
//		Git git = new Git(rep);
//		git.add().addFilepattern("C:/Bibliotecas/Documentos/Correo.JPG").call();
//		git.commit().setMessage("commit 2").call();
		
		

	}

}
