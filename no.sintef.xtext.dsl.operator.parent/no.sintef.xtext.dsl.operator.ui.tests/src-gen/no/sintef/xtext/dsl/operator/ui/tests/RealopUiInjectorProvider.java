/*
 * generated by Xtext 2.9.2
 */
package no.sintef.xtext.dsl.operator.ui.tests;

import com.google.inject.Injector;
import no.sintef.xtext.dsl.operator.ui.internal.OperatorActivator;
import org.eclipse.xtext.junit4.IInjectorProvider;

public class RealopUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return OperatorActivator.getInstance().getInjector("no.sintef.xtext.dsl.operator.Realop");
	}

}
