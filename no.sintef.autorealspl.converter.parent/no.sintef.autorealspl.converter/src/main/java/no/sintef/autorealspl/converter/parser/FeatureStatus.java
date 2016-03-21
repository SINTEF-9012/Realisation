package no.sintef.autorealspl.converter.parser;

import no.sintef.autorealspl.converter.interfaces.parser.IFeatureStatus;

public class FeatureStatus implements IFeatureStatus {

	public byte status;
	
	public FeatureStatus(byte _status) {
		status = _status;
		if(!(status == IFeatureStatus.TRUE || status == IFeatureStatus.FALSE || status == IFeatureStatus.NR))
			throw new RuntimeException("illegal status value");
	}
	
	public byte getValue() {
		return status;
	}

	public boolean isPosResolved() {
		return status == IFeatureStatus.TRUE;
	}

	public boolean isNegResolved() {
		return status == IFeatureStatus.FALSE;
	}

	public boolean isNotResolved() {
		return status == IFeatureStatus.NR;
	}

}
