package algorithm.DataStructure;

public final class Xtools {
    public static int[] IntArray(String data) {
        //[1,2,3,2,2,2,5,4,2]
        data = data.substring(1, data.length() - 1);
        var datas = data.split(",");
        var ans = new int[datas.length];
        for (int i = 0; i < datas.length; i++)
            ans[i] = Integer.parseInt(datas[i]);
        return ans;
    }

    public static String printArray(Object[] data) {
        StringBuilder s = new StringBuilder("[");
        for (var x : data)
            s.append(x).append(",");
        s.append(']');
        System.out.println(s);
        return s.toString();
    }

    public static String printArray(int[] data) {
        StringBuilder s = new StringBuilder("[");
        for (var x : data)
            s.append(x).append(",");
        s.append(']');
        System.out.println(s);
        return s.toString();
    }

    public static void main(String[] args) {
        var a = IntArray("[1,2,3,2,2,2,5,4,2]");
        var b = printArray(a);
    }
}
