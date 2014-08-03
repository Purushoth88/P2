package PracticaGitGui;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.lib.CommitBuilder;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revplot.PlotCommitList;
import org.eclipse.jgit.revplot.PlotLane;
import org.eclipse.jgit.revplot.PlotWalk;
import org.eclipse.jgit.revwalk.DepthWalk.Commit;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.treewalk.filter.AndTreeFilter;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;

public class CommandGit {

	//	private File gitworkDir = new File("/tmp/gittest/");
	private File gitworkDir;
	private File gitDir;
	private Git git;

	public CommandGit(String pathName){

		
			gitworkDir = new File(pathName);
			gitDir = new File(gitworkDir, ".git");
			//git = new Git(new FileRepository(gitDir));
//			InitCommand initCommand = Git.init();
//			initCommand.setDirectory(gitworkDir);
//			git = initCommand.call();
			git = openRepo();

	}


	public Git getGit(){
		return git;
	}
	
	private Git openRepo() {
		Git git;
		try {
			git = Git.open(gitworkDir);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return git;
	}



	public void addAndCommit(Git git, String message, String pathToAdd) throws NoFilepatternException, GitAPIException {
		add(git, pathToAdd);
		commit(git, message);
	}

	public void addAndCommit( String message, String pathToAdd) {
		add(pathToAdd);
		commit(message);
	}

	public void commit(Git git, String message) {
		CommitCommand commit = git.commit();
		try {
			commit.setMessage(message).call();
		} catch (NoHeadException e) {
			throw new RuntimeException(e);
		} catch (NoMessageException e) {
			throw new RuntimeException(e);
		} catch (ConcurrentRefUpdateException e) {
			throw new RuntimeException(e);
		} catch (JGitInternalException e) {
			throw new RuntimeException(e);
		} catch (WrongRepositoryStateException e) {
			throw new RuntimeException(e);
		} catch (UnmergedPathsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void commit( String message) {
		CommitCommand commit = git.commit();
		try {
			commit.setMessage(message).call();
		} catch (NoHeadException e) {
			throw new RuntimeException(e);
		} catch (NoMessageException e) {
			throw new RuntimeException(e);
		} catch (ConcurrentRefUpdateException e) {
			throw new RuntimeException(e);
		} catch (JGitInternalException e) {
			throw new RuntimeException(e);
		} catch (WrongRepositoryStateException e) {
			throw new RuntimeException(e);
		} catch (UnmergedPathsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(Git git, String pathToAdd) throws NoFilepatternException, GitAPIException {
		File myfile = new File(pathToAdd);
        try {
			myfile.createNewFile();
			 git.add()
	           .addFilepattern("myfile")
	           .call();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}


	public void add( String pathToAdd) {
		AddCommand add = git.add();

		try {
			add.addFilepattern(pathToAdd).call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Delete directory even if not empty
	 */
	public static void deleteDirectory(String pathname) {

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
		File f = new File("C:/tmp/gitHello");
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
	
//	//Pegar os commits
//	public PlotCommitList getPlotCommits(String path){
//	    System.out.println(path);
//	    Repository repository = getGit().getRepository();
//	    PlotCommitList<PlotLane> plotCommitList = new PlotCommitList<PlotLane>();
//	    PlotWalk revWalk = new PlotWalk(repository);
//	    try {
//
//	        ObjectId rootId = repository.resolve("HEAD");
//	        if (rootId != null) {
//	            RevCommit root = revWalk.parseCommit(rootId);
//	            revWalk.markStart(root);
//	            revWalk.setTreeFilter(
//	            AndTreeFilter.create(PathFilter.create(path), TreeFilter.ANY_DIFF));
//	            plotCommitList.source(revWalk);
//	            plotCommitList.fillTo(Integer.MAX_VALUE);
//	            return plotCommitList;
//	        }
//
//	    } catch (AmbiguousObjectException ex) {
//	        System.out.println(ex.getMessage());
//	    } catch (IOException ex) {
//	    	System.out.println(ex.getMessage());
//	    }
//	    return plotCommitList;
//	}

	public static void main(String[] args) throws NoFilepatternException, GitAPIException{
		CommandGit commands = new CommandGit("C:/tmp/gittest/");
		commands.add("C:/tmp/gittest/nuevo.txt");
		commands.addAndCommit( commands.getGit(),"commit1 hello", "C:/Users/Lucas/hello.txt");
	}
}
