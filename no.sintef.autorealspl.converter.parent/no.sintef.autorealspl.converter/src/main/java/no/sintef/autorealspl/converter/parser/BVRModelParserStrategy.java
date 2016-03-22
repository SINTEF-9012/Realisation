package no.sintef.autorealspl.converter.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import bvr.BVRModel;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import no.sintef.autorealspl.converter.interfaces.parser.IParserStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IFeatureFactory;

public class BVRModelParserStrategy implements IParserStrategy {
	
	private BVRModel model;
	private IFeatureFactory feature_factory;
	private CompoundResolution resolution;

	public BVRModelParserStrategy() {
		feature_factory = new BVRFeatureFactory();
	}
	
	public void setBVRModel(BVRModel _model) {
		model = _model;
	}
	
	public void setResolution(CompoundResolution _resolution) {
		resolution = _resolution;
	}

	public List<IFeature> getFeatures() {
		List<IFeature> features = parseModel();
		return features;
	}
	
	private List<IFeature> parseModel() {
		List<IFeature> features = new ArrayList<IFeature>();
		List<VSpec> vspecs = flattenVSpecModel(model);
		
		if(resolution != null) {
			List<VSpecResolution> resolutions = flattenResolutionModel(resolution);
			for(VSpecResolution res_node: resolutions) {
				VSpec vspec = res_node.getResolvedVSpec();
				vspecs.remove(vspec);
				String name = vspec.getName();
				
				IFeature feature = (res_node instanceof PosResolution) ? feature_factory.createPosResolved(name) : feature_factory.createNegResolved(name);
				features.add(feature);
			}
		}
		
		for(VSpec vspec : vspecs) {
			String name = vspec.getName();
			IFeature feature = feature_factory.createNotResolved(name);
			features.add(feature);
		}	
		return features;
	}
	
	private List<VSpecResolution> flattenResolutionModel(CompoundResolution resolution) {
		List<VSpecResolution> list = new ArrayList<VSpecResolution>();
		parseResolutonModel(resolution, list);
		return list;
	}
	
	private void parseResolutonModel(VSpecResolution resolution, List<VSpecResolution> list) {
		list.add(resolution);
		
		if(resolution instanceof CompoundResolution) {
			EList<VSpecResolution> resolutions = ((CompoundResolution) resolution).getMembers();
			for(VSpecResolution res : resolutions) {
				if(res instanceof PosResolution || res instanceof NegResolution)
					parseResolutonModel(res, list);
			}
		}
	}
	
	private List<VSpec> flattenVSpecModel(BVRModel model) {
		List<VSpec> list = new ArrayList<VSpec>();
		CompoundNode root = model.getVariabilityModel();
		parseVSpecModel(root, list);
		return list;
	}
	
	private void parseVSpecModel(CompoundNode node, List<VSpec> vspec) {
		vspec.add((VSpec) node);
		
		EList<VNode> members = node.getMember();
		for(VNode member : members) {
			if(member instanceof Choice)
				parseVSpecModel((CompoundNode) member, vspec);
		}
	}

}
