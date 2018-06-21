/*
https://leetcode.com/problems/number-of-islands/description/
 */
package trees;

/**
 *
 * @author mattoop
 */
public class NumberOfIslands {
    
    private void performDFS(char[][] inputGridMap, int x, int y) {
        if (x < 0 || y < 0 || x>= inputGridMap.length || y >= inputGridMap[0].length || inputGridMap[x][y] == '0') {
            return;
        }
        inputGridMap[x][y] = '0';
        
        performDFS(inputGridMap, x - 1, y);
        performDFS(inputGridMap, x + 1, y);
        performDFS(inputGridMap, x, y - 1);
        performDFS(inputGridMap, x, y + 1);
    }
    
    public int countNumberOfIslands(char[][] inputGridMap) {
        if(inputGridMap == null || inputGridMap.length ==0) {
            return 0;
        }
        int numIslands = 0;
        // Linear scan the 2D array
        for (int i = 0; i < inputGridMap.length; i++) {
            for (int j = 0; j < inputGridMap[0].length; j++) {
                //Do a DFS & mark the nodes as 0
                if (inputGridMap[i][j] == '1') {
                    numIslands++;
                    //Do a DFS
                    performDFS(inputGridMap, i, j);
                }
            }
        }
        return numIslands;
    }
}
