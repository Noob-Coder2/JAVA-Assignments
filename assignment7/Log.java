package assignment7;


public class Log{
    private int logId;
    private String accountNumber;
    private LogType logType;
    private int amount;
    private String timestamp;
    private boolean status;

    Log(int logId, String accountNumber, LogType logType, int amount, String timestamp, boolean status) {
        this.logId = logId;
        this.accountNumber = accountNumber;
        this.logType = logType;
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Log getLog() {
        return this;
    }

    public int getLogId() {
        return logId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean getStatus() {
        return status;
    }

    public LogType getLogType() {
        return logType;
    }

    @Override
    public String toString() {
        return "Log ID: " + logId + ", Account Number: " + accountNumber + ", Log Type: " + logType + ", Amount: " + amount + ", Timestamp: " + timestamp + ", Status: " + status;
}
}