package com.ak.fx.core;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class AbstractService implements Service {
  @Nullable
  private final SerialPort comPort = Arrays.stream(SerialPort.getCommPorts())
      .filter(serialPort -> serialPort.getSystemPortName().toLowerCase().contains("serial"))
      .findFirst().orElse(null);

  @Override
  public final void serve() {
    Logger.getLogger(getClass().getName()).info("serve");

    if (comPort != null) {
      comPort.setBaudRate(115200);
      comPort.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);

      if (comPort.isOpen()) {
        byte[] buffer = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        comPort.writeBytes(buffer, buffer.length);
      }
      else if (comPort.openPort()) {
        comPort.addDataListener(new SerialPortDataListener() {
          @Override
          public int getListeningEvents() {
            return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
          }

          @Override
          public void serialEvent(SerialPortEvent event) {
            if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
              byte[] newData = event.getReceivedData();
              Logger.getLogger(getClass().getName()).info("%s : %s".formatted(event.getSerialPort(), Arrays.toString(newData)));
            }
          }
        });
        byte[] buffer = {10, 21, 31, 41, 51, 61, 71, 81, 91, 100};
        comPort.writeBytes(buffer, buffer.length);
      }
      else {
        Logger.getLogger(getClass().getName()).info(() -> "already opened %s %s".formatted(comPort, comPort.closePort()));
      }
    }
  }

  @Override
  public void close() {
    if (comPort != null) {
      Logger.getLogger(getClass().getName()).info(() -> "%s %s".formatted(comPort, comPort.closePort()));
    }
  }
}
