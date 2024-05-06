package com.darlanmarangoni.cashcontrol.income.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_income")
class Income(
    @Enumerated(EnumType.STRING)
    @Column(name = "income_type", nullable = false)
    val incomeType: IncomeType,
    @Column(name = "user_id", nullable = false)
    val userId: String,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "description", nullable = false)
    val description: String,
    @JsonIgnore
    @CreationTimestamp
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @JsonIgnore
    @UpdateTimestamp
    val updateDate: LocalDateTime = LocalDateTime.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_income_seq")
    @SequenceGenerator(name = "tb_income_seq", sequenceName = "tb_income_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @OneToMany(mappedBy = "income")
    @JsonIgnore
    lateinit var receiveList: List<Receive>
}