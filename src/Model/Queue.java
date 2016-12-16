package Model;

/**
 * Created by 204g13 on 31.10.2016.
 */
public class Queue<ContentType> {
    private QueueNode head;
    private QueueNode tail;
    //___________________________________________
    private class QueueNode{
        private ContentType content= null;
        private QueueNode next = null;
        public QueueNode(ContentType content){
            this.content =content;
        }

        public void setNext(QueueNode next){
            this.next = next;
        }
        public QueueNode getNext(){
            return next;
        }
        public ContentType getContent(){
            return content;
        }
    }
    //____________________________________________________
    public Queue(){
        head = null;
        tail= null;
    }

    public boolean isEmpty(){
        if(head != null){
            return true;
        }
        return false;
    }

    public void enqueue(ContentType object){
        QueueNode node = new QueueNode(object);
        if(head==null){
            head = node;
            tail = node;
        }else {
            tail.setNext(node);
            tail = tail.getNext();
        }
    }

    public void dequeue(){
        if(head != null) {
            head = head.getNext();
        }
    }

    public ContentType front(){
        return head.getContent();
    }


}
