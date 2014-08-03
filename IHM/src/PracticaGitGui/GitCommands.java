package PracticaGitGui;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.GitCommand;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.DetachedHeadException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepository;





public class GitCommands {
	
	private static File targetDir;
	private Repository rep;
	private static Git git; 
	
	public GitCommands(String camino){
		try {
			rep = new FileRepository(new File(camino));
			git = new Git(rep);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Repository newRepository(String pathName){
		targetDir = new File(pathName);
		try {
			rep = new FileRepository(targetDir);
			rep.create(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	
	public Repository getRepository(){
		return git.getRepository();
	}
	
	
	public void add(String pathName){
		try {
			git.add().addFilepattern(pathName).call();
		} catch (NoFilepatternException e) {
			e.printStackTrace();
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
	}
	
	
	public void commit(String txt){
		try {
			git.commit().setMessage(txt).call();
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoMessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnmergedPathsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConcurrentRefUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongRepositoryStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void push(String origin){
		try {
			git.push().setPushAll().setRemote(origin).call();
		} catch (InvalidRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pull(){
		try {
			git.pull().call();
		} catch (WrongRepositoryStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DetachedHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CanceledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteDirectory(String pathname) {
		
		File dirPath = new File(pathname);
		
		if(!dirPath.exists()) {
			return;
		}

		for (String filePath : dirPath.list()) {
			File file = new File(dirPath, filePath);
			if (file.isDirectory())
				deleteDirectory(file.getPath());
			file.delete();
		}
	}
	
	public void getCommits(String pathName) throws GitAPIException{
		File f = new File(pathName);
		Git git2;
		git2 = Git.init().setDirectory(f).call();
	
		try {
			for (RevCommit commit : git2.log().call()) {
				System.out.println(commit.getAuthorIdent().getName());
				System.out.println(commit.getAuthorIdent().getWhen());
				System.out.println(commit.getFullMessage());
			}
		} catch (NoHeadException e) {
			System.out.println("Empty repo, nothing to log");
		}
	}
	
	
	public static void main(String[] args) throws GitAPIException {
		GitCommands commands = new GitCommands("C:/tmp2/.git");
		commands.add("C:/tmp2/hello.txt");
		commands.commit("primeiro commit");
		//commands.getCommits("C:/tmp/gittest/");
		//commands.deleteDirectory("C:/tmp/newRepository.git");
	}
}

	
	

