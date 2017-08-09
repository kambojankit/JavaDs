package com.techarha.training.ds.stack;

public class BalanceExpressionEnhanced {
    private static char[][] TOKENS = {{'{','}'}, {'[',']'}, {'(',')'}, {'<', '>'}};

    /**
     * //TODO Question:: Enhance isBalancedParanthesis provided solution.
     */
    public static boolean isBalancedParenthesisEnhanced(String input) {
        Stack<Character> characterStack = new GenericLinkedListStack<>();
        for(char c : input.toCharArray()) {
            if(isOpenTerm(c)){
                characterStack.push(c);
            }else {
                if(characterStack.isEmpty()) {
                    return false;
                }else {
                    char topChar = characterStack.top();
                    characterStack.pop();
                    if(!matches(topChar, c)) {
                        return false;
                    }
                }
            }
        }
        return characterStack.isEmpty();
    }

    private static boolean isOpenTerm(char term) {
        for(char[] allTerms : TOKENS) {
            if(allTerms[0] == term) {
                return true;
            }
        }
        return false;
    }
    private static boolean matches(char openTerm, char closeTerm) {
        for(char[] allTerms : TOKENS) {
            if(allTerms[0] == openTerm) {
                return allTerms[1] == closeTerm;
            }
        }
        return false;
    }
}
