package com.example.tensor.model;

import java.util.HashMap;

public class MainCenter {
    private long id;
    private  String name;
    private String Status;
    private HashMap<String,Worker> map = new HashMap<>();

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getStatus() {return Status;}
    public void setStatus(String status) {this.Status = status;}
    public HashMap<String,Worker> getMap() {return map;}
    public void setMap(HashMap<String,Worker> map) {this.map = map;}
    public Worker getWorker(String id) {return map.get(id);}
    public void addWorker(Worker worker) {map.put(String.valueOf(worker.getId()),worker);}

}
