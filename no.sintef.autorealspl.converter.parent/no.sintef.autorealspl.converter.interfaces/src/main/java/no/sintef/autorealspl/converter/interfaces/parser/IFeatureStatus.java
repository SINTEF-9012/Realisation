package no.sintef.autorealspl.converter.interfaces.parser;

public interface IFeatureStatus {
	
	public static byte TRUE = 1;
	public static byte FALSE = 0;
	public static byte NR = 3;
	public static byte MASK = (byte) 0xFF;
	
	public byte getValue();
	
	public boolean isPosResolved();
	
	public boolean isNegResolved();
	
	public boolean isNotResolved();

}
