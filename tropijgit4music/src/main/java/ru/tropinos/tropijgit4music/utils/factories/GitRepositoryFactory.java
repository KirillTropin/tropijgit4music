package ru.tropinos.tropijgit4music.utils.factories;

import org.eclipse.jgit.lib.Repository;

public abstract class GitRepositoryFactory {
    public abstract void createDirectory();
    public abstract Repository createRepository();
    public abstract Repository getExistingRepository();
    public abstract Repository cloneRepository();
}
