package ru.tropinos.tropijgit4music.utils;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.springframework.stereotype.Component;
import ru.tropinos.tropijgit4music.utils.factories.*;

@Component
public class CoreInitialisation {
    public void gitInit(){
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            os = os.substring(0,3);
        }
        String version = System.getProperty("os.version");
        AbstractGitRepositoryFactory repositoryFactory = switch (os) {
            case "mac" -> {
                if (Double.parseDouble(version) <= 10.14) {
                    yield new MacOSExtendedGitRepositoryFactory();
                } else {
                    yield new AppleFileSystemGitRepositoryFactory();
                }
            }
            case "linux"-> {
                String linuxVersion = version.replaceAll("\\D","");
                if (Integer.getInteger(linuxVersion) >= 2629) {
                    yield new BtrfsLinuxGitRepositoryFactory();
                } else {
                    yield new EXT4LinuxGitRepositoryFactory();
                }
            }
            case "windows"-> {
                yield new WindowsGitRepositoryFactory();
            }
            default -> {var ex = new IllegalArgumentException(
                    "Unknown operation system");
                throw ex;}
        };
        repositoryFactory.createDirectory();
        Repository repository = repositoryFactory.createRepository();
        Git git = new Git(repository);
    }
}
