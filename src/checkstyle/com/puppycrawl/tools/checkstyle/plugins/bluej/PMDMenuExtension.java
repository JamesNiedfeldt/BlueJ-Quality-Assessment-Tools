package com.puppycrawl.tools.checkstyle.plugins.bluej;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import bluej.extensions.*;

public class PMDMenuExtension extends MenuGenerator{
    
    @Override
    public JMenuItem getClassMenuItem(BClass aClass){
        final JMenuItem jm = new JMenuItem("PMD");
        jm.addActionListener(new PMDaction(aClass));
        System.out.println("SetClassMenuAction");
        return jm;
    }

    @Override
    public JMenuItem getToolsMenuItem(BPackage aPackage){
        System.out.println("ToolsMenuGen");
        final JMenuItem item = new JMenuItem("Tool");
        item.addActionListener(new reportAction());
        return item;
    }

    class reportAction extends AbstractAction {
        public reportAction(){
            putValue(AbstractAction.NAME, "Tool");

        }
        public void actionPerformed(ActionEvent event){
            System.out.println("ToolPress");
        }
    }
}
