package PracticaGitGui;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.ReflogCommand;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.ReflogEntry;
import org.junit.Before;
import org.junit.Test;


/*
 * Code sample about using jgit to commit content inside a git repository
 * depedencies:
 * - junit.jar
 * - org.eclipse.jgit-1.1.0.201109151100-r.jar
 * 
 */
public class JgitTest {

	File gitworkDir = new File("/tmp/gittest/");
	File gitDir = new File(gitworkDir, ".git");
	String message1 = "commit1";
	String message2 = "commit2";
	String content1 = "blabla";
	String content2 = "blablaBIS";
	Git git;

	@Before
	public void setUp() {
		deleteDirectory(gitworkDir);
		try {
			createGitRepo();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		git = openRepo();
	}

	@Test
	public void openGitRepo() {
		assertTrue(gitDir.exists());
		assertNotNull(git);
	}

	@Test
	public void addCommit() throws GitAPIException {
		addContent();

		Iterator<RevCommit> iterator = getLogsIterable(git);
		assertNextCommitEqual(message2, iterator);
		assertNextCommitEqual(message1, iterator);

	}

	

	@Test
	public void testReflog() {
		addContent();
		Collection<ReflogEntry> reflogs = reflog(git);
		assertEquals(2, reflogs.size());
	}

	private void addContent() {
		changeContent(git, content1, message1);
		changeContent(git, content2, message2);
	}

	private void assertNextCommitEqual(String message, Iterator<RevCommit> iterator) {
		RevCommit commit = iterator.next();
		assertEquals(message, commit.getFullMessage());
	}

	private void createGitRepo() throws GitAPIException {
		InitCommand initCommand = Git.init();
		initCommand.setDirectory(gitworkDir);
		Git git = initCommand.call();

		assertTrue(gitDir.exists());
		assertNotNull(git);
	}

	private void changeContent(Git git, String content, String message) {
		File myfile = new File("C:/Users/Lucas/hello.txt");
		
		writeToFile(myfile, content);

		addAndCommit(git, message, ".");
	}

	private void addAndCommit(Git git, String message, String pathToAdd) {
		//add(git, pathToAdd);
		commit(git, message);
	}

	private void commit(Git git, String message) {
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

	private void add(Git git, String pathToAdd) {
		AddCommand add = git.add();
		try {
			add.addFilepattern(pathToAdd).call();
		} catch (NoFilepatternException e) {
			throw new RuntimeException(e);
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Iterator<RevCommit> getLogsIterable(Git git) throws GitAPIException {
		Iterable<RevCommit> log;
		try {
			log = git.log().call();
		} catch (NoHeadException e) {
			throw new RuntimeException(e);
		} catch (JGitInternalException e) {
			throw new RuntimeException(e);
		}
		return log.iterator();
	}

	private Collection<ReflogEntry> reflog(Git git) {
		ReflogCommand reflog = git.reflog();
		Collection<ReflogEntry> reflogs;
		try {
			reflogs = reflog.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return reflogs;
	}

	private void writeToFile(File myfile, String string) {
		FileWriter writer;
		try {
			writer = new FileWriter(myfile);
			//writer.write(string);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	/**
	 * Delete directory even if not empty
	 */
	public static void deleteDirectory(File dirPath) {

		if(!dirPath.exists()) {
			return;
		}

		for (String filePath : dirPath.list()) {
			File file = new File(dirPath, filePath);
			if (file.isDirectory())
				
				deleteDirectory(file);
			file.delete();
		}
	}

}