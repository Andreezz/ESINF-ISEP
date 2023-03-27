public class complexity {

    public boolean mystery2 (int[] A, int value)
    {
        boolean flag=false;
        for (int i = 0; i < (A.length-1); i++)
            for (int j = i+1; j < A.length; j++)
                if (A[i]+A[j] == value) {
                    flag = true;
                    System.out.println("pos "+ i +"->"+A[i]+", pos "+j+"->"+A[j]);
                }
        return flag;
    }
    public boolean optimizedmystery2(int[] A, int value){
        int i =0;
        int j = A.length;
        boolean flag = false;
        if(A[0]+A[1] > value || A[j-2]+A[j-1] < value){
            return false;
        }while (i<j){
            if(A[i]+A[j]==value){
                flag=true;
                System.out.println("pos "+ i +"->"+A[i]+", pos "+j+"->"+A[j]);
                i++;
                j--;
            }else if(A[i]+A[j]<value){
                i++;
            }else
                j--;

        }
        return flag;
    }
}
/* Ex1:
Pos 1->13 pos 4->22
Pos 2->17 pos 3->18
 */

//
