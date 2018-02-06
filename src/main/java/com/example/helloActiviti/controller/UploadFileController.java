package com.example.helloActiviti.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloActiviti.domain.TaskInformation;

/**
 * Created by guang.yang on 2017-11-02.
 */
@RestController
@RequestMapping("/api")
public class UploadFileController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ManagementService managementService;

    @GetMapping("/startStandardTask")
    public String test() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloActiviti");
        System.out.println(processInstance + " started.");


        return "OK";
    }

    public void endProcess(String taskId){

    }

    @GetMapping("/startGMTask")
    public String startGmTask(){
        runtimeService.startProcessInstanceByKey("SequenceForGM");
        return "OK";
    }

    @GetMapping("/getTasks/{assigne}")
    public List<TaskInformation> getTasks(@PathVariable String assigne){
        List<Task> tasks =  taskService.createTaskQuery().taskAssignee(assigne).list();
        List<TaskInformation> taskInfos = new LinkedList<>();
        for(Task task : tasks){
            TaskInformation taskInformation = new TaskInformation();
            taskInformation.setTaskId(task.getId());
            taskInformation.setTaskName(task.getName());
            taskInformation.setTaskExcuteId(task.getExecutionId());
            String processDefinitionId = task.getProcessDefinitionId().substring(0,task.getProcessDefinitionId().indexOf(":"));
            taskInformation.setProcessDefinitionId(processDefinitionId);
            taskInfos.add(taskInformation);
        }
        return taskInfos;
    }

    @GetMapping("/getHistory/{excutionId}")
    public List<String> getHistory(@PathVariable String excutionId){
        List<HistoricActivityInstance> histories = historyService.createNativeHistoricActivityInstanceQuery().sql("select * from " + managementService.getTableName(HistoricActivityInstance.class)+ " where EXECUTION_ID_= #{excutionId}")
        .parameter("excutionId",excutionId).list();
        List<String> actNames = new ArrayList<>();
        for(HistoricActivityInstance history:histories){
            actNames.add(history.getActivityName());
        }
        return actNames;
    }

    @GetMapping("/giveApprove/{taskId}")
    public String giveApprove(@PathVariable String taskId){
        Map<String,Object> result = new HashMap<>();
        result.put("status",true);
        taskService.complete(taskId,result);
        return "OK";
    }

    @GetMapping("/giveReject/{taskId}")
    public String giveReject(@PathVariable String taskId){
        Map<String,Object> result = new HashMap<>();
        result.put("status",false);
        taskService.complete(taskId,result);
        return "OK";
    }
}
