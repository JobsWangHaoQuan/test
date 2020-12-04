public class SearchBall {
    private static int x[]=new int[10];
    public SearchBall(){}
    public void setBWeight(int w[]){
        for(int i=0;i<w.length;i++){
            x=w;
        }}
    public String BeginSearch(){
        if(x[0]+x[1]+x[2]+x[3]+x[4]<x[5]+x[6]+x[7]+x[8]+x[9]){
            if(x[1]+x[2]==x[3]+x[4])  {
                System.out.println("1号是假球");
                return "1号是假球";}
            if(x[1]+x[2]<x[3]+x[4]){
                if (x[1]<x[2]) {
                    System.out.println("2号是假球");
                    return "2号是假球";}
                else {
                    System.out.println("3号是假球");
                    return "3号是假球";}}
            else {if (x[3]<x[4]){
                System.out.println("4号是假球");
                return "4号是假球";}
            else{
                System.out.println("5号是假球");
                return "5号是假球";}}}
        else {if(x[6]+x[7]==x[8]+x[9])  {
            System.out.println("6号是假球");
            return "6号是假球";
        }
            if(x[6]+x[7]<x[8]+x[9])
            {if (x[6]<x[7]) {System.out.println("7号是假球");
                return "7号是假球";}
            else {
                System.out.println("8号是假球");
                return "8号是假球"; }}
            else {if (x[8]<x[9]) {
                System.out.println("9号是假球");
                return "9号是假球";}
            else  {System.out.println("10号是假球");
                return "10号是假球";} }}}
    public static void main (String args[]){
        SearchBall sb=new SearchBall();
        int a0[]={1,2,2,2,2,2,2,2,2,2};
        int a1[]={2,1,2,2,2,2,2,2,2,2};
        int a2[]={2,2,1,2,2,2,2,2,2,2};
        int a3[]={2,2,2,1,2,2,2,2,2,2};
        int a4[]={2,2,2,2,1,2,2,2,2,2};
        int a5[]={2,2,2,2,2,1,2,2,2,2};
        int a6[]={2,2,2,2,2,2,1,2,2,2};
        int a7[]={2,2,2,2,2,2,2,1,2,2};
        int a8[]={2,2,2,2,2,2,2,2,1,2};
        int a9[]={2,2,2,2,2,2,2,2,2,1};
        sb.setBWeight(a0);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a1);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a2);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a3);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a4);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a5);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a6);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a7);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a8);
        System.out.println(sb.BeginSearch());
        sb.setBWeight(a9);
        System.out.println(sb.BeginSearch());
    }

}
