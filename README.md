# Bug Description

With the dev tools added as a dependency like this...

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
</dependency>
```

... `mvn spring-boot:run` fails with the following error message:

```
[whuesken@odin fsm]$ mvn spring-boot:run
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building fsm 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:2.0.0.RELEASE:run (default-cli) > test-compile @ fsm >>>
[INFO] 
[INFO] --- maven-resources-plugin:3.0.1:resources (default-resources) @ fsm ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ fsm ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.0.1:testResources (default-testResources) @ fsm ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/whuesken/Downloads/fsm/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ fsm ---
[INFO] No sources to compile
[INFO] 
[INFO] <<< spring-boot-maven-plugin:2.0.0.RELEASE:run (default-cli) < test-compile @ fsm <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.0.0.RELEASE:run (default-cli) @ fsm ---
[INFO] Attaching agents: []
23:40:42.890 [main] DEBUG org.springframework.boot.devtools.settings.DevToolsSettings - Included patterns for restart : []
23:40:42.893 [main] DEBUG org.springframework.boot.devtools.settings.DevToolsSettings - Excluded patterns for restart : [/spring-boot-starter/target/classes/, /spring-boot-autoconfigure/target/classes/, /spring-boot-starter-[\w-]+/, /spring-boot/target/classes/, /spring-boot-actuator/target/classes/, /spring-boot-devtools/target/classes/]
23:40:42.893 [main] DEBUG org.springframework.boot.devtools.restart.ChangeableUrls - Matching URLs for reloading : [file:/home/whuesken/Downloads/fsm/target/classes/]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.0.0.RELEASE)

2018-03-10 23:40:43.124  INFO 8441 --- [  restartedMain] com.example.fsm.FsmApplication           : Starting FsmApplication on odin with PID 8441 (/home/whuesken/Downloads/fsm/target/classes started by whuesken in /home/whuesken/Downloads/fsm)
2018-03-10 23:40:43.124  INFO 8441 --- [  restartedMain] com.example.fsm.FsmApplication           : The following profiles are active: dev,native
2018-03-10 23:40:43.157  INFO 8441 --- [  restartedMain] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@5119c6c1: startup date [Sat Mar 10 23:40:43 SGT 2018]; root of context hierarchy
2018-03-10 23:40:43.666  INFO 8441 --- [  restartedMain] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.statemachine.config.configuration.StateMachineAnnotationPostProcessorConfiguration' of type [org.springframework.statemachine.config.configuration.StateMachineAnnotationPostProcessorConfiguration$$EnhancerBySpringCGLIB$$2576ffb4] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-03-10 23:40:43.722  WARN 8441 --- [  restartedMain] s.c.a.AnnotationConfigApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'stateMachineRunner': Unsatisfied dependency expressed through field 'stateMachine'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'stateMachine': Invocation of init method failed; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.fsm.StateMachineConfiguration' available
2018-03-10 23:40:43.733  INFO 8441 --- [  restartedMain] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2018-03-10 23:40:43.836 ERROR 8441 --- [  restartedMain] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Field stateMachine in com.example.fsm.StateMachineRunner required a bean of type 'com.example.fsm.StateMachineConfiguration' that could not be found.


Action:

Consider defining a bean of type 'com.example.fsm.StateMachineConfiguration' in your configuration.

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.362 s
[INFO] Finished at: 2018-03-10T23:40:43+08:00
[INFO] Final Memory: 22M/328M
[INFO] ------------------------------------------------------------------------

```

With the dev tools commented out in the POM file everything works as expected.