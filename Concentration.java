/**
 * The game of Concentration (also called Memory or Match Match)
 * 
 * Create a gameboard of tiles. Each tile contains a card that has exactly
 * one match on the board. Cards are originally show "face down" on the board.
 * 
 * Player chooses two random cards from the board. The chosen cards
 * are temporarily shown face up. If the cards match, they are removed from board.
 * 
 * Play continues, matching two cards at a time, until all cards have been matched.
 */
public class Concentration extends Board
{
    // create the game board
    public Tile[][] gameboard = makeBoard();

    /** 
     * The constructor for the game. Creates the 2-dim gameboard
     * by populating it with tiles.
     */
    public Concentration() { 

       // to do
       int count = 0;
      for(int i = 0; i < rows; i++){
          for(int j = 0; j < columns; j++){
              gameboard[i][j] = new Tile(cards[count]);
              count++;
           }
      }

    }
    /**
     * Determine if the board is full of cards that have all been matched,
     * indicating the game is over
     * 
     * Precondition: gameboard is populated with tiles
     * 
     * @return true if all pairs of cards have been matched, false otherwse
     */
    public boolean allTilesMatch() {
        
        // to do
        for(int i = 0; i < rows; i++){
          for(int j = 0; j < columns; j++){
              if(gameboard[i][j].matched()) continue;
              else return false;
           }
      }
        return true;
    }

    /**
     * Check for a match between the cards in the two tile locations.
     * For matched cards, remove from the board. For unmatched cares, them face down again.
     * 
     * Precondition: gameboard is populated with tiles,
     * row values (i values) must be in the range of 0 to gameboard.length,
     * column values (j values) must be in the range of 0 to gameboard[0].length
     * 
     * @param row1 the row value of Tile 1
     * @param column1 the column value of Tile 1
     * @param row2 the row value of Tile 2
     * @param column2 the column vlue of Tile 2
     * @return a message indicating whether or not a match occured
     */
    public String checkForMatch(int row1, int column1, int row2, int column2) {
        // to do
        if(gameboard[row1][column1].cardFace.equals(gameboard[row2][column2].cardFace)){
            gameboard[row1][column1].foundMatch();
            gameboard[row2][column2].foundMatch();
            return "yes";
        }
        else {
            gameboard[row1][column1].faceUp(false);
            gameboard[row2][column2].faceUp(false);
            return "no";
        }
    }
    public static double ave2D(int[][] a){
        double total  = 0;
        int count  = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                total += a[i][j];
                count++;
            }
        }
        return total/count;
    }
    /**
     * Set  tile to show its card in the face up state
     * 
     * Precondition: gameboard is populated with tiles,
     * row values (i values) must be in the range of 0 to gameboard.length,
     * column values (j values) must be in the range of 0 to gameboard[0].length
     * 
     * @param row the row value of Tile
     * @param column the column value of Tile
     */
    public void showFaceUp (int row, int column) {
        // to do 
        if(row < gameboard.length && column < gameboard[0].length){
            gameboard[row][column].faceUp(true);
        }
        
    }

    /**
     * Returns a string representation of the board. A tab is placed between tiles,
     * and a newline is placed at the end of a row
     * 
     * Precondition: gameboard is populated with tiles
     * 
     * @return a string represetation of the board
     */
    public void toStringPrint() {
        // to do
         for(int i = 0; i < gameboard.length; i++){
            for(int j = 0; j < gameboard[i].length; j++){
                if(gameboard[i][j].isFaceUp()){
                    System.out.print("|"+gameboard[i][j].getFace());
                }
                else{
                    System.out.print("|"+gameboard[i][j].getBack());
                }
            }
            System.out.println("|");
        }
    }

}

