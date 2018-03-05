// Generated from C:/projet/src\TinyLanguage_SII.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TinyLanguage_SIIParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TinyLanguage_SIIVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TinyLanguage_SIIParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(TinyLanguage_SIIParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(TinyLanguage_SIIParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(TinyLanguage_SIIParser.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(TinyLanguage_SIIParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#affectation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectation(TinyLanguage_SIIParser.AffectationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TinyLanguage_SIIParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(TinyLanguage_SIIParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#expression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression1(TinyLanguage_SIIParser.Expression1Context ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(TinyLanguage_SIIParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression2(TinyLanguage_SIIParser.Expression2Context ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#terme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerme(TinyLanguage_SIIParser.TermeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#lecture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLecture(TinyLanguage_SIIParser.LectureContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#ecriture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEcriture(TinyLanguage_SIIParser.EcritureContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(TinyLanguage_SIIParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#instruction_conditionnelle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction_conditionnelle(TinyLanguage_SIIParser.Instruction_conditionnelleContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#instruction_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction_else(TinyLanguage_SIIParser.Instruction_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(TinyLanguage_SIIParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLanguage_SIIParser#comparateur}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparateur(TinyLanguage_SIIParser.ComparateurContext ctx);
}