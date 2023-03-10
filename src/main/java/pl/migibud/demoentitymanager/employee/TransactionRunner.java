package pl.migibud.demoentitymanager.employee;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.function.Consumer;

@Component
class TransactionRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void executeInTransaction(Consumer<EntityManager> c){
        c.accept(entityManager);
    }


}
