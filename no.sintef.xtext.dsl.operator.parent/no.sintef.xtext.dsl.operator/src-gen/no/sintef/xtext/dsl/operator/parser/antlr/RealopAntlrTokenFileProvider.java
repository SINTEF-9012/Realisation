/*
 * generated by Xtext 2.9.2
 */
package no.sintef.xtext.dsl.operator.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class RealopAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("no/sintef/xtext/dsl/operator/parser/antlr/internal/InternalRealop.tokens");
	}
}
