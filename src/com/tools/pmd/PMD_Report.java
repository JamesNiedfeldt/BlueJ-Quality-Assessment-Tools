package com.tools.pmd;

public class PMD_Report {
  private StringBuilder msg;
  private boolean finalized;
  private static final String LINE_SEPARATOR = System.getProperty("line.separator");
  private static final String EXPLANATION = "Any problems found are displayed below:";
  private static final String NOT_FINISHED = "The PMD report is not finished yet.";
  
  public PMD_Report(){
    msg = new StringBuilder(EXPLANATION);
    msg.append(LINE_SEPARATOR);
    finalized = false;
  }
  
  public void appendMessage(String input){
    if(!finalized){
      msg.append(input);
      msg.append(LINE_SEPARATOR);
    }
  }
  
  public String getMessage(){
    if(!finalized){
      return NOT_FINISHED;
    } else {
      return msg.toString();
    }
  }
  
  public void finalize(){
    finalized = true;
  }
}
