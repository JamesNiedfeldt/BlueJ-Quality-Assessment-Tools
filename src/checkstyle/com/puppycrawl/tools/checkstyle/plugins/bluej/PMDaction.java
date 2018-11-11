package com.puppycrawl.tools.checkstyle.plugins.bluej;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import net.sourceforge.pmd.PMDConfiguration;
import bluej.extensions.*;

class PMDaction extends AbstractAction {
    BProject bProject;

    public void PMDaction(BProject bProject){
        this.bProject = bProject;
    }

    public void actionPerformed(ActionEvent event){
        //TODO: Collect all java files worked on
        //TODO: Generate PMD preferences
        //TODO: Generate PMD reports
        PMDConfiguration config= configure();
    }

    //Should be called on compile and when extension is 
    //loaded. Provides a handle to all of the relevant
    //BlueJ objects (classes, packages, directories, etc.)
    //Should be called on Save/Compile etc, but definitely
    //before action performed is run
    public void update(BProject bProject){
        this.bProject = bProject;
    }

    public String runPMD(){
    }

    private PMDConfiguration configure(){
        List<File> files = new List();
        for(BPackage bPackage : bProject.getPackages()){
            for(BClass bClass : bPackage.getClasses()){
                files.add(bClass.getClassFile());
            }
        }
    }
}
