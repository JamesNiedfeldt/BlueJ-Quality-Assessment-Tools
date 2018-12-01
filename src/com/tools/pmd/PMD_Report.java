package com.tools.pmd;

public class PMD_Report {
  private StringBuilder msg;
  private static final String LINE_SEPARATOR = System.getProperty("line.separator");
  private static final String EXPLANATION = "Any problems found are displayed below:";
  
  public PMD_Report(){
    msg = new StringBuilder(EXPLANATION);
    msg.append(LINE_SEPARATOR);
  }
  
  public void appendMessage(String input){
    msg.append(input);
    msg.append(LINE_SEPARATOR);
  }
  
  public String getMessage(){
    return msg.toString();
  }
  
}
