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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRealopParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'not'", "'and'", "'or'", "'xor'", "'realised'", "'positive'", "'negative'", "'operator'", "'{'", "'}'", "'pre'", "'post'", "':'", "';'", "'('", "')'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalRealopParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRealopParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRealopParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRealop.g"; }


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



    // $ANTLR start "entryRuleRealop"
    // InternalRealop.g:53:1: entryRuleRealop : ruleRealop EOF ;
    public final void entryRuleRealop() throws RecognitionException {
        try {
            // InternalRealop.g:54:1: ( ruleRealop EOF )
            // InternalRealop.g:55:1: ruleRealop EOF
            {
             before(grammarAccess.getRealopRule()); 
            pushFollow(FOLLOW_1);
            ruleRealop();

            state._fsp--;

             after(grammarAccess.getRealopRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRealop"


    // $ANTLR start "ruleRealop"
    // InternalRealop.g:62:1: ruleRealop : ( ( rule__Realop__OperatorAssignment )* ) ;
    public final void ruleRealop() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:66:2: ( ( ( rule__Realop__OperatorAssignment )* ) )
            // InternalRealop.g:67:2: ( ( rule__Realop__OperatorAssignment )* )
            {
            // InternalRealop.g:67:2: ( ( rule__Realop__OperatorAssignment )* )
            // InternalRealop.g:68:3: ( rule__Realop__OperatorAssignment )*
            {
             before(grammarAccess.getRealopAccess().getOperatorAssignment()); 
            // InternalRealop.g:69:3: ( rule__Realop__OperatorAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRealop.g:69:4: rule__Realop__OperatorAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Realop__OperatorAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getRealopAccess().getOperatorAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealop"


    // $ANTLR start "entryRuleOperator"
    // InternalRealop.g:78:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalRealop.g:79:1: ( ruleOperator EOF )
            // InternalRealop.g:80:1: ruleOperator EOF
            {
             before(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalRealop.g:87:1: ruleOperator : ( ( rule__Operator__Group__0 ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:91:2: ( ( ( rule__Operator__Group__0 ) ) )
            // InternalRealop.g:92:2: ( ( rule__Operator__Group__0 ) )
            {
            // InternalRealop.g:92:2: ( ( rule__Operator__Group__0 ) )
            // InternalRealop.g:93:3: ( rule__Operator__Group__0 )
            {
             before(grammarAccess.getOperatorAccess().getGroup()); 
            // InternalRealop.g:94:3: ( rule__Operator__Group__0 )
            // InternalRealop.g:94:4: rule__Operator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleExpression"
    // InternalRealop.g:103:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalRealop.g:104:1: ( ruleExpression EOF )
            // InternalRealop.g:105:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalRealop.g:112:1: ruleExpression : ( ( rule__Expression__Group__0 ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:116:2: ( ( ( rule__Expression__Group__0 ) ) )
            // InternalRealop.g:117:2: ( ( rule__Expression__Group__0 ) )
            {
            // InternalRealop.g:117:2: ( ( rule__Expression__Group__0 ) )
            // InternalRealop.g:118:3: ( rule__Expression__Group__0 )
            {
             before(grammarAccess.getExpressionAccess().getGroup()); 
            // InternalRealop.g:119:3: ( rule__Expression__Group__0 )
            // InternalRealop.g:119:4: rule__Expression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleTerminalExpression"
    // InternalRealop.g:128:1: entryRuleTerminalExpression : ruleTerminalExpression EOF ;
    public final void entryRuleTerminalExpression() throws RecognitionException {
        try {
            // InternalRealop.g:129:1: ( ruleTerminalExpression EOF )
            // InternalRealop.g:130:1: ruleTerminalExpression EOF
            {
             before(grammarAccess.getTerminalExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleTerminalExpression();

            state._fsp--;

             after(grammarAccess.getTerminalExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // InternalRealop.g:137:1: ruleTerminalExpression : ( ( rule__TerminalExpression__Group__0 ) ) ;
    public final void ruleTerminalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:141:2: ( ( ( rule__TerminalExpression__Group__0 ) ) )
            // InternalRealop.g:142:2: ( ( rule__TerminalExpression__Group__0 ) )
            {
            // InternalRealop.g:142:2: ( ( rule__TerminalExpression__Group__0 ) )
            // InternalRealop.g:143:3: ( rule__TerminalExpression__Group__0 )
            {
             before(grammarAccess.getTerminalExpressionAccess().getGroup()); 
            // InternalRealop.g:144:3: ( rule__TerminalExpression__Group__0 )
            // InternalRealop.g:144:4: rule__TerminalExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleLogic"
    // InternalRealop.g:153:1: entryRuleLogic : ruleLogic EOF ;
    public final void entryRuleLogic() throws RecognitionException {
        try {
            // InternalRealop.g:154:1: ( ruleLogic EOF )
            // InternalRealop.g:155:1: ruleLogic EOF
            {
             before(grammarAccess.getLogicRule()); 
            pushFollow(FOLLOW_1);
            ruleLogic();

            state._fsp--;

             after(grammarAccess.getLogicRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogic"


    // $ANTLR start "ruleLogic"
    // InternalRealop.g:162:1: ruleLogic : ( ( rule__Logic__Alternatives ) ) ;
    public final void ruleLogic() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:166:2: ( ( ( rule__Logic__Alternatives ) ) )
            // InternalRealop.g:167:2: ( ( rule__Logic__Alternatives ) )
            {
            // InternalRealop.g:167:2: ( ( rule__Logic__Alternatives ) )
            // InternalRealop.g:168:3: ( rule__Logic__Alternatives )
            {
             before(grammarAccess.getLogicAccess().getAlternatives()); 
            // InternalRealop.g:169:3: ( rule__Logic__Alternatives )
            // InternalRealop.g:169:4: rule__Logic__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Logic__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLogicAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogic"


    // $ANTLR start "entryRulePredicate"
    // InternalRealop.g:178:1: entryRulePredicate : rulePredicate EOF ;
    public final void entryRulePredicate() throws RecognitionException {
        try {
            // InternalRealop.g:179:1: ( rulePredicate EOF )
            // InternalRealop.g:180:1: rulePredicate EOF
            {
             before(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_1);
            rulePredicate();

            state._fsp--;

             after(grammarAccess.getPredicateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalRealop.g:187:1: rulePredicate : ( ( rule__Predicate__Group__0 ) ) ;
    public final void rulePredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:191:2: ( ( ( rule__Predicate__Group__0 ) ) )
            // InternalRealop.g:192:2: ( ( rule__Predicate__Group__0 ) )
            {
            // InternalRealop.g:192:2: ( ( rule__Predicate__Group__0 ) )
            // InternalRealop.g:193:3: ( rule__Predicate__Group__0 )
            {
             before(grammarAccess.getPredicateAccess().getGroup()); 
            // InternalRealop.g:194:3: ( rule__Predicate__Group__0 )
            // InternalRealop.g:194:4: rule__Predicate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRulePredicates"
    // InternalRealop.g:203:1: entryRulePredicates : rulePredicates EOF ;
    public final void entryRulePredicates() throws RecognitionException {
        try {
            // InternalRealop.g:204:1: ( rulePredicates EOF )
            // InternalRealop.g:205:1: rulePredicates EOF
            {
             before(grammarAccess.getPredicatesRule()); 
            pushFollow(FOLLOW_1);
            rulePredicates();

            state._fsp--;

             after(grammarAccess.getPredicatesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicates"


    // $ANTLR start "rulePredicates"
    // InternalRealop.g:212:1: rulePredicates : ( ( rule__Predicates__Alternatives ) ) ;
    public final void rulePredicates() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:216:2: ( ( ( rule__Predicates__Alternatives ) ) )
            // InternalRealop.g:217:2: ( ( rule__Predicates__Alternatives ) )
            {
            // InternalRealop.g:217:2: ( ( rule__Predicates__Alternatives ) )
            // InternalRealop.g:218:3: ( rule__Predicates__Alternatives )
            {
             before(grammarAccess.getPredicatesAccess().getAlternatives()); 
            // InternalRealop.g:219:3: ( rule__Predicates__Alternatives )
            // InternalRealop.g:219:4: rule__Predicates__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Predicates__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPredicatesAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicates"


    // $ANTLR start "entryRuleNOT_TOKEN"
    // InternalRealop.g:228:1: entryRuleNOT_TOKEN : ruleNOT_TOKEN EOF ;
    public final void entryRuleNOT_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:229:1: ( ruleNOT_TOKEN EOF )
            // InternalRealop.g:230:1: ruleNOT_TOKEN EOF
            {
             before(grammarAccess.getNOT_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleNOT_TOKEN();

            state._fsp--;

             after(grammarAccess.getNOT_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNOT_TOKEN"


    // $ANTLR start "ruleNOT_TOKEN"
    // InternalRealop.g:237:1: ruleNOT_TOKEN : ( 'not' ) ;
    public final void ruleNOT_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:241:2: ( ( 'not' ) )
            // InternalRealop.g:242:2: ( 'not' )
            {
            // InternalRealop.g:242:2: ( 'not' )
            // InternalRealop.g:243:3: 'not'
            {
             before(grammarAccess.getNOT_TOKENAccess().getNotKeyword()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getNOT_TOKENAccess().getNotKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNOT_TOKEN"


    // $ANTLR start "entryRuleAND_TOKEN"
    // InternalRealop.g:253:1: entryRuleAND_TOKEN : ruleAND_TOKEN EOF ;
    public final void entryRuleAND_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:254:1: ( ruleAND_TOKEN EOF )
            // InternalRealop.g:255:1: ruleAND_TOKEN EOF
            {
             before(grammarAccess.getAND_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleAND_TOKEN();

            state._fsp--;

             after(grammarAccess.getAND_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAND_TOKEN"


    // $ANTLR start "ruleAND_TOKEN"
    // InternalRealop.g:262:1: ruleAND_TOKEN : ( 'and' ) ;
    public final void ruleAND_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:266:2: ( ( 'and' ) )
            // InternalRealop.g:267:2: ( 'and' )
            {
            // InternalRealop.g:267:2: ( 'and' )
            // InternalRealop.g:268:3: 'and'
            {
             before(grammarAccess.getAND_TOKENAccess().getAndKeyword()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getAND_TOKENAccess().getAndKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAND_TOKEN"


    // $ANTLR start "entryRuleOR_TOKEN"
    // InternalRealop.g:278:1: entryRuleOR_TOKEN : ruleOR_TOKEN EOF ;
    public final void entryRuleOR_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:279:1: ( ruleOR_TOKEN EOF )
            // InternalRealop.g:280:1: ruleOR_TOKEN EOF
            {
             before(grammarAccess.getOR_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleOR_TOKEN();

            state._fsp--;

             after(grammarAccess.getOR_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOR_TOKEN"


    // $ANTLR start "ruleOR_TOKEN"
    // InternalRealop.g:287:1: ruleOR_TOKEN : ( 'or' ) ;
    public final void ruleOR_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:291:2: ( ( 'or' ) )
            // InternalRealop.g:292:2: ( 'or' )
            {
            // InternalRealop.g:292:2: ( 'or' )
            // InternalRealop.g:293:3: 'or'
            {
             before(grammarAccess.getOR_TOKENAccess().getOrKeyword()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getOR_TOKENAccess().getOrKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOR_TOKEN"


    // $ANTLR start "entryRuleXOR_TOKEN"
    // InternalRealop.g:303:1: entryRuleXOR_TOKEN : ruleXOR_TOKEN EOF ;
    public final void entryRuleXOR_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:304:1: ( ruleXOR_TOKEN EOF )
            // InternalRealop.g:305:1: ruleXOR_TOKEN EOF
            {
             before(grammarAccess.getXOR_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleXOR_TOKEN();

            state._fsp--;

             after(grammarAccess.getXOR_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXOR_TOKEN"


    // $ANTLR start "ruleXOR_TOKEN"
    // InternalRealop.g:312:1: ruleXOR_TOKEN : ( 'xor' ) ;
    public final void ruleXOR_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:316:2: ( ( 'xor' ) )
            // InternalRealop.g:317:2: ( 'xor' )
            {
            // InternalRealop.g:317:2: ( 'xor' )
            // InternalRealop.g:318:3: 'xor'
            {
             before(grammarAccess.getXOR_TOKENAccess().getXorKeyword()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXOR_TOKENAccess().getXorKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXOR_TOKEN"


    // $ANTLR start "entryRulePRED_REALISED_TOKEN"
    // InternalRealop.g:328:1: entryRulePRED_REALISED_TOKEN : rulePRED_REALISED_TOKEN EOF ;
    public final void entryRulePRED_REALISED_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:329:1: ( rulePRED_REALISED_TOKEN EOF )
            // InternalRealop.g:330:1: rulePRED_REALISED_TOKEN EOF
            {
             before(grammarAccess.getPRED_REALISED_TOKENRule()); 
            pushFollow(FOLLOW_1);
            rulePRED_REALISED_TOKEN();

            state._fsp--;

             after(grammarAccess.getPRED_REALISED_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePRED_REALISED_TOKEN"


    // $ANTLR start "rulePRED_REALISED_TOKEN"
    // InternalRealop.g:337:1: rulePRED_REALISED_TOKEN : ( 'realised' ) ;
    public final void rulePRED_REALISED_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:341:2: ( ( 'realised' ) )
            // InternalRealop.g:342:2: ( 'realised' )
            {
            // InternalRealop.g:342:2: ( 'realised' )
            // InternalRealop.g:343:3: 'realised'
            {
             before(grammarAccess.getPRED_REALISED_TOKENAccess().getRealisedKeyword()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getPRED_REALISED_TOKENAccess().getRealisedKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePRED_REALISED_TOKEN"


    // $ANTLR start "entryRulePRED_POSITIVE_TOKEN"
    // InternalRealop.g:353:1: entryRulePRED_POSITIVE_TOKEN : rulePRED_POSITIVE_TOKEN EOF ;
    public final void entryRulePRED_POSITIVE_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:354:1: ( rulePRED_POSITIVE_TOKEN EOF )
            // InternalRealop.g:355:1: rulePRED_POSITIVE_TOKEN EOF
            {
             before(grammarAccess.getPRED_POSITIVE_TOKENRule()); 
            pushFollow(FOLLOW_1);
            rulePRED_POSITIVE_TOKEN();

            state._fsp--;

             after(grammarAccess.getPRED_POSITIVE_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePRED_POSITIVE_TOKEN"


    // $ANTLR start "rulePRED_POSITIVE_TOKEN"
    // InternalRealop.g:362:1: rulePRED_POSITIVE_TOKEN : ( 'positive' ) ;
    public final void rulePRED_POSITIVE_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:366:2: ( ( 'positive' ) )
            // InternalRealop.g:367:2: ( 'positive' )
            {
            // InternalRealop.g:367:2: ( 'positive' )
            // InternalRealop.g:368:3: 'positive'
            {
             before(grammarAccess.getPRED_POSITIVE_TOKENAccess().getPositiveKeyword()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getPRED_POSITIVE_TOKENAccess().getPositiveKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePRED_POSITIVE_TOKEN"


    // $ANTLR start "entryRulePRED_NEGATIVE_TOKEN"
    // InternalRealop.g:378:1: entryRulePRED_NEGATIVE_TOKEN : rulePRED_NEGATIVE_TOKEN EOF ;
    public final void entryRulePRED_NEGATIVE_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:379:1: ( rulePRED_NEGATIVE_TOKEN EOF )
            // InternalRealop.g:380:1: rulePRED_NEGATIVE_TOKEN EOF
            {
             before(grammarAccess.getPRED_NEGATIVE_TOKENRule()); 
            pushFollow(FOLLOW_1);
            rulePRED_NEGATIVE_TOKEN();

            state._fsp--;

             after(grammarAccess.getPRED_NEGATIVE_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePRED_NEGATIVE_TOKEN"


    // $ANTLR start "rulePRED_NEGATIVE_TOKEN"
    // InternalRealop.g:387:1: rulePRED_NEGATIVE_TOKEN : ( 'negative' ) ;
    public final void rulePRED_NEGATIVE_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:391:2: ( ( 'negative' ) )
            // InternalRealop.g:392:2: ( 'negative' )
            {
            // InternalRealop.g:392:2: ( 'negative' )
            // InternalRealop.g:393:3: 'negative'
            {
             before(grammarAccess.getPRED_NEGATIVE_TOKENAccess().getNegativeKeyword()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getPRED_NEGATIVE_TOKENAccess().getNegativeKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePRED_NEGATIVE_TOKEN"


    // $ANTLR start "entryRuleOP_TOKEN"
    // InternalRealop.g:403:1: entryRuleOP_TOKEN : ruleOP_TOKEN EOF ;
    public final void entryRuleOP_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:404:1: ( ruleOP_TOKEN EOF )
            // InternalRealop.g:405:1: ruleOP_TOKEN EOF
            {
             before(grammarAccess.getOP_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleOP_TOKEN();

            state._fsp--;

             after(grammarAccess.getOP_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOP_TOKEN"


    // $ANTLR start "ruleOP_TOKEN"
    // InternalRealop.g:412:1: ruleOP_TOKEN : ( 'operator' ) ;
    public final void ruleOP_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:416:2: ( ( 'operator' ) )
            // InternalRealop.g:417:2: ( 'operator' )
            {
            // InternalRealop.g:417:2: ( 'operator' )
            // InternalRealop.g:418:3: 'operator'
            {
             before(grammarAccess.getOP_TOKENAccess().getOperatorKeyword()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getOP_TOKENAccess().getOperatorKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOP_TOKEN"


    // $ANTLR start "entryRuleOPEN_OP_TOKEN"
    // InternalRealop.g:428:1: entryRuleOPEN_OP_TOKEN : ruleOPEN_OP_TOKEN EOF ;
    public final void entryRuleOPEN_OP_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:429:1: ( ruleOPEN_OP_TOKEN EOF )
            // InternalRealop.g:430:1: ruleOPEN_OP_TOKEN EOF
            {
             before(grammarAccess.getOPEN_OP_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleOPEN_OP_TOKEN();

            state._fsp--;

             after(grammarAccess.getOPEN_OP_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOPEN_OP_TOKEN"


    // $ANTLR start "ruleOPEN_OP_TOKEN"
    // InternalRealop.g:437:1: ruleOPEN_OP_TOKEN : ( '{' ) ;
    public final void ruleOPEN_OP_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:441:2: ( ( '{' ) )
            // InternalRealop.g:442:2: ( '{' )
            {
            // InternalRealop.g:442:2: ( '{' )
            // InternalRealop.g:443:3: '{'
            {
             before(grammarAccess.getOPEN_OP_TOKENAccess().getLeftCurlyBracketKeyword()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getOPEN_OP_TOKENAccess().getLeftCurlyBracketKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOPEN_OP_TOKEN"


    // $ANTLR start "entryRuleCLOSE_OP_TOKEN"
    // InternalRealop.g:453:1: entryRuleCLOSE_OP_TOKEN : ruleCLOSE_OP_TOKEN EOF ;
    public final void entryRuleCLOSE_OP_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:454:1: ( ruleCLOSE_OP_TOKEN EOF )
            // InternalRealop.g:455:1: ruleCLOSE_OP_TOKEN EOF
            {
             before(grammarAccess.getCLOSE_OP_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleCLOSE_OP_TOKEN();

            state._fsp--;

             after(grammarAccess.getCLOSE_OP_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCLOSE_OP_TOKEN"


    // $ANTLR start "ruleCLOSE_OP_TOKEN"
    // InternalRealop.g:462:1: ruleCLOSE_OP_TOKEN : ( '}' ) ;
    public final void ruleCLOSE_OP_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:466:2: ( ( '}' ) )
            // InternalRealop.g:467:2: ( '}' )
            {
            // InternalRealop.g:467:2: ( '}' )
            // InternalRealop.g:468:3: '}'
            {
             before(grammarAccess.getCLOSE_OP_TOKENAccess().getRightCurlyBracketKeyword()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getCLOSE_OP_TOKENAccess().getRightCurlyBracketKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCLOSE_OP_TOKEN"


    // $ANTLR start "entryRulePRE_TOKEN"
    // InternalRealop.g:478:1: entryRulePRE_TOKEN : rulePRE_TOKEN EOF ;
    public final void entryRulePRE_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:479:1: ( rulePRE_TOKEN EOF )
            // InternalRealop.g:480:1: rulePRE_TOKEN EOF
            {
             before(grammarAccess.getPRE_TOKENRule()); 
            pushFollow(FOLLOW_1);
            rulePRE_TOKEN();

            state._fsp--;

             after(grammarAccess.getPRE_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePRE_TOKEN"


    // $ANTLR start "rulePRE_TOKEN"
    // InternalRealop.g:487:1: rulePRE_TOKEN : ( 'pre' ) ;
    public final void rulePRE_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:491:2: ( ( 'pre' ) )
            // InternalRealop.g:492:2: ( 'pre' )
            {
            // InternalRealop.g:492:2: ( 'pre' )
            // InternalRealop.g:493:3: 'pre'
            {
             before(grammarAccess.getPRE_TOKENAccess().getPreKeyword()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getPRE_TOKENAccess().getPreKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePRE_TOKEN"


    // $ANTLR start "entryRulePOST_TOKEN"
    // InternalRealop.g:503:1: entryRulePOST_TOKEN : rulePOST_TOKEN EOF ;
    public final void entryRulePOST_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:504:1: ( rulePOST_TOKEN EOF )
            // InternalRealop.g:505:1: rulePOST_TOKEN EOF
            {
             before(grammarAccess.getPOST_TOKENRule()); 
            pushFollow(FOLLOW_1);
            rulePOST_TOKEN();

            state._fsp--;

             after(grammarAccess.getPOST_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePOST_TOKEN"


    // $ANTLR start "rulePOST_TOKEN"
    // InternalRealop.g:512:1: rulePOST_TOKEN : ( 'post' ) ;
    public final void rulePOST_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:516:2: ( ( 'post' ) )
            // InternalRealop.g:517:2: ( 'post' )
            {
            // InternalRealop.g:517:2: ( 'post' )
            // InternalRealop.g:518:3: 'post'
            {
             before(grammarAccess.getPOST_TOKENAccess().getPostKeyword()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getPOST_TOKENAccess().getPostKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePOST_TOKEN"


    // $ANTLR start "entryRuleCOND_ST_TOKEN"
    // InternalRealop.g:528:1: entryRuleCOND_ST_TOKEN : ruleCOND_ST_TOKEN EOF ;
    public final void entryRuleCOND_ST_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:529:1: ( ruleCOND_ST_TOKEN EOF )
            // InternalRealop.g:530:1: ruleCOND_ST_TOKEN EOF
            {
             before(grammarAccess.getCOND_ST_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleCOND_ST_TOKEN();

            state._fsp--;

             after(grammarAccess.getCOND_ST_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCOND_ST_TOKEN"


    // $ANTLR start "ruleCOND_ST_TOKEN"
    // InternalRealop.g:537:1: ruleCOND_ST_TOKEN : ( ':' ) ;
    public final void ruleCOND_ST_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:541:2: ( ( ':' ) )
            // InternalRealop.g:542:2: ( ':' )
            {
            // InternalRealop.g:542:2: ( ':' )
            // InternalRealop.g:543:3: ':'
            {
             before(grammarAccess.getCOND_ST_TOKENAccess().getColonKeyword()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getCOND_ST_TOKENAccess().getColonKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCOND_ST_TOKEN"


    // $ANTLR start "entryRuleCOND_END_TOKEN"
    // InternalRealop.g:553:1: entryRuleCOND_END_TOKEN : ruleCOND_END_TOKEN EOF ;
    public final void entryRuleCOND_END_TOKEN() throws RecognitionException {
        try {
            // InternalRealop.g:554:1: ( ruleCOND_END_TOKEN EOF )
            // InternalRealop.g:555:1: ruleCOND_END_TOKEN EOF
            {
             before(grammarAccess.getCOND_END_TOKENRule()); 
            pushFollow(FOLLOW_1);
            ruleCOND_END_TOKEN();

            state._fsp--;

             after(grammarAccess.getCOND_END_TOKENRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCOND_END_TOKEN"


    // $ANTLR start "ruleCOND_END_TOKEN"
    // InternalRealop.g:562:1: ruleCOND_END_TOKEN : ( ';' ) ;
    public final void ruleCOND_END_TOKEN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:566:2: ( ( ';' ) )
            // InternalRealop.g:567:2: ( ';' )
            {
            // InternalRealop.g:567:2: ( ';' )
            // InternalRealop.g:568:3: ';'
            {
             before(grammarAccess.getCOND_END_TOKENAccess().getSemicolonKeyword()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getCOND_END_TOKENAccess().getSemicolonKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCOND_END_TOKEN"


    // $ANTLR start "rule__Logic__Alternatives"
    // InternalRealop.g:577:1: rule__Logic__Alternatives : ( ( ( rule__Logic__AndAssignment_0 ) ) | ( ( rule__Logic__OrAssignment_1 ) ) | ( ( rule__Logic__XorAssignment_2 ) ) );
    public final void rule__Logic__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:581:1: ( ( ( rule__Logic__AndAssignment_0 ) ) | ( ( rule__Logic__OrAssignment_1 ) ) | ( ( rule__Logic__XorAssignment_2 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt2=1;
                }
                break;
            case 13:
                {
                alt2=2;
                }
                break;
            case 14:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalRealop.g:582:2: ( ( rule__Logic__AndAssignment_0 ) )
                    {
                    // InternalRealop.g:582:2: ( ( rule__Logic__AndAssignment_0 ) )
                    // InternalRealop.g:583:3: ( rule__Logic__AndAssignment_0 )
                    {
                     before(grammarAccess.getLogicAccess().getAndAssignment_0()); 
                    // InternalRealop.g:584:3: ( rule__Logic__AndAssignment_0 )
                    // InternalRealop.g:584:4: rule__Logic__AndAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Logic__AndAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLogicAccess().getAndAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRealop.g:588:2: ( ( rule__Logic__OrAssignment_1 ) )
                    {
                    // InternalRealop.g:588:2: ( ( rule__Logic__OrAssignment_1 ) )
                    // InternalRealop.g:589:3: ( rule__Logic__OrAssignment_1 )
                    {
                     before(grammarAccess.getLogicAccess().getOrAssignment_1()); 
                    // InternalRealop.g:590:3: ( rule__Logic__OrAssignment_1 )
                    // InternalRealop.g:590:4: rule__Logic__OrAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Logic__OrAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLogicAccess().getOrAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRealop.g:594:2: ( ( rule__Logic__XorAssignment_2 ) )
                    {
                    // InternalRealop.g:594:2: ( ( rule__Logic__XorAssignment_2 ) )
                    // InternalRealop.g:595:3: ( rule__Logic__XorAssignment_2 )
                    {
                     before(grammarAccess.getLogicAccess().getXorAssignment_2()); 
                    // InternalRealop.g:596:3: ( rule__Logic__XorAssignment_2 )
                    // InternalRealop.g:596:4: rule__Logic__XorAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Logic__XorAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getLogicAccess().getXorAssignment_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logic__Alternatives"


    // $ANTLR start "rule__Predicates__Alternatives"
    // InternalRealop.g:604:1: rule__Predicates__Alternatives : ( ( ( rule__Predicates__RealisedAssignment_0 ) ) | ( ( rule__Predicates__PositiveAssignment_1 ) ) | ( ( rule__Predicates__NegativeAssignment_2 ) ) );
    public final void rule__Predicates__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:608:1: ( ( ( rule__Predicates__RealisedAssignment_0 ) ) | ( ( rule__Predicates__PositiveAssignment_1 ) ) | ( ( rule__Predicates__NegativeAssignment_2 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalRealop.g:609:2: ( ( rule__Predicates__RealisedAssignment_0 ) )
                    {
                    // InternalRealop.g:609:2: ( ( rule__Predicates__RealisedAssignment_0 ) )
                    // InternalRealop.g:610:3: ( rule__Predicates__RealisedAssignment_0 )
                    {
                     before(grammarAccess.getPredicatesAccess().getRealisedAssignment_0()); 
                    // InternalRealop.g:611:3: ( rule__Predicates__RealisedAssignment_0 )
                    // InternalRealop.g:611:4: rule__Predicates__RealisedAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Predicates__RealisedAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatesAccess().getRealisedAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRealop.g:615:2: ( ( rule__Predicates__PositiveAssignment_1 ) )
                    {
                    // InternalRealop.g:615:2: ( ( rule__Predicates__PositiveAssignment_1 ) )
                    // InternalRealop.g:616:3: ( rule__Predicates__PositiveAssignment_1 )
                    {
                     before(grammarAccess.getPredicatesAccess().getPositiveAssignment_1()); 
                    // InternalRealop.g:617:3: ( rule__Predicates__PositiveAssignment_1 )
                    // InternalRealop.g:617:4: rule__Predicates__PositiveAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Predicates__PositiveAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatesAccess().getPositiveAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRealop.g:621:2: ( ( rule__Predicates__NegativeAssignment_2 ) )
                    {
                    // InternalRealop.g:621:2: ( ( rule__Predicates__NegativeAssignment_2 ) )
                    // InternalRealop.g:622:3: ( rule__Predicates__NegativeAssignment_2 )
                    {
                     before(grammarAccess.getPredicatesAccess().getNegativeAssignment_2()); 
                    // InternalRealop.g:623:3: ( rule__Predicates__NegativeAssignment_2 )
                    // InternalRealop.g:623:4: rule__Predicates__NegativeAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Predicates__NegativeAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatesAccess().getNegativeAssignment_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicates__Alternatives"


    // $ANTLR start "rule__Operator__Group__0"
    // InternalRealop.g:631:1: rule__Operator__Group__0 : rule__Operator__Group__0__Impl rule__Operator__Group__1 ;
    public final void rule__Operator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:635:1: ( rule__Operator__Group__0__Impl rule__Operator__Group__1 )
            // InternalRealop.g:636:2: rule__Operator__Group__0__Impl rule__Operator__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Operator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__0"


    // $ANTLR start "rule__Operator__Group__0__Impl"
    // InternalRealop.g:643:1: rule__Operator__Group__0__Impl : ( ruleOP_TOKEN ) ;
    public final void rule__Operator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:647:1: ( ( ruleOP_TOKEN ) )
            // InternalRealop.g:648:1: ( ruleOP_TOKEN )
            {
            // InternalRealop.g:648:1: ( ruleOP_TOKEN )
            // InternalRealop.g:649:2: ruleOP_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getOP_TOKENParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOP_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getOP_TOKENParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__0__Impl"


    // $ANTLR start "rule__Operator__Group__1"
    // InternalRealop.g:658:1: rule__Operator__Group__1 : rule__Operator__Group__1__Impl rule__Operator__Group__2 ;
    public final void rule__Operator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:662:1: ( rule__Operator__Group__1__Impl rule__Operator__Group__2 )
            // InternalRealop.g:663:2: rule__Operator__Group__1__Impl rule__Operator__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Operator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__1"


    // $ANTLR start "rule__Operator__Group__1__Impl"
    // InternalRealop.g:670:1: rule__Operator__Group__1__Impl : ( ( rule__Operator__NameAssignment_1 ) ) ;
    public final void rule__Operator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:674:1: ( ( ( rule__Operator__NameAssignment_1 ) ) )
            // InternalRealop.g:675:1: ( ( rule__Operator__NameAssignment_1 ) )
            {
            // InternalRealop.g:675:1: ( ( rule__Operator__NameAssignment_1 ) )
            // InternalRealop.g:676:2: ( rule__Operator__NameAssignment_1 )
            {
             before(grammarAccess.getOperatorAccess().getNameAssignment_1()); 
            // InternalRealop.g:677:2: ( rule__Operator__NameAssignment_1 )
            // InternalRealop.g:677:3: rule__Operator__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Operator__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__1__Impl"


    // $ANTLR start "rule__Operator__Group__2"
    // InternalRealop.g:685:1: rule__Operator__Group__2 : rule__Operator__Group__2__Impl rule__Operator__Group__3 ;
    public final void rule__Operator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:689:1: ( rule__Operator__Group__2__Impl rule__Operator__Group__3 )
            // InternalRealop.g:690:2: rule__Operator__Group__2__Impl rule__Operator__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Operator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__2"


    // $ANTLR start "rule__Operator__Group__2__Impl"
    // InternalRealop.g:697:1: rule__Operator__Group__2__Impl : ( ruleOPEN_OP_TOKEN ) ;
    public final void rule__Operator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:701:1: ( ( ruleOPEN_OP_TOKEN ) )
            // InternalRealop.g:702:1: ( ruleOPEN_OP_TOKEN )
            {
            // InternalRealop.g:702:1: ( ruleOPEN_OP_TOKEN )
            // InternalRealop.g:703:2: ruleOPEN_OP_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getOPEN_OP_TOKENParserRuleCall_2()); 
            pushFollow(FOLLOW_2);
            ruleOPEN_OP_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getOPEN_OP_TOKENParserRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__2__Impl"


    // $ANTLR start "rule__Operator__Group__3"
    // InternalRealop.g:712:1: rule__Operator__Group__3 : rule__Operator__Group__3__Impl rule__Operator__Group__4 ;
    public final void rule__Operator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:716:1: ( rule__Operator__Group__3__Impl rule__Operator__Group__4 )
            // InternalRealop.g:717:2: rule__Operator__Group__3__Impl rule__Operator__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Operator__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__3"


    // $ANTLR start "rule__Operator__Group__3__Impl"
    // InternalRealop.g:724:1: rule__Operator__Group__3__Impl : ( rulePRE_TOKEN ) ;
    public final void rule__Operator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:728:1: ( ( rulePRE_TOKEN ) )
            // InternalRealop.g:729:1: ( rulePRE_TOKEN )
            {
            // InternalRealop.g:729:1: ( rulePRE_TOKEN )
            // InternalRealop.g:730:2: rulePRE_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getPRE_TOKENParserRuleCall_3()); 
            pushFollow(FOLLOW_2);
            rulePRE_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getPRE_TOKENParserRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__3__Impl"


    // $ANTLR start "rule__Operator__Group__4"
    // InternalRealop.g:739:1: rule__Operator__Group__4 : rule__Operator__Group__4__Impl rule__Operator__Group__5 ;
    public final void rule__Operator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:743:1: ( rule__Operator__Group__4__Impl rule__Operator__Group__5 )
            // InternalRealop.g:744:2: rule__Operator__Group__4__Impl rule__Operator__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Operator__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__4"


    // $ANTLR start "rule__Operator__Group__4__Impl"
    // InternalRealop.g:751:1: rule__Operator__Group__4__Impl : ( ruleCOND_ST_TOKEN ) ;
    public final void rule__Operator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:755:1: ( ( ruleCOND_ST_TOKEN ) )
            // InternalRealop.g:756:1: ( ruleCOND_ST_TOKEN )
            {
            // InternalRealop.g:756:1: ( ruleCOND_ST_TOKEN )
            // InternalRealop.g:757:2: ruleCOND_ST_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_4()); 
            pushFollow(FOLLOW_2);
            ruleCOND_ST_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__4__Impl"


    // $ANTLR start "rule__Operator__Group__5"
    // InternalRealop.g:766:1: rule__Operator__Group__5 : rule__Operator__Group__5__Impl rule__Operator__Group__6 ;
    public final void rule__Operator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:770:1: ( rule__Operator__Group__5__Impl rule__Operator__Group__6 )
            // InternalRealop.g:771:2: rule__Operator__Group__5__Impl rule__Operator__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Operator__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__5"


    // $ANTLR start "rule__Operator__Group__5__Impl"
    // InternalRealop.g:778:1: rule__Operator__Group__5__Impl : ( ( rule__Operator__Exp_preAssignment_5 ) ) ;
    public final void rule__Operator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:782:1: ( ( ( rule__Operator__Exp_preAssignment_5 ) ) )
            // InternalRealop.g:783:1: ( ( rule__Operator__Exp_preAssignment_5 ) )
            {
            // InternalRealop.g:783:1: ( ( rule__Operator__Exp_preAssignment_5 ) )
            // InternalRealop.g:784:2: ( rule__Operator__Exp_preAssignment_5 )
            {
             before(grammarAccess.getOperatorAccess().getExp_preAssignment_5()); 
            // InternalRealop.g:785:2: ( rule__Operator__Exp_preAssignment_5 )
            // InternalRealop.g:785:3: rule__Operator__Exp_preAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Exp_preAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getExp_preAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__5__Impl"


    // $ANTLR start "rule__Operator__Group__6"
    // InternalRealop.g:793:1: rule__Operator__Group__6 : rule__Operator__Group__6__Impl rule__Operator__Group__7 ;
    public final void rule__Operator__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:797:1: ( rule__Operator__Group__6__Impl rule__Operator__Group__7 )
            // InternalRealop.g:798:2: rule__Operator__Group__6__Impl rule__Operator__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Operator__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__6"


    // $ANTLR start "rule__Operator__Group__6__Impl"
    // InternalRealop.g:805:1: rule__Operator__Group__6__Impl : ( ruleCOND_END_TOKEN ) ;
    public final void rule__Operator__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:809:1: ( ( ruleCOND_END_TOKEN ) )
            // InternalRealop.g:810:1: ( ruleCOND_END_TOKEN )
            {
            // InternalRealop.g:810:1: ( ruleCOND_END_TOKEN )
            // InternalRealop.g:811:2: ruleCOND_END_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_6()); 
            pushFollow(FOLLOW_2);
            ruleCOND_END_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__6__Impl"


    // $ANTLR start "rule__Operator__Group__7"
    // InternalRealop.g:820:1: rule__Operator__Group__7 : rule__Operator__Group__7__Impl rule__Operator__Group__8 ;
    public final void rule__Operator__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:824:1: ( rule__Operator__Group__7__Impl rule__Operator__Group__8 )
            // InternalRealop.g:825:2: rule__Operator__Group__7__Impl rule__Operator__Group__8
            {
            pushFollow(FOLLOW_7);
            rule__Operator__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__7"


    // $ANTLR start "rule__Operator__Group__7__Impl"
    // InternalRealop.g:832:1: rule__Operator__Group__7__Impl : ( rulePOST_TOKEN ) ;
    public final void rule__Operator__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:836:1: ( ( rulePOST_TOKEN ) )
            // InternalRealop.g:837:1: ( rulePOST_TOKEN )
            {
            // InternalRealop.g:837:1: ( rulePOST_TOKEN )
            // InternalRealop.g:838:2: rulePOST_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getPOST_TOKENParserRuleCall_7()); 
            pushFollow(FOLLOW_2);
            rulePOST_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getPOST_TOKENParserRuleCall_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__7__Impl"


    // $ANTLR start "rule__Operator__Group__8"
    // InternalRealop.g:847:1: rule__Operator__Group__8 : rule__Operator__Group__8__Impl rule__Operator__Group__9 ;
    public final void rule__Operator__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:851:1: ( rule__Operator__Group__8__Impl rule__Operator__Group__9 )
            // InternalRealop.g:852:2: rule__Operator__Group__8__Impl rule__Operator__Group__9
            {
            pushFollow(FOLLOW_8);
            rule__Operator__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__8"


    // $ANTLR start "rule__Operator__Group__8__Impl"
    // InternalRealop.g:859:1: rule__Operator__Group__8__Impl : ( ruleCOND_ST_TOKEN ) ;
    public final void rule__Operator__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:863:1: ( ( ruleCOND_ST_TOKEN ) )
            // InternalRealop.g:864:1: ( ruleCOND_ST_TOKEN )
            {
            // InternalRealop.g:864:1: ( ruleCOND_ST_TOKEN )
            // InternalRealop.g:865:2: ruleCOND_ST_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_8()); 
            pushFollow(FOLLOW_2);
            ruleCOND_ST_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__8__Impl"


    // $ANTLR start "rule__Operator__Group__9"
    // InternalRealop.g:874:1: rule__Operator__Group__9 : rule__Operator__Group__9__Impl rule__Operator__Group__10 ;
    public final void rule__Operator__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:878:1: ( rule__Operator__Group__9__Impl rule__Operator__Group__10 )
            // InternalRealop.g:879:2: rule__Operator__Group__9__Impl rule__Operator__Group__10
            {
            pushFollow(FOLLOW_9);
            rule__Operator__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__9"


    // $ANTLR start "rule__Operator__Group__9__Impl"
    // InternalRealop.g:886:1: rule__Operator__Group__9__Impl : ( ( rule__Operator__Exp_postAssignment_9 ) ) ;
    public final void rule__Operator__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:890:1: ( ( ( rule__Operator__Exp_postAssignment_9 ) ) )
            // InternalRealop.g:891:1: ( ( rule__Operator__Exp_postAssignment_9 ) )
            {
            // InternalRealop.g:891:1: ( ( rule__Operator__Exp_postAssignment_9 ) )
            // InternalRealop.g:892:2: ( rule__Operator__Exp_postAssignment_9 )
            {
             before(grammarAccess.getOperatorAccess().getExp_postAssignment_9()); 
            // InternalRealop.g:893:2: ( rule__Operator__Exp_postAssignment_9 )
            // InternalRealop.g:893:3: rule__Operator__Exp_postAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Exp_postAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getExp_postAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__9__Impl"


    // $ANTLR start "rule__Operator__Group__10"
    // InternalRealop.g:901:1: rule__Operator__Group__10 : rule__Operator__Group__10__Impl rule__Operator__Group__11 ;
    public final void rule__Operator__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:905:1: ( rule__Operator__Group__10__Impl rule__Operator__Group__11 )
            // InternalRealop.g:906:2: rule__Operator__Group__10__Impl rule__Operator__Group__11
            {
            pushFollow(FOLLOW_11);
            rule__Operator__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__10"


    // $ANTLR start "rule__Operator__Group__10__Impl"
    // InternalRealop.g:913:1: rule__Operator__Group__10__Impl : ( ruleCOND_END_TOKEN ) ;
    public final void rule__Operator__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:917:1: ( ( ruleCOND_END_TOKEN ) )
            // InternalRealop.g:918:1: ( ruleCOND_END_TOKEN )
            {
            // InternalRealop.g:918:1: ( ruleCOND_END_TOKEN )
            // InternalRealop.g:919:2: ruleCOND_END_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_10()); 
            pushFollow(FOLLOW_2);
            ruleCOND_END_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__10__Impl"


    // $ANTLR start "rule__Operator__Group__11"
    // InternalRealop.g:928:1: rule__Operator__Group__11 : rule__Operator__Group__11__Impl ;
    public final void rule__Operator__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:932:1: ( rule__Operator__Group__11__Impl )
            // InternalRealop.g:933:2: rule__Operator__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__11"


    // $ANTLR start "rule__Operator__Group__11__Impl"
    // InternalRealop.g:939:1: rule__Operator__Group__11__Impl : ( ruleCLOSE_OP_TOKEN ) ;
    public final void rule__Operator__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:943:1: ( ( ruleCLOSE_OP_TOKEN ) )
            // InternalRealop.g:944:1: ( ruleCLOSE_OP_TOKEN )
            {
            // InternalRealop.g:944:1: ( ruleCLOSE_OP_TOKEN )
            // InternalRealop.g:945:2: ruleCLOSE_OP_TOKEN
            {
             before(grammarAccess.getOperatorAccess().getCLOSE_OP_TOKENParserRuleCall_11()); 
            pushFollow(FOLLOW_2);
            ruleCLOSE_OP_TOKEN();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getCLOSE_OP_TOKENParserRuleCall_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group__11__Impl"


    // $ANTLR start "rule__Expression__Group__0"
    // InternalRealop.g:955:1: rule__Expression__Group__0 : rule__Expression__Group__0__Impl rule__Expression__Group__1 ;
    public final void rule__Expression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:959:1: ( rule__Expression__Group__0__Impl rule__Expression__Group__1 )
            // InternalRealop.g:960:2: rule__Expression__Group__0__Impl rule__Expression__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Expression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group__0"


    // $ANTLR start "rule__Expression__Group__0__Impl"
    // InternalRealop.g:967:1: rule__Expression__Group__0__Impl : ( ( rule__Expression__LhsAssignment_0 ) ) ;
    public final void rule__Expression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:971:1: ( ( ( rule__Expression__LhsAssignment_0 ) ) )
            // InternalRealop.g:972:1: ( ( rule__Expression__LhsAssignment_0 ) )
            {
            // InternalRealop.g:972:1: ( ( rule__Expression__LhsAssignment_0 ) )
            // InternalRealop.g:973:2: ( rule__Expression__LhsAssignment_0 )
            {
             before(grammarAccess.getExpressionAccess().getLhsAssignment_0()); 
            // InternalRealop.g:974:2: ( rule__Expression__LhsAssignment_0 )
            // InternalRealop.g:974:3: rule__Expression__LhsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Expression__LhsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getLhsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group__0__Impl"


    // $ANTLR start "rule__Expression__Group__1"
    // InternalRealop.g:982:1: rule__Expression__Group__1 : rule__Expression__Group__1__Impl ;
    public final void rule__Expression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:986:1: ( rule__Expression__Group__1__Impl )
            // InternalRealop.g:987:2: rule__Expression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group__1"


    // $ANTLR start "rule__Expression__Group__1__Impl"
    // InternalRealop.g:993:1: rule__Expression__Group__1__Impl : ( ( rule__Expression__RhsAssignment_1 )? ) ;
    public final void rule__Expression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:997:1: ( ( ( rule__Expression__RhsAssignment_1 )? ) )
            // InternalRealop.g:998:1: ( ( rule__Expression__RhsAssignment_1 )? )
            {
            // InternalRealop.g:998:1: ( ( rule__Expression__RhsAssignment_1 )? )
            // InternalRealop.g:999:2: ( rule__Expression__RhsAssignment_1 )?
            {
             before(grammarAccess.getExpressionAccess().getRhsAssignment_1()); 
            // InternalRealop.g:1000:2: ( rule__Expression__RhsAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=12 && LA4_0<=14)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRealop.g:1000:3: rule__Expression__RhsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__RhsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExpressionAccess().getRhsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group__0"
    // InternalRealop.g:1009:1: rule__TerminalExpression__Group__0 : rule__TerminalExpression__Group__0__Impl rule__TerminalExpression__Group__1 ;
    public final void rule__TerminalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1013:1: ( rule__TerminalExpression__Group__0__Impl rule__TerminalExpression__Group__1 )
            // InternalRealop.g:1014:2: rule__TerminalExpression__Group__0__Impl rule__TerminalExpression__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__TerminalExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group__0"


    // $ANTLR start "rule__TerminalExpression__Group__0__Impl"
    // InternalRealop.g:1021:1: rule__TerminalExpression__Group__0__Impl : ( ( rule__TerminalExpression__OpAssignment_0 ) ) ;
    public final void rule__TerminalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1025:1: ( ( ( rule__TerminalExpression__OpAssignment_0 ) ) )
            // InternalRealop.g:1026:1: ( ( rule__TerminalExpression__OpAssignment_0 ) )
            {
            // InternalRealop.g:1026:1: ( ( rule__TerminalExpression__OpAssignment_0 ) )
            // InternalRealop.g:1027:2: ( rule__TerminalExpression__OpAssignment_0 )
            {
             before(grammarAccess.getTerminalExpressionAccess().getOpAssignment_0()); 
            // InternalRealop.g:1028:2: ( rule__TerminalExpression__OpAssignment_0 )
            // InternalRealop.g:1028:3: rule__TerminalExpression__OpAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__OpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group__1"
    // InternalRealop.g:1036:1: rule__TerminalExpression__Group__1 : rule__TerminalExpression__Group__1__Impl ;
    public final void rule__TerminalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1040:1: ( rule__TerminalExpression__Group__1__Impl )
            // InternalRealop.g:1041:2: rule__TerminalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group__1"


    // $ANTLR start "rule__TerminalExpression__Group__1__Impl"
    // InternalRealop.g:1047:1: rule__TerminalExpression__Group__1__Impl : ( ( rule__TerminalExpression__RhsAssignment_1 ) ) ;
    public final void rule__TerminalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1051:1: ( ( ( rule__TerminalExpression__RhsAssignment_1 ) ) )
            // InternalRealop.g:1052:1: ( ( rule__TerminalExpression__RhsAssignment_1 ) )
            {
            // InternalRealop.g:1052:1: ( ( rule__TerminalExpression__RhsAssignment_1 ) )
            // InternalRealop.g:1053:2: ( rule__TerminalExpression__RhsAssignment_1 )
            {
             before(grammarAccess.getTerminalExpressionAccess().getRhsAssignment_1()); 
            // InternalRealop.g:1054:2: ( rule__TerminalExpression__RhsAssignment_1 )
            // InternalRealop.g:1054:3: rule__TerminalExpression__RhsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__RhsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getRhsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group__1__Impl"


    // $ANTLR start "rule__Predicate__Group__0"
    // InternalRealop.g:1063:1: rule__Predicate__Group__0 : rule__Predicate__Group__0__Impl rule__Predicate__Group__1 ;
    public final void rule__Predicate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1067:1: ( rule__Predicate__Group__0__Impl rule__Predicate__Group__1 )
            // InternalRealop.g:1068:2: rule__Predicate__Group__0__Impl rule__Predicate__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Predicate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Predicate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__0"


    // $ANTLR start "rule__Predicate__Group__0__Impl"
    // InternalRealop.g:1075:1: rule__Predicate__Group__0__Impl : ( ( rule__Predicate__NegatedAssignment_0 )? ) ;
    public final void rule__Predicate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1079:1: ( ( ( rule__Predicate__NegatedAssignment_0 )? ) )
            // InternalRealop.g:1080:1: ( ( rule__Predicate__NegatedAssignment_0 )? )
            {
            // InternalRealop.g:1080:1: ( ( rule__Predicate__NegatedAssignment_0 )? )
            // InternalRealop.g:1081:2: ( rule__Predicate__NegatedAssignment_0 )?
            {
             before(grammarAccess.getPredicateAccess().getNegatedAssignment_0()); 
            // InternalRealop.g:1082:2: ( rule__Predicate__NegatedAssignment_0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalRealop.g:1082:3: rule__Predicate__NegatedAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Predicate__NegatedAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPredicateAccess().getNegatedAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__0__Impl"


    // $ANTLR start "rule__Predicate__Group__1"
    // InternalRealop.g:1090:1: rule__Predicate__Group__1 : rule__Predicate__Group__1__Impl rule__Predicate__Group__2 ;
    public final void rule__Predicate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1094:1: ( rule__Predicate__Group__1__Impl rule__Predicate__Group__2 )
            // InternalRealop.g:1095:2: rule__Predicate__Group__1__Impl rule__Predicate__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Predicate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Predicate__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__1"


    // $ANTLR start "rule__Predicate__Group__1__Impl"
    // InternalRealop.g:1102:1: rule__Predicate__Group__1__Impl : ( ( rule__Predicate__PredicateAssignment_1 ) ) ;
    public final void rule__Predicate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1106:1: ( ( ( rule__Predicate__PredicateAssignment_1 ) ) )
            // InternalRealop.g:1107:1: ( ( rule__Predicate__PredicateAssignment_1 ) )
            {
            // InternalRealop.g:1107:1: ( ( rule__Predicate__PredicateAssignment_1 ) )
            // InternalRealop.g:1108:2: ( rule__Predicate__PredicateAssignment_1 )
            {
             before(grammarAccess.getPredicateAccess().getPredicateAssignment_1()); 
            // InternalRealop.g:1109:2: ( rule__Predicate__PredicateAssignment_1 )
            // InternalRealop.g:1109:3: rule__Predicate__PredicateAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__PredicateAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicateAccess().getPredicateAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__1__Impl"


    // $ANTLR start "rule__Predicate__Group__2"
    // InternalRealop.g:1117:1: rule__Predicate__Group__2 : rule__Predicate__Group__2__Impl rule__Predicate__Group__3 ;
    public final void rule__Predicate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1121:1: ( rule__Predicate__Group__2__Impl rule__Predicate__Group__3 )
            // InternalRealop.g:1122:2: rule__Predicate__Group__2__Impl rule__Predicate__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Predicate__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Predicate__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__2"


    // $ANTLR start "rule__Predicate__Group__2__Impl"
    // InternalRealop.g:1129:1: rule__Predicate__Group__2__Impl : ( '(' ) ;
    public final void rule__Predicate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1133:1: ( ( '(' ) )
            // InternalRealop.g:1134:1: ( '(' )
            {
            // InternalRealop.g:1134:1: ( '(' )
            // InternalRealop.g:1135:2: '('
            {
             before(grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__2__Impl"


    // $ANTLR start "rule__Predicate__Group__3"
    // InternalRealop.g:1144:1: rule__Predicate__Group__3 : rule__Predicate__Group__3__Impl rule__Predicate__Group__4 ;
    public final void rule__Predicate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1148:1: ( rule__Predicate__Group__3__Impl rule__Predicate__Group__4 )
            // InternalRealop.g:1149:2: rule__Predicate__Group__3__Impl rule__Predicate__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__Predicate__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Predicate__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__3"


    // $ANTLR start "rule__Predicate__Group__3__Impl"
    // InternalRealop.g:1156:1: rule__Predicate__Group__3__Impl : ( ( rule__Predicate__NameAssignment_3 ) ) ;
    public final void rule__Predicate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1160:1: ( ( ( rule__Predicate__NameAssignment_3 ) ) )
            // InternalRealop.g:1161:1: ( ( rule__Predicate__NameAssignment_3 ) )
            {
            // InternalRealop.g:1161:1: ( ( rule__Predicate__NameAssignment_3 ) )
            // InternalRealop.g:1162:2: ( rule__Predicate__NameAssignment_3 )
            {
             before(grammarAccess.getPredicateAccess().getNameAssignment_3()); 
            // InternalRealop.g:1163:2: ( rule__Predicate__NameAssignment_3 )
            // InternalRealop.g:1163:3: rule__Predicate__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPredicateAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__3__Impl"


    // $ANTLR start "rule__Predicate__Group__4"
    // InternalRealop.g:1171:1: rule__Predicate__Group__4 : rule__Predicate__Group__4__Impl ;
    public final void rule__Predicate__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1175:1: ( rule__Predicate__Group__4__Impl )
            // InternalRealop.g:1176:2: rule__Predicate__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__4"


    // $ANTLR start "rule__Predicate__Group__4__Impl"
    // InternalRealop.g:1182:1: rule__Predicate__Group__4__Impl : ( ')' ) ;
    public final void rule__Predicate__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1186:1: ( ( ')' ) )
            // InternalRealop.g:1187:1: ( ')' )
            {
            // InternalRealop.g:1187:1: ( ')' )
            // InternalRealop.g:1188:2: ')'
            {
             before(grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__4__Impl"


    // $ANTLR start "rule__Realop__OperatorAssignment"
    // InternalRealop.g:1198:1: rule__Realop__OperatorAssignment : ( ruleOperator ) ;
    public final void rule__Realop__OperatorAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1202:1: ( ( ruleOperator ) )
            // InternalRealop.g:1203:2: ( ruleOperator )
            {
            // InternalRealop.g:1203:2: ( ruleOperator )
            // InternalRealop.g:1204:3: ruleOperator
            {
             before(grammarAccess.getRealopAccess().getOperatorOperatorParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getRealopAccess().getOperatorOperatorParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Realop__OperatorAssignment"


    // $ANTLR start "rule__Operator__NameAssignment_1"
    // InternalRealop.g:1213:1: rule__Operator__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Operator__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1217:1: ( ( RULE_ID ) )
            // InternalRealop.g:1218:2: ( RULE_ID )
            {
            // InternalRealop.g:1218:2: ( RULE_ID )
            // InternalRealop.g:1219:3: RULE_ID
            {
             before(grammarAccess.getOperatorAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOperatorAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__NameAssignment_1"


    // $ANTLR start "rule__Operator__Exp_preAssignment_5"
    // InternalRealop.g:1228:1: rule__Operator__Exp_preAssignment_5 : ( ruleExpression ) ;
    public final void rule__Operator__Exp_preAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1232:1: ( ( ruleExpression ) )
            // InternalRealop.g:1233:2: ( ruleExpression )
            {
            // InternalRealop.g:1233:2: ( ruleExpression )
            // InternalRealop.g:1234:3: ruleExpression
            {
             before(grammarAccess.getOperatorAccess().getExp_preExpressionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getExp_preExpressionParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Exp_preAssignment_5"


    // $ANTLR start "rule__Operator__Exp_postAssignment_9"
    // InternalRealop.g:1243:1: rule__Operator__Exp_postAssignment_9 : ( ruleExpression ) ;
    public final void rule__Operator__Exp_postAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1247:1: ( ( ruleExpression ) )
            // InternalRealop.g:1248:2: ( ruleExpression )
            {
            // InternalRealop.g:1248:2: ( ruleExpression )
            // InternalRealop.g:1249:3: ruleExpression
            {
             before(grammarAccess.getOperatorAccess().getExp_postExpressionParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getOperatorAccess().getExp_postExpressionParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Exp_postAssignment_9"


    // $ANTLR start "rule__Expression__LhsAssignment_0"
    // InternalRealop.g:1258:1: rule__Expression__LhsAssignment_0 : ( rulePredicate ) ;
    public final void rule__Expression__LhsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1262:1: ( ( rulePredicate ) )
            // InternalRealop.g:1263:2: ( rulePredicate )
            {
            // InternalRealop.g:1263:2: ( rulePredicate )
            // InternalRealop.g:1264:3: rulePredicate
            {
             before(grammarAccess.getExpressionAccess().getLhsPredicateParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePredicate();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getLhsPredicateParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__LhsAssignment_0"


    // $ANTLR start "rule__Expression__RhsAssignment_1"
    // InternalRealop.g:1273:1: rule__Expression__RhsAssignment_1 : ( ruleTerminalExpression ) ;
    public final void rule__Expression__RhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1277:1: ( ( ruleTerminalExpression ) )
            // InternalRealop.g:1278:2: ( ruleTerminalExpression )
            {
            // InternalRealop.g:1278:2: ( ruleTerminalExpression )
            // InternalRealop.g:1279:3: ruleTerminalExpression
            {
             before(grammarAccess.getExpressionAccess().getRhsTerminalExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerminalExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getRhsTerminalExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__RhsAssignment_1"


    // $ANTLR start "rule__TerminalExpression__OpAssignment_0"
    // InternalRealop.g:1288:1: rule__TerminalExpression__OpAssignment_0 : ( ruleLogic ) ;
    public final void rule__TerminalExpression__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1292:1: ( ( ruleLogic ) )
            // InternalRealop.g:1293:2: ( ruleLogic )
            {
            // InternalRealop.g:1293:2: ( ruleLogic )
            // InternalRealop.g:1294:3: ruleLogic
            {
             before(grammarAccess.getTerminalExpressionAccess().getOpLogicParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleLogic();

            state._fsp--;

             after(grammarAccess.getTerminalExpressionAccess().getOpLogicParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__OpAssignment_0"


    // $ANTLR start "rule__TerminalExpression__RhsAssignment_1"
    // InternalRealop.g:1303:1: rule__TerminalExpression__RhsAssignment_1 : ( ruleExpression ) ;
    public final void rule__TerminalExpression__RhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1307:1: ( ( ruleExpression ) )
            // InternalRealop.g:1308:2: ( ruleExpression )
            {
            // InternalRealop.g:1308:2: ( ruleExpression )
            // InternalRealop.g:1309:3: ruleExpression
            {
             before(grammarAccess.getTerminalExpressionAccess().getRhsExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getTerminalExpressionAccess().getRhsExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__RhsAssignment_1"


    // $ANTLR start "rule__Logic__AndAssignment_0"
    // InternalRealop.g:1318:1: rule__Logic__AndAssignment_0 : ( ruleAND_TOKEN ) ;
    public final void rule__Logic__AndAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1322:1: ( ( ruleAND_TOKEN ) )
            // InternalRealop.g:1323:2: ( ruleAND_TOKEN )
            {
            // InternalRealop.g:1323:2: ( ruleAND_TOKEN )
            // InternalRealop.g:1324:3: ruleAND_TOKEN
            {
             before(grammarAccess.getLogicAccess().getAndAND_TOKENParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAND_TOKEN();

            state._fsp--;

             after(grammarAccess.getLogicAccess().getAndAND_TOKENParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logic__AndAssignment_0"


    // $ANTLR start "rule__Logic__OrAssignment_1"
    // InternalRealop.g:1333:1: rule__Logic__OrAssignment_1 : ( ruleOR_TOKEN ) ;
    public final void rule__Logic__OrAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1337:1: ( ( ruleOR_TOKEN ) )
            // InternalRealop.g:1338:2: ( ruleOR_TOKEN )
            {
            // InternalRealop.g:1338:2: ( ruleOR_TOKEN )
            // InternalRealop.g:1339:3: ruleOR_TOKEN
            {
             before(grammarAccess.getLogicAccess().getOrOR_TOKENParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOR_TOKEN();

            state._fsp--;

             after(grammarAccess.getLogicAccess().getOrOR_TOKENParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logic__OrAssignment_1"


    // $ANTLR start "rule__Logic__XorAssignment_2"
    // InternalRealop.g:1348:1: rule__Logic__XorAssignment_2 : ( ruleXOR_TOKEN ) ;
    public final void rule__Logic__XorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1352:1: ( ( ruleXOR_TOKEN ) )
            // InternalRealop.g:1353:2: ( ruleXOR_TOKEN )
            {
            // InternalRealop.g:1353:2: ( ruleXOR_TOKEN )
            // InternalRealop.g:1354:3: ruleXOR_TOKEN
            {
             before(grammarAccess.getLogicAccess().getXorXOR_TOKENParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXOR_TOKEN();

            state._fsp--;

             after(grammarAccess.getLogicAccess().getXorXOR_TOKENParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logic__XorAssignment_2"


    // $ANTLR start "rule__Predicate__NegatedAssignment_0"
    // InternalRealop.g:1363:1: rule__Predicate__NegatedAssignment_0 : ( ruleNOT_TOKEN ) ;
    public final void rule__Predicate__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1367:1: ( ( ruleNOT_TOKEN ) )
            // InternalRealop.g:1368:2: ( ruleNOT_TOKEN )
            {
            // InternalRealop.g:1368:2: ( ruleNOT_TOKEN )
            // InternalRealop.g:1369:3: ruleNOT_TOKEN
            {
             before(grammarAccess.getPredicateAccess().getNegatedNOT_TOKENParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNOT_TOKEN();

            state._fsp--;

             after(grammarAccess.getPredicateAccess().getNegatedNOT_TOKENParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__NegatedAssignment_0"


    // $ANTLR start "rule__Predicate__PredicateAssignment_1"
    // InternalRealop.g:1378:1: rule__Predicate__PredicateAssignment_1 : ( rulePredicates ) ;
    public final void rule__Predicate__PredicateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1382:1: ( ( rulePredicates ) )
            // InternalRealop.g:1383:2: ( rulePredicates )
            {
            // InternalRealop.g:1383:2: ( rulePredicates )
            // InternalRealop.g:1384:3: rulePredicates
            {
             before(grammarAccess.getPredicateAccess().getPredicatePredicatesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            rulePredicates();

            state._fsp--;

             after(grammarAccess.getPredicateAccess().getPredicatePredicatesParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__PredicateAssignment_1"


    // $ANTLR start "rule__Predicate__NameAssignment_3"
    // InternalRealop.g:1393:1: rule__Predicate__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Predicate__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1397:1: ( ( RULE_ID ) )
            // InternalRealop.g:1398:2: ( RULE_ID )
            {
            // InternalRealop.g:1398:2: ( RULE_ID )
            // InternalRealop.g:1399:3: RULE_ID
            {
             before(grammarAccess.getPredicateAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPredicateAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__NameAssignment_3"


    // $ANTLR start "rule__Predicates__RealisedAssignment_0"
    // InternalRealop.g:1408:1: rule__Predicates__RealisedAssignment_0 : ( rulePRED_REALISED_TOKEN ) ;
    public final void rule__Predicates__RealisedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1412:1: ( ( rulePRED_REALISED_TOKEN ) )
            // InternalRealop.g:1413:2: ( rulePRED_REALISED_TOKEN )
            {
            // InternalRealop.g:1413:2: ( rulePRED_REALISED_TOKEN )
            // InternalRealop.g:1414:3: rulePRED_REALISED_TOKEN
            {
             before(grammarAccess.getPredicatesAccess().getRealisedPRED_REALISED_TOKENParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePRED_REALISED_TOKEN();

            state._fsp--;

             after(grammarAccess.getPredicatesAccess().getRealisedPRED_REALISED_TOKENParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicates__RealisedAssignment_0"


    // $ANTLR start "rule__Predicates__PositiveAssignment_1"
    // InternalRealop.g:1423:1: rule__Predicates__PositiveAssignment_1 : ( rulePRED_POSITIVE_TOKEN ) ;
    public final void rule__Predicates__PositiveAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1427:1: ( ( rulePRED_POSITIVE_TOKEN ) )
            // InternalRealop.g:1428:2: ( rulePRED_POSITIVE_TOKEN )
            {
            // InternalRealop.g:1428:2: ( rulePRED_POSITIVE_TOKEN )
            // InternalRealop.g:1429:3: rulePRED_POSITIVE_TOKEN
            {
             before(grammarAccess.getPredicatesAccess().getPositivePRED_POSITIVE_TOKENParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            rulePRED_POSITIVE_TOKEN();

            state._fsp--;

             after(grammarAccess.getPredicatesAccess().getPositivePRED_POSITIVE_TOKENParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicates__PositiveAssignment_1"


    // $ANTLR start "rule__Predicates__NegativeAssignment_2"
    // InternalRealop.g:1438:1: rule__Predicates__NegativeAssignment_2 : ( rulePRED_NEGATIVE_TOKEN ) ;
    public final void rule__Predicates__NegativeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRealop.g:1442:1: ( ( rulePRED_NEGATIVE_TOKEN ) )
            // InternalRealop.g:1443:2: ( rulePRED_NEGATIVE_TOKEN )
            {
            // InternalRealop.g:1443:2: ( rulePRED_NEGATIVE_TOKEN )
            // InternalRealop.g:1444:3: rulePRED_NEGATIVE_TOKEN
            {
             before(grammarAccess.getPredicatesAccess().getNegativePRED_NEGATIVE_TOKENParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePRED_NEGATIVE_TOKEN();

            state._fsp--;

             after(grammarAccess.getPredicatesAccess().getNegativePRED_NEGATIVE_TOKENParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicates__NegativeAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000038800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});

}