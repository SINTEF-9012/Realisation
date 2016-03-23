package no.sintef.autorealspl.converter.parser;

import java.util.List;

import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IParserStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IVariabilityModelParser;

public class VariabiltiyModelParser implements IVariabilityModelParser {
	
	private IParserStrategy strategy;

	public VariabiltiyModelParser(IParserStrategy _strategy) {
		strategy = _strategy;
	}

	public List<IFeature> parse() {
		return strategy.getFeatures();
	}

	public IParserStrategy getParserStrategy() {
		return strategy;
	}

}
