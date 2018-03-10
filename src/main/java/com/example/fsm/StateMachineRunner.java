package com.example.fsm;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

@Component
public class StateMachineRunner implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(StateMachineRunner.class);

    @Autowired
    private StateMachine<String, String> stateMachine;

    @PostConstruct
    public void init() {
        stateMachine.start();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Sending E1 with result: {}", stateMachine.sendEvent("E1"));
    }

}
