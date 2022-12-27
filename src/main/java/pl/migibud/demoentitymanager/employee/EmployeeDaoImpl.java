package pl.migibud.demoentitymanager.employee;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createNamedQuery("From Employee",Employee.class).getResultList();
    }
}
