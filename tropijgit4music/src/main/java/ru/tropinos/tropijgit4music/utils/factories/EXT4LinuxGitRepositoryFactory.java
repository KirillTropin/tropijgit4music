package ru.tropinos.tropijgit4music.utils.factories;

import org.eclipse.jgit.lib.Repository;

public class EXT4LinuxGitRepositoryFactory extends AbstractGitRepositoryFactory{
    @Override
    public void createDirectory() {

    }

    @Override
    public Repository createRepository() {
        return null;
    }

    @Override
    public Repository getExistingRepository() {
        return null;
    }

    @Override
    public Repository cloneRepository() {
        return null;
    }
}
