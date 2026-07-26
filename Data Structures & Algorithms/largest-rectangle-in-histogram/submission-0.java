class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]>st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int startIdx = i;
            while(!st.isEmpty() && st.peek()[1]>= heights[i]){
                int bar[] = st.pop();
                int start = bar[0];
                int height = bar[1];
                int width = i - start;
                int area = height * width;
                maxArea = Math.max(maxArea,area);
                startIdx = start;
            }
            st.push(new int[]{startIdx,heights[i]});
        }

        //if heights are increasing order
        while(!st.isEmpty()){
            int bar[] = st.pop();
            int start = bar[0];
            int height = bar[1];
            int width = n - start;
            int area = width * height;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
