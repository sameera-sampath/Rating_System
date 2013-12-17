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
public class Linked_List_Vendor {
    private NodeVendor head;
    private int size=0;
    public Linked_List_Vendor()
    {
        head=new NodeVendor();
        head.next=null;
        head.perv=null;
        head.data=null;
    }
    public void insert(Vendor o)
    {
        NodeVendor current, temp = new NodeVendor();
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
    public void VendorSearch(String name,Linked_List_Book listBook)
    {
        DecimalFormat formatter = new DecimalFormat("#0.000000000000000");
        int i=1,j=0;
        Record rec;
        String book;
        Vendor temp=this.search(name);
        if(temp!=null)
        {
            int heapSize=temp.Heaplength();
            System.out.println("5 most recent ratings of the vendor "+name);
            System.out.println("\tTimestamp\t\tRating\tUserName");
            while(i<=5)
            {
                rec=temp.stack.getElement(i);
                System.out.println(rec.getTimestamp()+"\t"+rec.getVendorRating()+"\t"+rec.getUser());
                i++;
            }
            System.out.println("Overall aggregate rating of the vendor "+name+" =\t"+temp.getRating());
            System.out.println("List of products "+name+" sells and overall aggregate rating of each product");
            book=temp.getRecord_byMin(j).getBook();
            if(j<heapSize)
            {
                System.out.println("\tRating\t\tProduct");
                System.out.println(formatter.format(listBook.search(book).getRating())+"\t"+book);
            }
            for(j=1;j<heapSize;j++)
            {
                book=temp.getRecord_byMin(j).getBook();
                if((!temp.getRecord_byMin(j-1).getBook().equals(book)))
                {
                    System.out.println(formatter.format(listBook.search(book).getRating())+"\t"+book);
                }
            }
        }
        else
        {
            System.out.println("\tError!!!\nIncorrect Vendor Name.");
        }
    }
    public Vendor search(String value) 
    {
        NodeVendor next = head;
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
    public Vendor getElement(int index) 
    {
        NodeVendor next = head;
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
class NodeVendor
{
    NodeVendor next;
    NodeVendor perv;
    Vendor data;
}