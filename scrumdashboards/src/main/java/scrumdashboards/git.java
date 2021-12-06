package ESGRUPO8.esgrupo8;

import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

public class git {

	static String token= "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";
	static GitHub github;
	private static GHRepository repository;
	public git() {
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
	
	public String getReadme() throws IOException {
		String conteudo= repository.getReadme().getContent();
		return conteudo;
	}
	
	//public String getTags() {
	//	String tags=repository.getMasterBranch().
	//}
}
