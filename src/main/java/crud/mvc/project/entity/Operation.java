package crud.mvc.project.entity;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
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

    public Operation() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CashDesk getFromCashDesk() {
        return fromCashDesk;
    }

    public void setFromCashDesk(CashDesk fromCashDesk) {
        this.fromCashDesk = fromCashDesk;
    }

    public CashDesk getToCashDesk() {
        return toCashDesk;
    }

    public void setToCashDesk(CashDesk toCashDesk) {
        this.toCashDesk = toCashDesk;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getSomAmount() {
        return somAmount;
    }

    public void setSomAmount(BigDecimal somAmount) {
        this.somAmount = somAmount;
    }

    private void generateCode() {
        this.code = UUID.randomUUID().toString();
    }

    @PrePersist
    public void init(){
        setCreatedDate(LocalDateTime.now());
        setStatus(OperationStatus.CREATED);
        generateCode();
    }
}
