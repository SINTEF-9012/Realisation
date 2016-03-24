package no.sintef.autorealspl.converter.operconverter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import no.sintef.autorealspl.converter.interfaces.operconverter.IOperatorSerializer;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.RealopPackage;

public class XMIOperatorSerializer implements IOperatorSerializer {

	@Override
	public void serialize(List<Operator> operators, String dest) {
		RealopPackage.eINSTANCE.eClass();
		
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		registry.getExtensionToFactoryMap().put("realop", new XMIResourceFactoryImpl());

		XtextResourceSet resourceSet = new XtextResourceSet();
		Resource resource = resourceSet.createResource(URI.createURI(dest));
		
		resource.getContents().addAll(operators);
		
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XtextResource.OPTION_ENCODING, "UTF-8");
		
		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
