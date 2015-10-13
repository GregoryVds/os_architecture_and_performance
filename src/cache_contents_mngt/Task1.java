package cache_contents_mngt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {

	public static void main(String[] args) throws IOException {
		int warmupSize 		 = Integer.parseInt(args[0]);
		int cacheSizeInLines = Integer.parseInt(args[1]);

		LRU LRUCache = new LRU(warmupSize, false, cacheSizeInLines);
		LFU LFUCache = new LFU(warmupSize, false, cacheSizeInLines);
		
		BufferedReader stdin = new BufferedReader(new FileReader("/Users/Greg/Desktop/trace_tiny.txt"));
		// BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		String request;
		while((request = stdin.readLine()) != null) {
			String url  = request.split(" ")[0];
			int size = Integer.parseInt(request.split(" ")[1]);
			LRUCache.get(url, size);
			LFUCache.get(url, size);
		}
		
		stdin.close();
		
		print("LRU Hit rate:", LRUCache.getHitRate());
		print("LFU Hit rate:", LFUCache.getHitRate());
	}
	
	public static void print(String text, double pc) {
		System.out.printf("%s %.1f%c\n", text, pc, '%');
	}
}
