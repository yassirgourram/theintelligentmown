package mown;

import java.util.Scanner;
import java.util.Vector;

public class TheMown {
	
	private static char [] Directions = {'N','W','S','E'};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int currentX;
		int currentY;
		int nextX;
		int nextY;
		char currentDirection;
		char nextDirection='N';
		int Nd;
		int Md;
		
		int [] N = {0,1}; 
		int [] W = {-1,0};
		int [] E = {1,0};
		int [] S = {0,-1};
		
		
		
        Scanner input = new Scanner(System.in);
        String gridDimenssion = input.nextLine();
        String startPosition = input.nextLine();
        String instruction = input.nextLine();
        
        String [] arrayDimenssion = gridDimenssion.split(" ");
        String [] arrayPosition = startPosition.split(" ");
        
        Nd = Integer.parseInt(arrayDimenssion[0]) ;
        Md = Integer.parseInt(arrayDimenssion[1]) ;

        currentX = Integer.parseInt(arrayPosition[0]) ;
        currentY = Integer.parseInt(arrayPosition[1]) ;
        nextX=currentX;
        nextY=currentY;
        currentDirection =  arrayPosition[2].charAt(0) ;
       
        for (char inst : instruction.toCharArray()) {
        	
			switch (inst) {
			
			case 'L':
				nextDirection =getNextDirection(currentDirection,'L');
				currentDirection=nextDirection;
				break;
			case 'R':
				nextDirection =getNextDirection(currentDirection,'R');
				currentDirection=nextDirection;
				break;
			case 'F':
				switch (currentDirection) {
				case 'N':
					nextX=nextX+N[0];
					nextY=nextY+N[1];
					break;
				case 'E':
					nextX=nextX+E[0];
					nextY=nextY+E[1];
					break;
				case 'W':
					nextX=nextX+W[0];
					nextY=nextY+W[1];
					break;
				case 'S':
					nextX=nextX+S[0];
					nextY=nextY+S[1];
					break;
				}
				// check bondary
				if (nextX>-1 && nextX<= Nd && nextX>-1 && nextY<= Md) {
					currentX=nextX;
					currentY=nextY;
				}else {
					nextX=currentX;
					nextY=currentY;
				}
				break;
			}

		} 
        System.out.println(currentX+" "+currentY+" "+currentDirection);
	}
	
	private static char getNextDirection(char cur,char dir) {
		int position=-1;
		 for (int i=0; i< Directions.length; i++) {
			 if (Directions[i]== cur) { 
				 position =i;
			 break;
			 }
		 }
		 if (position == Directions.length-1 && dir=='L') 
			 position =0;
		 else {
			 if (position >= 0 && position < Directions.length-1 && dir=='L') 
				 position =position+1;
		 }
		 if (position == 0 && dir=='R') 
			 position =Directions.length-1;
		 else {
		 if (position >  0 && position < Directions.length && dir=='R') 
			 position =position-1;
		 }
		return Directions[position];
	}
}
