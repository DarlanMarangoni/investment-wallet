package com.darlanmarangoni.investmentapi.records;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record BrockerageNoteRecord(List<TransactionOrderRecord> brockerageNoteRecords) {
}
