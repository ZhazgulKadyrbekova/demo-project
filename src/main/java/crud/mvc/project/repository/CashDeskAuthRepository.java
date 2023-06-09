package crud.mvc.project.repository;

import crud.mvc.project.entity.CashDeskAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CashDeskAuthRepository extends JpaRepository<CashDeskAuth, Long>, QuerydslPredicateExecutor<CashDeskAuth> {
}
