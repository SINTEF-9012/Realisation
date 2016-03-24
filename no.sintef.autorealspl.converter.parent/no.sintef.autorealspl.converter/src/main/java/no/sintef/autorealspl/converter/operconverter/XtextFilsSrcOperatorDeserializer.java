package no.sintef.autorealspl.converter.operconverter;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import no.sintef.autorealspl.converter.interfaces.operconverter.IOperatorDeserializer;
import no.sintef.xtext.dsl.operator.RealopStandaloneSetupGenerated;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.Realop;

public class XtextFilsSrcOperatorDeserializer implements IOperatorDeserializer {

	@Override
	public List<Operator> deserialize(String src) {
		RealopStandaloneSetupGenerated standalone = new RealopStandaloneSetupGenerated();
		Injector injector = standalone.createInjectorAndDoEMFRegistration();
		XtextResourceSet resSet = injector.getInstance(XtextResourceSet.class);
		Resource resource = resSet.getResource(URI.createURI(src), true);
		EList<EObject> contents = resource.getContents();
		Realop root = (Realop) contents.get(0);
		return root.getOperators();
	}

}
