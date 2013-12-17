/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sameera
 */
public final class FileInput {
    private String fileName;
    public FileInput(String name) 
    {
        this.fileName=name;
    }
    public int count()throws IOException
    {
        int i=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        try {
            String line;
            while ((line = br.readLine()) != null) 
            {
                i++;
            }
        } 
        finally 
        {
            br.close();
        }
        return i;
    }
    public Record[] inputFile()throws IOException
    {
        int i=this.count();
        Record[] record=new Record[i];
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        try {
            String line;
            int j=0;
            while ((line = br.readLine()) != null) 
            {
                record[j]=new Record(line);
                j++;
            }
        } 
        finally 
        {
            br.close();
        }
        return record;
    }
}
