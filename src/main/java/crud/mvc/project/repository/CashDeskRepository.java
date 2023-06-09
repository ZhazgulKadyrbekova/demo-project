package crud.mvc.project.repository;

import crud.mvc.project.entity.CashDesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CashDeskRepository extends JpaRepository<CashDesk, Long>, QuerydslPredicateExecutor<CashDesk> {
}
