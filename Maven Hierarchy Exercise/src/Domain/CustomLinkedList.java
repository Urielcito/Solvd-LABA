package Domain;

public class CustomLinkedList<Person> {
    private Node<Person> head;

    public void append(Person p){
        if(head == null){
            this.head = new Node<Person>(p);
        }
        else{
            Node<Person> temp = new Node<Person>(p);
            Node<Person> last = this.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = temp;
        }
    }

    public void display(){
        if(this.head == null){
            throw new java.lang.Error("Empty List");
        }
        else {
            Node<Person> print = this.head;
            while(print != null){
                System.out.println(print.data);
                print = print.next;
            }
        }
        System.out.println("\n");
    }

    public void pop(){
        Node<Person> demilast = this.head;
        if(this.head == null){
            throw new java.lang.Error("Empty List");
        }
        else {
            while(demilast.next.next != null){
                demilast = demilast.next;
            }
            demilast.next = null;
        }
    }

    public void delete(int i){
        try {
            if (i == 0){
                this.head = head.next;
            }
            else {
                int c = 1;
                Node count = this.head;
                while (count != null){
                    if (c == i){
                        count.next = count.next.next;
                        break;
                    }
                    count = count.next;
                    c++;
                }
            }
        }
        catch(Exception  e){
            throw new java.lang.Error("Wrong Index");
        }
    }

    public void insertAtBeginning(Person p){
        Node<Person> temp = new Node<Person>(p);
        if (head == null){
            this.head = temp;
        }
        else {
            temp.next = this.head;
            temp.next.next = this.head.next;
            this.head = temp;
        }
    }

    public void clear(){
        this.head = null;
    }
}
