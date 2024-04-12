package battleship;


// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MSolution {
    public static void main(String[] args) {
        MSolution solution = new MSolution();
        int n = 3;
        String[] B = new String[n];
        B[0] = "...Xv";
        B[1] = "AX..^";
        B[2] = ".XX..";
        System.out.println(solution.solution(B));
    }
    public boolean solution(String[] B) {
        // Implement your solution here

        int n = B.length;
        int m = B[0].length();

        if(n == 1 && m == 1) {
            return true;
        }
        Character obs = 'X';
        Character leftG = '<';
        Queue<List<Integer>> lq = new LinkedList<>();
        Character rightG = '>';
        Queue<List<Integer>> rq = new LinkedList<>();
        Character upG = '^';
        Queue<List<Integer>> uq = new LinkedList<>();
        Character downG = 'v';
        Queue<List<Integer>> dq = new LinkedList<>();
        Character emt = '.';


        int startX = n-1;
        int startY = m-1;

        List<Integer> cod = new ArrayList<>();

        int[][] grid = new int[n][m];
        //val -> 0,notVis | 1,vis | -1,obs

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Character c = B[i].charAt(j);
                if(c == 'A') {
                    startX = i;
                    startY = j;
                    grid[i][j] = 1;
                } else if(c == '.') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = -1;
                    if(c == upG) {
                        uq.offer(getCod(i, j));
                    } else if(c == downG) {
                        dq.offer(getCod(i, j));
                    } else if(c == rightG) {
                        rq.offer(getCod(i, j));
                    } else if(c == leftG) {
                        lq.offer(getCod(i, j));
                    }
                }
            }
        }
        while(!uq.isEmpty()) {
            cod = uq.poll();
            for(int i = cod.get(0) - 1; i >= 0; i--) {
                Character c = B[i].charAt(cod.get(1));
                if(c == obs || c == downG || c == upG || c == rightG || c == leftG) {
                    break;
                } else {
                    grid[i][cod.get(1)] = -1;
                }
            }
        }
        while(!dq.isEmpty()) {
            cod = dq.poll();
            for(int i = cod.get(0) + 1; i < n; i++) {
                Character c = B[i].charAt(cod.get(1));
                if(c == obs || c == downG || c == upG || c == rightG || c == leftG) {
                    break;
                } else {
                    grid[i][cod.get(1)] = -1;
                }
            }
        }
        while(!rq.isEmpty()) {
            cod = rq.poll();
            for(int i = cod.get(1) + 1; i < m; i++) {
                Character c = B[cod.get(0)].charAt(i);
                if(c == obs || c == downG || c == upG || c == rightG || c == leftG) {
                    break;
                } else {
                    grid[cod.get(0)][i] = -1;
                }
            }
        }
        while(!lq.isEmpty()) {
            cod = lq.poll();
            for(int i = cod.get(1) - 1; i >= 0; i--) {
                Character c = B[cod.get(0)].charAt(i);
                if(c == obs || c == downG || c == upG || c == rightG || c == leftG) {
                    break;
                } else {
                    grid[cod.get(0)][i] = -1;
                }
            }
        }
        if(grid[n-1][m-1] == -1) {
            return false;
        }
        if(startX == n-1 && startY == m-1) {
            return true;
        }
        Queue<List<Integer>> bfsQ = new LinkedList<>();
        int[] rDir = {0, 1, 0, -1};
        int[] cDir = {1, 0, -1, 0};
        bfsQ.offer(getCod(startX, startY));
        while(!bfsQ.isEmpty()) {
            cod = bfsQ.poll();
            if(grid[cod.get(0)][cod.get(1)] != 0) {
                //either already visited or not allowed to visit
                continue;
            }
            for(int dir = 0; dir < 4; dir++) {
                int rNext = rDir[dir] + cod.get(0);
                int cNext = cDir[dir] + cod.get(1);
                if(grid[rNext][cNext] != -1 && rNext == n-1 && cNext == m-1) {
                    return true;
                }
                if(isInbound(rNext, cNext, n, m) && grid[rNext][cNext] == 0) {
                    bfsQ.offer(getCod(rNext, cNext));
                }
            }
        }
        return false;

    }

    private boolean isInbound(int i, int j, int n, int m) {
        if(i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

    private List<Integer> getCod(int x, int y) {
        List<Integer> cod = new ArrayList<>();
        cod.add(x);
        cod.add(y);
        return cod;
    }
}


