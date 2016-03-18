package no.sintef.xtext.dsl.operator.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import no.sintef.xtext.dsl.operator.services.RealopGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRealopParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'not'", "'and'", "'or'", "'xor'", "'realised'", "'positive'", "'negative'", "'operator'", "'{'", "'}'", "'pre'", "'post'", "':'", "';'"
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

        public InternalRealopParser(TokenStream input, RealopGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Realop";
       	}

       	@Override
       	protected RealopGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRealop"
    // InternalRealop.g:64:1: entryRuleRealop returns [EObject current=null] : iv_ruleRealop= ruleRealop EOF ;
    public final EObject entryRuleRealop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealop = null;


        try {
            // InternalRealop.g:64:47: (iv_ruleRealop= ruleRealop EOF )
            // InternalRealop.g:65:2: iv_ruleRealop= ruleRealop EOF
            {
             newCompositeNode(grammarAccess.getRealopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRealop=ruleRealop();

            state._fsp--;

             current =iv_ruleRealop; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealop"


    // $ANTLR start "ruleRealop"
    // InternalRealop.g:71:1: ruleRealop returns [EObject current=null] : ( (lv_operator_0_0= ruleOperator ) )* ;
    public final EObject ruleRealop() throws RecognitionException {
        EObject current = null;

        EObject lv_operator_0_0 = null;



        	enterRule();

        try {
            // InternalRealop.g:77:2: ( ( (lv_operator_0_0= ruleOperator ) )* )
            // InternalRealop.g:78:2: ( (lv_operator_0_0= ruleOperator ) )*
            {
            // InternalRealop.g:78:2: ( (lv_operator_0_0= ruleOperator ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==20) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRealop.g:79:3: (lv_operator_0_0= ruleOperator )
            	    {
            	    // InternalRealop.g:79:3: (lv_operator_0_0= ruleOperator )
            	    // InternalRealop.g:80:4: lv_operator_0_0= ruleOperator
            	    {

            	    				newCompositeNode(grammarAccess.getRealopAccess().getOperatorOperatorParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_operator_0_0=ruleOperator();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getRealopRule());
            	    				}
            	    				add(
            	    					current,
            	    					"operator",
            	    					lv_operator_0_0,
            	    					"no.sintef.xtext.dsl.operator.Realop.Operator");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealop"


    // $ANTLR start "entryRuleOperator"
    // InternalRealop.g:100:1: entryRuleOperator returns [EObject current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final EObject entryRuleOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperator = null;


        try {
            // InternalRealop.g:100:49: (iv_ruleOperator= ruleOperator EOF )
            // InternalRealop.g:101:2: iv_ruleOperator= ruleOperator EOF
            {
             newCompositeNode(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperator=ruleOperator();

            state._fsp--;

             current =iv_ruleOperator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalRealop.g:107:1: ruleOperator returns [EObject current=null] : ( ruleOP_TOKEN ( (lv_name_1_0= RULE_ID ) ) ruleOPEN_OP_TOKEN rulePRE_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_pre_5_0= ruleExpression ) ) ruleCOND_END_TOKEN rulePOST_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_post_9_0= ruleExpression ) ) ruleCOND_END_TOKEN ruleCLOSE_OP_TOKEN ) ;
    public final EObject ruleOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_exp_pre_5_0 = null;

        EObject lv_exp_post_9_0 = null;



        	enterRule();

        try {
            // InternalRealop.g:113:2: ( ( ruleOP_TOKEN ( (lv_name_1_0= RULE_ID ) ) ruleOPEN_OP_TOKEN rulePRE_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_pre_5_0= ruleExpression ) ) ruleCOND_END_TOKEN rulePOST_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_post_9_0= ruleExpression ) ) ruleCOND_END_TOKEN ruleCLOSE_OP_TOKEN ) )
            // InternalRealop.g:114:2: ( ruleOP_TOKEN ( (lv_name_1_0= RULE_ID ) ) ruleOPEN_OP_TOKEN rulePRE_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_pre_5_0= ruleExpression ) ) ruleCOND_END_TOKEN rulePOST_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_post_9_0= ruleExpression ) ) ruleCOND_END_TOKEN ruleCLOSE_OP_TOKEN )
            {
            // InternalRealop.g:114:2: ( ruleOP_TOKEN ( (lv_name_1_0= RULE_ID ) ) ruleOPEN_OP_TOKEN rulePRE_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_pre_5_0= ruleExpression ) ) ruleCOND_END_TOKEN rulePOST_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_post_9_0= ruleExpression ) ) ruleCOND_END_TOKEN ruleCLOSE_OP_TOKEN )
            // InternalRealop.g:115:3: ruleOP_TOKEN ( (lv_name_1_0= RULE_ID ) ) ruleOPEN_OP_TOKEN rulePRE_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_pre_5_0= ruleExpression ) ) ruleCOND_END_TOKEN rulePOST_TOKEN ruleCOND_ST_TOKEN ( (lv_exp_post_9_0= ruleExpression ) ) ruleCOND_END_TOKEN ruleCLOSE_OP_TOKEN
            {

            			newCompositeNode(grammarAccess.getOperatorAccess().getOP_TOKENParserRuleCall_0());
            		
            pushFollow(FOLLOW_4);
            ruleOP_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalRealop.g:122:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRealop.g:123:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRealop.g:123:4: (lv_name_1_0= RULE_ID )
            // InternalRealop.g:124:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getOperatorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            			newCompositeNode(grammarAccess.getOperatorAccess().getOPEN_OP_TOKENParserRuleCall_2());
            		
            pushFollow(FOLLOW_6);
            ruleOPEN_OP_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            			newCompositeNode(grammarAccess.getOperatorAccess().getPRE_TOKENParserRuleCall_3());
            		
            pushFollow(FOLLOW_7);
            rulePRE_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            			newCompositeNode(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_4());
            		
            pushFollow(FOLLOW_8);
            ruleCOND_ST_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalRealop.g:161:3: ( (lv_exp_pre_5_0= ruleExpression ) )
            // InternalRealop.g:162:4: (lv_exp_pre_5_0= ruleExpression )
            {
            // InternalRealop.g:162:4: (lv_exp_pre_5_0= ruleExpression )
            // InternalRealop.g:163:5: lv_exp_pre_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getOperatorAccess().getExp_preExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_exp_pre_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperatorRule());
            					}
            					set(
            						current,
            						"exp_pre",
            						lv_exp_pre_5_0,
            						"no.sintef.xtext.dsl.operator.Realop.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            			newCompositeNode(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_6());
            		
            pushFollow(FOLLOW_10);
            ruleCOND_END_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            			newCompositeNode(grammarAccess.getOperatorAccess().getPOST_TOKENParserRuleCall_7());
            		
            pushFollow(FOLLOW_7);
            rulePOST_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            			newCompositeNode(grammarAccess.getOperatorAccess().getCOND_ST_TOKENParserRuleCall_8());
            		
            pushFollow(FOLLOW_8);
            ruleCOND_ST_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalRealop.g:201:3: ( (lv_exp_post_9_0= ruleExpression ) )
            // InternalRealop.g:202:4: (lv_exp_post_9_0= ruleExpression )
            {
            // InternalRealop.g:202:4: (lv_exp_post_9_0= ruleExpression )
            // InternalRealop.g:203:5: lv_exp_post_9_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getOperatorAccess().getExp_postExpressionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_9);
            lv_exp_post_9_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperatorRule());
            					}
            					set(
            						current,
            						"exp_post",
            						lv_exp_post_9_0,
            						"no.sintef.xtext.dsl.operator.Realop.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            			newCompositeNode(grammarAccess.getOperatorAccess().getCOND_END_TOKENParserRuleCall_10());
            		
            pushFollow(FOLLOW_11);
            ruleCOND_END_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            			newCompositeNode(grammarAccess.getOperatorAccess().getCLOSE_OP_TOKENParserRuleCall_11());
            		
            pushFollow(FOLLOW_2);
            ruleCLOSE_OP_TOKEN();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleExpression"
    // InternalRealop.g:238:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalRealop.g:238:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalRealop.g:239:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalRealop.g:245:1: ruleExpression returns [EObject current=null] : ( ( (lv_lhs_0_0= rulePredicate ) ) ( (lv_rhs_1_0= ruleTerminalExpression ) )? ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_1_0 = null;



        	enterRule();

        try {
            // InternalRealop.g:251:2: ( ( ( (lv_lhs_0_0= rulePredicate ) ) ( (lv_rhs_1_0= ruleTerminalExpression ) )? ) )
            // InternalRealop.g:252:2: ( ( (lv_lhs_0_0= rulePredicate ) ) ( (lv_rhs_1_0= ruleTerminalExpression ) )? )
            {
            // InternalRealop.g:252:2: ( ( (lv_lhs_0_0= rulePredicate ) ) ( (lv_rhs_1_0= ruleTerminalExpression ) )? )
            // InternalRealop.g:253:3: ( (lv_lhs_0_0= rulePredicate ) ) ( (lv_rhs_1_0= ruleTerminalExpression ) )?
            {
            // InternalRealop.g:253:3: ( (lv_lhs_0_0= rulePredicate ) )
            // InternalRealop.g:254:4: (lv_lhs_0_0= rulePredicate )
            {
            // InternalRealop.g:254:4: (lv_lhs_0_0= rulePredicate )
            // InternalRealop.g:255:5: lv_lhs_0_0= rulePredicate
            {

            					newCompositeNode(grammarAccess.getExpressionAccess().getLhsPredicateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_lhs_0_0=rulePredicate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_0_0,
            						"no.sintef.xtext.dsl.operator.Realop.Predicate");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRealop.g:272:3: ( (lv_rhs_1_0= ruleTerminalExpression ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=14 && LA2_0<=16)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalRealop.g:273:4: (lv_rhs_1_0= ruleTerminalExpression )
                    {
                    // InternalRealop.g:273:4: (lv_rhs_1_0= ruleTerminalExpression )
                    // InternalRealop.g:274:5: lv_rhs_1_0= ruleTerminalExpression
                    {

                    					newCompositeNode(grammarAccess.getExpressionAccess().getRhsTerminalExpressionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_rhs_1_0=ruleTerminalExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionRule());
                    					}
                    					set(
                    						current,
                    						"rhs",
                    						lv_rhs_1_0,
                    						"no.sintef.xtext.dsl.operator.Realop.TerminalExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleTerminalExpression"
    // InternalRealop.g:295:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalRealop.g:295:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalRealop.g:296:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
            {
             newCompositeNode(grammarAccess.getTerminalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminalExpression=ruleTerminalExpression();

            state._fsp--;

             current =iv_ruleTerminalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // InternalRealop.g:302:1: ruleTerminalExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogic ) ) ( (lv_rhs_1_0= ruleExpression ) ) ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_rhs_1_0 = null;



        	enterRule();

        try {
            // InternalRealop.g:308:2: ( ( ( (lv_op_0_0= ruleLogic ) ) ( (lv_rhs_1_0= ruleExpression ) ) ) )
            // InternalRealop.g:309:2: ( ( (lv_op_0_0= ruleLogic ) ) ( (lv_rhs_1_0= ruleExpression ) ) )
            {
            // InternalRealop.g:309:2: ( ( (lv_op_0_0= ruleLogic ) ) ( (lv_rhs_1_0= ruleExpression ) ) )
            // InternalRealop.g:310:3: ( (lv_op_0_0= ruleLogic ) ) ( (lv_rhs_1_0= ruleExpression ) )
            {
            // InternalRealop.g:310:3: ( (lv_op_0_0= ruleLogic ) )
            // InternalRealop.g:311:4: (lv_op_0_0= ruleLogic )
            {
            // InternalRealop.g:311:4: (lv_op_0_0= ruleLogic )
            // InternalRealop.g:312:5: lv_op_0_0= ruleLogic
            {

            					newCompositeNode(grammarAccess.getTerminalExpressionAccess().getOpLogicParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
            lv_op_0_0=ruleLogic();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerminalExpressionRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_0_0,
            						"no.sintef.xtext.dsl.operator.Realop.Logic");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRealop.g:329:3: ( (lv_rhs_1_0= ruleExpression ) )
            // InternalRealop.g:330:4: (lv_rhs_1_0= ruleExpression )
            {
            // InternalRealop.g:330:4: (lv_rhs_1_0= ruleExpression )
            // InternalRealop.g:331:5: lv_rhs_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getTerminalExpressionAccess().getRhsExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_rhs_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerminalExpressionRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_1_0,
            						"no.sintef.xtext.dsl.operator.Realop.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleLogic"
    // InternalRealop.g:352:1: entryRuleLogic returns [String current=null] : iv_ruleLogic= ruleLogic EOF ;
    public final String entryRuleLogic() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogic = null;


        try {
            // InternalRealop.g:352:45: (iv_ruleLogic= ruleLogic EOF )
            // InternalRealop.g:353:2: iv_ruleLogic= ruleLogic EOF
            {
             newCompositeNode(grammarAccess.getLogicRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogic=ruleLogic();

            state._fsp--;

             current =iv_ruleLogic.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogic"


    // $ANTLR start "ruleLogic"
    // InternalRealop.g:359:1: ruleLogic returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_AND_TOKEN_0= ruleAND_TOKEN | this_OR_TOKEN_1= ruleOR_TOKEN | this_XOR_TOKEN_2= ruleXOR_TOKEN ) ;
    public final AntlrDatatypeRuleToken ruleLogic() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_AND_TOKEN_0 = null;

        AntlrDatatypeRuleToken this_OR_TOKEN_1 = null;

        AntlrDatatypeRuleToken this_XOR_TOKEN_2 = null;



        	enterRule();

        try {
            // InternalRealop.g:365:2: ( (this_AND_TOKEN_0= ruleAND_TOKEN | this_OR_TOKEN_1= ruleOR_TOKEN | this_XOR_TOKEN_2= ruleXOR_TOKEN ) )
            // InternalRealop.g:366:2: (this_AND_TOKEN_0= ruleAND_TOKEN | this_OR_TOKEN_1= ruleOR_TOKEN | this_XOR_TOKEN_2= ruleXOR_TOKEN )
            {
            // InternalRealop.g:366:2: (this_AND_TOKEN_0= ruleAND_TOKEN | this_OR_TOKEN_1= ruleOR_TOKEN | this_XOR_TOKEN_2= ruleXOR_TOKEN )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 16:
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
                    // InternalRealop.g:367:3: this_AND_TOKEN_0= ruleAND_TOKEN
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getAND_TOKENParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AND_TOKEN_0=ruleAND_TOKEN();

                    state._fsp--;


                    			current.merge(this_AND_TOKEN_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRealop.g:378:3: this_OR_TOKEN_1= ruleOR_TOKEN
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getOR_TOKENParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OR_TOKEN_1=ruleOR_TOKEN();

                    state._fsp--;


                    			current.merge(this_OR_TOKEN_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRealop.g:389:3: this_XOR_TOKEN_2= ruleXOR_TOKEN
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getXOR_TOKENParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_XOR_TOKEN_2=ruleXOR_TOKEN();

                    state._fsp--;


                    			current.merge(this_XOR_TOKEN_2);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogic"


    // $ANTLR start "entryRulePredicate"
    // InternalRealop.g:403:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // InternalRealop.g:403:50: (iv_rulePredicate= rulePredicate EOF )
            // InternalRealop.g:404:2: iv_rulePredicate= rulePredicate EOF
            {
             newCompositeNode(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicate=rulePredicate();

            state._fsp--;

             current =iv_rulePredicate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalRealop.g:410:1: rulePredicate returns [EObject current=null] : ( ( (lv_negate_0_0= ruleNOT_TOKEN ) )? ( (lv_predicate_1_0= rulePredicates ) ) otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_negate_0_0 = null;

        AntlrDatatypeRuleToken lv_predicate_1_0 = null;



        	enterRule();

        try {
            // InternalRealop.g:416:2: ( ( ( (lv_negate_0_0= ruleNOT_TOKEN ) )? ( (lv_predicate_1_0= rulePredicates ) ) otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalRealop.g:417:2: ( ( (lv_negate_0_0= ruleNOT_TOKEN ) )? ( (lv_predicate_1_0= rulePredicates ) ) otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalRealop.g:417:2: ( ( (lv_negate_0_0= ruleNOT_TOKEN ) )? ( (lv_predicate_1_0= rulePredicates ) ) otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' )
            // InternalRealop.g:418:3: ( (lv_negate_0_0= ruleNOT_TOKEN ) )? ( (lv_predicate_1_0= rulePredicates ) ) otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalRealop.g:418:3: ( (lv_negate_0_0= ruleNOT_TOKEN ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRealop.g:419:4: (lv_negate_0_0= ruleNOT_TOKEN )
                    {
                    // InternalRealop.g:419:4: (lv_negate_0_0= ruleNOT_TOKEN )
                    // InternalRealop.g:420:5: lv_negate_0_0= ruleNOT_TOKEN
                    {

                    					newCompositeNode(grammarAccess.getPredicateAccess().getNegateNOT_TOKENParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_8);
                    lv_negate_0_0=ruleNOT_TOKEN();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPredicateRule());
                    					}
                    					set(
                    						current,
                    						"negate",
                    						true,
                    						"no.sintef.xtext.dsl.operator.Realop.NOT_TOKEN");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalRealop.g:437:3: ( (lv_predicate_1_0= rulePredicates ) )
            // InternalRealop.g:438:4: (lv_predicate_1_0= rulePredicates )
            {
            // InternalRealop.g:438:4: (lv_predicate_1_0= rulePredicates )
            // InternalRealop.g:439:5: lv_predicate_1_0= rulePredicates
            {

            					newCompositeNode(grammarAccess.getPredicateAccess().getPredicatePredicatesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_predicate_1_0=rulePredicates();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPredicateRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_1_0,
            						"no.sintef.xtext.dsl.operator.Realop.Predicates");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_2());
            		
            // InternalRealop.g:460:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalRealop.g:461:4: (lv_name_3_0= RULE_ID )
            {
            // InternalRealop.g:461:4: (lv_name_3_0= RULE_ID )
            // InternalRealop.g:462:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_3_0, grammarAccess.getPredicateAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPredicateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRulePredicates"
    // InternalRealop.g:486:1: entryRulePredicates returns [String current=null] : iv_rulePredicates= rulePredicates EOF ;
    public final String entryRulePredicates() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePredicates = null;


        try {
            // InternalRealop.g:486:50: (iv_rulePredicates= rulePredicates EOF )
            // InternalRealop.g:487:2: iv_rulePredicates= rulePredicates EOF
            {
             newCompositeNode(grammarAccess.getPredicatesRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicates=rulePredicates();

            state._fsp--;

             current =iv_rulePredicates.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicates"


    // $ANTLR start "rulePredicates"
    // InternalRealop.g:493:1: rulePredicates returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PRED_REALISED_TOKEN_0= rulePRED_REALISED_TOKEN | this_PRED_POSITIVE_TOKEN_1= rulePRED_POSITIVE_TOKEN | this_PRED_NEGATIVE_TOKEN_2= rulePRED_NEGATIVE_TOKEN ) ;
    public final AntlrDatatypeRuleToken rulePredicates() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_PRED_REALISED_TOKEN_0 = null;

        AntlrDatatypeRuleToken this_PRED_POSITIVE_TOKEN_1 = null;

        AntlrDatatypeRuleToken this_PRED_NEGATIVE_TOKEN_2 = null;



        	enterRule();

        try {
            // InternalRealop.g:499:2: ( (this_PRED_REALISED_TOKEN_0= rulePRED_REALISED_TOKEN | this_PRED_POSITIVE_TOKEN_1= rulePRED_POSITIVE_TOKEN | this_PRED_NEGATIVE_TOKEN_2= rulePRED_NEGATIVE_TOKEN ) )
            // InternalRealop.g:500:2: (this_PRED_REALISED_TOKEN_0= rulePRED_REALISED_TOKEN | this_PRED_POSITIVE_TOKEN_1= rulePRED_POSITIVE_TOKEN | this_PRED_NEGATIVE_TOKEN_2= rulePRED_NEGATIVE_TOKEN )
            {
            // InternalRealop.g:500:2: (this_PRED_REALISED_TOKEN_0= rulePRED_REALISED_TOKEN | this_PRED_POSITIVE_TOKEN_1= rulePRED_POSITIVE_TOKEN | this_PRED_NEGATIVE_TOKEN_2= rulePRED_NEGATIVE_TOKEN )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt5=1;
                }
                break;
            case 18:
                {
                alt5=2;
                }
                break;
            case 19:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalRealop.g:501:3: this_PRED_REALISED_TOKEN_0= rulePRED_REALISED_TOKEN
                    {

                    			newCompositeNode(grammarAccess.getPredicatesAccess().getPRED_REALISED_TOKENParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PRED_REALISED_TOKEN_0=rulePRED_REALISED_TOKEN();

                    state._fsp--;


                    			current.merge(this_PRED_REALISED_TOKEN_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRealop.g:512:3: this_PRED_POSITIVE_TOKEN_1= rulePRED_POSITIVE_TOKEN
                    {

                    			newCompositeNode(grammarAccess.getPredicatesAccess().getPRED_POSITIVE_TOKENParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PRED_POSITIVE_TOKEN_1=rulePRED_POSITIVE_TOKEN();

                    state._fsp--;


                    			current.merge(this_PRED_POSITIVE_TOKEN_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRealop.g:523:3: this_PRED_NEGATIVE_TOKEN_2= rulePRED_NEGATIVE_TOKEN
                    {

                    			newCompositeNode(grammarAccess.getPredicatesAccess().getPRED_NEGATIVE_TOKENParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PRED_NEGATIVE_TOKEN_2=rulePRED_NEGATIVE_TOKEN();

                    state._fsp--;


                    			current.merge(this_PRED_NEGATIVE_TOKEN_2);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicates"


    // $ANTLR start "entryRuleNOT_TOKEN"
    // InternalRealop.g:537:1: entryRuleNOT_TOKEN returns [String current=null] : iv_ruleNOT_TOKEN= ruleNOT_TOKEN EOF ;
    public final String entryRuleNOT_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNOT_TOKEN = null;


        try {
            // InternalRealop.g:537:49: (iv_ruleNOT_TOKEN= ruleNOT_TOKEN EOF )
            // InternalRealop.g:538:2: iv_ruleNOT_TOKEN= ruleNOT_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getNOT_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNOT_TOKEN=ruleNOT_TOKEN();

            state._fsp--;

             current =iv_ruleNOT_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNOT_TOKEN"


    // $ANTLR start "ruleNOT_TOKEN"
    // InternalRealop.g:544:1: ruleNOT_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'not' ;
    public final AntlrDatatypeRuleToken ruleNOT_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:550:2: (kw= 'not' )
            // InternalRealop.g:551:2: kw= 'not'
            {
            kw=(Token)match(input,13,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getNOT_TOKENAccess().getNotKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNOT_TOKEN"


    // $ANTLR start "entryRuleAND_TOKEN"
    // InternalRealop.g:559:1: entryRuleAND_TOKEN returns [String current=null] : iv_ruleAND_TOKEN= ruleAND_TOKEN EOF ;
    public final String entryRuleAND_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAND_TOKEN = null;


        try {
            // InternalRealop.g:559:49: (iv_ruleAND_TOKEN= ruleAND_TOKEN EOF )
            // InternalRealop.g:560:2: iv_ruleAND_TOKEN= ruleAND_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getAND_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAND_TOKEN=ruleAND_TOKEN();

            state._fsp--;

             current =iv_ruleAND_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAND_TOKEN"


    // $ANTLR start "ruleAND_TOKEN"
    // InternalRealop.g:566:1: ruleAND_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'and' ;
    public final AntlrDatatypeRuleToken ruleAND_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:572:2: (kw= 'and' )
            // InternalRealop.g:573:2: kw= 'and'
            {
            kw=(Token)match(input,14,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getAND_TOKENAccess().getAndKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAND_TOKEN"


    // $ANTLR start "entryRuleOR_TOKEN"
    // InternalRealop.g:581:1: entryRuleOR_TOKEN returns [String current=null] : iv_ruleOR_TOKEN= ruleOR_TOKEN EOF ;
    public final String entryRuleOR_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOR_TOKEN = null;


        try {
            // InternalRealop.g:581:48: (iv_ruleOR_TOKEN= ruleOR_TOKEN EOF )
            // InternalRealop.g:582:2: iv_ruleOR_TOKEN= ruleOR_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getOR_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOR_TOKEN=ruleOR_TOKEN();

            state._fsp--;

             current =iv_ruleOR_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOR_TOKEN"


    // $ANTLR start "ruleOR_TOKEN"
    // InternalRealop.g:588:1: ruleOR_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'or' ;
    public final AntlrDatatypeRuleToken ruleOR_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:594:2: (kw= 'or' )
            // InternalRealop.g:595:2: kw= 'or'
            {
            kw=(Token)match(input,15,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getOR_TOKENAccess().getOrKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOR_TOKEN"


    // $ANTLR start "entryRuleXOR_TOKEN"
    // InternalRealop.g:603:1: entryRuleXOR_TOKEN returns [String current=null] : iv_ruleXOR_TOKEN= ruleXOR_TOKEN EOF ;
    public final String entryRuleXOR_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXOR_TOKEN = null;


        try {
            // InternalRealop.g:603:49: (iv_ruleXOR_TOKEN= ruleXOR_TOKEN EOF )
            // InternalRealop.g:604:2: iv_ruleXOR_TOKEN= ruleXOR_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getXOR_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXOR_TOKEN=ruleXOR_TOKEN();

            state._fsp--;

             current =iv_ruleXOR_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOR_TOKEN"


    // $ANTLR start "ruleXOR_TOKEN"
    // InternalRealop.g:610:1: ruleXOR_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'xor' ;
    public final AntlrDatatypeRuleToken ruleXOR_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:616:2: (kw= 'xor' )
            // InternalRealop.g:617:2: kw= 'xor'
            {
            kw=(Token)match(input,16,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getXOR_TOKENAccess().getXorKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXOR_TOKEN"


    // $ANTLR start "entryRulePRED_REALISED_TOKEN"
    // InternalRealop.g:625:1: entryRulePRED_REALISED_TOKEN returns [String current=null] : iv_rulePRED_REALISED_TOKEN= rulePRED_REALISED_TOKEN EOF ;
    public final String entryRulePRED_REALISED_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePRED_REALISED_TOKEN = null;


        try {
            // InternalRealop.g:625:59: (iv_rulePRED_REALISED_TOKEN= rulePRED_REALISED_TOKEN EOF )
            // InternalRealop.g:626:2: iv_rulePRED_REALISED_TOKEN= rulePRED_REALISED_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getPRED_REALISED_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePRED_REALISED_TOKEN=rulePRED_REALISED_TOKEN();

            state._fsp--;

             current =iv_rulePRED_REALISED_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRED_REALISED_TOKEN"


    // $ANTLR start "rulePRED_REALISED_TOKEN"
    // InternalRealop.g:632:1: rulePRED_REALISED_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'realised' ;
    public final AntlrDatatypeRuleToken rulePRED_REALISED_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:638:2: (kw= 'realised' )
            // InternalRealop.g:639:2: kw= 'realised'
            {
            kw=(Token)match(input,17,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPRED_REALISED_TOKENAccess().getRealisedKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePRED_REALISED_TOKEN"


    // $ANTLR start "entryRulePRED_POSITIVE_TOKEN"
    // InternalRealop.g:647:1: entryRulePRED_POSITIVE_TOKEN returns [String current=null] : iv_rulePRED_POSITIVE_TOKEN= rulePRED_POSITIVE_TOKEN EOF ;
    public final String entryRulePRED_POSITIVE_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePRED_POSITIVE_TOKEN = null;


        try {
            // InternalRealop.g:647:59: (iv_rulePRED_POSITIVE_TOKEN= rulePRED_POSITIVE_TOKEN EOF )
            // InternalRealop.g:648:2: iv_rulePRED_POSITIVE_TOKEN= rulePRED_POSITIVE_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getPRED_POSITIVE_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePRED_POSITIVE_TOKEN=rulePRED_POSITIVE_TOKEN();

            state._fsp--;

             current =iv_rulePRED_POSITIVE_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRED_POSITIVE_TOKEN"


    // $ANTLR start "rulePRED_POSITIVE_TOKEN"
    // InternalRealop.g:654:1: rulePRED_POSITIVE_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'positive' ;
    public final AntlrDatatypeRuleToken rulePRED_POSITIVE_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:660:2: (kw= 'positive' )
            // InternalRealop.g:661:2: kw= 'positive'
            {
            kw=(Token)match(input,18,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPRED_POSITIVE_TOKENAccess().getPositiveKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePRED_POSITIVE_TOKEN"


    // $ANTLR start "entryRulePRED_NEGATIVE_TOKEN"
    // InternalRealop.g:669:1: entryRulePRED_NEGATIVE_TOKEN returns [String current=null] : iv_rulePRED_NEGATIVE_TOKEN= rulePRED_NEGATIVE_TOKEN EOF ;
    public final String entryRulePRED_NEGATIVE_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePRED_NEGATIVE_TOKEN = null;


        try {
            // InternalRealop.g:669:59: (iv_rulePRED_NEGATIVE_TOKEN= rulePRED_NEGATIVE_TOKEN EOF )
            // InternalRealop.g:670:2: iv_rulePRED_NEGATIVE_TOKEN= rulePRED_NEGATIVE_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getPRED_NEGATIVE_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePRED_NEGATIVE_TOKEN=rulePRED_NEGATIVE_TOKEN();

            state._fsp--;

             current =iv_rulePRED_NEGATIVE_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRED_NEGATIVE_TOKEN"


    // $ANTLR start "rulePRED_NEGATIVE_TOKEN"
    // InternalRealop.g:676:1: rulePRED_NEGATIVE_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'negative' ;
    public final AntlrDatatypeRuleToken rulePRED_NEGATIVE_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:682:2: (kw= 'negative' )
            // InternalRealop.g:683:2: kw= 'negative'
            {
            kw=(Token)match(input,19,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPRED_NEGATIVE_TOKENAccess().getNegativeKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePRED_NEGATIVE_TOKEN"


    // $ANTLR start "entryRuleOP_TOKEN"
    // InternalRealop.g:691:1: entryRuleOP_TOKEN returns [String current=null] : iv_ruleOP_TOKEN= ruleOP_TOKEN EOF ;
    public final String entryRuleOP_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOP_TOKEN = null;


        try {
            // InternalRealop.g:691:48: (iv_ruleOP_TOKEN= ruleOP_TOKEN EOF )
            // InternalRealop.g:692:2: iv_ruleOP_TOKEN= ruleOP_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getOP_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOP_TOKEN=ruleOP_TOKEN();

            state._fsp--;

             current =iv_ruleOP_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOP_TOKEN"


    // $ANTLR start "ruleOP_TOKEN"
    // InternalRealop.g:698:1: ruleOP_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'operator' ;
    public final AntlrDatatypeRuleToken ruleOP_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:704:2: (kw= 'operator' )
            // InternalRealop.g:705:2: kw= 'operator'
            {
            kw=(Token)match(input,20,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getOP_TOKENAccess().getOperatorKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOP_TOKEN"


    // $ANTLR start "entryRuleOPEN_OP_TOKEN"
    // InternalRealop.g:713:1: entryRuleOPEN_OP_TOKEN returns [String current=null] : iv_ruleOPEN_OP_TOKEN= ruleOPEN_OP_TOKEN EOF ;
    public final String entryRuleOPEN_OP_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOPEN_OP_TOKEN = null;


        try {
            // InternalRealop.g:713:53: (iv_ruleOPEN_OP_TOKEN= ruleOPEN_OP_TOKEN EOF )
            // InternalRealop.g:714:2: iv_ruleOPEN_OP_TOKEN= ruleOPEN_OP_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getOPEN_OP_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOPEN_OP_TOKEN=ruleOPEN_OP_TOKEN();

            state._fsp--;

             current =iv_ruleOPEN_OP_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOPEN_OP_TOKEN"


    // $ANTLR start "ruleOPEN_OP_TOKEN"
    // InternalRealop.g:720:1: ruleOPEN_OP_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '{' ;
    public final AntlrDatatypeRuleToken ruleOPEN_OP_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:726:2: (kw= '{' )
            // InternalRealop.g:727:2: kw= '{'
            {
            kw=(Token)match(input,21,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getOPEN_OP_TOKENAccess().getLeftCurlyBracketKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOPEN_OP_TOKEN"


    // $ANTLR start "entryRuleCLOSE_OP_TOKEN"
    // InternalRealop.g:735:1: entryRuleCLOSE_OP_TOKEN returns [String current=null] : iv_ruleCLOSE_OP_TOKEN= ruleCLOSE_OP_TOKEN EOF ;
    public final String entryRuleCLOSE_OP_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCLOSE_OP_TOKEN = null;


        try {
            // InternalRealop.g:735:54: (iv_ruleCLOSE_OP_TOKEN= ruleCLOSE_OP_TOKEN EOF )
            // InternalRealop.g:736:2: iv_ruleCLOSE_OP_TOKEN= ruleCLOSE_OP_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getCLOSE_OP_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCLOSE_OP_TOKEN=ruleCLOSE_OP_TOKEN();

            state._fsp--;

             current =iv_ruleCLOSE_OP_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCLOSE_OP_TOKEN"


    // $ANTLR start "ruleCLOSE_OP_TOKEN"
    // InternalRealop.g:742:1: ruleCLOSE_OP_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '}' ;
    public final AntlrDatatypeRuleToken ruleCLOSE_OP_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:748:2: (kw= '}' )
            // InternalRealop.g:749:2: kw= '}'
            {
            kw=(Token)match(input,22,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getCLOSE_OP_TOKENAccess().getRightCurlyBracketKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCLOSE_OP_TOKEN"


    // $ANTLR start "entryRulePRE_TOKEN"
    // InternalRealop.g:757:1: entryRulePRE_TOKEN returns [String current=null] : iv_rulePRE_TOKEN= rulePRE_TOKEN EOF ;
    public final String entryRulePRE_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePRE_TOKEN = null;


        try {
            // InternalRealop.g:757:49: (iv_rulePRE_TOKEN= rulePRE_TOKEN EOF )
            // InternalRealop.g:758:2: iv_rulePRE_TOKEN= rulePRE_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getPRE_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePRE_TOKEN=rulePRE_TOKEN();

            state._fsp--;

             current =iv_rulePRE_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRE_TOKEN"


    // $ANTLR start "rulePRE_TOKEN"
    // InternalRealop.g:764:1: rulePRE_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'pre' ;
    public final AntlrDatatypeRuleToken rulePRE_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:770:2: (kw= 'pre' )
            // InternalRealop.g:771:2: kw= 'pre'
            {
            kw=(Token)match(input,23,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPRE_TOKENAccess().getPreKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePRE_TOKEN"


    // $ANTLR start "entryRulePOST_TOKEN"
    // InternalRealop.g:779:1: entryRulePOST_TOKEN returns [String current=null] : iv_rulePOST_TOKEN= rulePOST_TOKEN EOF ;
    public final String entryRulePOST_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOST_TOKEN = null;


        try {
            // InternalRealop.g:779:50: (iv_rulePOST_TOKEN= rulePOST_TOKEN EOF )
            // InternalRealop.g:780:2: iv_rulePOST_TOKEN= rulePOST_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getPOST_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePOST_TOKEN=rulePOST_TOKEN();

            state._fsp--;

             current =iv_rulePOST_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePOST_TOKEN"


    // $ANTLR start "rulePOST_TOKEN"
    // InternalRealop.g:786:1: rulePOST_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'post' ;
    public final AntlrDatatypeRuleToken rulePOST_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:792:2: (kw= 'post' )
            // InternalRealop.g:793:2: kw= 'post'
            {
            kw=(Token)match(input,24,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPOST_TOKENAccess().getPostKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePOST_TOKEN"


    // $ANTLR start "entryRuleCOND_ST_TOKEN"
    // InternalRealop.g:801:1: entryRuleCOND_ST_TOKEN returns [String current=null] : iv_ruleCOND_ST_TOKEN= ruleCOND_ST_TOKEN EOF ;
    public final String entryRuleCOND_ST_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCOND_ST_TOKEN = null;


        try {
            // InternalRealop.g:801:53: (iv_ruleCOND_ST_TOKEN= ruleCOND_ST_TOKEN EOF )
            // InternalRealop.g:802:2: iv_ruleCOND_ST_TOKEN= ruleCOND_ST_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getCOND_ST_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCOND_ST_TOKEN=ruleCOND_ST_TOKEN();

            state._fsp--;

             current =iv_ruleCOND_ST_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCOND_ST_TOKEN"


    // $ANTLR start "ruleCOND_ST_TOKEN"
    // InternalRealop.g:808:1: ruleCOND_ST_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= ':' ;
    public final AntlrDatatypeRuleToken ruleCOND_ST_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:814:2: (kw= ':' )
            // InternalRealop.g:815:2: kw= ':'
            {
            kw=(Token)match(input,25,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getCOND_ST_TOKENAccess().getColonKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCOND_ST_TOKEN"


    // $ANTLR start "entryRuleCOND_END_TOKEN"
    // InternalRealop.g:823:1: entryRuleCOND_END_TOKEN returns [String current=null] : iv_ruleCOND_END_TOKEN= ruleCOND_END_TOKEN EOF ;
    public final String entryRuleCOND_END_TOKEN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCOND_END_TOKEN = null;


        try {
            // InternalRealop.g:823:54: (iv_ruleCOND_END_TOKEN= ruleCOND_END_TOKEN EOF )
            // InternalRealop.g:824:2: iv_ruleCOND_END_TOKEN= ruleCOND_END_TOKEN EOF
            {
             newCompositeNode(grammarAccess.getCOND_END_TOKENRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCOND_END_TOKEN=ruleCOND_END_TOKEN();

            state._fsp--;

             current =iv_ruleCOND_END_TOKEN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCOND_END_TOKEN"


    // $ANTLR start "ruleCOND_END_TOKEN"
    // InternalRealop.g:830:1: ruleCOND_END_TOKEN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= ';' ;
    public final AntlrDatatypeRuleToken ruleCOND_END_TOKEN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRealop.g:836:2: (kw= ';' )
            // InternalRealop.g:837:2: kw= ';'
            {
            kw=(Token)match(input,26,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getCOND_END_TOKENAccess().getSemicolonKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCOND_END_TOKEN"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000E2000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000000001C002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000001000L});

}