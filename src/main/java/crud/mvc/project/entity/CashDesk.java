package crud.mvc.project.entity;

import javax.persistence.*;
import java.math.BigDecimal;

//    currency always in som
@Entity
@Table(name = "cash_desk")      //касса банка
public class CashDesk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cash_desk_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cash_desk_auth_id")
    private CashDeskAuth auth;

    public CashDesk() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CashDesk(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public CashDeskAuth getAuth() {
        return auth;
    }

    public void setAuth(CashDeskAuth auth) {
        this.auth = auth;
    }
}
