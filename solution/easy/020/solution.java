ass Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();  
        for(int i=0;i<s.length();i++){  
            char candidate = s.charAt(i);  
            if(candidate=='{'||candidate=='['||candidate=='('){  
                stack.push(candidate+"");  
            }else{  
                if(stack.isEmpty()){  
                    return false;  
                }  
                if((candidate=='}' && stack.peek().equals("{"))||  
                (candidate==']' && stack.peek().equals("["))||  
                (candidate==')' && stack.peek().equals("("))){  
                    stack.pop();  
                }else{  
                    return false;  
                }  
            }  
        }  
        if(stack.isEmpty()){  
            return true;  
        }else{  
            return false;  
        }  
    }
}
