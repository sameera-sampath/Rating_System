/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

import java.util.Date;

/**
 *
 * @author Sameera
 */
public class Stack_Record {
    private NodeRecord head;
    private int size=0;
    public Stack_Record()
    {
        this.head=new NodeRecord();
        head.next=null;
        head.perv=null;
        head.data=null;
    }
    public void Push(Record o)
    {
        NodeRecord current, temp = new NodeRecord();
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
    public Record search(Date value) 
    {
        NodeRecord next = head;
        while (next.next != null) 
        {
            next = next.next;
            if (next.data.getTimestamp().equals(value)) 
            {
                return next.data;
            }
        }
        return null;
    }
    public Record getElement(int index) 
    {
        NodeRecord next = head;
        if(index>size)
        {
            return null;
        }
        for(int i=0;i<index;i++)
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
class NodeRecord
{
    NodeRecord next;
    NodeRecord perv;
    Record data;
}