package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerTest extends TestCase {

    public void testTurnOn() {
        // given
        Computer pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // when
        pc.turnOn();

        // then
        assertThat(pc.isRunning()).isTrue();
    }

    public void testTurnOff() {
        // given
        Computer pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // when
        pc.turnOn();
        pc.turnOff();

        // then
        assertThat(pc.isRunning()).isFalse();
    }

    public void testGetUUIDNumber() {
        // given
        Computer pc;

        // when
        pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // then
        assertThat(pc.getUUIDNumber()).isInstanceOf(UUID.class);
    }

    public void testSetName() {
        // given
        Computer pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // when
        pc.setName("New Name");

        // then
        assertThat(pc.getName()).startsWith("New")
                .endsWithIgnoringCase("name")
                .isEqualToIgnoringCase("new name");
    }

    public void testSetRam() {
        // given
        Computer pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // when
        pc.setRam(24);

        // then
        assertThat(pc.getRam()).isEqualTo(24);
    }

    public void testNotSetRam() {
        // given
        Computer pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // when
        pc.turnOn();

        // then
        assertThatThrownBy(() -> { pc.setRam(24); }).hasMessage("Turn off pc first");
    }

    public void testSetCores() {
        // given
        Computer pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // when
        pc.setCores(12);

        // then
        assertThat(pc.getCores()).isEqualTo(12);
    }

    public void testNotSetCores() {
        // given
        Computer pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // when
        pc.turnOn();

        // then
        assertThatThrownBy(() -> { pc.setCores(12); }).hasMessage("Turn off pc first");
    }

    public void testSetOperatingSystem() {
        // given
        Computer pc = new Computer(16, 6, "PC", Computer.OperatingSystem.WINDOWS);

        // when
        pc.setOperatingSystem(Computer.OperatingSystem.LINUX);

        // then
        assertThat(pc.getOperatingSystem()).isEqualTo(Computer.OperatingSystem.LINUX);
    }
}