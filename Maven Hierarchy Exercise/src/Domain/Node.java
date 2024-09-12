package Domain;

public class Node<Person> {
    Person data;
    Node next;
    Node(Person p){
        this.data = p;
        this.next = null;
    }
}
