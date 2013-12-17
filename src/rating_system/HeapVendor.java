/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

/**
 *
 * @author Sameera
 */
public class HeapVendor {
    private Record[] heap;
    /*
     * type must be set to non zero value to Sort Oldest to Latest.
     * If type =0, then this function sort the array Latest to Oldest.
     */
    private int heap_size;
    Linked_List_Vendor listVendor;
    int select=1;
    /*
     * if select = 0, calculate rating using alternative method (t=no of users).
     * else , ratings are calculated using exact method (t=no of records)
     */
    HeapVendor(Record[] data,Linked_List_Vendor listVendor)
    {
        this.listVendor=listVendor;
        heap=data;
        BuildHeap();
        for(int i=heap.length-1;i>0;i--)
        {
            this.exchange(0,i);
            heap_size--;
            Max_heapify(0);
        }
    }
    HeapVendor(Record[] data,Linked_List_Vendor listVendor,int select)
    {
        this.select=select;
        this.listVendor=listVendor;
        heap=data.clone();
        BuildHeap();
        for(int i=heap.length-1;i>0;i--)
        {
            this.exchange(0,i);
            heap_size--;
            Max_heapify(0);
        }
    }
    public int parent(int index)
    {
        return ((index+1)/2)-1;
    }
    public int left(int index)
    {
        return ((index+1)*2)-1;
    }
    public int right(int index)
    {
        return ((index+1)*2);
    }
/*
* in this function the object which have the latest Timestamp will go to the rootindex of the array
*/
    private void Max_heapify(int rootIndex)
    {
        int root=rootIndex;
        int max;
        while(this.left(root)<heap_size)
        {
            if(select!=0)
            {
                if((listVendor.search(heap[this.left(root)].getVendor()).getRating())>(listVendor.search(heap[root].getVendor()).getRating()))
                {
                    max=this.left(root);
                }
                else
                {
                    max=root;
                }
                if((this.right(root)<heap_size)&&(listVendor.search(heap[this.right(root)].getVendor()).getRating()>listVendor.search(heap[max].getVendor()).getRating()))
                {
                    max=this.right(root);
                }
            }
            else
            {
                if((listVendor.search(heap[this.left(root)].getBook()).getRatingAlternative())>(listVendor.search(heap[root].getBook()).getRatingAlternative()))
                {
                    max=this.left(root);
                }
                else
                {
                    max=root;
                }
                if((listVendor.search(heap[this.right(root)].getBook()).getRatingAlternative())>(listVendor.search(heap[max].getBook()).getRatingAlternative()))
                {
                    max=this.right(root);
                }
            }
            if(max==root)
            {
                break;
            }
            else
            {
                this.exchange(root, max);
                root=max;
            }
        }
    }
    //exchange function is to exchange two elements in the heap.
    private void exchange(int index1,int index2)
    {
        Record temp=heap[index1];
        heap[index1]=heap[index2];
        heap[index2]=temp;
    }
    //BuildHeap function is to create a heap using diven data; 
    private void BuildHeap()
    {
        heap_size=heap.length;
        for(int i=(heap_size-1)/2;i>=0;i--)
        {
            Max_heapify(i);
        }
    }
    //This function is to retrieve records from heap which is sorted by timestamp max to min. 
    public Record getRecord_byMax(int index)
    {
        return heap[index];
    }
    //This function is to retrieve records from heap which is sorted by rating min to max. 
    public Record getRecord_byMin(int index)
    {
        return heap[heap.length-1-index];
    }
    //This function is to get size of the heap.
    public int length()
    {
        return heap.length;
    }
    //This function is to retrieve max from heap.
    public Record getMax()
    {
        return heap[0];
    }
    //This function is to retrieve min from heap.
    public Record getMin()
    {
        return heap[heap.length-1];
    }
}
