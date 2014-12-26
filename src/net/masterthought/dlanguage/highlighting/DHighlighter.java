package net.masterthought.dlanguage.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import net.masterthought.dlanguage.psi.DTokenSets;
import net.masterthought.dlanguage.psi.interfaces.DElementTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Highlighter for D source.  Uses DHighlightingLexer to create tokens of
 * DElementType, then returns the highlighting TextAttributesKey associated
 * with the DElementType token.
 */
public class DHighlighter extends SyntaxHighlighterBase {

    // Token based highlighting
    public static final TextAttributesKey ILLEGAL = createTextAttributesKey("D_ILLEGAL", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("D_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey STRING = createTextAttributesKey("D_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("D_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("D_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey PARENTHESES = createTextAttributesKey("D_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACES = createTextAttributesKey("D_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKETS = createTextAttributesKey("D_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey OP_SIGN = createTextAttributesKey("D_OP_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    // Annotation based highlighting
    public static final TextAttributesKey FUNCTION_DEFINITION = createTextAttributesKey("D_SYMBOL", DefaultLanguageHighlighterColors.INSTANCE_METHOD);
    public static final TextAttributesKey REF_MODULE = createTextAttributesKey("D_REF_MODULE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey VARIABLE = createTextAttributesKey("D_VARIABLE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new DHighlightingLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(final IElementType type) {
        if (type == TokenType.BAD_CHARACTER) {
            return pack(ILLEGAL);
        }
        if (DTokenSets.COMMENTS.contains(type)) {
            return pack(COMMENT);
        }
        if (DTokenSets.STRING_LITERALS.contains(type)) {
            return pack(STRING);
        }
        if (DTokenSets.INTEGER_LITERALS.contains(type) || DTokenSets.FLOAT_LITERALS.contains(type)) {
            return pack(NUMBER);
        }
        if (DTokenSets.OPERATOR.contains(type)) {
            return pack(OP_SIGN);
        }
        if (DTokenSets.PARENS.contains(type)) {
            return pack(PARENTHESES);
        }
        if (DTokenSets.BRACE.contains(type)) {
            return pack(BRACES);
        }
        if (DTokenSets.BRACKET.contains(type)) {
            return pack(BRACKETS);
        }
        if (DTokenSets.KEYWORD.contains(type)) {
            return pack(KEYWORD);
        }
        return EMPTY;
    }


//    public static final TextAttributesKey LINE_COMMENT = createTextAttributesKey(
//                                                                "LINE_COMMENT",
//                                                                DefaultLanguageHighlighterColors.LINE_COMMENT);
//    public static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey(
//                                                                "BLOCK_COMMENT",
//                                                                DefaultLanguageHighlighterColors.BLOCK_COMMENT);
//    public static final TextAttributesKey DOC_COMMENT = createTextAttributesKey(
//                                                                "DOC_COMMENT",
//                                                                DefaultLanguageHighlighterColors.DOC_COMMENT);
//
//    private static final TextAttributesKey[] COMMENTS = new TextAttributesKey[]{LINE_COMMENT,BLOCK_COMMENT,DOC_COMMENT};
//
//
//    public static final TextAttributesKey STRING_LITERAL = createTextAttributesKey(
//                                                                "STRING_LITERAL",
//                                                                DefaultLanguageHighlighterColors.STRING);
//
//    public static final TextAttributesKey NUM_LITERAL = createTextAttributesKey(
//                                                                "NUM_LITERAL",
//                                                                DefaultLanguageHighlighterColors.NUMBER);
//
//
//    public static final TextAttributesKey OPERATOR = createTextAttributesKey(
//                                                                "OPERATOR",
//                                                                DefaultLanguageHighlighterColors.OPERATION_SIGN);
//
//    public static final TextAttributesKey KEYWORD = createTextAttributesKey(
//                                                                "KEYWORD",
//                                                                DefaultLanguageHighlighterColors.KEYWORD);
//
//    public static final TextAttributesKey PARENS = createTextAttributesKey(
//                                                                "PARENS",
//                                                                DefaultLanguageHighlighterColors.PARENTHESES);
//    public static final TextAttributesKey BRACES = createTextAttributesKey(
//                                                                "BRACES",
//                                                                DefaultLanguageHighlighterColors.BRACES);
//    public static final TextAttributesKey BRACKETS = createTextAttributesKey(
//                                                                "BRACKETS",
//                                                                DefaultLanguageHighlighterColors.BRACKETS);
//
///*
//    public static final TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey("IDENTIFIER",
//                                                                                                 DefaultLanguageHighlighterColors.KEYWORD);
//*/
//
//    private static final Map<TokenSet, TextAttributesKey[]> keys;
//    static {
//        keys = new HashMap<TokenSet, TextAttributesKey[]>();
//
///*
//        keys.put(DTokenType.LINE_COMMENT, LINE_COMMENT);
//        keys.put(DTokenType.BLOCK_COMMENT, BLOCK_COMMENT);
//        keys.put(DTokenType.BLOCK_COMMENT_NEST, BLOCK_COMMENT);
//        keys.put(DTokenType.DOC_COMMENT, DOC_COMMENT);
//        keys.put(DTokenType.DOC_COMMENT_NEST, DOC_COMMENT);
//        keys.put(DTokenType.DOC_LINE_COMMENT, DOC_COMMENT);
//*/
//
//        keys.put(DLanguageTokenType.COMMENTS, COMMENTS);
//        keys.put(DLanguageTokenType.PARENS, pack(PARENS));
//        keys.put(DLanguageTokenType.BRACE, pack(BRACES));
//        keys.put(DLanguageTokenType.BRACKET, pack(BRACKETS));
//        keys.put(DLanguageTokenType.OPERATOR, pack(OPERATOR));
//        keys.put(DLanguageTokenType.KEYWORD, pack(KEYWORD));
//        keys.put(DLanguageTokenType.STRING_LITERALS, pack(STRING_LITERAL));
//
///*
//        keys.put(DTokenType.STRING_LITERAL, STRING_LITERAL);
//        keys.put(DTokenType.DSTR_LITERAL, STRING_LITERAL);
//        keys.put(DTokenType.WSTR_LITERAL, STRING_LITERAL);
//        keys.put(DTokenType.CHAR_LITERAL, STRING_LITERAL);
//*/
//
////        keys.put(DTokenType.LITERAL, NUM_LITERAL);
////        keys.put(DTokenType.IDENTIFIER, IDENTIFIER);
//}

}
