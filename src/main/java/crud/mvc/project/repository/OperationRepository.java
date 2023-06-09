package crud.mvc.project.repository;

import crud.mvc.project.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>, QuerydslPredicateExecutor<Operation> {
}
