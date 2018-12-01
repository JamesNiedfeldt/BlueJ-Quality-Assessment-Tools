package com.tools.pmd;

import bluej.extensions.event.CompileListener;
import bluej.extensions.event.CompileEvent;
import bluej.extensions.*;

import com.bluejmanager.*;

public class PMD_Compile_Listener implements CompileListener{
  
  public void compileError(CompileEvent event){
    
  }
  
  public void compileFailed(CompileEvent event){
    
  }
  
  public void compileStarted(CompileEvent event){
    
  }
  
  public void compileSucceeded(CompileEvent event){
    Thread thread = new Thread(new PMD_Runnable_Thread());
    thread.start();
  }
  
  public void compileWarning(CompileEvent event){
    
  }
  
}