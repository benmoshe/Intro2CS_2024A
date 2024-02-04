package assignments.ex1.solution;

public class Bulls_m_Cows {
    private static int[][] _options;
    public static void main(String[] args) {
        // create a scanner so we can read the command-line input
        int[] a = {8, 7, 5, 9};
        int[] b = {5, 6, 8, 6};
        int[] ans = testBullsNCows(a, b);
        System.out.println(("B=" + ans[0] + ",  C=" + ans[1]));
        _options = allOptions(4);
        int gg = 8759, co = 5686;
        int[] guess = _options[gg];
        int[] code = _options[co];
        int[] curr_ans = testBullsNCows(guess, code);
        int j=0;
        while(curr_ans[0]<4) {
            curr_ans = testBullsNCows(guess, code);
            boolean OK = _options[co] != null;
            System.out.println(j+") "+guess[3]+","+guess[2]+","+guess[1]+","+guess[0]+"  |  B="+curr_ans[0]+",  C="+curr_ans[1]+"  test: "+OK);
            gg = eliminate(_options, guess, curr_ans[0], curr_ans[1]);
            guess = _options[gg];
            j=j+1;
        }
    }
    public static int[] getGuess() {
        int[] ans = null;
        int ii=0;
      //  for(int i=0;i<_options.length;i=i+1) {
      //      if(_options[i]!=null) {ans =_options[i];}
      //  }
        ans = _options[randomIndex()];
        return ans;
    }
    public static int play(int[] guess, int b, int c) {
        int gg = eliminate(_options, guess, b, c);
        return gg;
    }
    public static void initData(int size) {
        _options = allOptions(size);
    }
        public static int[][] allOptions(int size) {
            int dim = (int)(Math.pow(10,size));
            int[][] ans = new int[dim][size];
            for(int i=0;i<ans.length;i=i+1) {
                int t = i;
                int[] c = new int[size];
                for(int j=0;j<c.length;j+=1) {
                    c[j] = t%10;
                    t=t/10;
                }
                ans[i] = c;
            }
            return ans;
        }
        public static int eliminate(int[][] all, int[] guess, int b, int c) {
            int ans = -1, cc=0;
            for(int i=0;i<all.length;i=i+1) {
                int[] curr = all[i];
                if(curr!=null) {
                    int[] bc = testBullsNCows(curr, guess);
                    if(bc[0]!=b || bc[1]!=c) {
                        all[i]=null;
                    }
                    else {cc+=1;}
                }
            }
            if(b<guess.length) {
                int ind = 0;
                for(int i=guess.length-1; i>=0;i=i-1) {
                    ind=ind*10;
                    ind=ind+guess[i];
                }
                all[ind]=null;// ind is not the solution
            }
            //System.out.println(cc);
            ans = randomIndex();
            return ans;
        }
        private static int randomIndex() {
            int ans = -1, count=0;
            int len = _options.length;
            int ind = (int)(Math.random()*len);
            while(ans==-1 && count<len/2) {
                int i1 = ind+count;
                int i2 = ind-count;
                if(i1>=len) {i1=(ind+count)%len;}
                if(i2<0) {i2=len+(ind-count);}
                int[] aaa = _options[i1];
                if(aaa!=null) {ans=i1;}
                if(ans==-1 && _options[i2]!=null) {ans=i2;}
                count+=1;
            }
            return ans;
        }
    public static int[] testBullsNCows(int[] a, int[] b) {
        int[] ans = new int[2];
        int len = a.length;
        int[] a1 = new int[len];
        int[] b1 = new int[len];
        for(int i=0;i<len;i++) {
            if (a[i] == b[i]) {
                a1[i] = 1;
                b1[i] = 1;
                ans[0] += 1;
            }
        }
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j=j+1) {
                if(b1[j]==0 && a1[i]==0 && a[i]==b[j]) {
                    b1[j]=2;
                    a1[i]=2;
                    ans[1]+=1;
                }
            }
        }
        return ans;
    }

}
