package com.ak.fx.core;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
            return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
          }

          @Override
          public void serialEvent(SerialPortEvent event) {
            if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
              byte[] newData = event.getReceivedData();
              Logger.getLogger(getClass().getName()).info("%s : %s".formatted(event.getSerialPort(), Arrays.toString(newData)));
              latch.countDown();
            }
          }
        });

        byte[] buffer = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        comPort.writeBytes(buffer, buffer.length);
        try {
          Assertions.assertThat(latch.await(1, TimeUnit.SECONDS)).isFalse();
        }
        catch (InterruptedException e) {
          Assertions.fail(comPort.getDescriptivePortName());
        }
      }
    });
  }
}