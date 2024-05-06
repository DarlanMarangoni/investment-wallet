package com.darlanmarangoni.cashcontrol.income.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "tb_receive")
class Receive(
    @Column(name = "date", nullable = false)
    val date: LocalDate,
    @Column(name = "projected")
    val projected: BigDecimal,
    @Column(name = "actual", nullable = false)
    val actual: BigDecimal,
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_receive_seq")
    @SequenceGenerator(name = "tb_receive_seq", sequenceName = "tb_receive_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "income_id")
    lateinit var income: Income
}