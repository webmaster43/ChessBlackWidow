/*sx
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.player;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import engine.Alliance;
import engine.board.Board;
import engine.board.Move;
import engine.board.MoveStatus;
import engine.board.MoveTransition;
import engine.board.MoveUtils;
import engine.pieces.King;
import engine.pieces.Piece;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Tutor
 */
public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;
    final boolean isInCheck;
    
    
    Player(final Board board,
            final Collection<Move> legalMoves,
            final Collection<Move> opponentMoves) {

        this.board = board;
        this.playerKing = establishKing();
        this.legalMoves = ImmutableList.copyOf(Iterables.concat(legalMoves, calculateKingCastles(legalMoves, opponentMoves)));
        this.isInCheck = !Player.calculateAttacksOnTile(this.playerKing.getPiecePosition(), opponentMoves).isEmpty();
    }
    public King getPlayerKing(){
        return this.playerKing;
    }
    public Board getToBoard(){
        return board;
    }
    public Collection<Move> getLegalMoves(){
        return this.legalMoves;
    }
    protected static Collection<Move> calculateAttacksOnTile(int piecePosition, Collection<Move> moves) {
        final List<Move> attackMoves = new ArrayList<>();
        for(final Move move : moves){
            if(piecePosition == move.getDestinationCoordinate()) {
              attackMoves.add(move);   
            }
        }
        return ImmutableList.copyOf(attackMoves);
    }
    private King establishKing() {
        for (final Piece piece : getActivePieces()) {
            if (piece.getPieceType().isKing()) {
                return (King) piece;    
                
            }
        }
        throw new RuntimeException("Should not reach here! Not a valid board!!");
    }
    
    public boolean isMoveLegal(final Move move){
        return this.legalMoves.contains(move);
    }
    public boolean isInCheck(){
        return this.isInCheck;
    }
    public boolean isInCheckMate(){
        return this.isInCheck && !hasEscapeMoves();
    }
    public boolean isInStaleMate(){
        return !this.isInCheck() && !hasEscapeMoves();
    }
    
    protected boolean hasEscapeMoves(){
     for(final Move move : this.legalMoves){
         final MoveTransition transition = makeMove(move);
         if(transition.getMoveStatus().isDone()){
             return true;
         }
     }   
     return false;
    }
 
    public boolean isCastled(){
        return false;
    }

    public MoveTransition makeMove(final Move move){
        if(!isMoveLegal(move)){
            return new MoveTransition(this.board, this.board, move, MoveStatus.ILLEGAL_MOVE);
        }
        final Board transitionBoard = move.execute();
        final Collection<Move> kingAttacks = Player.calculateAttacksOnTile(transitionBoard.currentPlayer().getOpponent().getPlayerKing().getPiecePosition(),
              transitionBoard.currentPlayer().getLegalMoves());
        if(!kingAttacks.isEmpty()){
            return new MoveTransition(this.board, this.board, move, MoveStatus.LEAVES_PLAYER_IN_CHECK);
        }
        
        return new MoveTransition(this.board, transitionBoard, move, MoveStatus.DONE);
    }
    public abstract Collection<Piece> getActivePieces();
    public abstract Alliance getAlliance();
    public abstract Player getOpponent();
    protected abstract Collection<Move> calculateKingCastles(Collection<Move> playerLegals, Collection<Move> opponentsLegals);

    public Board unMakeMove(Move lastMove) {
            return getToBoard();
    }

//    public boolean isKingSideCastleCapable() {
//        throw new UnsupportedOperationException("Not supported yet. King Side Castle"); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public boolean isQueenSideCastleCapable() {
//        throw new UnsupportedOperationException("Not supported yet. Queen Side "); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void setMoveStrategy(StockAlphaBeta strategy) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
