package com.example.tensor.service;

import com.example.tensor.model.Worker;
import com.example.tensor.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
    public List<Worker> getAllWorkers() {
        return workerRepository.FindAll();
    }
    public Worker getWorkerById(int id) {
        return workerRepository.findById(id);
    }
    public void save(Worker worker) {
        workerRepository.save(worker);
    }
}
