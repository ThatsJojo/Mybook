package util;
public class Queue implements IQueue{
    
    private Node head;

    private class Node{
        private Object data;
        private Node proximo;
        
        public Node(Object data){
            this.data=data;
            this.proximo=null;
        }
        
        public Object getData(){
            return this.data;
        }
        
        public void setData(Object data){
            this.data=data;
        }

        public Node getProximo() {
            return proximo;
        }

        public void setProximo(Node proximo) {
            this.proximo = proximo;
        }
        
        
    }

    @Override
    public void push(Object data) {
        Node temp = new Node(data);
        temp.setProximo(head);
        head=temp;
    }

    @Override
    public Object pop() {
        Object temp = head.getData();
        head=head.getProximo();
        return temp;
    }

    @Override
    public Object peek() {
        return head==null?null: head.getData();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
}
