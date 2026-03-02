package serial;

import com.fazecast.jSerialComm.SerialPort;

public class SerialManager {

    private SerialPort port;

    public boolean connect(String portName) {
        port = SerialPort.getCommPort(portName);
        port.setComPortParameters(9600, 8, 1, 0);
        port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        return port.openPort();
    }

    public void send(String data) {
        if (port != null && port.isOpen()) {
            port.writeBytes((data + "\n").getBytes(), data.length() + 1);
        }
    }

    public void disconnect() {
        if (port != null && port.isOpen()) {
            port.closePort();
        }
    }
}
