package pl.migibud.demoentitymanager.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class EmployeeWarmup {

    private final EmployeeDao employeeDao;
    private final TransactionRunner transactionRunner;

    @EventListener(ContextRefreshedEvent.class)
    void run(){
        Employee employee = new Employee("Piotr","Migaj");
        Employee save = employeeDao.save(employee);
        System.out.println(save);
//        transactionRunner.executeInTransaction(entityManager -> {
//            transactionRunner.executeInTransaction();
//        });
    }


}
