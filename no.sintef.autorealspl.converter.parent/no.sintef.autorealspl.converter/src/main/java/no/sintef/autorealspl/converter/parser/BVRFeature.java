package no.sintef.autorealspl.converter.parser;

import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IFeatureStatus;

public class BVRFeature implements IFeature {
	
	private IFeatureStatus status;
	private String name;

	public BVRFeature(String _name, IFeatureStatus _status) {
		status = _status;
		name = _name;
	}

	public IFeatureStatus getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

}
