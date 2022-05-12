class BrowserHistory {
    private String currentPage;
    private Stack<String> backStack, forwardStack;
    
    public BrowserHistory(String homepage) {
        this.currentPage = homepage;
        this.backStack = new Stack();
        this.forwardStack = new Stack();
    }
    
    public void visit(String url) {
        this.backStack.push(currentPage);
        this.forwardStack = new Stack();
        this.currentPage = url;
    }
    
    public String back(int steps) {
        while (!backStack.isEmpty() && steps-- > 0) {
            forwardStack.push(this.currentPage);
            this.currentPage = backStack.pop();
        }
        return this.currentPage;
    }
    
    public String forward(int steps) {
        while (!forwardStack.isEmpty() && steps-- > 0) {
            backStack.push(this.currentPage);
            this.currentPage = forwardStack.pop();
        }
        return this.currentPage;
    }
}
​
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
