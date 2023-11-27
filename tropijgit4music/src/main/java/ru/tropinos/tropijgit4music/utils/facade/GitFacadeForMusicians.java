package ru.tropinos.tropijgit4music.utils.facade;

import org.eclipse.jgit.api.Git;

import java.net.URL;
import java.nio.file.DirectoryStream;
import java.util.List;

public interface GitFacadeForMusicians {
    String ABLETON = "Ableton";
    String CUBASE = "Cubase";
    String FRUITYLOOPS = "FruityLoops";
    void includePlugins(List<String> plugins, DirectoryStream directoryStream);
    void searchMusicalProducingProgram(String name);
    void createNewRepository();
    void addExistingRepository();
    void deleteRepository(Git git);
    void checkoutBranch(String branchName);
    void createNewBranch(String branchName);
    void commitChanges(String commitName);
    void viewHistory();
    void chooseRemoteRepository(URL url);
    void addRemoteRepository(URL url);
    void createRemotePeerToPeerRepository(String IP);
    void addProjectToRepository(String directory);
    //TODO доделать прочие обёртки для сервисного слоя GUI

}
