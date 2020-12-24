package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	public Board(int rows, int columns) {
		if(rows<1 || columns <1) {
			throw new BoardException("O tabuleiro deve ter pelo menos uma linha e uma coluna!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public Piece piece(int row,int column) {
		if(!positionExists(row,column)) {
			throw new BoardException("Posição fora da borda!");
		}
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição fora da borda!");
		}
		return pieces [position.getRow()][position.getColumn()];
	}
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Esta posição já está ocupada! "+ position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
		
	}
	private boolean positionExists(int row, int column) {
		return row>=0 && row< this.rows && column >= 0 && column < this.columns;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColumn());
	}
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição fora da borda!");
		}
		return piece(position) != null;
	}
	
}
