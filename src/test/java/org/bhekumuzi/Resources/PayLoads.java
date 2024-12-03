package org.bhekumuzi.Resources;

import org.bhekumuzi.Board;

public class PayLoads {

    public Board createBoardPayload(String boardName,String boardDescription) {
        Board board = new Board(boardName);
        if (!boardDescription.isEmpty()) {
            board.setDesc(boardDescription);
        }
        return board;
    }
}