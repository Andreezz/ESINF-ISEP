package Exame2019N;

public class Ex2 {
    // Este metodo retorna o valor maior da diferenca entre os membros do array, sendo este neste caso 8
    // Este metodo tem de complexidade temporal O(n2). O primeiro loop for itera n-1 vezes e o interior n vezes, tendo entao como resultado n2 de complexidade temoporal.
    public static void main(String[] args) {
        int[] a= {3,1,4,1,5,9,2};
        System.out.println(mistery(a));
    }
    public	static	int	mistery(int[]	a){

        int	max	=	a[1]-a[0];
        for	(int	j	=	2;	j	<	a.length;	j++)
            for	(int	i	=	0;	i	<	j;	i++)
                if	(a[j]	- a[i]	>	max)
                    max	=	a[j]-a[i];
        return	max;
    }
}
