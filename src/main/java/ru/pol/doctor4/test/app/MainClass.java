package ru.pol.doctor4.test.app;

import ru.polbadwolf.test.interfaces.remoteRMI.RemoteInterface;

import java.net.*;
import java.rmi.*;

public class MainClass {
    public static void main(String[] args) {
        new MainClass().go(args[0], args[1]);
    }
    private void go(String ip, String mes) {
        RemoteInterface.BlockData[] blockData = new RemoteInterface.BlockData[2];
        blockData[0] = new RemoteInterface.BlockData("Mamba", 314);
        blockData[1] = new RemoteInterface.BlockData("Dgo", 159);
        try {
            RemoteInterface service = (RemoteInterface) Naming.lookup("rmi://" + ip + "/Interface1");
            service.putMessage(mes);
            System.out.println(service.retStatus());
            service.putData(blockData);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
