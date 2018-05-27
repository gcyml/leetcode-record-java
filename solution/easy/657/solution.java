ass Solution {
    public boolean judgeCircle(String moves) {
        char[] steps = moves.toCharArray();
        int x = 0;
        int y = 0;
        if(steps.length%2 != 0) {
            return false;
        }
        for(char step: steps) {
            if('U' == step) {
                y -=1;
            } else if('D' == step) {
                y+=1;
            }else if('L' ==step) {
                x+=1;
            }else if('R' == step) {
                x-=1;
            }
        }
        if(x == 0 && y==0) {
            return true;
        }
        return false;
    }
}
