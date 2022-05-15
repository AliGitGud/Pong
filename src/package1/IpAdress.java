package package1;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import static java.net.InetAddress.getLocalHost;

public class IpAdress {

    public void ipAdresseAusgeben() {
        Inet4Address ipAdress = null;
        String ipString;
        try {
            ipAdress = (Inet4Address) getLocalHost();
           ipString = ipAdress.toString();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ip-Adresse zum beitreten:" + ipString);
    }
}
