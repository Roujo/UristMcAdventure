package roujo.games.urist.ui.sprites;

public enum Character implements Sprite {
	P1(0,0),
	P2(0,1),
	P3(1,0),
	P4(1,1);
	
	private static final int SPRITE_SIZE = 16;
	private static final String SHEET_NAME = "characters";
	
	private final int rowIndex, columnIndex;
	
	private Character(int rowIndex, int columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}

	@Override
	public int getSize() {
		return SPRITE_SIZE;
	}

	@Override
	public String getSheetName() {
		return SHEET_NAME;
	}

	@Override
	public int getRowIndex() {
		return rowIndex;
	}

	@Override
	public int getColumnIndex() {
		return columnIndex;
	}
}
