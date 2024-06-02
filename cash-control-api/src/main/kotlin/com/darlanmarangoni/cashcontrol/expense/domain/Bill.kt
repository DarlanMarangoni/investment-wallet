package com.darlanmarangoni.cashcontrol.expense.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "tb_bill")
class Bill(
    @Column(name = "date", nullable = false)
    val date: LocalDate,
    @Column(name = "projected")
    val projected: BigDecimal = BigDecimal.ZERO,
    @Column(name = "actual", nullable = false)
    val actual: BigDecimal = BigDecimal.ZERO,
    @JsonIgnore
    @CreationTimestamp
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @JsonIgnore
    @UpdateTimestamp
    val updateDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    @JoinColumn(name = "expense_id")
    val expense: Expense
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_spent_seq")
    @SequenceGenerator(name = "tb_spent_seq", sequenceName = "tb_spent_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}