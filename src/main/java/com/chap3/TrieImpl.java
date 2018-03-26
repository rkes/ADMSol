package com.chap3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieImpl {
	Node node = new Node();
	public void add(String key){
		node.add(key);
	}
	public Node search(String key){
		return node.search(key);
	}
	public List<TrieNodeEntry> getAllWords(){
		return node.getAllWords();
	}
	public static class Node {
		Character value;
		Map<Character, Node> children;
		int freq;
		Node parent;
		boolean isWord;

		public Node() {
			children = new HashMap<>();
			this.isWord = false;
		}

		public Node(Character value, Node parent) {
			this();
			this.value = value;
			this.parent = parent;
		}

		public Node get(Character ch) {
			return this.children.get(ch);
		}

		public void add(String key) {
			char ch = key.charAt(0);
			if (!this.children.containsKey(ch)) {
				Node temp = new Node(ch, this);
				this.children.put(ch, temp);
			}
			if (key.length() > 1) {
				this.get(ch).add(key.substring(1));
			} else {
				this.get(ch).isWord = true;
				this.get(ch).freq++;
			}
		}

		public Node search(String key) {
			Node temp = this;
			for (int i = 0; i < key.length(); i++) {
				if (temp.children.containsKey(key.charAt(i))) {
					temp = temp.get(key.charAt(i));
				}
			}
			return (temp == this ? null : temp);
		}

		public List<TrieNodeEntry> getAllWords() {
			List<TrieNodeEntry> words = new ArrayList<>();
			if (isWord) {
				words.add(new TrieNodeEntry(toString(), freq));
			} 
			if(!this.children.isEmpty()){
				for(Node node:this.children.values()){
					words.addAll(node.getAllWords());
				}
			}
			return words;
		}

		public String toString() {
			return this.parent == null ? "" : parent.toString() + String.valueOf(value);
		}
	}

	public static class TrieNodeEntry {
		String key;
		int frequency;

		TrieNodeEntry(String key, int frequency) {
			this.key = key;
			this.frequency = frequency;
		}

		public String toString() {
			return String.format("Trie Entry [ word = %s , frequency = %d ]", key, frequency);
		}

	}
}
