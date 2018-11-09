import bluej.extensions.*;
import bluej.extensions.event.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;

public class SimpleExtension extends Extension implements PackageListener{
    public void startup(BlueJ bluej){
        //listen for bluej events at the package level
        bluej.addPackageListener(this);
        bluej.setMenuGenerator(new MenuBuilder());
    }

    //this runs when bluej detects that the user has "opened a package".
    //essentially whenever the user starts a new project
    public void packageOpened(PackageEvent ev){
        try
        {
            System.out.println("Project " + ev.getPackage().getProject().getName() 
                               + " opened.");
        }
        catch (ExtensionException e)
        {
            System.out.println("Project closed by BlueJ");
        }
    }

    public void packageClosing(PackageEvent ev)
    {
    } 
    //extension should be compatible for all bluej
    public boolean isCompatible(){
        return true;
    }
    
    //extension name, version, discription, and URL with further discription
    public String getName(){return "Simple Extension";}
    public String getVersion(){return "1.0";}
    public String getDescription(){return "A Simple Extension";}
    public URL getURL ()
    {
        try
        {
            return new URL("http://www.bluej.org/doc/writingextensions.html");
        }
        catch ( Exception e )
        {
            // The link is either dead or otherwise unreachable
            System.out.println ("Simple extension: getURL: Exception="+e.getMessage());
            return null;
        }
    }


    class MenuBuilder extends MenuGenerator{
    //B for bluej, current package, class, and object 
    //being edited
    private BPackage curPackage;
    private BClass curClass;
    private BObject curObject;

    public JMenuItem getToolsMenuItem(BPackage aPackage)
    {
        return new JMenuItem(new SimpleAction("Click Tools", "Tools menu:"));
    }

    public JMenuItem getClassMenuItem(BClass aClass)
    {
        return new JMenuItem(new SimpleAction("Click Class", "Class menu:"));
    }

    public JMenuItem getObjectMenuItem(BObject anObject)
    {
        return new JMenuItem(new SimpleAction("Click Object", "Object menu:"));
    }

    // These methods will be called when
    // each of the different menus are about to be invoked.
    public void notifyPostToolsMenu(BPackage bp, JMenuItem jmi)
    {
        System.out.println("Post on Tools menu");
        curPackage = bp ; curClass = null ; curObject = null;
    }

    public void notifyPostClassMenu(BClass bc, JMenuItem jmi)
    {
        System.out.println("Post on Class menu");
        curPackage = null ; curClass = bc ; curObject = null;
    }

    public void notifyPostObjectMenu(BObject bo, JMenuItem jmi)
    {
        System.out.println("Post on Object menu");
        curPackage = null ; curClass = null ; curObject = bo;
    }

    // A utility method which pops up a dialog detailing the objects                
    // involved in the current (SimpleAction) menu invocation.
    private void showCurrentStatus(String header)
    {
        try
        {
            if (curObject != null)
                curClass = curObject.getBClass();
            if (curClass != null)
                curPackage = curClass.getPackage();

            String msg = header;
            if (curPackage != null)
                msg += "\nCurrent Package = " + curPackage;
            if (curClass != null)
                msg += "\nCurrent Class = " + curClass;
            if (curObject != null)
                msg += "\nCurrent Object = " + curObject;
            JOptionPane.showMessageDialog(null, msg);
        }
        catch (Exception exc)
        {
        }
    }

    // The nested class that instantiates the different (simple) menus.
    @SuppressWarnings("serial")
    class SimpleAction extends AbstractAction {
        private String msgHeader;

        public SimpleAction(String menuName, String msg)
        {
            putValue(AbstractAction.NAME, menuName);
            msgHeader = msg;
        }
        public void actionPerformed(ActionEvent anEvent)
        {
            showCurrentStatus(msgHeader);
        }
    }
}
}
