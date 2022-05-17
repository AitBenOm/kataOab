package Model;

import java.util.Calendar;

public record AccountHistoryEntry(OperationTypeEnum operationType, Calendar operationDate, int amount, int balance) {}


