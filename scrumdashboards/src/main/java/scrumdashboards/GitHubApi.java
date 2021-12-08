package ESGRUPO8.esgrupo8;

import java.io.IOException;
import java.util.HashMap;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHTag;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.PagedIterable;

/**
 * 
 * @author Francisco Luz
 * @version 1.0
 * @param <tag>
 *
 */
public class GitHubApi<tag> {

	static String token = "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";
	static GitHub github;
	private static GHRepository repository;

	public GitHubApi() {
		try {
			this.github = new GitHubBuilder().withOAuthToken(token).build();
			this.repository = github.getRepository("bmlcs-iscte/ES-LETI-1Sem-2021-Grupo8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			github = new GitHubBuilder().withOAuthToken(token).build();
			repository = github.getRepository("bmlcs-iscte/ES-LETI-1Sem-2021-Grupo8");
			System.out.println(repository.getReadme().getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	/**
	 * Shows the content of the file README.md as a String
	 * 
	 * @return This method returns a String with the content of the file README.md
	 * @throws IOException
	 */
	public String getReadme() throws IOException {
		String conteudo = repository.getReadme().getContent();
		return conteudo;

	}

	/**
	 * Shows the Tags and the their creation date from the GitHub repository
	 * 
	 * @return This method returns all the tags and their creation date
	 * @throws IOException
	 */
	public HashMap<GHTag, String> getTags() throws IOException {
		HashMap<GHTag, String> date = new HashMap<GHTag, String>();
		PagedIterable<GHTag> tags = repository.listTags();
		for (GHTag t : tags)
			date.put((GHTag) t, t.getCommit().getCommitDate().toString());
		return date;
	}

}