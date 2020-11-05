package com.ak.fx.core;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceTest {
  @Test
  void serve() {
    Arrays.stream(SerialPort.getCommPorts()).forEach(comPort -> {
      Logger.getLogger(getClass().getName()).info("[%s] %s".formatted(comPort.getSystemPortName(), comPort.getDescriptivePortName()));
      comPort.setBaudRate(115200);
      comPort.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);
      CountDownLatch latch = new CountDownLatch(1);
      if (comPort.openPort()) {
        comPort.addDataListener(new SerialPortDataListener() {
          @Override
          public int getListeningEvents() {
            return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
          }

          @Override
          public void serialEvent(SerialPortEvent event) {
            if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
              byte[] newData = new byte[comPort.bytesAvailable()];
              int numRead = comPort.readBytes(newData, newData.length);
              if (numRead > 0) {
                Logger.getLogger(getClass().getName()).info(Arrays.toString(newData));
                latch.countDown();
              }
            }
          }
        });

        comPort.writeBytes(new byte[] {1, 2}, 2);
        try {
          latch.await(1, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
          Assertions.fail(comPort.getDescriptivePortName());
        }
      }
    });
  }
}