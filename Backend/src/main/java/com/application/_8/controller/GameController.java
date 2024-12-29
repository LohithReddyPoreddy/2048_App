package com.application._8.controller;


import com.application._8.model.GameBoard;
import com.application._8.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = {"http://localhost:5173"}, allowCredentials = "true")
public class GameController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public ResponseEntity<int[][]> startNewGame(){
        GameBoard board = boardService.newBoard();
        return ResponseEntity.ok(board.getBoard());
    }

    @PostMapping("moveUp")
    public ResponseEntity<int[][]> moveUp(){
         return ResponseEntity.ok(boardService.moveUp());
    }

    @PostMapping("moveDown")
    public ResponseEntity<int[][]> moveDown(){
        return ResponseEntity.ok(boardService.moveDown());
    }
    @PostMapping("moveLeft")
    public ResponseEntity<int[][]> moveLeft(){
        return ResponseEntity.ok(boardService.moveLeft());
    }

    @PostMapping("moveRight")
    public ResponseEntity<int[][]> moveRight(){
        return ResponseEntity.ok(boardService.moveRight());
    }




}
