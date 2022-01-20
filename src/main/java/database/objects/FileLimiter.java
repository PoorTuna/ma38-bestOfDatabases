package database.objects;

import lombok.Data;

@Data
public class FileLimiter {
    public int recordCount = 0;
    public int fileIndex = 0;
    private int recordLimit;

    public FileLimiter(int recordLimit){
        this.recordLimit = recordLimit;
    }

    public void increment(){
        recordCount++;

    }

    public void isOverLimit(){
        if( recordCount >= recordLimit){
           recordCount = 0;
           fileIndex++;
        }
    }
}
