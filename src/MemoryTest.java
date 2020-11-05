
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MemoryTest {

    private static void  showfree_link(LinkedList list){//显示空闲区函数
        System.out.println("空闲表如下：");
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Emp obj = (Emp) iterator.next();
            System.out.println("起始地址："+obj.addr+"  空闲区长度："+obj.size);

        }

    }
    private static	void allocms(LinkedList list, ArrayList jobtab)//分配函数
    {
        int no,size;
        Work work = null;
        System.out.println("请输入申请资源作业信息：");
        System.out.println("作业编号：");
        Scanner sc = new Scanner(System.in);
        no=sc.nextInt();
        System.out.println("作业长度：");
        Scanner sc1 = new Scanner(System.in);
        size=sc1.nextInt();
        for (Iterator iterator = jobtab.iterator(); iterator.hasNext();) {
            Work work1 = (Work) iterator.next();
            if(work1.no==no){
                System.out.println("该编号的作业已经存在！！！");
                break;
            }
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Emp emp = (Emp) iterator.next();
            if(emp.size>=size){
                work=new Work(no,size);
                work.addr=emp.addr;
                emp.addr+=size;
                emp.size-=size;
                System.out.println("已经分配完毕！！！");
                jobtab.add(work);
                if(work.size==0){
                    list.remove(work);
                }
                break;
            }

        }

    }

    private static void  freem(LinkedList list, ArrayList worktab){//回收函数
        int j;
        int listsize=list.size();
        int k=0,key=0;
        System.out.println("请输入回收的作业编号：");
        Scanner sc1 = new Scanner(System.in);
        j=sc1.nextInt();
        for (int i = 0; i < worktab.size(); i++) {
//			System.out.println(jobtab.size());
            Work work=(Work) worktab.get(i);
            if(work.no==j){
                key++;
                for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                    Emp obj = (Emp) iterator.next();
                    if((obj.addr+obj.size)==work.addr){//空闲区在上邻
                        k++;
                        obj.size=obj.size+work.size;
                        worktab.remove(i);
                        System.out.println("回收成功！！");
                        break;
                    }else if((work.addr+work.size)==obj.addr){//空闲区在下邻
                        k++;
                        obj.addr=work.addr;
                        obj.size+=work.size;
                        worktab.remove(i);
                        System.out.println("回收成功！！");
                        break;
                    }else{
                        continue;
                    }

                }
                if(k==0){
                    list.add(new Emp(work.addr,work.size));
                    paixu(list);
                    worktab.remove(i);
                    break;
                }
            }else{
                continue;
            }
        }
        if(key==0){
            System.out.println("没有该作业！！");
        }

    }

    private static void  showtab(ArrayList jobtab){
        for (Iterator iterator = jobtab.iterator(); iterator.hasNext();) {
            Work job = (Work) iterator.next();
            System.out.println("作业编号："+job.no+"   作业起始地址："+job.addr+"   作业长度"+job.size);
        }

    }
    private static void paixu(LinkedList list){//排序函数，将空闲分区从小到大排序

        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size()-1; j >i; j--) {
                Emp k1=(Emp)list.get(j-1);
                Emp k2=(Emp)list.get(j);
                if(k2.size<k1.size){//交换记录
                    list.set(j, k1);
                    list.set(j-1, k2);
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub\
        int i,j,all;
        System.out.println("请输入空闲区总长度：");
        Scanner s = new Scanner(System.in);
        all=s.nextInt();
        boolean istrue=true;
        Emp em=new Emp(0,all);
        LinkedList free_list=new LinkedList();
        free_list.add(em);
        ArrayList joblist= new ArrayList();
        LinkedList used_list=new LinkedList();
        showfree_link(free_list);
        System.out.println("请输入申请资源作业信息：");
        allocms(free_list,joblist);
        while(istrue){
            System.out.println("     请输入演示功能项:     ");
            System.out.println("=================================");
            System.out.println("     0.显示空闲表                      ");
            System.out.println("     1.显示作业表                      ");
            System.out.println("     2.回收                      ");
            System.out.println("     3.分配                      ");
            System.out.println("  请输入(0－4):");
            Scanner sc1 = new Scanner(System.in);
            j=sc1.nextInt();
            switch(j){
                case 0: showfree_link(free_list); break;
                case 1: showtab(joblist);break;
                case 2: freem(free_list,joblist);break;
                case 3: allocms(free_list,joblist);break;
                default : System.err.println("输入有误请重新输入！！");
            }
        }
    }

}
class Emp<linkk> {
    public int size;
    public int  addr;
    public  linkk  next;
    Emp(int addr,int  size){
        this.addr=addr;
        this.size=size;
    }
}
class Work{
    public int no;
    public int size;
    public int addr;//内存地址
    Work(int no,int size){
        this.no=no;
        this.size=size;
    }

}