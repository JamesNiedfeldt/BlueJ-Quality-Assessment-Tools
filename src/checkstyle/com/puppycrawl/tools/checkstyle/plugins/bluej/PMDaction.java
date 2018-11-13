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
    boolean hasChecks;
    Path checkPath;
    String PMDPath;
    File executable;
    String JavaFileName;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static String OS = System.getProperty("os.name").toLowerCase();


    public PMDaction(BClass aClass){
        putValue(AbstractAction.NAME, "PMD");
        try{
            this.bProject = aClass.getPackage().getProject();
            projectDir=bProject.getDir().toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        checkPath = Paths.get(projectDir).resolve("checks/PMD").normalize();
        if(Files.exists(checkPath) && Files.isDirectory(checkPath)){
            hasChecks = true;
        }
        FileSystem fs = FileSystems.getDefault();
        PathMatcher pmdMatcher = fs.getPathMatcher("glob:pmd*");
        try{
            JavaFileName = aClass.getJavaFile().getPath();
        }catch(Exception e){}
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
        String myCommand = PMDPath + " pmd -format text -R java-basic,java-design -version 1.8 -language java -d " + JavaFileName;
        String output = runPMD(myCommand);

        JOptionPane.showMessageDialog(null, "Class Checked");

        StringBuilder msg = new StringBuilder("Any problems found are displayed below:");
        msg.append(LINE_SEPARATOR);
        msg.append(output);
        JOptionPane.showMessageDialog(null, msg);
    }

    private String runPMD(String myCommand){
        ProcessBuilder pb = new ProcessBuilder(myCommand.split(" +"));
        pb.redirectErrorStream(false);
        final StringBuilder output = new StringBuilder();
        try{
            final Process p = pb.start();
            Thread reader = new Thread(new Runnable() {
                public void run() {
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String s;
                    try {
                        while ((s = stdInput.readLine()) != null ){ 
                            output.append(s);
                            output.append(LINE_SEPARATOR);
                        }
                    } catch (IOException e) {
                        output.append(e.toString());
                        e.printStackTrace();
                    } finally {
                        try { stdInput.close(); } catch (IOException e) { /* quiet */ }
                    }
                }
            });
            reader.setDaemon(true);
            reader.start();
            p.waitFor();
            return output.toString();
        }catch(Exception e){

        }
        return output.toString();
    }
    private boolean isWindows(){
        return (OS.indexOf("win") >= 0);
    }

    private void yell(){
        System.out.println("PMDAction_Yell");
    }

}
