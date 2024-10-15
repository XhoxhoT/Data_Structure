package Complexity;

// Mbaj mend qe konstantet bien dhe nuk llogariten ne kompleksitet.
// Cheat sheet per kompleksitettet> https://www.bigocheatsheet.com/

public class fuqi2 {


    public static void onefuqite2(int n){

        for (int i=0;i<n;i++){

            for (int j=0;j<n;j++){
                System.out.println(i+" "+j);
            }
        }
//DROP NON DOMINANTS
//        Nuk ehste dominante kodi me poshte e rrit kompleksitetin me O(n) por me rritjen e n kompleksiteti total
//        O(n^2 + n) me rrijten e n n^2 behet aq e madhe sa ajo n ne fuqi te pare bahet pa ndikim
        for (int k=0;k<n;k++){
            System.out.println(k);
        }

    }

//    O(1) = vetem nje operacion do bahet ska rendsi sa shkon n/ja

    public static int addItems(int n){
        return  n+n+n;
    }

//    O(log n), kemi nje array te renditun me 8 elemente.
//    Per sa operacione e gjejme nje nr ne array?
//    e ndajme arrayn gjithmon per gjys dhe krahasojme nr tone me fillimin e gjysave ne varesi te krahasimit
//    ose shkojjm tek gjysma e pare ose tek e dyta
//    pra 2 ne fuqi te sate jep 8 (size i arrays) kjo gjehet me log2 i 8 qe jep 3.


    public static void main(String[] args){

        onefuqite2(9);


    }

}
