package com.example.helloActiviti.service.impl;

/**
 * Created by guang.yang on 2017-11-28.
 */

import org.springframework.stereotype.Service;
    import org.activiti.engine.impl.context.Context;
    import org.activiti.engine.impl.interceptor.Command;
    import org.activiti.engine.impl.interceptor.CommandContext;
    import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
    import org.activiti.engine.impl.persistence.entity.TaskEntity;
    import org.activiti.engine.impl.pvm.process.ActivityImpl;
    import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
    import org.activiti.engine.task.Comment;
    import org.springframework.stereotype.Service;

@Service("JumpTaskCmd")
public class JumpTaskCmdService implements Command<Comment> {

    protected String executionId;  //当前任务的executionID
    protected String activityId;  //跳转目标activityID

    public JumpTaskCmdService() {

    }

    public JumpTaskCmdService(String executionId, String activityId) {
        this.executionId = executionId;
        this.activityId = activityId;
    }

    public Comment execute(CommandContext commandContext) {
        for (TaskEntity taskEntity : Context.getCommandContext().getTaskEntityManager().findTasksByExecutionId(executionId)) {
            Context.getCommandContext().getTaskEntityManager().deleteTask(taskEntity, "jump", false);
        }
        ExecutionEntity executionEntity = Context.getCommandContext().getExecutionEntityManager().findExecutionById(executionId);
        ProcessDefinitionImpl processDefinition = executionEntity.getProcessDefinition();
        ActivityImpl activity = processDefinition.findActivity(activityId);
        executionEntity.executeActivity(activity);
        return null;
    }

}