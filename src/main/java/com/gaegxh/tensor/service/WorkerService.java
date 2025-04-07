package com.gaegxh.tensor.service;

import com.gaegxh.tensor.model.Worker;
import com.gaegxh.tensor.repository.WorkerRepository;
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
    public void delete(Worker worker) {
        workerRepository.delete(worker);
    }
    public List<Worker> findByName(String name) {
        return workerRepository.findByName(name);
    }
}
