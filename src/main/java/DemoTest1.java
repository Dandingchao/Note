
import entity.DaddyDog;
import entity.DaddyDog1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ThreadPoolExecutor;

public class DemoTest1 {
    public static void main(String[] args) {
        ThreadLocal<String> local=new ThreadLocal<>();
        String a="dsadas";
        String s="sjilxczz";
        for (int i=0;i<a.length();i++){
            if (s.contains(a.substring(i,i+1))){

            }
        }
    }
    public void quicksort(int[] a,int start,int end){
        if (start>=end)
            return ;
        Integer length=a.length;
        int temporary=a[start];
        int begin=start;
        int over=end;
        while (over>begin) {
            while (a[begin++] <= a[temporary]) ;
            while (a[end--] > a[temporary]) ;
            int swap = a[begin];
            a[begin] = a[end];
            a[end] = swap;
        }
        a[start]=a[begin];
        a[begin]=temporary;
        quicksort(a,start,begin);
        quicksort(a,begin+1,end);
    }
}
