/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

import java.text.DecimalFormat;

/**
 *
 * @author Sameera
 */
public class Linked_List_Book {
    private NodeBook head;
    private int size=0;
    public Linked_List_Book()
    {
        head=new NodeBook();
        head.next=null;
        head.perv=null;
        head.data=null;
    }
    public void insert(Book o)
    {
        NodeBook current, temp = new NodeBook();
        temp.data= o;
        current = head;
        temp.perv = current;
        temp.next = current.next;
        if(current.next!=null)
        {
            current.next.perv=temp;
        }
        current.next = temp;
        size++;
    }
    public int length()
    {
        return size;
    }
    public void BookSearch(String name,Linked_List_Vendor listVendor)
    {
        DecimalFormat formatter = new DecimalFormat("#0.000000000000000");
        int i=1,j=0;
        Record rec;
        String vendor;
        Book temp=this.search(name);
        if(temp!=null)
        {
            int heapSize=temp.Heaplength();
            System.out.println("5 most recent ratings of the book "+name);
            System.out.println("\tTimestamp\t\tRating\tUserName");
            while(i<=5)
            {
                rec=temp.stack.getElement(i);
                System.out.println(rec.getTimestamp()+"\t"+rec.getBookRating()+"\t"+rec.getUser());
                i++;
            }
            System.out.println("Overall aggregate rating of the book "+name+" =\t"+temp.getRating());
            System.out.println("Top rated vendors of the product "+name);
            vendor=temp.getRecord_byMin(j).getVendor();
            if(j<heapSize)
            {
                System.out.println("\tRating\t\tProduct");
                System.out.println(formatter.format(listVendor.search(vendor).getRating())+"\t"+vendor);
            }
            for(j=1;j<heapSize;j++)
            {
                vendor=temp.getRecord_byMin(j).getVendor();
                if((!temp.getRecord_byMin(j-1).getVendor().equals(vendor)))
                {
                    System.out.println(formatter.format(listVendor.search(vendor).getRating())+"\t"+vendor);
                }
            }
        }
        else
        {
            System.out.println("\tError!!!\nIncorrect Book Name.");
        }
    }
    public Book search(String value) 
    {
        NodeBook next = head;
        while (next.next != null) 
        {
            next = next.next;
            if (next.data.getName().equals(value)) 
            {
                return next.data;
            }
        }
        return null;
    }
    public Book getElement(int index) 
    {
        NodeBook next = head;
        for(int i=0;i<index&&index<=size;i++)
        {
            next = next.next;
        }
        return next.data;
    }
    public boolean isEmpty()
    {
        if(head.next==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
class NodeBook
{
    NodeBook next;
    NodeBook perv;
    Book data;
}