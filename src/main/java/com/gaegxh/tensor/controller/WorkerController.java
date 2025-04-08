package com.gaegxh.tensor.controller;


import com.gaegxh.tensor.model.Worker;
import com.gaegxh.tensor.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/worker")
public class WorkerController {
    public final WorkerService workerService;
    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/auth")
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
        try{
            workerService.save(worker);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(worker, HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWorker(@PathVariable int id) {
        try {
            var work= workerService.findById(id);
            if(work==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            workerService.delete(work);

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Удален");
    }








}
