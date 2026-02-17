package assignment7;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

interface LogDetails {
    void addLog(String accountNumber, LogType logType, int amount, String timestamp, boolean status);
    void getAllLogs(String accountNumber);
    void getRecentLogs(String accountNumber, int n);
    void getSuspiciousLogs(String accountNumber);
    void getAllLogsByType(String accountNumber, LogType logType);
}  

public class LogManager implements LogDetails{

    public  LinkedList<Log> loglist = new LinkedList<>();
    public Deque<Log> recentLogs = new LinkedList<>();
    public HashMap<String, LinkedList<Log>> accountLogs = new HashMap<>();
    int counter = 1;

    public LogManager(String accountNumber) {
        accountLogs.put(accountNumber, new LinkedList<>());
    }
    
    public void addLog(String accountNumber, LogType logType, int amount, String timestamp, boolean status){
        if (logType == LogType.LOGIN || logType == LogType.FAILED_LOGIN) {
            amount = 0; // Set amount to 0 for LOGIN and FAILED_LOGIN types
        }

        Log newLog = new Log(counter++, accountNumber, logType, amount, timestamp, status);
        loglist.add(newLog);
        recentLogs.addFirst(newLog);
        accountLogs.get(accountNumber).add(newLog);
    }

    public void getAllLogs(String accountNumber){
        LinkedList<Log> logs = accountLogs.get(accountNumber);
        for(Log log : logs){
            System.out.println(log.getLog());
        }
    }

    public void getRecentLogs(String accountNumber, int n){
        LinkedList<Log> logs = accountLogs.get(accountNumber);
        int count = 0;
        for(Log log : recentLogs){
            if(log.getAccountNumber().equals(accountNumber)){
                System.out.println(log.getLog());
                count++;
                if(count == n) break;
            }
        }
    }

    public void getSuspiciousLogs(String accountNumber){
        LinkedList<Log> logs = accountLogs.get(accountNumber);
        for(Log log : logs){
            if(!log.getStatus()){
                System.out.println(log.getLog());
            }
        }
    }

    public void getAllLogsByType(String accountNumber, LogType logType){
        LinkedList<Log> logs = accountLogs.get(accountNumber);
        for(Log log : logs){
            if(log.getLogType() == logType){
                System.out.println(log.getLog());
            }
        }
    }
}