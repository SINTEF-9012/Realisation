package no.sintef.autorealspl.converter.parser;

import java.util.List;

import bvr.BVRModel;
import no.sintef.autorealspl.converter.interfaces.parser.IParserStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;

public class BVRModelParserStrategy implements IParserStrategy {
	
	private BVRModel model;

	public BVRModelParserStrategy(BVRModel _model) {
		model = _model;
	}

	public List<IFeature> getFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

}
