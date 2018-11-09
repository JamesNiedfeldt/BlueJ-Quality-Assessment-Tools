package SimpleExtension;

import bluej.extensions.*;
import bluej.extensions.event.*;
import java.net.URL;

public class SimpleExtension extends Extension implements PackageListener{
    MenuBuilder myMenus;
    public void startup(BlueJ bluej){
        //listen for bluej events at the package level
        bluej.addPackageListener(this);
        myMenus = new MenuBuilder();
        bluej.setMenuGenerator(myMenus);
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
}
