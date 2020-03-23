package ui.elements;

import utils.Git;

import javax.swing.*;

public class CurrentBranch extends JLabel implements Element {

    public static final int MAX_BRANCH_COUNT = 2;
    private final Git git;

    public CurrentBranch(Git git) {

        this.git = git;

        this.createElement();
        this.addListener();

    }

    public void createElement() {

    }

    public void addListener() {

    }

    public void update() {

        String branchName = git.getBranchName();
        int count = git.getRepositories().size();

        if (count >= MAX_BRANCH_COUNT) {
            branchName = count + " Repositories";
            setToolTipText(this.git.getBranchName());
        }

        setText(branchName);

    }

}
