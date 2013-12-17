/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

/**
 *
 * @author Sameera
 */
public class Linked_List_User {
    private NodeUser head;
    private int size=0;
    public Linked_List_User()
    {
        head=new NodeUser();
        head.next=null;
        head.perv=null;
        head.data=null;
    }
    public void insert(User o)
    {
        NodeUser current, temp = new NodeUser();
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
    public User search(String value) 
    {
        NodeUser next = head;
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
    public User getElement(int index) 
    {
        NodeUser next = head;
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
class NodeUser
{
    NodeUser next;
    NodeUser perv;
    User data;
}