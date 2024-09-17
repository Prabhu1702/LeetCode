class StockSpanner {
     Stack<Pair<Integer, Integer>> stack;
    int index=-1;
    public StockSpanner() {
        stack = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index=index+1;
        while(!stack.isEmpty() && stack.peek().getKey()<=price){
            stack.pop();
        }

        int span;
        if(!stack.isEmpty()){
            span=index-stack.peek().getValue();;
        }
        else{
            span=index+1;
        }

        stack.push(new Pair<>(price, index));

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */