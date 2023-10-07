public class MyLinkedList<E> {
    private int size;
    public class Node{
        private E data;
        private Node next;
        private Node last;
        public Node()
        {
            this.data=null;
            this.next=null;
            this.last=null;
        }
        public Node(E data)
        {
            this.data=data;
            this.next=null;
            this.last=null;
        }
        public Node(E data,Node next,Node last)
        {
            this.data=data;
            this.next=next;
            this.last=last;
        }
        public E data()
        {
            return this.data;
        }
        public Node next()
        {
            return this.next;
        }
        public Node last()
        {
            return this.last;
        }
        @Override
        public String toString()
        {
            return "data="+data.toString();
        }
    }
    private Node front;
    private Node back;
    public MyLinkedList()
    {
        this.size=0;
        this.front=new Node();
        this.back=new Node();
    }
    public int size()
    {
        return this.size;
    }
    public Node front()
    {
        return this.front;
    }
    public Node back()
    {
        return this.back;
    }
    public void add(E data,int index) throws IllegalArgumentException
    {
        if(index<0||index>this.size())
            throw new IllegalArgumentException();
        Node node=new Node(data);
        if(this.size()==0)
        {
            this.front.next=node;
            this.back.last=node;
            this.size++;
            return;
        }
        if(index<this.size()/2)
        {
        Node p=this.front();
        for(int i=0;i<index;i++)
            p=p.next();
        node.last=p;
        node.next=p.next();
        p.next.last=node;
        p.next=node;
        }
        else
        {
            Node p=this.back();
            for(int i=this.size();i>index;i--)
                p=p.last();
            node.next=p;
            node.last=p.last();
            p.last.next=node;
            p.last=node;
        }
        this.size++;
    }


    public void add(E data)
    {
        Node node=new Node(data);
        if(this.size()==0)
        {
            this.front.next=node;
            this.back.last=node;
            this.size++;
            return;
        }
        this.back().last.next=node;
        node.last=this.back.last;
        node.next=this.back();
        this.back().last=node;
        this.size++;
    }


    public void delete(int index)
    {
        if(index<0||index>this.size()-1)
            throw new IllegalArgumentException();
        if(index<this.size()/2)
        {
            Node p=this.front();
            for(int i=0;i<index;i++)
                p=p.next();
            p.next=p.next.next;
            p.next.last=p;
        }
        else
        {
            Node p=this.back();
            for(int i=size;i>index+1;i--)
                p=p.last();
            p.last=p.last.last;
            p.last.next=p;
        }
        this.size--;
    }


    public Node query(int index)
    {
        if(index<0||index>this.size()-1)
            throw new IllegalArgumentException();
        if(index<this.size()/2)
        {
            Node p=this.front();
            for(int i=0;i<index;i++)
                p=p.next();
            return p.next();
        }
        else
        {
            Node p=this.back();
            for(int i=size;i>index+1;i--)
                p=p.last();
            return p.last();
        }
    }


    public  Node findLoop()
    {
        Node slowPtr=this.front().next();
        Node fastPtr=this.front().next().next();
        while(slowPtr!=null&&fastPtr!=null&&slowPtr!=fastPtr)
        {
            slowPtr=slowPtr.next();
            fastPtr=fastPtr.next().next();
        }
        if(slowPtr==null||fastPtr==null)
            return null;
        slowPtr=this.front();
        while(slowPtr!=fastPtr)
        {
            slowPtr=slowPtr.next();
            fastPtr=fastPtr.next();
        }
        return slowPtr;
    }


    //测试使用,不过感觉似乎有尾指针的话，尾指针的next指针指向的就是环的起点，不过这题就当作是单向链表处理。
    public void getLoop(int index)
    {
        Node p=this.front();
        for(int i=0;i<=index;i++)
            p=p.next();
        this.back.next=p;
    }


    public void deleteLoop()
    {
        Node p=this.findLoop();
        if(p==null)
            return;
        Node ptr=p;
        while(ptr.next()!=p)
            ptr=ptr.next();
        ptr.next=null;
    }


    public void deleteLoop(Node p)
    {

    }


    @Override
    public String toString()
    {
         String ret="";
         Node p=this.front().next;
         for(int i=0;i<this.size()-1;i++)
         {
             ret=ret+p.toString()+",";
             p=p.next;
         }
         ret=ret+p.toString();
         return ret;
    }
}
