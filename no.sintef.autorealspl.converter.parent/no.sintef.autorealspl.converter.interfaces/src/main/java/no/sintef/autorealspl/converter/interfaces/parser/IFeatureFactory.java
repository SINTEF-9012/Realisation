package no.sintef.autorealspl.converter.interfaces.parser;

public interface IFeatureFactory {
	
	public IFeature createPosResolved(String name);
	
	public IFeature createNegResolved(String name);
	
	public IFeature createNotResolved(String name);

}
