package com.example.tensor.model;




public class Worker {
    private long id;
    private String name;
    private boolean active;
    private float cpuUsage;
    private float ramUsage;
    private float diskUsage;

    public Worker(long id, String name, boolean active, float cpuUsage, float ramUsage, float diskUsage) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.cpuUsage = cpuUsage;
        this.ramUsage = ramUsage;
        this.diskUsage = diskUsage;
    }

    public Worker() {}

    public long getId() {
        return id;
    }
    public String getName() {return name;}

    public boolean isActive() {return active;}
    public float getCpuUsage() {return cpuUsage;}
    public float getRamUsage() {return ramUsage;}
    public float getDiskUsage() {return diskUsage;}
    public void setActive(boolean active) {this.active = active;}
    public void setCpuUsage(float cpuUsage) {this.cpuUsage = cpuUsage;}
    public void setRamUsage(float ramUsage) {this.ramUsage = ramUsage;}
    public void setDiskUsage(float diskUsage) {this.diskUsage = diskUsage;}
    public void setName(String name) {this.name = name;}
    

}
