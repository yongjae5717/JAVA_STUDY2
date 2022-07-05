package elwlahd555.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import elwlahd555.baekjoon.baekjoon14725_개미굴.TrieNode;

public class baekjoon14725_개미굴 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");

			int K = Integer.parseInt(input[0]);
			int[] arr = new int[K];

			StringBuffer buf = new StringBuffer();
			for (int j = 1; j <= K; j++) {
				buf.append(input[j]);
				arr[j - 1] = input[j].length();
			}

			trie.insert(buf.toString(), arr);

		}

		trie.print();

	}

	static class Trie {

		TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		public void insert(String word, int[] arr) {

			TrieNode thisNode = rootNode;

			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				String str = word.substring(idx, idx + arr[i]);
				idx = idx + arr[i];

				thisNode = thisNode.getChildNodes().computeIfAbsent(str, key -> new TrieNode());
			}
			thisNode.setIstLastChar(true);
		}

		public void print() {
			print(rootNode, 0);
		}

		public void print(TrieNode thisNode, int floor) {

			Set<String> set = thisNode.getChildNodes().keySet();
			Iterator<String> it = set.iterator();

			while (it.hasNext()) {
				String str = it.next();

				TrieNode childNode = thisNode.getChildNodes().get(str);
				for (int i = 0; i < floor; i++)
					System.out.print("--");
				System.out.println(str);
				print(childNode, floor + 1);

			}
		}
	}

	static class TrieNode {

		Map<String, TrieNode> childNodes = new TreeMap<>();
		boolean isLastChar;

		Map<String, TrieNode> getChildNodes() {
			return childNodes;
		}

		public void setIstLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		public boolean isLastChar() {
			return isLastChar;
		}
	}

}