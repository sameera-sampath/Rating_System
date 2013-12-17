/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

/**
 *
 * @author Sameera
 */
public class Vendor {
    private String name;
    private double aggregateRating,aggregateAlternative;
    Stack_Record stack=new Stack_Record();
    private Linked_List_User listUser=new Linked_List_User();
    private Linked_List_User list;
    private Linked_List_Book Book;
    private HeapBook bookHeap;
    private Record[] heap;
    private boolean heaped=false;
    public Vendor(Record record,Linked_List_User list,Linked_List_Book listBook)
    {
        this.Book=listBook;
        this.list=list;
        name=record.getVendor();
        stack.Push(record);
        listUser.insert(new User(record.getUser(),record.getVendorRating()));
    }
    public void AddRating(Record record)
    {
        stack.Push(record);
        if(listUser.search(record.getUser())==null)
            {
                listUser.insert(new User(record.getUser(),record.getVendorRating()));
            }
            else
            {
                listUser.search(record.getUser()).newRating(record.getVendorRating());
            }
    }
    public String getName()
    {
        return name;
    }
    public int getCount()
    {
        return stack.length();
    }
    public double getRating()
    {
        if(!heaped)
        {
            this.heap();
        }
        this.calculateRating();
        return aggregateRating;
    }
    public double getRatingAlternative()
    {
        if(!heaped)
        {
            this.heap();
        }
        this.calculateRatingAlternative();
        return aggregateAlternative;
    }
    public void calculateRatingAlternative()
    {
        double weight;
        int ratingSum,ratingCount;
        double neumirator=0,denominator=0;
        for(int i=1;i<=listUser.length();i++)
        {
            weight=list.search(listUser.getElement(i).getName()).getWeight();
            ratingSum=listUser.getElement(i).getRatingSum();
            ratingCount=listUser.getElement(i).getCount();
            neumirator+=(weight*ratingSum);
            denominator+=(weight*ratingCount);
        }
        aggregateAlternative=neumirator/denominator;
    }
    public void calculateRating()
    {
        double weight;
        int ratingSum,ratingCount;
        double neumirator=0,denominator=0;
        for(int i=0;i<heap.length;i++)
        {
            weight=list.search(heap[i].getUser()).getWeight();
            ratingSum=listUser.search(heap[i].getUser()).getRatingSum();
            ratingCount=listUser.search(heap[i].getUser()).getCount();
            neumirator+=(weight*ratingSum);
            denominator+=(weight*ratingCount);
        }
        aggregateRating=neumirator/denominator;
    }
    public void heap()
    {
        heaped=true;
        heap=new Record[stack.length()];
        for(int i=0;i<heap.length;i++)
        {
            heap[i]=stack.getElement(i+1);
        }
        bookHeap=new HeapBook(heap,Book);
    }
    //This function is to retrieve records from heap which is sorted by bookRating max to min. 
    public Record getRecord_byMax(int index)
    {
        if(!heaped)
        {
            this.heap();
        }
        return heap[index];
    }
    //This function is to retrieve records from heap which is sorted by BookRating mint to max. 
    public Record getRecord_byMin(int index)
    {
        if(!heaped)
        {
            this.heap();
        }
        return heap[heap.length-1-index];
    }
    //This function is to get length of the book heap.
    public int Heaplength()
    {
        if(!heaped)
        {
            this.heap();
        }
        return heap.length;
    }
}
