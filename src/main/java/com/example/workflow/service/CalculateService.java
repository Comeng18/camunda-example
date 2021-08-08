package com.example.workflow.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service("calculate")
public class CalculateService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        double salary = Double.parseDouble(delegateExecution.getVariable("salary").toString());
        int creditNote = 500;
        if (salary > 2000 && salary <= 5000)
            creditNote = 1000;
        else if (salary > 5000)
            creditNote = 3000;

        delegateExecution.setVariable("creditNote", creditNote);
    }
}
