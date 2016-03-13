public class Combine {
	private static int PosX, PosY;
	private static int PosValue;
	private static int NumSame;
	private static int PosX2, PosY2;
	private static int NextNum;
	

	/**
	 * Determine how many same objects based on the given location
	 * 
	 * @param x - the x-position of the grid to be determined
	 * @param y - the y-position of the grid to be determined
	 */
	public static void SameObject(int x, int y) {
		int count = 0;
		
		// A series of number to store the position of the same object
		int existL=0, existR=0, existU=0, existD=0;
		NumSame++;
		
		// Check if the point can move 
		// The count will increase by 1 if it is removable in one direction
		if (CheckLeft(x, y)) {
			count++;
			existL = 1;
			TritownActual.board[x][y] = 0;
			SameObject(x, y-1);			
		}
		if (CheckUp(x, y)) {
			count++;
			existU = 1;
			TritownActual.board[x][y] = 0;
			SameObject(x-1, y);
		}
		if (CheckRight(x, y)) {
			count++;
			existR = 1;
			TritownActual.board[x][y] = 0;
			SameObject(x, y+1);
		}
		if (CheckDown(x, y)) {
			count++;
			existD = 1;
			TritownActual.board[x][y] = 0;
			SameObject(x+1, y);
		}
		
		// When there are only two same numbers
		// Get the location of the other one
		if (count == 1) {
			if (existL == 1) {
				PosX2 = x;
				PosY2 = y-1;
			}if (existR == 1) {
				PosX2 = x;
				PosY2 = y+1;
			}if (existU == 1) {
				PosX2 = x-1;
				PosY2 = y;
			}if (existD == 1) {
				PosX2 = x+1;
				PosY2 = y;
			}
		}
		
		// If the point is not movable, do the following
		if (count == 0) {
			
			// Return to the start point
			if (x != PosX || y != PosY) {
				TritownActual.board[x][y] = 0;
				TritownActual.board[PosX][PosY] = PosValue;
			}
			
			// Check the boundary; corners are included
			if (PosX == 0 && PosY == 1) {
				if (TritownActual.board[PosX+1][PosY] == PosValue 
						|| TritownActual.board[PosX][PosY+1] == PosValue) {
					if (TritownActual.board[PosX][PosY] != 0) {
						SameObject(PosX, PosY);
					}
				}
				else {return;}
			}
					
			if (PosX == 1 && PosY == 0) {
				if (TritownActual.board[PosX+1][PosY] == PosValue 
						|| TritownActual.board[PosX][PosY+1] == PosValue) {
					if (TritownActual.board[PosX][PosY] != 0) {
						SameObject(PosX, PosY);
					}
				}
			else {return;}
		}
								
			if (PosX == 0) {
				if (PosY == 5) {
					if (TritownActual.board[PosX+1][PosY] == PosValue 
							|| TritownActual.board[PosX][PosY-1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
							SameObject(PosX, PosY);
							}
						}
					else {return;}
				}
				else {
					if (TritownActual.board[PosX+1][PosY] == PosValue || 
							TritownActual.board[PosX][PosY-1] ==PosValue || 
							TritownActual.board[PosX][PosY+1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
							SameObject(PosX, PosY);
						}
					}
					else {return;}
				}
			}
								
			if (PosX == 5) {
				if (PosY == 5) {
					if (TritownActual.board[PosX-1][PosY] == PosValue || 
							TritownActual.board[PosX][PosY-1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
							SameObject(PosX, PosY);
						}
					}
					else {return;}
				}
				else if (PosY == 0) {
					if (TritownActual.board[PosX-1][PosY] == PosValue || 
							TritownActual.board[PosX][PosY+1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
							SameObject(PosX, PosY);
					}
				}
					else {return;}
				}
				else {
					if (TritownActual.board[PosX-1][PosY] == PosValue ||
							TritownActual.board[PosX][PosY-1] == PosValue || 
							TritownActual.board[PosX][PosY+1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
							SameObject(PosX, PosY);}
					} 
					else {return;}
				}
			}
			
			if (PosY == 0) {
				if (PosX == 5) {
					if (TritownActual.board[PosX-1][PosY] == PosValue || 
							TritownActual.board[PosX][PosY+1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
							SameObject(PosX, PosY);
						}
					}
					else {return;}
				}
				else {
					if (TritownActual.board[PosX-1][PosY] == PosValue || 
							TritownActual.board[PosX+1][PosY] == PosValue || 
							TritownActual.board[PosX][PosY+1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
						SameObject(PosX, PosY);
					}
				} 
				else {return;}
			}
		}
		
			if (PosY == 5) {
				if (PosX == 0) {
					if (TritownActual.board[PosX+1][PosY] == PosValue || 
							TritownActual.board[PosX][PosY-1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
							SameObject(PosX, PosY);
						}
					}
					else {return;}
				}
				else {
					if (TritownActual.board[PosX-1][PosY] == PosValue ||
							TritownActual.board[PosX+1][PosY] == PosValue || 
							TritownActual.board[PosX][PosY-1] == PosValue) {
						if (TritownActual.board[PosX][PosY] != 0) {
							SameObject(PosX, PosY);
						}
					} 
					else {return;}
				}
			}
			
			// If the point is not in the boundary, check all directions
			if (PosX != 0 && PosX != 5 && PosY != 0 && PosY != 5) { 
				if (TritownActual.board[PosX-1][PosY] == PosValue || 
						TritownActual.board[PosX+1][PosY] == PosValue || 
						TritownActual.board[PosX][PosY-1] == PosValue || 
						TritownActual.board[PosX][PosY+1] == PosValue) {
					if (TritownActual.board[PosX][PosY] != 0) {
						SameObject(PosX, PosY);
					}
				} 
				else {return;}
			}
		}
	}
	
	/**
	 * check if the point can move left
	 * @param x - the x position of point
	 * @param y - the y position of point
	 * @return - If it can move left
	 */
	public static boolean CheckLeft(int x, int y) {
		if (y != 0) {
			if (TritownActual.board[x][y-1] == TritownActual.board[x][y]
					&& TritownActual.board[x][y-1] != 0) {
				return true; }
			else {return false;}
		} else {return false;}
	}
	
	/**
	 * check if the point can move up
	 * @param x - the x position of point
	 * @param y - the y position of point
	 * @return - If it can move up
	 */
	public static boolean CheckUp(int x, int y) {
		if (x != 0) {
			if (TritownActual.board[x-1][y] == TritownActual.board[x][y] 
					&& TritownActual.board[x-1][y] != 0) {
				return true; }
			else {return false;}
		} else {return false;}
	}
	
	/**
	 * check if the point can move right
	 * @param x - the x position of point
	 * @param y - the y position of point
	 * @return - If it can move right
	 */
	public static boolean CheckRight(int x, int y) {
		if (y != TritownActual.board.length - 1) {
			if (TritownActual.board[x][y+1] == TritownActual.board[x][y] 
					&& TritownActual.board[x][y+1] != 0) {
				return true; }
			else {return false;}
		} else {return false;}
	}

	/**
	 * check if the point can move down
	 * @param x - the x position of point
	 * @param y - the y position of point
	 * @return - If it can move down
	 */
	public static boolean CheckDown(int x, int y) {
		if (x != TritownActual.board.length - 1){
			if (TritownActual.board[x+1][y] == TritownActual.board[x][y]
					&& TritownActual.board[x+1][y] != 0) {
				return true; }
			else {return false;}
					}else {return false;}
	}
	
	/**
	 * Initial local variables with the start point's value
	 * 
	 * @param x - the x position of point
	 * @param y - the y position of point
	 */
	public static void StartPoint(int x, int y) {
		PosX = x;
		PosY = y;
		PosValue = TritownActual.board[x][y];
	}
			

	/**
	 * The return method of value
	 * @return NumSame
	 */
	public static int ReturnSame() {
		return NumSame;
	}
	
	/**
	 * The return method of value
	 * @return NextNum
	 */
	public static int ReturnNumber() {
		return NextNum;
	}
	
	/**
	 * The return method of value
	 * @return the same point's x position
	 */
	public static int ReturnX2() {
		return PosX2;
	}
	
	/**
	 * The return method of value
	 * @return the same point's y position
	 */
	public static int ReturnY2() {
		return PosY2;
	}
	
	/**
	 * Set NumSame to 0
	 */
	public static void InitialNumSame() {
	    NumSame = 0;
	}
	
	/**
	 * The return method of value
	 * @return the value of the given point
	 */
	public static int ReturnValue() {
		return PosValue;
	}

}
