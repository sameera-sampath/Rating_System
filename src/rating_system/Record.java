/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

/**
 *
 * @author Sameera
 */
import java.util.Date;
public class Record {
    private String temp[];
    private String dateString;
    private String user;
    private String book;
    private String vendor;
    private int vendorRating;
    private int bookRating;
    private int year,month,date,hour,minit;
    private String inputDate[];
    private String tempDate[];
    private String tempTime[];
    private Date timestamp;
    public Record(String input)
    {
        temp=input.split(" ");
        dateString=temp[0];
        user=temp[1];
        book=temp[2];
        vendor=temp[3];
        vendorRating=Integer.parseInt(temp[4]);
        bookRating=Integer.parseInt(temp[5]);
        inputDate=dateString.split("T");
        tempDate=inputDate[0].split("-");
        tempTime=inputDate[1].split(":");
        year=Integer.parseInt(tempDate[0])-1900;
        month=Integer.parseInt(tempDate[1])-1;
        date=Integer.parseInt(tempDate[2]);
        hour=Integer.parseInt(tempTime[0]);
        minit=Integer.parseInt(tempTime[1]);
        timestamp=new Date(year,month,date,hour,minit);
    }
    public Date getTimestamp()
    {
        return timestamp;
    }
    public String getUser()
    {
        return user;
    }
    public String getBook()
    {
        return book;
    }
    public String getVendor()
    {
        return vendor;
    }
    public int getVendorRating()
    {
        return vendorRating;
    }
    public int getBookRating()
    {
        return bookRating;
    }
}
