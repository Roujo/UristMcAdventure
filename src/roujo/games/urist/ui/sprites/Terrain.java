package roujo.games.urist.ui.sprites;

public enum Terrain implements Sprite {
	Grass1(0,0),
	Grass2(0,1),
	Grass3(1,0),
	Grass4(1,1);
	
	private static final int SPRITE_SIZE = 16;
	private static final String SHEET_NAME = "terrain";
	
	private final int rowIndex, columnIndex;
	
	private Terrain(int rowIndex, int columnIndex) {
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
