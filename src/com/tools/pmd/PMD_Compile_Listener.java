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
    PMD_Report report = PMD_Report_Builder.getInstance().generatePMDReport();
    QualityAssessmentExtension.getInstance().mPMDReport = report;
  }
  
  public void compileWarning(CompileEvent event){
    
  }
  
}