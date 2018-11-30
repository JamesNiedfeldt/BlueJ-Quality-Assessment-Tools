package com.tools.pmd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.bluejmanager.QualityAssessmentExtension;

public class PMD_Menu_Listener implements ActionListener {
  public void actionPerformed(ActionEvent event){
    String msg = QualityAssessmentExtension.getInstance().mPMDReport.getMessage();
    JOptionPane.showMessageDialog(null, msg);
  }
}