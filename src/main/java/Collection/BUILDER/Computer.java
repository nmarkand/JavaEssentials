package Collection.BUILDER;

public class Computer {
	// required parameters
	private String HDD;
	private String RAM;
	
	//optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	//Create private constructor in main class whose object is going to be build
	//So that no one else can create this object from outside
	private Computer(ComputerBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
	}
	
	//Create Builder Class with object name and create all properties of main class
	// create build method which calls private constructor of main class and return it
	public static class ComputerBuilder{
		// required parameters
		private String HDD;
		private String RAM;

		// optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		//All mandatory fields must be in constructor
		public ComputerBuilder(String hdd, String ram){
			this.HDD=hdd;
			this.RAM=ram;
		}

		//Optional fields are on setters.
		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public Computer build(){
			return new Computer(this);
		}
	}
}