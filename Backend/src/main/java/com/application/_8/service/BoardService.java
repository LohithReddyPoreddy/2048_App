package com.application._8.service;


import com.application._8.model.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class BoardService {


    private GameBoard board;






    public GameBoard newBoard(){
        board = new GameBoard();
       return board;
    }

    public int[] merge(int[] arr){
        int i = 0;
        for(int j = 1 ; j < arr.length; j++){
            if(arr[i]!=0){
                if(arr[i] == arr[j]){
                    arr[i]*=2;
                    arr[j]=0;
                    i++;
                }
                else if(arr[j]!=0){
                    i = j;
                }
            }
            else{
                i= j;
            }

        }
        arr = compress(arr);
        return arr;
    }

    public int[] compress(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                if (i != j) {
                    arr[i] = arr[j];
                    arr[j] = 0;
                }
                i++;
            }
        }

        return arr;
    }

    public int[][] moveUp(){
        boolean isTileMoved = false;
        int[] temp;
        for(int j = 0 ; j < 4 ; j++){
            temp = new int[4];
            for(int i = 0; i < 4 ; i++){
                temp[i] = board.getBoard()[i][j];
            }
            temp = merge(temp);
            for(int i = 0 ; i < 4 ; i++){
                if(board.getBoard()[i][j] != temp[i]){
                    isTileMoved = true;
                    board.getBoard()[i][j] = temp[i];
                }
            }
        }
        if(isTileMoved) useAddRandomTitle();

        return board.getBoard();
    }

    public int[][] moveDown(){
        boolean isTileMoved = false;
        int[] temp;
        for(int j = 0 ; j < 4   ; j++){
            temp = new int[4];
            int value = 0;
            for(int i = 3; i >= 0 ; i--){
                temp[value++] = board.getBoard()[i][j];
            }
            temp = merge(temp);
            System.out.println(Arrays.toString(temp));
            value = 0;
            for(int i = 3 ; i >= 0 ; i--){
                if(board.getBoard()[i][j] != temp[value]){
                    isTileMoved = true;
                    board.getBoard()[i][j] = temp[value];
                }
                value++;
            }
        }
        if(isTileMoved) useAddRandomTitle();

        return board.getBoard();
    }

    public int[][] moveLeft(){
        boolean isTileMoved = false;
        int[] temp;
        for(int i = 0 ; i < 4 ; i++){
            temp = new int[4];
            for(int j = 0; j < 4 ; j++){
                temp[j] = board.getBoard()[i][j];
            }
            temp = merge(temp);
            for(int j = 0 ; j < 4 ; j++){
                if(board.getBoard()[i][j] != temp[j]){
                    isTileMoved = true;
                }
                board.getBoard()[i][j] = temp[j];
            }
        }
        if(isTileMoved) useAddRandomTitle();
        return board.getBoard();
    }

    public int[][] moveRight(){
        boolean isTileMoved = false;
        int[] temp;
        for(int i = 0 ; i < 4   ; i++){
            temp = new int[4];
            int value = 0;
            for(int j = 3; j >= 0 ; j--){
                temp[value++] = board.getBoard()[i][j];
            }
            temp = merge(temp);
            System.out.println(Arrays.toString(temp));
            value = 0;
            for(int j = 3 ; j >= 0 ; j--){
                if(board.getBoard()[i][j] != temp[value]){
                    isTileMoved = true;
                    board.getBoard()[i][j] = temp[value];
                }
                value++;
            }
        }
        if(isTileMoved) useAddRandomTitle();

        return board.getBoard();
    }

    public void useAddRandomTitle(){
        board.getBoardAfterAddingTile();
    }




}
