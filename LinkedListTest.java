import com.sun.security.jgss.GSSUtil;

public class LinkedListTest {
    int grade;
    String name;

    public LinkedListTest(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkedListTest{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
          MyLinkedList<LinkedListTest>t=new MyLinkedList<LinkedListTest>();
          LinkedListTest test1=new LinkedListTest(1,"frog");
          LinkedListTest test2=new LinkedListTest(2,"cat");
          LinkedListTest test3=new LinkedListTest(3,"dog");
          LinkedListTest test4=new LinkedListTest(4,"tiger");
          t.add(test1);
          t.add(test2,1);
          t.add(test3,2);
          t.add(test4,0);
          System.out.println(t.toString());
          t.delete(3);
          System.out.println(t.toString());
          System.out.println(t.query(2).toString());
          t.add(test3);
          System.out.println(t);
          if(t.findLoop()!=null)
             System.out.println(t.findLoop());
          else
              System.out.println("null");
          t.getLoop(3);
          if(t.findLoop()!=null)
              System.out.println(t.findLoop());
          else
              System.out.println("null");
          t.deleteLoop();
          if(t.findLoop()!=null)
              System.out.println(t.findLoop());
          else
              System.out.println("null");
    }
}
