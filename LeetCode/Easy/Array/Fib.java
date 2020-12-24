class Fib {
    int[] mem;
    public int fib(int n) {
        mem = new int[n+1];
        if(n == 0) {
            return 0;
        } else if (n == 1){
            return 1;
        }
        mem[1] = 1;
        mem[0] = 0;
        return fibRec(n);
    }

    public int fibRec(int n) {
        if(mem[n] == 0 && n != 0) {
            int minus_one = fibRec(n-1);
            int minus_two = fibRec(n-2);
            mem[n-1] = minus_one;
            mem[n-2] = minus_two;
            return minus_one + minus_two;
        } else {
            return mem[n];
        }
    }
}
