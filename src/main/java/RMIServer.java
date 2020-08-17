import org.junit.Test;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements RMIInterface {
    public String sayHello() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        try {
//            System.setProperty("sun.rmi.registry.registryFilter", "java.;sun.reflect.annotation.;com.sun.**");
//
//            System.setProperty("sun.rmi.registry.registryFilter", "java.util.HashMap;");
//            System.setProperty("sun.rmi.registry.registryFilter", "java.util.HashMap;sun.reflect.annotation.**;");
//            System.setProperty("sun.rmi.registry.registryFilter", "java.**;sun.reflect.annotation.**;com.sun.**");
            System.setProperty("java.rmi.server.hostname", "10.179.86.132");

            RMIServer obj = new RMIServer();
            RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject((Remote) obj, 0);

            LocateRegistry.createRegistry(8412);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hello", stub);
            System.out.println("Server Start!");
            Thread.sleep(1000*100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void Testmain() {
        try {
//            System.setProperty("sun.rmi.registry.registryFilter", "java.;sun.reflect.annotation.;com.sun.**");
//
//            System.setProperty("sun.rmi.registry.registryFilter", "java.util.HashMap;");
//            System.setProperty("sun.rmi.registry.registryFilter", "java.util.HashMap;sun.reflect.annotation.**;");
//            System.setProperty("sun.rmi.registry.registryFilter", "java.**;sun.reflect.annotation.**;com.sun.**");
            RMIServer obj = new RMIServer();
            RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject((Remote) obj, 0);
            LocateRegistry.createRegistry(8412);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hello", stub);
            System.out.println("Server Start!");
            Thread.sleep(1000*100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}