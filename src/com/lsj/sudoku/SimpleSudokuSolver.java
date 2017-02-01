package com.lsj.sudoku;

public class SimpleSudokuSolver extends AbstractSudokuSolver {
	boolean finish = false;
	
	@Override
	public void Solve() {
		rec(NextPointIndex(-1));
	}
	
	private void rec(int index){
		if(index==81){
			finish = true;
			return;
		}
		
		int row = index/9;
		int col = index%9;
		
		for(int number = 1; number <= 9; number++){
			if(CheckPoint(index, number)){
				layout[row][col] = number;
				
				rec(NextPointIndex(index));
				if(finish){return;}
				layout[row][col] = 0;
			}
		}
	}
	
	private int NextPointIndex(int currentIndex){
		for(int index = currentIndex+1; index<81; index++){
			if(layout[index/9][index%9] == 0){
				return index;
			}
		}
		return 81;
	}
}