import java.util.Random;
import java.util.Scanner;

class GuessNumberGame{
   //This is main method for comparison of given number by user and choose number by computer.
    public void guess(int a,int b,int c){
        if(c==1 && a!=b){
            System.out.println("Your guess is wrong.");
            System.out.println("Attempt number 1 is  fail, 2 attempts remain.");
            System.out.print("The hint is: the number present in group ");
            System.out.println(hint1(a));
        }
        else if(c>1 && c<3 && a!=b){
            System.out.println("Your guess is wrong.");
            System.out.println("Attempt number 2 is  fail, 1 attempts remain.");
            System.out.print("The hint is: The number present in ");
            hint2(a);
        }
        else if(c==3 && a!=b){
            System.out.println("You lose");
            System.out.println("The number computer choose is: "+a);
            System.out.println("Reason of lose -->Your all attempts are end.");

        }
        else{
            System.out.println("Your guess is correct and the number is choose by computer is: "+a);
        }
    }

    // instruction method gives all instruction about the guess game.
    public void instruction(){
        System.out.println("Each player get 3 attempt to guess number.");
        System.out.println("If hint is group A then the number computer choose is between 1 to 5");
        System.out.println("If hint is group B then the number computer choose is between 6 to 10");
        System.out.println("If hint is group C then the number computer choose is between 11 to 15");
        System.out.println("If hint is group D then the number computer choose is between 16 to 20");
    }

    //hint1 method gave a first hint about the number which is computer choose.
    public char hint1(int a){
        char group;
        if(a<=5){
            return group='A';
        }
        else if (a>5 && a<=10) {
           return group='B';
        }
        else if(a>10 && a<=15){
           return group='c';
        }
        else{
            return group='D';
        }
    }


    // hint2 method gave a second hint about a number that choose by computer.
    public void hint2(int a){
        if(avg(a)<a){
            System.out.println("The number computer choose is grater than the "+avg(a));
        }
        else if (avg(a)>a){
            System.out.println("The number computer choose is smaller than the "+avg(a));
        }
        else{
            System.out.println("The number computer choose is avg of that group.");
        }

    }

   // avg method gave avg of every group.
    public int avg(int a){
        int sum=0;
        switch (hint1(a)){
            case 'A':
                int[]x={1,2,3,4,5};
                for(int y:x){
                    sum+=y;
                }
                break;
            case 'B':
                int[]z={6,7,8,9,10};
                for(int y:z){
                    sum+=y;
                }
                break;
            case 'C':
                int[]w={11,12,13,14,15};
                for(int y:w){
                    sum+=y;
                }
                break;
            case 'D':
                int[]q={16,17,18,19,20};
                for(int y:q){
                    sum+=y;
                }
                break;
        }
        return (sum/5);
    }
}
public class Task1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("The numbers of player which is participate in this game.");
        int players =sc.nextInt();
        Random ra= new Random();
        GuessNumberGame obj = new GuessNumberGame();
        System.out.println("The limit for choose the number is 1 to 20 and instruction are given below.");
        obj.instruction();
        for(int i=1;i<=players;i++){
            System.out.println("the player"+i+" is playing.");
            int computernum=ra.nextInt(1,20);
            for(int j=1;j<=3;j++){
                System.out.println("Enter your number.");
                int playernum=sc.nextInt();
                obj.guess(computernum,playernum,j);
                if(playernum==computernum){
                    break;
                }
            }
        }
    }
}
