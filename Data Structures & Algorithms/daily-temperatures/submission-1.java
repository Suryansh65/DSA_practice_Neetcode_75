class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<n;i++){
        while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
            int top = st.pop();
            res[top] = i - top;
        }
        st.push(i);
        }
        while(!st.isEmpty()){
            res[st.pop()] = 0;
        }
        return res;
    }
}
