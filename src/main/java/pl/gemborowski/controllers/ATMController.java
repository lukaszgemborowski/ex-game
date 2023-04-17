package pl.gemborowski.controllers;

import org.springframework.web.bind.annotation.*;
import pl.gemborowski.model.atmservice.ATM;
import pl.gemborowski.model.atmservice.ServiceTasks;
import pl.gemborowski.model.atmservice.Task;

import java.util.*;

@RestController
public class ATMController {
    private ATMController() {}

    @PostMapping(value = "/atms/calculateOrder", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public static List<ATM> calculateOrder(@RequestBody ServiceTasks tasks) {
        Map<Integer, Map<Integer, Task>> data = new TreeMap<>();

        // store tasks by their region
        for (Task task : tasks) {
            Map<Integer, Task> e = data.get(task.getRegion());

            if (e == null) {
                e = new TreeMap<>();
                data.put(task.getRegion(), e);
            }

            // if there's an ATM with the same ID, replace it if priority is higher
            Task existingTask = e.get(task.getAtmId());
            if (existingTask != null) {
                if (getRequestPriority(task.getRequestType()) < getRequestPriority(existingTask.getRequestType())) {
                    e.put(task.getAtmId(), task);
                }
            } else {
                e.put(task.getAtmId(), task);
            }
        }

        List<ATM> result = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, Task>> entry : data.entrySet()) {
            for (Map.Entry<Integer, Task> taskEntry : entry.getValue().entrySet()) {
                ATM atm = new ATM();
                atm.setAtmId(taskEntry.getValue().getAtmId());
                atm.setRegion(entry.getKey());
                result.add(atm);
            }
        }

        return result;
    }


    private static int getRequestPriority(String requestType) {
        switch (requestType) {
            case "FAILURE_RESTART":
                return 1;
            case "PRIORITY":
                return 2;
            case "SIGNAL_LOW":
                return 3;
            case "STANDARD":
                return 4;
            default:
                throw new IllegalArgumentException("Invalid request type: " + requestType);
        }
    }


}