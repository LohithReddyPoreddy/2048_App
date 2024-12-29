package com.application._8.model;


import lombok.Data;

import java.util.Random;

@Data
public class GameBoard {

    private final int size = 4;




    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void setTile(int row, int col, int value){
        board[row][col] = value;
    }

    public int getTile(int row, int col){
        return board[row][col];
    }

    private int[][] board;
    private Random random;

    public GameBoard(){
        this.board = new int[size][size];
        this.random = new Random();
        initializeBoard();
    }

    private void initializeBoard() {
        addRandomTile();
        addRandomTile();
    }

    private void addRandomTile() {
        int value = random.nextInt(10) < 9?2:4; // 90% chance for the value to be 2 and 10% for 4
        int emptyCells = countEmptyCells();

        if(emptyCells > 0){
            int position = random.nextInt(emptyCells);
            int count = 0;

            for(int i = 0 ;i<size ; i++){
                for(int j = 0 ; j< size; j++){
                    if(board[i][j] == 0){
                        if(count == position){
                            board[i][j] = value;
                            return;
                        }
                        count++;
                    }
                }
            }
        }
    }

    private int countEmptyCells() {
        int count = 0;
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(board[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public void  getBoardAfterAddingTile(){
        addRandomTile();
    }
}
