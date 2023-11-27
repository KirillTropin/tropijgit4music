package ru.tropinos.tropijgit4music.utils;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import ru.tropinos.tropijgit4music.utils.factories.*;
import java.util.HashMap;
import java.util.Map;

public class CoreInitialisation {
    private final Map<String, GitRepositoryFactory> factories = new HashMap<>();
    public void gitInit(){
        String os = getOS();
        setFactories();
        GitRepositoryFactory repositoryFactory = factories.get(os);
        repositoryFactory.createDirectory();
        Repository repository = repositoryFactory.createRepository();
        Git git = new Git(repository);
    }
    private void setFactories() {
        factories.put("windows", new WindowsGitRepositoryFactory());
        factories.put("linux", new LinuxGitRepositoryFactory());
        factories.put("mac", new MacOSGitRepositoryFactory());
    }
    private static String getOS(){
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf( "win" ) >= 0) {
            return "windows";
        } else if (os.indexOf( "mac" ) >= 0){
            return "mac";
        } else if (os.indexOf( "nix" ) >= 0) {
            return "linux";
        } else {
            throw new RuntimeException("Unknown operating system!");
        }
    }
}
