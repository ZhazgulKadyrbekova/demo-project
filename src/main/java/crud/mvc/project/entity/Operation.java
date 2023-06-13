package crud.mvc.project.entity;

import crud.mvc.project.entity.enums.Currency;
import crud.mvc.project.entity.enums.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    private Long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @Column(name = "total_som_amount")
    private BigDecimal somAmount;

    @ManyToOne
    @JoinColumn(name = "from_cash_desk_id")
    private CashDesk fromCashDesk;

    @ManyToOne
    @JoinColumn(name = "to_cash_desk_id")
    private CashDesk toCashDesk;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OperationStatus status;

    @Column(name = "sender_name", nullable = false)
    private String senderName;

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Column(name = "sender_phone_number")
    private String senderPhoneNumber;

    @Column(name = "receiver_phone_number")
    private String receiverPhoneNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "code", unique = true, updatable = false, nullable = false)
    private String code;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @PrePersist
    public void init(){
        this.createdDate  = LocalDateTime.now();
        this.status = OperationStatus.CREATED;
        this.code = UUID.randomUUID().toString();
    }
}
