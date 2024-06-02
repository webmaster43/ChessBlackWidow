/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import engine.board.Board;
import gui.Table;

/**
 *
 * @author Tutor 101
 */
public class Chess {

      
     public static void main(String[] args) {
        
        
        Board gameBoard = Board.createStandardBoard();

        System.out.println(gameBoard);
        
        //Table table = new Table();
        Table.get().show();
    }

}

