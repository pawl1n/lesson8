package org.example;

import java.util.UUID;

public class Computer {
  private boolean running;
  private int ram;
  private int cores;
  private String name;
  private final UUID number;
  private OperatingSystem operatingSystem;

  public Computer(int ram, int cores, String name, OperatingSystem operatingSystem) {
    this.ram = ram;
    this.cores = cores;
    this.name = name;
    this.operatingSystem = operatingSystem;
    this.number = UUID.randomUUID();
    this.running = false;
  }

  public static ComputerBuilder builder() {
    return new ComputerBuilder();
  }

  public void turnOn() {
    running = true;
  }

  public void turnOff() {
    running = false;
  }

  public boolean isRunning() {
    return running;
  }

  public int getRam() {
    return ram;
  }

  public int getCores() {
    return cores;
  }

  public String getName() {
    return name;
  }

  public UUID getUUIDNumber() {
    return number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRam(int ram) {
    if (running) throw new IllegalArgumentException("Turn off pc first");

    this.ram = ram;
  }

  public void setCores(int cores) {
    if (running) throw new IllegalArgumentException("Turn off pc first");

    this.cores = cores;
  }

  public OperatingSystem getOperatingSystem() {
    return operatingSystem;
  }

  public void setOperatingSystem(OperatingSystem operatingSystem) {
    this.operatingSystem = operatingSystem;
  }

  @Override
  public String toString() {
    return "Computer{" +
            "running=" + running +
            ", ram=" + ram +
            ", cores=" + cores +
            ", name='" + name + '\'' +
            ", number=" + number +
            ", operatingSystem=" + operatingSystem +
            '}';
  }

  enum OperatingSystem{
    WINDOWS,
    LINUX,
    MACOS
  }

  public static class ComputerBuilder {
    private int ram;
    private int cores;
    private String name;
    private OperatingSystem operatingSystem;

    public ComputerBuilder ram(int ram) {
      this.ram = ram;
      return this;
    }

    public ComputerBuilder cores(int cores) {
      this.cores = cores;
      return this;
    }

    public ComputerBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ComputerBuilder operatingSystem(OperatingSystem operatingSystem) {
      this.operatingSystem = operatingSystem;
      return this;
    }

    public Computer build() {
      return new Computer(ram, cores, name, operatingSystem);
    }
  }

}
