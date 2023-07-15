
package minmax;

import java.io.BufferedReader;
import java.io.FileReader;

public class Read {
    private static BufferedReader in = null;
    public static int rows = 0;
    private static char [][] state = null;
    private static char move ;


    void readfile() throws Exception {
        try {
            String filepath ="m.txt";
            int lineNum = 0;
            int row=0;
            
            in = new BufferedReader(new FileReader(filepath));
           
            String line = null;
            while((line = in.readLine()) !=null) {
                lineNum++;
                
                if(lineNum==1) {
                   rows = Integer.parseInt(line);
                   state = new char[rows][rows];
                }else if(row>=rows){
                   String [] tokens = line.split("");
                   
                    for (int j=0; j<tokens.length; j++) {
                      move =tokens[j].charAt(0);
                    }
                    
                    row++;  
                }
                
                else {
                    String [] tokens = line.split("");
                    
                    for (int j=0; j<tokens.length; j++) {
                        state[row][j] =tokens[j].charAt(0);
                    }
                    row++;
                }
               

            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (in!=null) in.close();
        }
        System.out.println("*- Length: "+rows);
        System.out.println("*- Next: "+move);
        System.out.println("********************************************");

                          

    }
    
	public char[][] getInitialState() {
		return state;
	}

	public void setInitialState(char[][] matrix) {
		this.state = state;
	}
        
        public int getRow() {
		return rows;
	}

	public void setRow(int rows) {
		this.rows = rows;
	}
        
        public char getMove() {
		return move;
	}

	public void setMove(char move) {
		this.move = move;
	}
}
    
    
    
