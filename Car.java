public class Car {
	private CarType type;
	private String plateNum;

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public String getPlateNum() {
		return plateNum;
	}

	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}

	public Car(CarType type, String plateNum) {
		this.type = type;
		this.plateNum = plateNum;
	}

	public String toString() {
		return getType().toString() + '(' + plateNum + ')';
	}
}