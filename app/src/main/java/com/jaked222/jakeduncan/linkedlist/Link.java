package com.jaked222.jakeduncan.linkedlist;

/**
 * Created by jakeduncan on 10/29/16.
 */

public class Link {

    public String bookName;
    public int millionSold;

    public Link next;

    public Link(String bookName, int millionSold) {
        this.bookName = bookName;
        this.millionSold = millionSold;
    }

    public void display(){
        System.out.println(bookName + ": " + millionSold);
    }
    public String toString(){
        return bookName;
    }

    public static void main(String[] args) {
    LinkList linkList = new LinkList();

        linkList.insertFirstLink("book1", 500);
        linkList.insertFirstLink("book2", 200);
        linkList.insertFirstLink("book3", 100);
        linkList.insertFirstLink("book4", 1);
        linkList.insertFirstLink("book5", 4);

        linkList.display();
    }
}

class LinkList{
    public Link firstLink;

    public LinkList() {
        this.firstLink = null;
    }
    public boolean isEmpty(){
    return (firstLink == null);
    }
    public void insertFirstLink(String bookName, int millionSold){

        Link newLink = new Link(bookName, millionSold);

        newLink.next = firstLink;

        firstLink = newLink;
    }
    public Link removeFirst(){
        Link linkReference = firstLink;

        if (!isEmpty()){
            firstLink = firstLink.next;
        }else{
            System.out.println("empty linkedList");
        }
        return linkReference;
    }
    public void display(){
        Link theLink = firstLink;

        while (theLink!= null){

            theLink.display();

            System.out.println("Next Link:" + theLink.next);

            theLink = theLink.next;

            System.out.println();
        }
    }
    public Link find(String bookName){
        Link theLink = firstLink;

        if (!isEmpty()){

            while (theLink.bookName != bookName){

                if (theLink.next == null){
                    return null;
                }
                else{
                    theLink = theLink.next;
                }
            }
        }else{
            System.out.println("empty list");
        }
        return theLink;
    }
    public Link removeLink(String bookName){

        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while (currentLink.bookName != bookName){

            if(currentLink.next == null){
                return null;
            }else{

                previousLink = currentLink;

                currentLink = currentLink.next;
            }



        }

        if(currentLink == firstLink){

            firstLink = firstLink.next;

        }else{
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }
}