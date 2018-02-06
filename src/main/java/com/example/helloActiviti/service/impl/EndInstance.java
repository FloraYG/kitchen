package com.example.helloActiviti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.TaskServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;

/**
 * Created by guang.yang on 2017-11-28.
 */
public class EndInstance {
    /**
     * 终止正在运行的流程实例
     * @author:kaka
     * @param dkey:流程定义key,businessKey:业务id
     */

    public void stopRunProcessInstance( String dkey,String businessKey) {
 /*       if( null != businessKey ) {
            HistoricProcessInstance processInstanceId = RepositoryService.getHistoryService().createHistoricProcessInstanceQuery().processInstanceBusinessKey( businessKey ).singleResult();
            Task task = workflowFactory.getTaskService().createTaskQuery().processInstanceId( processInstanceId.getId() ).singleResult();
            if(null != task){
                TaskServiceImpl taskServiceImpl = ( TaskServiceImpl )workflowFactory.getTaskService();
                // 直接跳转到结束
                String eventActivityId = workflowUtils.getEndEventActivityId(dkey);
                taskServiceImpl.getCommandExecutor().execute( new JumpTaskCmdService( task.getExecutionId(), eventActivityId) );
            }
        }*/

    }

    public String getEndEventActivityId(String dkey){
        String endActivityId = null;
        List<ActivityImpl> allActivities = getAllActivities(dkey);
        for(ActivityImpl activity : allActivities){
            String type = activity.getProperty("type").toString();
            if(type.equals("endEvent")){
                endActivityId = activity.getId();
                break;
            }
        }
        return endActivityId;
    }

    //存放流程对应的所有activity
    private static Map<String,List<ActivityImpl>> processActivitiMap = new HashMap<>();

    public List<ActivityImpl> getAllActivities(String dkey) {
        List<ActivityImpl> activities = processActivitiMap.get(dkey);
 /*       if(activities == null){
            RepositoryService repositoryService = factory.getRepositoryService();
            ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(dkey).singleResult();
            ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                .getDeployedProcessDefinition(definition.getId());

            //获取所有的activity
            activities = processDefinition.getActivities();
            processActivitiMap.put(dkey,activities);
        }*/

        return activities;
    }

}
