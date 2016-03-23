package no.sintef.autorealspl.converter.operconverter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl;
import org.eclipse.xtext.serializer.impl.Serializer;

import com.google.inject.Guice;
import com.google.inject.Injector;

import no.sintef.autorealspl.converter.interfaces.operconverter.IOperatorSerializer;
import no.sintef.xtext.dsl.operator.realop.Operator;

public class XtextFileSrcOperatorSerializer implements IOperatorSerializer {
	
	@Override
	public void serialize(List<Operator> operators, String dest) {
		
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xtextbin"))
			  Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
			                "xtextbin", new BinaryGrammarResourceFactoryImpl());
		
		Injector injector = Guice.createInjector(new no.sintef.xtext.dsl.operator.RealopRuntimeModule());
		Serializer serializer = injector.getInstance(Serializer.class);
		
		String contents = new String();
		for(Operator operator : operators)
			contents += serializer.serialize(operator) + "\n";

		try {
			File file = new File(dest);
			file.createNewFile();
			
			FileOutputStream file_output = new FileOutputStream(file);
			OutputStreamWriter output_writer = new OutputStreamWriter(file_output);
			BufferedWriter writer = new BufferedWriter(output_writer);
			writer.write(contents);
			writer.close();			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
