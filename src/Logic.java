import java.util.ArrayList;
import java.util.Scanner;

public class Logic {


    public static void main(String[] args) {
        char[] positionList = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Integer count = 0;
        boolean turn = true;
        boolean endGame = false;
        ArrayList<Integer> xMoves = new ArrayList();
        ArrayList<Integer> oMoves = new ArrayList();
        ArrayList<Integer> currentArray;
        while (!endGame) {
            char player;
            if (turn) {
                player = 'X';
                currentArray = xMoves;
            } else {
                player = '0';
                currentArray = oMoves;
            }
            count++;
            printTable(positionList);
                System.out.println("Ходит игрок " + player);
            Scanner in = new Scanner(System.in);
            System.out.print("Введите позицию: ");
            Integer position = Integer.valueOf(in.nextLine());

            while (position > 9 || position < 1) {                // не стал парится с проверкой, ибо проверки на другие символы кроме чисел нет, наверно лучше эксепшены отрабатывать. Проверь остальное плз
                Scanner poz = new Scanner(System.in);
                System.out.println("Ошибка ввода. Введите позицию от 1 до 9");
                position = Integer.valueOf(in.nextLine());
            }
                positionList[position - 1] = player;
                currentArray.add(position);

            if (count > 4) {
                endGame = checkWinner(currentArray, player);
                }
            if (turn){
                turn = false;
            }
            else {
                turn = true;
            }
            }
        }



    public static boolean checkWinner(ArrayList<Integer> playerMovesList, char player) {
        for (int i : playerMovesList) {
            switch (i) {
                case 1:
                    if (playerMovesList.contains(4) && playerMovesList.contains(7)) {
                        System.out.println("Победил игрок " + player);
                        return true;
                    } else if (playerMovesList.contains(5) && playerMovesList.contains(9)) {
                        System.out.println("Победил игрок " + player);
                        return true;
                    } else if (playerMovesList.contains(2) && playerMovesList.contains(3)) {
                        System.out.println("Победил игрок " + player);
                        return true;
                    }
                case 2:
                    if (playerMovesList.contains(5) && playerMovesList.contains(8)) {
                        System.out.println("Победил игрок " + player);
                        return true;
                    }
                case 3:
                    if (playerMovesList.contains(5) && playerMovesList.contains(7)) {
                        System.out.println("Победил игрок " + player);
                        return true;
                    } else if (playerMovesList.contains(6) && playerMovesList.contains(9)) {
                        System.out.println("Победил игрок " + player);
                        return true;
                    }
                case 4:
                    if (playerMovesList.contains(5) && playerMovesList.contains(6)) {
                        System.out.println("Победил игрок " + player);
                        return true;
                    }
                case 7:
                    if (playerMovesList.contains(8) && playerMovesList.contains(9)) {
                        System.out.println("Победил игрок " + player);
                        return true;
                    }
            }
        }
        return false;
    }

    public static void printTable(char[] positionList) {
        System.out.println(("_" + positionList[0] + "_" + "|" + "_" + positionList[1] + "_" + "|" + "_" + positionList[2] + "_" + "\n" +
                "_" + positionList[3] + "_" + "|" + "_" + positionList[4] + "_" + "|" + "_" + positionList[5] + "_" + "\n" +
                "_" + positionList[6] + "_" + "|" + "_" + positionList[7] + "_" + "|" + "_" + positionList[8] + "_"));
    }
}
