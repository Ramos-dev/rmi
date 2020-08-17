import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RmiServers extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;

    protected RmiServers() throws RemoteException {
        super();
    }

    public String say(String name) throws RemoteException {
        return "hello，"+name;
    }

    @Override
    public String sayHello() throws RemoteException {
        return null;
    }
}