import bluej.extensions.*;
import bluej.extensions.event.*;
import java.net.URL;

public class SimpleExtension extends Extension implements PackageListener{
    public void startup(Bluej bluej){
        //listen for bluej events at the package level
        bluej.addPackageListener(this);
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
    
    //extension name, version, discription
    public String getName(){return "Simple Extension";}
    public String getVersion(){return "1.0";}
    public String getDescription(){return "A Simple Extension";}
}
