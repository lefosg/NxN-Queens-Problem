import java.util.ArrayList;
import java.util.Scanner;
public class Qmain 
{
    public static void main(String [] arguments)
    {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter N: ");
        int N = input.nextInt();
        System.out.print("Enter K: ");
        int K = input.nextInt();
        
        if(N < 4||K < 1 ||K >= (N*N)-N)
        {
            System.out.println("Invalid parameters given!");
            input.close();
            return;
        }
        
        long start = System.currentTimeMillis();

        BoardState initialState = new BoardState(N);

        Algorithm algorithm = new Algorithm();
        
        System.out.println("Initial State, Score:" + initialState.getScore());
        initialState.printBoard();

        ArrayList<BoardState> result = algorithm.BeamSearch(initialState, N, K);

        int i=1;
        for (BoardState state:result){

            if(result.size()==i){System.out.println("SOLUTION:");}

            System.out.println("Step "+i+", Score:" + state.getScore());
            state.printBoard();

            i++;
        }
        long end = System.currentTimeMillis();

        System.out.println("Solution found in : " + (end-start) + " milliseconds");

        input.close();
    }
}