/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Sameera
 */
public class Rating_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner read=new Scanner(System.in);       //to get input
        FileInput f1=new FileInput("UserRating.txt");
        //FileInput f1=new FileInput("Input_2.txt");
        Record[] r1=f1.inputFile();
        HeapSort heap=new HeapSort(r1,1);
        Linked_List_User listUser=new Linked_List_User();
        Linked_List_Vendor listVendor=new Linked_List_Vendor();
        Linked_List_Book listBook=new Linked_List_Book();
        String book,vendor;
        int select=1;
        for(int i=0;i<heap.length();i++)
        {
            /*
             * If there is a rating by new user crate new user object.
             * If existing user rated a product or vendor, increment rating counter of the user.
             */
            if(listUser.search(heap.getRecord_byOldest(i).getUser())==null)
            {
                listUser.insert(new User(heap.getRecord_byOldest(i).getUser()));
            }
            else
            {
                listUser.search(heap.getRecord_byOldest(i).getUser()).incrementCount();
            }
            /*
             * If a new vendor is rated crate new vendor object and store the record in vendor object.
             * If a existing vendor is rated, store the record in vendor object for calculating aggregete rating.
             */
            if(listVendor.search(heap.getRecord_byOldest(i).getVendor())==null)
            {
                listVendor.insert(new Vendor(heap.getRecord_byOldest(i),listUser,listBook));
            }
            else
            {
                listVendor.search(heap.getRecord_byOldest(i).getVendor()).AddRating(heap.getRecord_byOldest(i));
            }
            /*
             * If a new book is rated crate new book object and store the record in book object.
             * If a existing book is rated, store the record in book object for calculating aggregete rating.
             */
            if(listBook.search(heap.getRecord_byOldest(i).getBook())==null)
            {
                listBook.insert(new Book(heap.getRecord_byOldest(i),listUser,listVendor));
            }
            else
            {
                listBook.search(heap.getRecord_byOldest(i).getBook()).AddRating(heap.getRecord_byOldest(i));
            }
        }
        /*
         * Print Aggregate ratings of all books and vendors.
         */
        /*System.out.println(heap.getRecord_byOldest(0).getTimestamp());
        System.out.println(heap.length());
        System.out.println("\t\tAggregate Ratings");
        System.out.println("Vendors\tt=no of Records method(Exact eqn)");
        System.out.println("No\tRating\t\t\tcount\tName");
        for(int i=1;i<=listVendor.length();i++)
        {
            System.out.println(i+"\t"+listVendor.getElement(i).getRating()+"\t"+listVendor.getElement(i).getCount()+"\t"+listVendor.getElement(i).getName());
        }
        System.out.println("Books\tt=no of Records method (Exact eqn)");
        System.out.println("No\tRating\t\t\tcount\tName");
        for(int i=1;i<=listBook.length();i++)
        {
            System.out.println(i+"\t"+listBook.getElement(i).getRating()+"\t"+listBook.getElement(i).getCount()+"\t"+listBook.getElement(i).getName());
        }
        /*
         * Print Aggregate ratings of all books and vendors when we had given t=number of users.
         */
        /*System.out.println("Vendors\tt=no of Users method");
        System.out.println("No\tRating\t\t\tcount\tName");
        for(int i=1;i<=listVendor.length();i++)
        {
            System.out.println(i+"\t"+listVendor.getElement(i).getRatingAlternative()+"\t"+listVendor.getElement(i).getCount()+"\t"+listVendor.getElement(i).getName());
        }
        System.out.println("Books\tt=no of Users method");
        System.out.println("No\tRating\t\t\tcount\tName");
        for(int i=1;i<=listBook.length();i++)
        {
            System.out.println(i+"\t"+listBook.getElement(i).getRatingAlternative()+"\t"+listBook.getElement(i).getCount()+"\t"+listBook.getElement(i).getName());
        }*/
        while(select!=0)
        {
            
            System.out.println("\tEnter\n1\tFor Book Search\n2\tFor Vendor Search\n0\tFor Exit");
            select=read.nextInt();
            switch(select)
            {
                case 1:
                    System.out.println("Enter Book name to search: ");
                    book=read.next();
                    listBook.BookSearch(book,listVendor);
                    break;
                case 2:
                    System.out.println("Enter Vendor name to search: ");
                    vendor=read.next();
                    listVendor.VendorSearch(vendor,listBook);
                    break;
                default:
                    select=0;
            }
        }
        /*listBook.BookSearch("A_Tale_of_Two_Cities",listVendor);
        listBook.BookSearch("The_Catcher_in_the_Rye",listVendor);
        listBook.BookSearch("The_Hobbit",listVendor);
        listVendor.VendorSearch("National_Book_Stall",listBook);
        listVendor.VendorSearch("Sarasavi",listBook);
        listVendor.VendorSearch("Makeen_Books",listBook);*/
    }
}
