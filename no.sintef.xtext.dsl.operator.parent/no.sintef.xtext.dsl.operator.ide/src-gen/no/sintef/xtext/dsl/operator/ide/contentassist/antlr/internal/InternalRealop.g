/*
 * generated by Xtext 2.9.2
 */
grammar InternalRealop;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package no.sintef.xtext.dsl.operator.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package no.sintef.xtext.dsl.operator.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import no.sintef.xtext.dsl.operator.services.RealopGrammarAccess;

}
@parser::members {
	private RealopGrammarAccess grammarAccess;

	public void setGrammarAccess(RealopGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleRealop
entryRuleRealop
:
{ before(grammarAccess.getRealopRule()); }
	 ruleRealop
{ after(grammarAccess.getRealopRule()); } 
	 EOF 
;

// Rule Realop
ruleRealop 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRealopAccess().getOperatorAssignment()); }
		(rule__Realop__OperatorAssignment)*
		{ after(grammarAccess.getRealopAccess().getOperatorAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOperator
entryRuleOperator
:
{ before(grammarAccess.getOperatorRule()); }
	 ruleOperator
{ after(grammarAccess.getOperatorRule()); } 
	 EOF 
;

// Rule Operator
ruleOperator 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOperatorAccess().getGroup()); }
		(rule__Operator__Group__0)
		{ after(grammarAccess.getOperatorAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExpression
entryRuleExpression
:
{ before(grammarAccess.getExpressionRule()); }
	 ruleExpression
{ after(grammarAccess.getExpressionRule()); } 
	 EOF 
;

// Rule Expression
ruleExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpressionAccess().getGroup()); }
		(rule__Expression__Group__0)
		{ after(grammarAccess.getExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminalExpression
entryRuleTerminalExpression
:
{ before(grammarAccess.getTerminalExpressionRule()); }
	 ruleTerminalExpression
{ after(grammarAccess.getTerminalExpressionRule()); } 
	 EOF 
;

// Rule TerminalExpression
ruleTerminalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getGroup()); }
		(rule__TerminalExpression__Group__0)
		{ after(grammarAccess.getTerminalExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLogic
entryRuleLogic
:
{ before(grammarAccess.getLogicRule()); }
	 ruleLogic
{ after(grammarAccess.getLogicRule()); } 
	 EOF 
;

// Rule Logic
ruleLogic 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLogicAccess().getAlternatives()); }
		(rule__Logic__Alternatives)
		{ after(grammarAccess.getLogicAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePredicate
entryRulePredicate
:
{ before(grammarAccess.getPredicateRule()); }
	 rulePredicate
{ after(grammarAccess.getPredicateRule()); } 
	 EOF 
;

// Rule Predicate
rulePredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPredicateAccess().getGroup()); }
		(rule__Predicate__Group__0)
		{ after(grammarAccess.getPredicateAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePredicates
entryRulePredicates
:
{ before(grammarAccess.getPredicatesRule()); }
	 rulePredicates
{ after(grammarAccess.getPredicatesRule()); } 
	 EOF 
;

// Rule Predicates
rulePredicates 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPredicatesAccess().getAlternatives()); }
		(rule__Predicates__Alternatives)
		{ after(grammarAccess.getPredicatesAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNOT_TOKEN
entryRuleNOT_TOKEN
:
{ before(grammarAccess.getNOT_TOKENRule()); }
	 ruleNOT_TOKEN
{ after(grammarAccess.getNOT_TOKENRule()); } 
	 EOF 
;

// Rule NOT_TOKEN
ruleNOT_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNOT_TOKENAccess().getNotKeyword()); }
		'not'
		{ after(grammarAccess.getNOT_TOKENAccess().getNotKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAND_TOKEN
entryRuleAND_TOKEN
:
{ before(grammarAccess.getAND_TOKENRule()); }
	 ruleAND_TOKEN
{ after(grammarAccess.getAND_TOKENRule()); } 
	 EOF 
;

// Rule AND_TOKEN
ruleAND_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAND_TOKENAccess().getAndKeyword()); }
		'and'
		{ after(grammarAccess.getAND_TOKENAccess().getAndKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOR_TOKEN
entryRuleOR_TOKEN
:
{ before(grammarAccess.getOR_TOKENRule()); }
	 ruleOR_TOKEN
{ after(grammarAccess.getOR_TOKENRule()); } 
	 EOF 
;

// Rule OR_TOKEN
ruleOR_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOR_TOKENAccess().getOrKeyword()); }
		'or'
		{ after(grammarAccess.getOR_TOKENAccess().getOrKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXOR_TOKEN
entryRuleXOR_TOKEN
:
{ before(grammarAccess.getXOR_TOKENRule()); }
	 ruleXOR_TOKEN
{ after(grammarAccess.getXOR_TOKENRule()); } 
	 EOF 
;

// Rule XOR_TOKEN
ruleXOR_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXOR_TOKENAccess().getXorKeyword()); }
		'xor'
		{ after(grammarAccess.getXOR_TOKENAccess().getXorKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePRED_REALISED_TOKEN
entryRulePRED_REALISED_TOKEN
:
{ before(grammarAccess.getPRED_REALISED_TOKENRule()); }
	 rulePRED_REALISED_TOKEN
{ after(grammarAccess.getPRED_REALISED_TOKENRule()); } 
	 EOF 
;

// Rule PRED_REALISED_TOKEN
rulePRED_REALISED_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPRED_REALISED_TOKENAccess().getRealisedKeyword()); }
		'realised'
		{ after(grammarAccess.getPRED_REALISED_TOKENAccess().getRealisedKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePRED_POSITIVE_TOKEN
entryRulePRED_POSITIVE_TOKEN
:
{ before(grammarAccess.getPRED_POSITIVE_TOKENRule()); }
	 rulePRED_POSITIVE_TOKEN
{ after(grammarAccess.getPRED_POSITIVE_TOKENRule()); } 
	 EOF 
;

// Rule PRED_POSITIVE_TOKEN
rulePRED_POSITIVE_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPRED_POSITIVE_TOKENAccess().getPositiveKeyword()); }
		'positive'
		{ after(grammarAccess.getPRED_POSITIVE_TOKENAccess().getPositiveKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePRED_NEGATIVE_TOKEN
entryRulePRED_NEGATIVE_TOKEN
:
{ before(grammarAccess.getPRED_NEGATIVE_TOKENRule()); }
	 rulePRED_NEGATIVE_TOKEN
{ after(grammarAccess.getPRED_NEGATIVE_TOKENRule()); } 
	 EOF 
;

// Rule PRED_NEGATIVE_TOKEN
rulePRED_NEGATIVE_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPRED_NEGATIVE_TOKENAccess().getNegativeKeyword()); }
		'negative'
		{ after(grammarAccess.getPRED_NEGATIVE_TOKENAccess().getNegativeKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOP_TOKEN
entryRuleOP_TOKEN
:
{ before(grammarAccess.getOP_TOKENRule()); }
	 ruleOP_TOKEN
{ after(grammarAccess.getOP_TOKENRule()); } 
	 EOF 
;

// Rule OP_TOKEN
ruleOP_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOP_TOKENAccess().getOperatorKeyword()); }
		'operator'
		{ after(grammarAccess.getOP_TOKENAccess().getOperatorKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOPEN_OP_TOKEN
entryRuleOPEN_OP_TOKEN
:
{ before(grammarAccess.getOPEN_OP_TOKENRule()); }
	 ruleOPEN_OP_TOKEN
{ after(grammarAccess.getOPEN_OP_TOKENRule()); } 
	 EOF 
;

// Rule OPEN_OP_TOKEN
ruleOPEN_OP_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOPEN_OP_TOKENAccess().getLeftCurlyBracketKeyword()); }
		'{'
		{ after(grammarAccess.getOPEN_OP_TOKENAccess().getLeftCurlyBracketKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCLOSE_OP_TOKEN
entryRuleCLOSE_OP_TOKEN
:
{ before(grammarAccess.getCLOSE_OP_TOKENRule()); }
	 ruleCLOSE_OP_TOKEN
{ after(grammarAccess.getCLOSE_OP_TOKENRule()); } 
	 EOF 
;

// Rule CLOSE_OP_TOKEN
ruleCLOSE_OP_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCLOSE_OP_TOKENAccess().getRightCurlyBracketKeyword()); }
		'}'
		{ after(grammarAccess.getCLOSE_OP_TOKENAccess().getRightCurlyBracketKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePRE_TOKEN
entryRulePRE_TOKEN
:
{ before(grammarAccess.getPRE_TOKENRule()); }
	 rulePRE_TOKEN
{ after(grammarAccess.getPRE_TOKENRule()); } 
	 EOF 
;

// Rule PRE_TOKEN
rulePRE_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPRE_TOKENAccess().getPreKeyword()); }
		'pre'
		{ after(grammarAccess.getPRE_TOKENAccess().getPreKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePOST_TOKEN
entryRulePOST_TOKEN
:
{ before(grammarAccess.getPOST_TOKENRule()); }
	 rulePOST_TOKEN
{ after(grammarAccess.getPOST_TOKENRule()); } 
	 EOF 
;

// Rule POST_TOKEN
rulePOST_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPOST_TOKENAccess().getPostKeyword()); }
		'post'
		{ after(grammarAccess.getPOST_TOKENAccess().getPostKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCOND_ST_TOKEN
entryRuleCOND_ST_TOKEN
:
{ before(grammarAccess.getCOND_ST_TOKENRule()); }
	 ruleCOND_ST_TOKEN
{ after(grammarAccess.getCOND_ST_TOKENRule()); } 
	 EOF 
;

// Rule COND_ST_TOKEN
ruleCOND_ST_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCOND_ST_TOKENAccess().getColonKeyword()); }
		':'
		{ after(grammarAccess.getCOND_ST_TOKENAccess().getColonKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCOND_END_TOKEN
entryRuleCOND_END_TOKEN
:
{ before(grammarAccess.getCOND_END_TOKENRule()); }
	 ruleCOND_END_TOKEN
{ after(grammarAccess.getCOND_END_TOKENRule()); } 
	 EOF 
;

// Rule COND_END_TOKEN
ruleCOND_END_TOKEN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCOND_END_TOKENAccess().getSemicolonKeyword()); }
		';'
		{ after(grammarAccess.getCOND_END_TOKENAccess().getSemicolonKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Logic__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLogicAccess().getAND_TOKENParserRuleCall_0()); }
		ruleAND_TOKEN
		{ after(grammarAccess.getLogicAccess().getAND_TOKENParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getLogicAccess().getOR_TOKENParserRuleCall_1()); }
		ruleOR_TOKEN
		{ after(grammarAccess.getLogicAccess().getOR_TOKENParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getLogicAccess().getXOR_TOKENParserRuleCall_2()); }
		ruleXOR_TOKEN
		{ after(grammarAccess.getLogicAccess().getXOR_TOKENParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicates__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatesAccess().getPRED_REALISED_TOKENParserRuleCall_0()); }
		rulePRED_REALISED_TOKEN
		{ after(grammarAccess.getPredicatesAccess().getPRED_REALISED_TOKENParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPredicatesAccess().getPRED_POSITIVE_TOKENParserRuleCall_1()); }
		rulePRED_POSITIVE_TOKEN
		{ after(grammarAccess.getPredicatesAccess().getPRED_POSITIVE_TOKENParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getPredicatesAccess().getPRED_NEGATIVE_TOKENParserRuleCall_2()); }
		rulePRED_NEGATIVE_TOKEN
		{ after(grammarAccess.getPredicatesAccess().getPRED_NEGATIVE_TOKENParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__0__Impl
	rule__Operator__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getOP_TOKENParserRuleCall_0()); }
	ruleOP_TOKEN
	{ after(grammarAccess.getOperatorAccess().getOP_TOKENParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__1__Impl
	rule__Operator__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getNameAssignment_1()); }
	(rule__Operator__NameAssignment_1)
	{ after(grammarAccess.getOperatorAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__2__Impl
	rule__Operator__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getOPEN_OP_TOKENParserRuleCall_2()); }
	ruleOPEN_OP_TOKEN
	{ after(grammarAccess.getOperatorAccess().getOPEN_OP_TOKENParserRuleCall_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__3__Impl
	rule__Operator__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getPRE_TOKENParserRuleCall_3()); }
	rulePRE_TOKEN
	{ after(grammarAccess.getOperatorAccess().getPRE_TOKENParserRuleCall_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__4__Impl
	rule__Operator__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_4()); }
	ruleCOND_ST_TOKEN
	{ after(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__5__Impl
	rule__Operator__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getExp_preAssignment_5()); }
	(rule__Operator__Exp_preAssignment_5)
	{ after(grammarAccess.getOperatorAccess().getExp_preAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__6__Impl
	rule__Operator__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_6()); }
	ruleCOND_END_TOKEN
	{ after(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__7__Impl
	rule__Operator__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getPOST_TOKENParserRuleCall_7()); }
	rulePOST_TOKEN
	{ after(grammarAccess.getOperatorAccess().getPOST_TOKENParserRuleCall_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__8__Impl
	rule__Operator__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_8()); }
	ruleCOND_ST_TOKEN
	{ after(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__9__Impl
	rule__Operator__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getExp_postAssignment_9()); }
	(rule__Operator__Exp_postAssignment_9)
	{ after(grammarAccess.getOperatorAccess().getExp_postAssignment_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__10__Impl
	rule__Operator__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_10()); }
	ruleCOND_END_TOKEN
	{ after(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operator__Group__11__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Group__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperatorAccess().getCLOSE_OP_TOKENParserRuleCall_11()); }
	ruleCLOSE_OP_TOKEN
	{ after(grammarAccess.getOperatorAccess().getCLOSE_OP_TOKENParserRuleCall_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Expression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Expression__Group__0__Impl
	rule__Expression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getLhsAssignment_0()); }
	(rule__Expression__LhsAssignment_0)
	{ after(grammarAccess.getExpressionAccess().getLhsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Expression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getRhsAssignment_1()); }
	(rule__Expression__RhsAssignment_1)?
	{ after(grammarAccess.getExpressionAccess().getRhsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group__0__Impl
	rule__TerminalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getOpAssignment_0()); }
	(rule__TerminalExpression__OpAssignment_0)
	{ after(grammarAccess.getTerminalExpressionAccess().getOpAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getRhsAssignment_1()); }
	(rule__TerminalExpression__RhsAssignment_1)
	{ after(grammarAccess.getTerminalExpressionAccess().getRhsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Predicate__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__0__Impl
	rule__Predicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getNegateAssignment_0()); }
	(rule__Predicate__NegateAssignment_0)?
	{ after(grammarAccess.getPredicateAccess().getNegateAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__1__Impl
	rule__Predicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getPredicateAssignment_1()); }
	(rule__Predicate__PredicateAssignment_1)
	{ after(grammarAccess.getPredicateAccess().getPredicateAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__2__Impl
	rule__Predicate__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__3__Impl
	rule__Predicate__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getNameAssignment_3()); }
	(rule__Predicate__NameAssignment_3)
	{ after(grammarAccess.getPredicateAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Realop__OperatorAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRealopAccess().getOperatorOperatorParserRuleCall_0()); }
		ruleOperator
		{ after(grammarAccess.getRealopAccess().getOperatorOperatorParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperatorAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getOperatorAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Exp_preAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperatorAccess().getExp_preExpressionParserRuleCall_5_0()); }
		ruleExpression
		{ after(grammarAccess.getOperatorAccess().getExp_preExpressionParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operator__Exp_postAssignment_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperatorAccess().getExp_postExpressionParserRuleCall_9_0()); }
		ruleExpression
		{ after(grammarAccess.getOperatorAccess().getExp_postExpressionParserRuleCall_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__LhsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getLhsPredicateParserRuleCall_0_0()); }
		rulePredicate
		{ after(grammarAccess.getExpressionAccess().getLhsPredicateParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__RhsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getRhsTerminalExpressionParserRuleCall_1_0()); }
		ruleTerminalExpression
		{ after(grammarAccess.getExpressionAccess().getRhsTerminalExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__OpAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getOpLogicParserRuleCall_0_0()); }
		ruleLogic
		{ after(grammarAccess.getTerminalExpressionAccess().getOpLogicParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__RhsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getRhsExpressionParserRuleCall_1_0()); }
		ruleExpression
		{ after(grammarAccess.getTerminalExpressionAccess().getRhsExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__NegateAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicateAccess().getNegateNOT_TOKENParserRuleCall_0_0()); }
		ruleNOT_TOKEN
		{ after(grammarAccess.getPredicateAccess().getNegateNOT_TOKENParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__PredicateAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicateAccess().getPredicatePredicatesParserRuleCall_1_0()); }
		rulePredicates
		{ after(grammarAccess.getPredicateAccess().getPredicatePredicatesParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicateAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getPredicateAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
