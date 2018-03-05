// Generated from C:/projet/src\TinyLanguage_SII.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinyLanguage_SIIParser}.
 */
public interface TinyLanguage_SIIListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TinyLanguage_SIIParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TinyLanguage_SIIParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(TinyLanguage_SIIParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(TinyLanguage_SIIParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TinyLanguage_SIIParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TinyLanguage_SIIParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(TinyLanguage_SIIParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(TinyLanguage_SIIParser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(TinyLanguage_SIIParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(TinyLanguage_SIIParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#affectation}.
	 * @param ctx the parse tree
	 */
	void enterAffectation(TinyLanguage_SIIParser.AffectationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#affectation}.
	 * @param ctx the parse tree
	 */
	void exitAffectation(TinyLanguage_SIIParser.AffectationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TinyLanguage_SIIParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TinyLanguage_SIIParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(TinyLanguage_SIIParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(TinyLanguage_SIIParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#expression1}.
	 * @param ctx the parse tree
	 */
	void enterExpression1(TinyLanguage_SIIParser.Expression1Context ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#expression1}.
	 * @param ctx the parse tree
	 */
	void exitExpression1(TinyLanguage_SIIParser.Expression1Context ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(TinyLanguage_SIIParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(TinyLanguage_SIIParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#expression2}.
	 * @param ctx the parse tree
	 */
	void enterExpression2(TinyLanguage_SIIParser.Expression2Context ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#expression2}.
	 * @param ctx the parse tree
	 */
	void exitExpression2(TinyLanguage_SIIParser.Expression2Context ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#terme}.
	 * @param ctx the parse tree
	 */
	void enterTerme(TinyLanguage_SIIParser.TermeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#terme}.
	 * @param ctx the parse tree
	 */
	void exitTerme(TinyLanguage_SIIParser.TermeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#lecture}.
	 * @param ctx the parse tree
	 */
	void enterLecture(TinyLanguage_SIIParser.LectureContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#lecture}.
	 * @param ctx the parse tree
	 */
	void exitLecture(TinyLanguage_SIIParser.LectureContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#ecriture}.
	 * @param ctx the parse tree
	 */
	void enterEcriture(TinyLanguage_SIIParser.EcritureContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#ecriture}.
	 * @param ctx the parse tree
	 */
	void exitEcriture(TinyLanguage_SIIParser.EcritureContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(TinyLanguage_SIIParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(TinyLanguage_SIIParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#instruction_conditionnelle}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_conditionnelle(TinyLanguage_SIIParser.Instruction_conditionnelleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#instruction_conditionnelle}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_conditionnelle(TinyLanguage_SIIParser.Instruction_conditionnelleContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#instruction_else}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_else(TinyLanguage_SIIParser.Instruction_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#instruction_else}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_else(TinyLanguage_SIIParser.Instruction_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(TinyLanguage_SIIParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(TinyLanguage_SIIParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLanguage_SIIParser#comparateur}.
	 * @param ctx the parse tree
	 */
	void enterComparateur(TinyLanguage_SIIParser.ComparateurContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLanguage_SIIParser#comparateur}.
	 * @param ctx the parse tree
	 */
	void exitComparateur(TinyLanguage_SIIParser.ComparateurContext ctx);
}