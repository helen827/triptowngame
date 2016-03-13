import java.util.Random;

public class CatRun {
	public static final int ROCK = 9;
	private static final int UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4;
	public static int nextX, nextY;
	public static Random random = new Random();
	
	/**
	 * The method checks if a cat can run 
	 * And run to a random position if it can
	 * @param x - the x position of the point
	 * @param y - the y position of the point
	 */
	public static void catRun(int x, int y) {
		// Check the boundary first
		// Since there are only six elements in each line
		// first consider those not in the boundary
		// The following check the boundary with the use of "x=5 & y=0"
		if (x >= 1 && x <= 4 
				&& y >= 1 && y <= 4) {
			
			if (TritownActual.board[x - 1][y] > 0 && 
					TritownActual.board[x][y + 1] > 0 && 
					TritownActual.board[x + 1][y] > 0 && 
					TritownActual.board[x][y - 1] > 0) {
				TritownActual.board[x][y] = ROCK;
			}
			else {
				//random.nextInt(max - min + 1) + min, inclusive
				int direction = random.nextInt(4 - 1 + 1) + 1;
					
				while (true) {
					if (direction == UP && 
							TritownActual.board[x - 1][y] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x - 1;
						nextY = y;
						break;
					}
					else if (direction == RIGHT && 
							TritownActual.board[x][y + 1] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x;
						nextY = y + 1;
						break;
					}
					else if (direction == DOWN && 
							TritownActual.board[x + 1][y] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x + 1;
						nextY = y;
						break;
					}
					else if (direction == LEFT && 
							TritownActual.board[x][y - 1] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x;
						nextY = y - 1;
						break;
					}
						
					//Generate another direction
					if (direction != LEFT) {
						direction++;
					}
					else {
						direction = UP;
					}
				}
			}
		}
			
			
			
		else if ((x == 0 && y == 1) || (x == 1 && y == 0)) {
			if (TritownActual.board[x][y + 1] > 0 && 
					TritownActual.board[x + 1][y] > 0) {
				TritownActual.board[x][y] = ROCK;
			}
			else {
				int direction2 = random.nextInt(3 - 2 + 1) + 2;
					
				while (true) {
					if (direction2 == RIGHT && 
							TritownActual.board[x][y + 1] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x;
						nextY = y + 1;
						break;
					}
					else if (direction2 == DOWN && 
							TritownActual.board[x + 1][y] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x + 1;
						nextY = y;
						break;
					}
						
					if (direction2 == RIGHT) {
						direction2 = DOWN;
					}
					else {
						direction2 = RIGHT;
					}
				}
			}
		}
			
			
			
		else if (x == 0 && y >= 2 && y <= 5) {
			if (y != 5) {
				if (TritownActual.board[x][y + 1] > 0 && 
						TritownActual.board[x + 1][y] > 0 && 
						TritownActual.board[x][y - 1] > 0) {
					TritownActual.board[x][y] = ROCK;
				}
				else {
					int direction3 = random.nextInt(4 - 2 + 1) + 2;
						
					while (true) {
						if (direction3 == RIGHT &&
								TritownActual.board[x][y + 1] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x;
							nextY = y + 1;
							break;
						}
						else if (direction3 == DOWN &&
								TritownActual.board[x + 1][y] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x + 1;
							nextY = y;
							break;
						}
						else if (direction3 == LEFT && 
								TritownActual.board[x][y - 1] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x;
							nextY = y - 1;
							break;
						}
							
						if (direction3 != LEFT) {
							direction3++;
						}
						else {
							direction3 = RIGHT;
						}
					}
				}
			}
				
			else {
				if (TritownActual.board[x + 1][y] > 0 && 
						TritownActual.board[x][y - 1] > 0) {
					TritownActual.board[x][y] = ROCK;
				}
				else {
					int direction4 = random.nextInt(4 - 3 + 1) + 3;
						
					while (true) {
						if (direction4 == DOWN && 
								TritownActual.board[x + 1][y] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x + 1;
							nextY = y;
							break;
						}
						else if (direction4 == LEFT &&
								TritownActual.board[x][y - 1] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x;
							nextY = y - 1;
							break;
						}
							
						if (direction4 == DOWN) {
							direction4 = LEFT;
						}
						else {
							direction4 = DOWN;
						}
					}
				}
			}
		}
			
			
			
		else if (x >= 1 && x <= 5 && y == 5) {
			if (x != 5) {
				if (TritownActual.board[x - 1][y] > 0 && 
						TritownActual.board[x + 1][y] > 0 && 
						TritownActual.board[x][y - 1] > 0) {
					TritownActual.board[x][y] = ROCK;
				}
				else {
					int[] directions = {UP, DOWN, LEFT};
					int direction5 = directions[random.nextInt(2 - 0 + 1) + 0];
					
					while (true) {
						if (direction5 == UP && 
								TritownActual.board[x - 1][y] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x - 1;
							nextY = y;
							break;
						}
						else if (direction5 == DOWN && 
								TritownActual.board[x + 1][y] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x + 1;
							nextY = y;
							break;
						}
						else if (direction5 == LEFT && 
								TritownActual.board[x][y - 1] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x;
							nextY = y - 1;
							break;
						}
							
						if (direction5 == UP) {
							direction5 = DOWN;
						}
						else if (direction5 == DOWN) {
							direction5 = LEFT;
						}
						else {
							direction5 = UP;
						}
					}
				}
			}
			else {
				if (TritownActual.board[x - 1][y] > 0 && 
						TritownActual.board[x][y - 1] > 0) {
					TritownActual.board[x][y] = ROCK;
				}
				else {
					int[] directions2 = {UP, LEFT};
					int direction6 = directions2[random.nextInt(1 - 0 + 1) + 0];
						
					while (true) {
						if (direction6 == UP && 
								TritownActual.board[x - 1][y] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x - 1;
							nextY = y;
							break;
						}
						else if (direction6 == LEFT && 
								TritownActual.board[x][y - 1] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x;
							nextY = y - 1;
							break;
						}
							
						if (direction6 == UP) {
							direction6 = LEFT;
						}
						else {
							direction6 = UP;
						}
					}
				}
			}
		}
			
			
			
		else if (x == 5 && y <= 4) {
			if (y != 0) {
				if (TritownActual.board[x - 1][y] > 0 && 
						TritownActual.board[x][y + 1] > 0 && 
						TritownActual.board[x][y - 1] > 0) {
					TritownActual.board[x][y] = ROCK;
				}
				else {
					int[] directions3 = {UP, RIGHT, LEFT};
					int direction7 = directions3[random.nextInt(2 - 0 + 1) + 0];
						
					while (true) {
						if (direction7 == UP && 
								TritownActual.board[x - 1][y] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x - 1;
							nextY = y;
							break;
						}
						else if (direction7 == RIGHT && 
								TritownActual.board[x][y + 1] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x;
							nextY = y + 1;
							break;
						}
						else if (direction7 == LEFT && 
								TritownActual.board[x][y - 1] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x;
							nextY = y - 1;
							break;
						}
							
						if (direction7 == UP) {
							direction7 = RIGHT;
						}
						else if (direction7 == RIGHT) {
							direction7 = LEFT;
						}
						else {
							direction7 = UP;
						}
					}
				}
			}
			else {
				if (TritownActual.board[x - 1][y] > 0 && 
						TritownActual.board[x][y + 1] > 0) {
					TritownActual.board[x][y] = ROCK;
				}
				else {
					int direction8 = random.nextInt(2 - 1 + 1) + 1;
						
					while (true) {
						if (direction8 == UP && 
								TritownActual.board[x - 1][y] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x - 1;
							nextY = y;
							break;
						}
						else if (direction8 == RIGHT && 
								TritownActual.board[x][y + 1] == 0) {
							TritownActual.board[x][y] = 0;
							nextX = x;
							nextY = y + 1;
							break;
						}
							
						if (direction8 == UP) {
							direction8 = RIGHT;
						}
						else {
							direction8 = UP;
						}
					}
				}
			}
		}
			
			
			
		else if (x >= 2 && x <= 4 && y == 0) {
			if (TritownActual.board[x - 1][y] > 0 && 
					TritownActual.board[x][y + 1] > 0 && 
					TritownActual.board[x + 1][y] > 0) {
				TritownActual.board[x][y] = ROCK;
			}
			else {
				int direction9 = random.nextInt(3 - 1 + 1) + 1;
					
				while (true) {
					if (direction9 == UP && 
							TritownActual.board[x - 1][y] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x - 1;
						nextY = y;
						break;
					}
					else if (direction9 == RIGHT && 
							TritownActual.board[x][y + 1] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x;
						nextY = y + 1;
						break;
					}
					else if (direction9 == DOWN && 
							TritownActual.board[x + 1][y] == 0) {
						TritownActual.board[x][y] = 0;
						nextX = x + 1;
						nextY = y;
						break;
					}
						
					if (direction9 !=  DOWN) {
						direction9++;
					}
					else {
						direction9 = UP;
					}
				}
			}
		}
	}

}
