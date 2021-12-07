package ESGRUPO8.esgrupo8;

import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

/**
 * 
 * @author Francisco Luz
 * @version 1.0
 *
 */
public class GitHubApi {

	static String token= "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";
	static GitHub github;
	private static GHRepository repository;
	public GitHubApi() {
		try {
			this.github = new GitHubBuilder().withOAuthToken(token).build();
			this.repository =  github.getRepository("bmlcs-iscte/ES-LETI-1Sem-2021-Grupo8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main( String[] args ){
		try {
			github = new GitHubBuilder().withOAuthToken(token).build();
			repository =  github.getRepository("bmlcs-iscte/ES-LETI-1Sem-2021-Grupo8");
			System.out.println(repository.getReadme().getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	/**
	 * Shows the content of the file README.md as a String
	 * @return
	 * this method returns a String with the content of the file README.md 
	 * @throws IOException
	 */
	public String getReadme() throws IOException {
		String conteudo= repository.getReadme().getContent();
		return conteudo;
		
	}
	
	
}