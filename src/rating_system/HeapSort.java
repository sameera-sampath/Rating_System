/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

/**
 *
 * @author Sameera
 */
public class HeapSort {
    private Record[] heap;
    private int type; 
    /*
     * type must be set to non zero value to Sort Oldest to Latest.
     * If type =0, then this function sort the array Latest to Oldest.
     */
    private int heap_size;
    HeapSort(Record[] data,int select)
    {
        type=select;
        heap=data.clone();
        BuildHeap();
        for(int i=heap.length-1;i>0;i--)
        {
            this.exchange(0,i);
            heap_size--;
            if(type==0)
            {
                Latest_heapify(0);
            }
            else
            {
                Oldest_heapify(0);
            }
        }
        /*for(int i=0;i<heap.length;i++)
        {
            System.out.println(heap[i].getTimestamp());
        }*/
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
    private void Latest_heapify(int rootIndex)
    {
        int root=rootIndex;
        int latest;
        while(this.left(root)<heap_size)
        {
            if(heap[this.left(root)].getTimestamp().before(heap[root].getTimestamp()))
            {
                latest=this.left(root);
            }
            else
            {
                latest=root;
            }
            if((this.right(root)<heap_size)&&(heap[this.right(root)].getTimestamp().before(heap[latest].getTimestamp())))
            {
                latest=this.right(root);
            }
            if(latest==root)
            {
                break;
            }
            else
            {
                this.exchange(root, latest);
                root=latest;
            }
        }
    }
/*
* in this function the object which have the oldest Timestamp will go to the rootindex of the array
*/
    private void Oldest_heapify(int rootIndex)
    {
        int root=rootIndex;
        int oldest;
        while(this.left(root)<heap_size)
        {
            if(heap[this.left(root)].getTimestamp().after(heap[root].getTimestamp()))
            {
                oldest=this.left(root);
            }
            else
            {
                oldest=root;
            }
            if((this.right(root)<heap_size)&&(heap[this.right(root)].getTimestamp().after(heap[oldest].getTimestamp())))
            {
                oldest=this.right(root);
            }
            if(oldest==root)
            {
                break;
            }
            else
            {
                this.exchange(root, oldest);
                root=oldest;
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
        if(type==0)
        {
            for(int i=(heap_size-1)/2;i>=0;i--)
            {
                Latest_heapify(i);
            }
        }
        else
        {
            for(int i=(heap_size-1)/2;i>=0;i--)
            {
                Oldest_heapify(i);
            }
        }
    }
    //This function is to retrieve records from heap which is sorted by timestamp latest to oldest. 
    public Record getRecord_byLatest(int index)
    {
        if(type==0)
        {
            return heap[index];
        }
        else
        {
            return heap[heap.length-1-index];
        }
    }
    //This function is to retrieve records from heap which is sorted by timestamp oldest to latest. 
    public Record getRecord_byOldest(int index)
    {
        if(type!=0)
        {
            return heap[index];
        }
        else
        {
            return heap[heap.length-1-index];
        }
    }
    //This function is to get size of the heap.
    public int length()
    {
        return heap.length;
    }
    //This function is to retrieve latest record from heap.
    public Record getLatest()
    {
        if(type==0)
        {
            return heap[0];
        }
        else
        {
            return heap[heap.length-1];
        }
    }
    //This function is to retrieve oldest record from heap.
    public Record getOldest()
    {
        if(type!=0)
        {
            return heap[0];
        }
        else
        {
            return heap[heap.length-1];
        }
    }
}
