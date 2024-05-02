package com.darlanmarangoni.cashcontrol.expense.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_expense")
class Expense(
    @Enumerated(EnumType.STRING)
    @Column(name = "expense_type", nullable = false)
    val expenseType: ExpenseType,
    @Column(name = "user_id", nullable = false)
    val userId: String,
    @Column(name = "name", nullable = false)
    val name: String,
    @JsonIgnore
    @CreationTimestamp
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @JsonIgnore
    @UpdateTimestamp
    val updateDate: LocalDateTime = LocalDateTime.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_expense_seq")
    @SequenceGenerator(name = "tb_expense_seq", sequenceName = "tb_expense_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @OneToMany(mappedBy = "expense")
    lateinit var bills: List<Bill>
}