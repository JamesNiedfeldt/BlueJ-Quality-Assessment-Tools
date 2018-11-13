package com.puppycrawl.tools.checkstyle.plugins.bluej;
import java.util.LinkedList;

import java.io.File;
import java.nio.file.Files;

import java.nio.file.*;
import java.nio.file.Paths;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;

import net.sourceforge.pmd.PMDConfiguration;
import bluej.extensions.*;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


class PMDaction extends AbstractAction {
    BProject bProject;
    String projectDir;
    String PMDPath;
    File executable;
    String [] filenames;
    String [] filePaths;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static String OS = System.getProperty("os.name").toLowerCase();


    public PMDaction(BPackage aPackage){
        try{
            this.bProject = aPackage().getProject();
            projectDir=bProject.getDir().toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        FileSystem fs = FileSystems.getDefault();
        PathMatcher pmdMatcher = fs.getPathMatcher("glob:pmd*");
        String [] filenames = aPackage.getClasses().getJavaFile().getAbsolutePath();
        filePaths = new String[filenames.length];
        for(int i = 0; i < filenames.length; i++){
            try{
                filePaths[i] = filenames[i].getJavaFile().getPath();
            }catch(Exception e){e.printStackTrace();}
        }
        for(File f : Paths.get(projectDir).toFile().listFiles()){
            if(pmdMatcher.matches(f.toPath())){
                PMDPath = f.toString();
                if (isWindows()) {
                    executable = new File(PMDPath, "bin/pmd.bat");
                } else {
                    executable = new File(PMDPath, "bin/run.sh");
                }
                PMDPath = executable.getAbsolutePath();
            }
        }
    }

    public void actionPerformed(ActionEvent event){
        PMDrunner runner = new PMDrunner(PMDPath);
        StringBuilder msg = new StringBuilder("Any problems found are displayed below:");
        for(int i = 0; i < filenames.length; i++){
            String output = runner.run(filePaths[i]);
            msg.append("Class Checked: " + filenames[i]);
            msg.append(LINE_SEPARATOR);
            msg.append(output);
            msg.append(LINE_SEPARATOR);
        }

        JOptionPane.showMessageDialog(null, msg);
    }

    private boolean isWindows(){
        return (OS.indexOf("win") >= 0);
    }
}
