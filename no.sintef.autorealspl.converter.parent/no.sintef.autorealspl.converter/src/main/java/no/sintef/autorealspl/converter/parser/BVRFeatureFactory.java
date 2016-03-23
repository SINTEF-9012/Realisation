package no.sintef.autorealspl.converter.parser;

import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IFeatureFactory;
import no.sintef.autorealspl.converter.interfaces.parser.IFeatureStatus;

public class BVRFeatureFactory implements IFeatureFactory {

	public IFeature createPosResolved(String name) {
		return new BVRFeature(name, new FeatureStatus(IFeatureStatus.TRUE));
	}

	public IFeature createNegResolved(String name) {
		return new BVRFeature(name, new FeatureStatus(IFeatureStatus.FALSE));
	}

	public IFeature createNotResolved(String name) {
		return new BVRFeature(name, new FeatureStatus(IFeatureStatus.NR));
	}

}
