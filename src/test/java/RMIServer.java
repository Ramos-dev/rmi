import org.junit.Test;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements RMIInterface {
    public String sayHello() {
        return "Hello World!";
    }


    @Test
    public  void Testmain() {
        try {
//            System.setProperty("sun.rmi.registry.registryFilter", "java.;sun.reflect.annotation.;com.sun.**");
//
//            System.setProperty("sun.rmi.registry.registryFilter", "java.util.HashMap;");
//            System.setProperty("sun.rmi.registry.registryFilter", "java.util.HashMap;sun.reflect.annotation.**;");
//            System.setProperty("sun.rmi.registry.registryFilter", "java.**;sun.reflect.annotation.**;com.sun.**");
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            RmiServers server=new RmiServers();
            LocateRegistry.createRegistry(8413);
            Naming.rebind("//127.0.0.1:8413/SAMPLE-SERVER", server);
            System.out.println("Server Start! 8413");
            Thread.sleep(1000*100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}